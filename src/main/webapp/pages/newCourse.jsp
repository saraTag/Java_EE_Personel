<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Basic interface</title>
	</head>
	<body>
		<form method="POST" action="../course">
			<div>
				<h1>Create Course</h1>
				<input type="text" name=id placeholder="ID (Number)"/>
				<input type="text" name="id_master" placeholder="Master (ID)"/>
				<input type="text" name="year_master" placeholder="Master (Year)"/>
				<input type="text" name="description" placeholder="Description"/>
				<label for="compulsory">Mandatory</label></label><input type="checkbox" name="compulsory"/>
				<input type="submit"></input>
			</div>
		</form>
	</body>
</html>