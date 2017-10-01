<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--  
	SpringMVC 处理静态资源:
	1. 为什么会有这样的问题:
	优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
	若将 DispatcherServlet 请求映射配置为 /, 
	则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理, 
	因找不到对应处理器将导致错误。
	2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
-->
<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href=$(this).attr("href");
			$("form").attr("action",href).submit();
			return false;
		});
	});

</script>
</head>
<body>
	
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>

	<center>
	<div style="height: 150px"></div>
	<c:if test="${empty requestScope.employees }">
	没有任何元素
	</c:if>
	<c:if test="${!empty requestScope.employees }">

		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Gender</td>
				<td>Department</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach items="${requestScope.employees }" var="employee">
				<tr>
					<td>${employee.id }</td>
					<td>${employee.lastName }</td>
					<td>${employee.email }</td>
					<td>${employee.gender==0?'FeMale':'Male' }</td>
					<td>${employee.department.departmentName }</td>
					<td><a href="emp/${employee.id }">Edit</a></td>
					<td><a class="delete" href="emp/${employee.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/><br/>
	<a href="${pageContext.request.contextPath }/emp">New Department</a>
	</center>
</body>
</html>