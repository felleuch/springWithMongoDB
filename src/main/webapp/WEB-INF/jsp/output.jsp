<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>

		<form action="person/save" method="post">
			<input type="hidden" name="id">
			<label for="name">Person Name</label>
			<input type="text" id="name" name="name"/>
            <label for="name">Person Age</label>
            <input type="text" id="age" name="age"/>
			<input type="submit" value="Submit"/>
		</form>

	<table border="1">
        <thead>
            <th>Name</th>
            <th>Age</th>
            <th></th>
        </thead>
        <tbody>
		<c:forEach var="person" items="${personList}">
			<tr>
				<td>${person.name}</td>
                <td>${person.age}</td>
                <td><input type="button" value="delete" onclick="window.location='person/delete?id=${person.id}'"/></td>
			</tr>
		</c:forEach>
        </tbody>
	</table>

<h2>Result of Query 2</h2>


    <table border="1">
        <thead>
        <th>Name</th>
        <th>Age</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="person" items="${personList2}">
            <tr>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td><input type="button" value="delete" onclick="window.location='person/delete?id=${person.id}'"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</body>
</html>