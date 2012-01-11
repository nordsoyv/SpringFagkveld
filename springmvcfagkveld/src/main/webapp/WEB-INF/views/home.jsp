<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<title>The fantastic book database</title>
	<script type="text/javascript">
	
	SFK = {};
	
	SFK.deleteBook = function(id){
		var deleteUrl = "books/" + id;
		var request  = $.ajax({url: deleteUrl, type: "DELETE" } );
		request.done(function(){
			//alert("DONE");
			location.reload();
		});
		request.fail(function(){
			alert("Ukjent error");
		});
		
	};
	
	SFK.updateBook = function(id){
		var titleId = "#title"+id;
		var authorId = "#author"+id;
		var titleObj =$(titleId);
		var authorObj =$(authorId);
		
		var bookTitle = titleObj.html();
		var bookAuthor = authorObj.html();
		$("#title").val(bookTitle);
		$("#author").val(bookAuthor);
		
		$("#button").hide();
		$("#updateButton").fadeIn(1000);
		
		SFK.bookToUpdate = {id: id, author: bookAuthor, title: bookTitle};
	};
	
	SFK.submitUpdate = function() {
		SFK.bookToUpdate.author = $("#author").val();
		SFK.bookToUpdate.title = $("#title").val();
		
		var jsonBook = JSON.stringify(SFK.bookToUpdate);
		var updateUrl = "books/" + SFK.bookToUpdate.id;
		var request  = $.ajax({
			url: updateUrl, 
			type: "PUT",
			data : jsonBook,
			dataType : "json",
			contentType : "application/json; charset=utf-8"
		});
		
		request.done(function(){
			location.reload();
		});
		request.fail(function(){
			alert("Ukjent error");
		});
	};

	$(document).ready(function (){
		$("#title").val("");
		$("#author").val("");
	});
	
	</script>
</head>
<body>
	<h2>The fantastic book database</h2>
	<c:import url="/books"></c:import>
	<jsp:include page="addBook.jsp"  ></jsp:include>
</body>
</html>
