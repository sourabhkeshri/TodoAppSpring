<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<title>It's JSP</title>

<body>

	<h2>Todo List!!</h2>
	<hr>
	Your name :${name}
	<br>
	
<div class="container">
	<table class="table">
	
		<thead>
			<tr>
			<th>Description</th>
			<th>Date</th>
			<th>Done</th>
			<th>Delete</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
			<td>${todo.desc}</td>
			<td>${todo.targetDate}</td>
			<td>${todo.done}</td>
			<td><a type="button" href="/deleteTodo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
	
	<hr>
	<a class="btn btn-success" href="/add-todo">Add Todo!<a>
	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</body>

</html>