define(['jqueryplugin/jquery.form'],function(form){
	
	$('#edit_form').on('submit', function(e) {
	    e.preventDefault(); // prevent native submit
	    var postContent=UE.getEditor('editor').getContent();
	    $(this).ajaxSubmit({
	    	data:{postContent:postContent},
	    	success:function(data){
	    		if(data.state=='SUCCESS')
	    			location.reload();
	    		else
	    			alert('注册失败!');
			}
	    })
	});
	
})