<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 직원의 상세보기....${myname }</h1>
<form action="empDetail" method="post">

직원번호:<input type="number" value="${emp.employee_id}" name="employee_id"><br>
부서이름:<input type="text" value="${emp.frist_name}" name="fname"><br>
<input type="submit" value="수정하기">
</form>

</body>
</html>