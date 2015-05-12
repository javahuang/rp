define(['jquery','jqueryplugin/jquery.form'],function($,form){
// prepare all forms for ajax submission
// $('form').ajaxForm({
// target: '#myResultsDiv'
// });
	$("#username").focus();
	$('#login_form').on('submit', function(e) {
	    e.preventDefault(); // prevent native submit
	    $(this).ajaxSubmit({
	    	success:function(data){
	    		if(data=='success')
	    			location.reload(); 	
	    		else 
	    			alert(data);
			}
	    })
	});
	$('#regist_form').on('submit', function(e) {
	    e.preventDefault(); // prevent native submit
	    $(this).ajaxSubmit({
	    	success:function(data){
	    		if(data=='success')
	    			location.reload();
	    		else
	    			alert('注册失败!');
			}
	    })
	});
	
})