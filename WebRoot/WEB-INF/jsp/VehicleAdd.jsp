<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加一个汽车故事</title>

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
	<form action="<%=path %>/vehicle/add" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>图标</td>
				<td><input name="files" type="file" >
				</td>
			</tr>
			<tr>
				<td>车名</td>
				<td><input name="CName" type="text" >
				</td>
			</tr>
			<tr>
				<td>国家</td>
				<td><input name="CCountry" type="text" >
				</td>
			</tr>
			<tr>
				<td>故事介绍</td>
				<td><input name="CTale" type="text" >
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
