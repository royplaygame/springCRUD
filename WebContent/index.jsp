<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url=this.href;
			var args={};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++){
					var id=data[i].id;
					var lastName=data[i].lastName;
					var email=data[i].email;
					var gender=data[i].gender;
					alert(id +" "+lastName+" "+email+" "+gender);
				} 
			});
			return false;
		});
	});

</script>
</head>
<body>

	<a href="emps">List All Employees</a>
	<br />
	<br />
	<a href="testJson" id="testJson">Test JSON</a>
</body>
</html>