
<html>
<body>

<%@ include file="includes.jsp"%>


<h2>Phone list </h2>

<form action="user/save" method="post" id="form">

		<tr>
			<input type="hidden" name="id">
			<label for="userName">User Name</label>
		</tr>
		<tr>
			<input type="text" id="userName" name="userName" required="required" />
			<label for="surName">Surname</label>
		</tr>
		<tr>
			<input type="text" id="surName" name="surName" required="required" />
			<label for="phoneNumber">Phone</label>
		</tr>
		<tr>
			<input type="text" id="phoneNumber" name="phoneNumber"
				required="required" />
			

			<input type="submit"  value="Save"  />
		</tr>
	</form>

<form action="user/update" method="post" id="form2">
<table border="1">
 <c:forEach var="user" items="${userList}">
			<tr>
				<%-- <td><input type="hidden" value="${user.id}" id="userId"></td> --%>
				<td><input type="text" value="${user.userName}" id="userNameN" name="userNameN"></td>
				<td><input type="text" value="${user.surName}" id="surNameN"></td>
				<td><input type="text" value="${user.phoneNumber}" id="phoneNumberN"></td>
				<td><input type="button" value="delete" class="button_example"
					onclick=" window.location='user/delete?id=${user.id}'" /></td>
				
				<td><input type="button" value="update" class="button_example"
					onclick="window.location='user/update?id=${user.id}&name=${user.userName}&surname=${user.surName}&phone=${user.phoneNumber}'" /></td>
			</tr>
		</c:forEach>
		
</table>	
</form>
</body>
</html>
