<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<table border=1>

	<tr>
		<th>Title</th><th>Author</th>
	</tr>

<c:forEach items="${books}" var="book">
	<tr>
		<td ><a href="#" onClick="SFK.updateBook(${book.id});"><div id="title${book.id}">${book.title}</div></a></td>
		<td ><div id="author${book.id}">${book.author}</div></td>
		<td><a  href="#" onClick="SFK.deleteBook(${book.id});" >Delete</a>
	</tr>
</c:forEach>

</table>