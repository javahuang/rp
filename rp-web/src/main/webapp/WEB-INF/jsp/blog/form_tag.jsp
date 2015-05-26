<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <form id="supplier_form" class="form-horizontal" action="${ctx }/blog/addTag">
		<div class="form-group">
			<label class="col-lg-3 col-md-2  control-label" for="value"><span style="color: red">*</span>标签名：</label>
			<div class="col-lg-7 col-md-8">
				<input type="text" id="value" name="value"class="form-control input-sm" placeholder="" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 col-md-2  control-label" for="weight"><span style="color: red">*</span>权重：</label>
			<div class="col-lg-7 col-md-8">
				<input type="number" id="weight" name="weight"class="form-control input-sm" placeholder="为1-10,将关系到主页标签云显示的大小" >
			</div>
		</div>
	</form>
