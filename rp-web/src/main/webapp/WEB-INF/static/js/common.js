/**
*定义公共的js
*require之后,可以直接调用
*/

/**jqgrid的日期格式化*/
var priorityDateFormatter = function(cellvalue, options, rowObject) {
	var udate = "";
	if (cellvalue) {
		var date = new Date(cellvalue);
		udate = DateFormat.format(date, 'MM-dd hh:mm');
	}
	return udate;
};

var priorityFullDateFormatter = function(cellvalue, options, rowObject) {
	var udate = "";
	if (cellvalue) {
		var date = new Date(cellvalue);
		udate = DateFormat.format(date, 'yyyy-MM-dd hh:mm:ss');
	}
	return udate;
};


var yyyyMMddhhmmDateFormatter = function(cellvalue, options, rowObject) {
	var udate = "";
	if (cellvalue) {
		var date = new Date(cellvalue);
		udate = DateFormat.format(date, 'yyyy-MM-dd hh:mm');
	}
	return udate;
};

var mmddFormatter = function(cellvalue, options, rowObject) {
	var udate = '';
	if (cellvalue) {
		var date = new Date(cellvalue);
		udate = DateFormat.format(date, 'MM-dd');
	}
	return udate;
};

var yymmddFormatter = function(cellvalue, options, rowObject) {
	var udate = '';
	if (cellvalue) {
		var date = new Date(cellvalue);
		udate = DateFormat.format(date, 'yyyy-MM-dd');
	}
	return udate;
};

var hhmmssFormatter = function(cellvalue, options, rowObject) {
	var udate = '';
	if (cellvalue) {
		var date = new Date(cellvalue);
		udate = DateFormat.format(date, 'hh:mm:ss');
	}
	return udate;
};

var hhmmFormatter = function(cellvalue, options, rowObject) {
	var etadate = '';
	if (cellvalue) {
		var date = new Date(cellvalue);
		etadate = DateFormat.format(date, 'hh:mm');
	}
	return etadate;
};


/**DateFormat*/
DateFormat = (function(){   
	
	 var SIGN_REGEXP = /([yMdhsm])(\1*)/g;     
	 var DEFAULT_PATTERN = 'yyyy-MM-dd';   
	 
	 function padding(s,len){     
	  len =len - (s+'').length;     
	  for(var i=0;i<len;i++){s = '0'+ s;}     
	  return s;     
	 };  
	 return({
	  format: function(date,pattern){     
	   pattern = pattern||DEFAULT_PATTERN;     
	   return pattern.replace(SIGN_REGEXP,function($0){     
	    switch($0.charAt(0)){     
	     case 'y' : return padding(date.getFullYear(),$0.length);     
	     case 'M' : return padding(date.getMonth()+1,$0.length);     
	     case 'd' : return padding(date.getDate(),$0.length);     
	     case 'w' : return date.getDay()+1;     
	     case 'h' : return padding(date.getHours(),$0.length);     
	     case 'm' : return padding(date.getMinutes(),$0.length);     
	     case 's' : return padding(date.getSeconds(),$0.length);     
	    }     
	   }); 
	  },  
	  
	parse: function(dateString,pattern){   
	   var matchs1=pattern.match(SIGN_REGEXP);     
	   var matchs2=dateString.match(/(\d)+/g);     
	   if(matchs1.length==matchs2.length){     
	    var _date = new Date(1970,0,1);     
	    for(var i=0;i<matchs1.length;i++){  
		     var _int = Number(matchs2[i]);  
		     var sign = matchs1[i];  
			 switch(sign.charAt(0)){     
			     case 'y' : _date.setFullYear(_int);break;     
			     case 'M' : _date.setMonth(_int-1);break;     
			     case 'd' : _date.setDate(_int);break;     
			     case 'h' : _date.setHours(_int);break;     
			     case 'm' : _date.setMinutes(_int);break;     
			     case 's' : _date.setSeconds(_int);break;     
			  }  
	    }     
	    return _date;     
	   }     
	   return null;     
	},
	  parseck : function(c_date){
			    if (!c_date)
			        return "";
			    var tempArray = c_date.split("-");
			    if (tempArray.length != 3) {
			        return 0;
			    }
			    var dateArr = c_date.split(" ");
			    var date = null;
			    if (dateArr.length == 2) {
			        var yymmdd = dateArr[0].split("-");
			        var hhmmss = dateArr[1].split(":");
			        date = new Date(yymmdd[0], yymmdd[1] - 1, yymmdd[2], hhmmss[0], hhmmss[1], hhmmss[2]);
			    } else {
			        date = new Date(tempArray[0], tempArray[1] - 1, tempArray[2], 00, 00, 00);
			    }
			    return date;
	  }
	 });     
	})();

	function changeDateFormat(cellval) {
	    var date = new Date(parseInt(cellval)*1000);
	    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
	    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		var hour=date.getHours()< 10 ? "0" + date.getHours() : date.getHours();
		var mints=date.getMinutes()< 10 ? "0" + date.getMinutes() : date.getMinutes();
		var sec=date.getSeconds()< 10 ? "0" + date.getSeconds() :date.getSeconds();
	    return date.getFullYear() + "-" + month + "-" + currentDate+ " " +hour+ ":" + mints+ ":" +sec;
	}