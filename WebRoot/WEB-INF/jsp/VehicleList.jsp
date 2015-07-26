<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>车标列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table>
		<tr>
			<td>车标</td>
			<td>车名</td>
			<td>国家</td>
			<td>故事</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${ vehicleList}" var="vehicle">
			<tr>
				<td>${vehicle.CLogoUrl }</td>
				<td>${vehicle.CName }</td>
				<td>${vehicle .CCountry}</td>
				<td>${vehicle .CTale}</td>
				<td><a href="<%=path%>/vehicle/del/${vehicle.CId}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
