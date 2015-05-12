/**
 * 页面布局相关
 */
define([ 'jqlayout','j-u-b/jquery-ui','jquery' ], function(layout,jui,$) {
	//布局
	var myLayout = $("body").layout({
		west__size : 210,
		west__spacing_closed : 20,
		west__togglerLength_closed : 100,
		west__togglerContent_closed : "菜<BR>单",
		togglerTip_closed : "打开",
		togglerTip_open : "关闭",
		sliderTip : "滑动打开",
		resizerTip : "调整大小",
		center__maskContents : true, // IMPORTANT - enable iframe masking
		north : {
			spacing_open: 0,//边框的间隙  
			size : 40
		}
	});
	//菜单初始化
	  var menus = $("#menu");
      menus.accordion({
          header:"h3",
          heightStyle:"content",
          icons : {
              header: "ui-icon-triangle-1-e",
              activeHeader: "ui-icon-triangle-1-s"
          },
          animate : {
              easing : "easeOutQuart"
          }
      });

      var leafIconClass = "menu-icon icon-angle-right";
      var branchOpenIconClass = "menu-icon icon-double-angle-right";
      var branchCloseIconClass = "menu-icon icon-double-angle-down";
      
      menus.find("li").each(function () {
          var li = $(this);

          li.children("a").wrap("<div class='li-wrapper'></div>");
          var liWrapper = li.children(".li-wrapper");
          var liUL = li.find("ul");
          var hasChild = liUL.length;
          if (hasChild) {
              liUL.hide();
              liWrapper.prepend('<span class="' + branchOpenIconClass + '"></span>')
                  .click(function () {
                      if (liWrapper.children("span").hasClass(branchCloseIconClass)) {
                          liWrapper.children("span")
                              .removeClass(branchCloseIconClass)
                              .addClass(branchOpenIconClass)
                              .end()
                              .closest("li").children("ul").hide("blind");
                      } else {
                          liWrapper.children("span")
                              .removeClass(branchOpenIconClass)
                              .addClass(branchCloseIconClass)
                              .end()
                              .closest("li").children("ul").show("blind");
                      }
                  });
          } else {
              liWrapper.prepend('<span class="' + leafIconClass + '"></span>');
          }
      });

      menus.find("a").each(function () {
          var a = $(this);
          var title = a.text();
          var href = a.attr("href");
          a.attr("href", "#");
          if (href == "#" || href == '') {
              return;
          }

          var active = function(a, forceRefresh) {
              menus.find("a").closest("li > .li-wrapper").removeClass("active");
              a.closest("li > .li-wrapper").addClass("active");
              var oldPanelIndex = a.data("panelIndex");
              var activeMenuCallback = function(panelIndex) {
                  if(!a.data("panelIndex")) {
                      a.data("panelIndex", panelIndex);
                      a.attr("id", "menu-" + panelIndex);
                  }
              }
              activeTab(oldPanelIndex, title, href, forceRefresh, activeMenuCallback);

              return false;
          }

          a.closest("li")
              .click(function () {
                  active(a, false);
                  return false;
              }).dblclick(function() {
                  active(a, true);//双击强制刷新
                  return false;
              });
      });
      
      //tab初始化 https://api.jqueryui.com/tabs
      var tabs = $(".tabs-bar");
      tabs.maxTabIndex=1;
      tabs.tabs({
          beforeActivate : function(event, ui) {
              setTimeout(function() {
                  tabs.find(".menu").hide();
                  tabs.find("#" + ui.newPanel.attr("aria-labelledby")).siblings(".menu").show();
              }, 0);
          },
          activate: function (event, ui) {
              setTimeout(function() {
                  var newPanelId = ui.newPanel.prop("id");
                  activeMenu(newPanelId);
                  activeIframe(newPanelId);
              }, 0);
          }
      });
      tabs.delegate("span.icon-remove", "click", function () {
          var panelId = $(this).closest("li").remove().attr("aria-controls");
          setTimeout(function() {
              removeTab(panelId);
          }, 0);
      });
      tabs.delegate("span.icon-refresh", "click", function () {
          var panelId = $(this).closest("li").attr("aria-controls");
          setTimeout(function() {
              activeTab(panelId, null, null, true);
          }, 0);
      });

      
      function createTab(title, panelIndex) {
    	  
          if(tabs.find(".ui-tabs-panel").length > 6) {
        	  alert("您打开的面板太多，为提高系统运行速度，请先关闭一些！");
              return;
          }
          
          var newPanelIndex = panelIndex || tabs.maxTabIndex++ || 1;
          var newPanelId = "tabs-" + newPanelIndex;
          var tabTemplate = "<li><a href='#{href}'>{label}</a> <span class='menu icon-remove' role='presentation'title='关闭'></span><br/><span class='menu icon-refresh' role='presentation' title='刷新'></span></li>";
          var li = $(tabTemplate.replace(/\{href\}/g, newPanelId).replace(/\{label\}/g, title));

          tabs.find("ul.ui-tabs-nav").append(li);
          tabs.append('<div id="' + newPanelId + '"></div>');

          tabs.tabs("refresh");

          var newPanel = $("#" + newPanelId);
          newPanel.data("index", newPanelIndex);

          return newPanel;
      };
      function activeTab(panelIdOrIndex, title, url, forceRefresh, callback) {
          if(panelIdOrIndex && ("" + panelIdOrIndex).indexOf("tabs-") == 0) {
              currentTabPanel = $("#" + panelIdOrIndex);
          } else {
              var currentTabPanel = $("#tabs-" + panelIdOrIndex);
          }
          if (!currentTabPanel.length) {
              currentTabPanel =createTab(title, panelIdOrIndex);
          }

          if(callback) {
              callback(currentTabPanel.data("index"));
          }

          if(!url) {
              url = currentTabPanel.data("url");
          }

          setTimeout(function() {
              loadingToCenterIframe(currentTabPanel, url, null, forceRefresh);
              tabs.tabs("option", "active", tabs.find(".ui-tabs-panel").index(currentTabPanel));
          }, 0);
          return currentTabPanel.data("index");
      };
      function removeTab(panelId) {
          var panel = $("#" + panelId);
          var iframe = $("#iframe-" + panelId);

          var currentMenu = $("#menu-" + panelId.replace("tabs-", ""));
          if(currentMenu.length) {
              currentMenu.attr("id", "");
              currentMenu.attr("panelIndex", "");
              $("#menu .li-wrapper.active").removeClass("active");
          }
          //Which panel is currently open.
          tabs.tabs("option", "active", tabs.find(".ui-tabs-panel").size());
          tabs.tabs("refresh");
          panel.remove();
          var iframeDom = iframe[0];
          //iframeDom.src = "";
          //iframeDom.contentWindow.document.write('');
          //iframeDom.contentWindow.close();
          iframe.remove();
          var isIE = !-[1,];
          if (isIE) {
              CollectGarbage();
          }
      };
      function activeIframe(panelId, iframe) {
          if (!iframe) {
              iframe = $("#iframe-" + panelId);
          }
          if (myLayout.panes.center.prop("id") == iframe.prop("id")) {
              return;
          }
          myLayout.panes.center.hide();
          myLayout.panes.center = iframe;
          myLayout.panes.center.show();
          myLayout.resizeAll();
         // initTabScrollHideOrShowMoveBtn(panelId);
      }
      function activeMenu(tabPanelId) {
          var currentMenu = $("#menu-" + tabPanelId.replace("tabs-", ""));
          $("#menu .li-wrapper.active").removeClass("active");

          if(currentMenu.length) {
              //把父菜单展示出来
              currentMenu.parents("ul").each(function(){
                  //不能使用“ul:hidden” 因为它是把只有隐藏的都查出来
                  // 比如<ul style="display:none"><li><ul><li><a class='a'></a></li></ul></li></ul>
                  //$(".a").parents("ul:hidden") 会查出两个 即hidden的元素对其子也是有效的
                  if($(this).css("display") == 'none') {
                      $(this).prev("a").click();
                  }
              });
              currentMenu.closest(".li-wrapper").addClass("active");
          }
      }
      //异步加载内容到iframe
      function loadingToCenterIframe(panel, url, loadingMessage, forceRefresh) {
          panel.data("url", url);
          var panelId = panel.prop("id");
          var iframeId = "iframe-" + panelId;
          var iframe = $("#" + iframeId);

          if (!iframe.length || forceRefresh) {
              if(!iframe.length) {
                  iframe = $("iframe[tabs=true]:last").clone(true);
                  iframe.prop("id", iframeId);
                  $("iframe[tabs=true]:last").after(iframe);
              }
              //$.app.waiting(loadingMessage);
              iframe.prop("src", url).one("load", function () {
                  activeIframe(panelId, iframe);
              });

          } else {
              activeIframe(panelId, iframe);
          }

      }
      //当tab过多,显示或者隐藏tab
      function initTabScrollHideOrShowMoveBtn(panelId) {
          var $ulWrapper = $(".tabs-bar .ul-wrapper");
          var $lastLI = $ulWrapper.find("ul li:last");
          var $firstLI = $ulWrapper.find("ul li:first");

          var ulWapperOffsetLeft = $ulWrapper.offset().left;
          var ulWrapperLeftPos = ulWapperOffsetLeft + $ulWrapper.width();

          var hideOrShowBtn = function() {
              var lastLIOffsetLeft = $lastLI.offset().left;
              var lastLILeftPos = lastLIOffsetLeft + $lastLI.width();
              var firstLIOffsetLeft = $firstLI.offset().left;

              var $leftBtn = $(".tabs-bar .icon-chevron-left");
              var $rightBtn = $(".tabs-bar .icon-chevron-right");

              if (ulWapperOffsetLeft == firstLIOffsetLeft) {
                  $leftBtn.hide();
              } else {
                  $leftBtn.show();
              }
              if (ulWrapperLeftPos >= lastLILeftPos) {
                  $rightBtn.hide();
              } else {
                  $rightBtn.show();
              }
          };

          if(panelId) {

              var $li = $(".tabs-bar").find("li[aria-labelledby='" + $("#" + panelId).attr("aria-labelledby") + "']");

              var liOffsetLeft = $li.offset().left;
              var liLeftPos = liOffsetLeft + $li.width();

              var isLast = $li.attr("aria-controls") == $lastLI.attr("aria-controls");

              //如果当前tab没有隐藏 则不scroll
              if((ulWapperOffsetLeft <= liOffsetLeft) && (liLeftPos <= ulWrapperLeftPos) && !isLast) {
                  return;
              }

              var leftPos = 0;
              //right
              if(ulWrapperLeftPos < liLeftPos || isLast) {
                  leftPos = $ulWrapper.scrollLeft() + (liLeftPos - ulWrapperLeftPos) + (isLast ? 10 :55);
              } else {
                  //left
                  leftPos = "-=" + (ulWapperOffsetLeft - liOffsetLeft + 55);
              }

              $ulWrapper.animate({scrollLeft: leftPos}, 600, function () {
                  hideOrShowBtn();
              });
          } else {
              hideOrShowBtn();
          }


      }
	
})