$("#login-button").click(function(event){


	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});

$('#form_login').submit(function (e) {
	var form = this;
	e.preventDefault();
	setTimeout(function () {
		form.submit();
	}, 2000); // in milliseconds
});