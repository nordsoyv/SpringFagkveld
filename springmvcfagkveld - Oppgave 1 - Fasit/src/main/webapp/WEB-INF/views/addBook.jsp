<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
	function saveBook() {
		
	}
</script>

<form:form commandName="book" method="POST" action="addBook">
	<label>Title</label><form:input path="title" id="title"/>
	<label>Author</label><form:input path="author" id="author"/>
	<input type="submit" value="Save book" id="button"/>
</form:form>