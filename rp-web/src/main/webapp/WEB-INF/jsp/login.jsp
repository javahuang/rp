<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="registrations" id="registrations" style="display: block;">
	<i class="fa fa-times" id="close-registrations"></i>
	<div class="container">
		<section class="col-md-5">
			<form accept-charset="UTF-8" action="${ctx }/login" id="login_form"
				method="post" name="login_form">
				<h2>使用邮箱/手机号登录：</h2>
				<div class="form-group">
					<input type="text" class="form-control" id="username" name="username"
						placeholder="手机号/邮箱">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password"
						id="password" placeholder="密码">
				</div>
				<div class="form-group">
					<input type="checkbox" id="rememberMe" name="rememberMe">
					<label for="rememberMe">自动登录</label>
					<a href="#" style="float: right">忘记密码?</a>
				</div>
				<button class="btn btn-primary" type="submit">登录</button>
			</form>
		</section>
		<section class="col-md-offset-1 col-md-4">
			<form accept-charset="UTF-8" action="${ctx }/regist" id="regist_form"
				data-remote="true" method="post" name="regist_form">
				<h2>
					没有帐号？<br>立即注册！
				</h2>
				<div class="form-group">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="邮箱">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="mobil_phone_number" name="mobilePhoneNumber"
						placeholder="手机号">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password"
						id="password" placeholder="密码">
					<input type="password" class="form-control" name="repassword"
						id="repassword" placeholder="确认密码">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="username" name="username"
						placeholder="用户名">
				</div>
				<button class="btn btn-success" type="submit">注册</button>
			</form>
		</section>
	</div>
</div>

