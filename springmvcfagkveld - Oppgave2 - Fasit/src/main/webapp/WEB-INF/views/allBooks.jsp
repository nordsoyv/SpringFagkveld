<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<table border=1>

	<tr>
		<th>Title</th><th>Author</th>
	</tr>

<c:forEach items="${books}" var="book">
	<tr>
		<td>${book.title}</td><td>${book.author}</td><td><a  href="#" onClick="SFK.deleteBook(${book.id});" >Delete</a>
	</tr>
</c:forEach>

</table>