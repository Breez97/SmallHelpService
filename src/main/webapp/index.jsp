<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/main.css">
		<title>Help Service</title>
	</head>
	<body>
		<div class="main-container">

			<h2>Help Service</h2>

			<div class="box-container">

				<p>Make small <b>HttpServlet</b> which will process <b>GET</b> and <b>POST</b> requests. Encouragement phrases should be stored in the application's memory.</p>

				<p><b>GET</b> request <b>/help-service/v1/support</b> which responses random encouragement phrase. (e.g. You will succeed).</p>

				<p><b>POST</b> request <b>/help-service/v1/support</b> which adds new phrase to the list of existing phrases.</p>
				
				<p>Collect <b>war</b> archive.</p>

				<p>Create tests for functions.</p>

				<p>Run <b>Tomcat</b> in <b>docker</b> and start service in it using <b>war</b> archive.</p>

				<button class="button-get-phrase">Get phrase</button>

			</div>
			
		</div>

		<script>
			window.onload = function() {
				let btn = document.querySelector('.button-get-phrase');
				btn.addEventListener('click', function() {
					window.location.href = '/HelpServiceServlet/help-service/v1/support';
				});
			}
		</script>

	</body>
</html>