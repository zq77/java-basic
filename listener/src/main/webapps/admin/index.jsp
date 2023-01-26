<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>admin</title>
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
    <body style="margin:0px;">
		<table border="1" width="100%" height="100%">
		   <tr height="60">
			<td colspan="2" align="center">
				欢迎${user.name}来到我们的公司...
				<a href="<c:url value='servlet/user?action=logout'/>"><font style="float: right" color="red">退出</font></a>
			</td>
		   </tr>
		   <tr>
			<td style="width:10%" valign="top" align="center">
				<c:forEach items="${privileges}" var="privilege">
					<a target="dataFrame" href="<c:url value='${privilege.url}'/>">${privilege.name}</a>
					<br/>
				</c:forEach>
			</td>
			<td>
					<iframe name="dataFrame" frameborder="0" width="100%" height="100%"></iframe>
			</td>
		   </tr>
		</table>
  </body>
</html>
