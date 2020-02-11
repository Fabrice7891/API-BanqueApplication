<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<META HTTP-EQUIV="expires" CONTENT="Wed, 01 Jan 2012 08:00:00 GMT">
<title>Home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>


	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home Page</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">Creer une t�che</a></li>
					<li><a href="all-tasks">Liste des T�ches</a></li>
				</ul>
			</div>
		</div>
	</div>


	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Bienvenue au Gestionnaire de T�ches</h1>
				</div>
			</div>
		</c:when>

		<c:when test="${mode == 'MODE_TASK'}">
			<div class="container text-center" id="taskDiv">
				<h3>Liste des T�ches</h3>
				<hr>
				
				<div class="container" >
<!--  <form >
  <label>Mot Cl�</label>
  <input type="text" name="motCle" />
  <button class="btn btn-primary">Chercher</button>
 </form>
</div> -->
				
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">

						<thead>
							<tr>
								<th>ID</th>
								<th>Nom</th>
								<th>Description</th>
								<th>Date de Creation</th>
								<th>Terminer(OUI/NON)</th>
								<th>Supprimer</th>
								<th>Editer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks}">
								<tr>
									<td><c:out value="${task.id}" /></td>
									<td><c:out value="${task.name}" /></td>
									<td><c:out value="${task.description}" /></td>
									<td><c:out value="${task.datecreated}" /></td>
									<td><c:out value="${task.finished}" /></td>
									<td><a onclick="return confirm('Voulez vous vraiment supprimer la t�che?')" href="delete-task?id=${task.id}"><span><span class="glyphicon glyphicon-trash"></span></span></a></td>
									<td><a href="update-task?id=${task.id}"><span><span class="glyphicon glyphicon-pencil"></span></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">

			<div class="container text-center">

				<h3>Nouvelle t�che</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-task">
					<input type="hidden" name="id" value="${task.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">Nom</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${task.name}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Description</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="description"
								value="${task.description}" />
						</div>
					</div>

					<%-- <div class="form-group">
						<label class="control-label col-md-3">Date Created</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="datecreated"
								value="${task.datecreated}" />
						</div>
					</div> --%>

					<div class="form-group">
						<label class="control-label col-md-3">Terminer(OUI/NON)</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="finished" value="true" />
							<div class="col-sm-1">Oui</div>
							<input type="radio" class="col-sm-1" name="finished"
								value="false" />
							<div class="col-sm-1">Non</div>
						</div>
					</div>

					<div class="form-group">
						<input  type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>
	<script src="statis/js/bootstrap.min.js"></script>

</body>
</html>