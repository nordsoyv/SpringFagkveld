<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<title>The fantastic book database</title>
	<script type="text/javascript">
	
	SFK = {};
	
	SFK.deleteBook = function(id){
		alert(id);
		var deleteUrl = "books/" + id;
		var request  = $.ajax({url: deleteUrl, type: "DELETE" } );
		request.done = function(){
			
		};
		request.fail = function(){
			
		};
		
	};

	
	$(document).ready(function (){
		//ingenting enda
	});
	
	</script>
</head>
<body>
	<h2>The fantastic book database</h2>
	<c:import url="/books"></c:import>
	<jsp:include page="addBook.jsp"  ></jsp:include>
</body>
</html>
