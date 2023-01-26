<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(session.getId());
Cookie cookie = new Cookie("JSESSIONID",session.getId());
cookie.setMaxAge(60*30);
response.addCookie(cookie);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<%
Cookie[] cookies = request.getCookies();
if(cookies != null) {
%>
  <body>
<form method="post" action="loginok.jsp" name="form">
	<table width="768" align="center" border="2">
		<tr>
			<th colspan="2" align="center" >用户登陆 </th>
		</tr>
<%
	for(Cookie c : cookies) {
%> 
		<% 
		if("username".equals(c.getName())) {
		%>
		<tr>
			<td width="15%">用户名：</td>
			<td>
				<input type="text" size="30" name="username" value="<%= c.getValue() %>"/>
			 </td>
		</tr>
		<% } %>
		<%
		if("pwd".equals(c.getName())) {
		%>
		<tr>
			<td width="15%">密码：</td>
			<td>
				<input type="password" size="20" name="pwd" value="<%= c.getValue() %>"/>
			</td>
		</tr>
		<% } %>
		
<% 	} %>

		<tr>
			<td><input type="submit" value="登陆"></td>
		</tr>
	</table>
</form>
<% 
	return;
}
%>

<form method="post" action="loginok.jsp" name="form">
	<table width="768" align="center" border="2">
		<tr>
			<th colspan="2" align="center" >用户登陆 </th>
		</tr>
		<tr>
			<td width="15%">用户名：</td>
			<td>
				<input type="text" size="30" name="username" value=""/>
			 </td>
		</tr>
		<tr>
			<td width="15%">密码：</td>
			<td>
				<input type="password" size="20" name="pwd" value=""/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="登陆"></td>
		</tr>
	</table>
</form>
<%
System.out.println("cookie is null");

Cookie cookie1 = new Cookie("username","z13903417792");
Cookie cookie2 = new Cookie("pwd","z123456");

cookie1.setMaxAge(60*60*24*7*2);
response.addCookie(cookie1);
cookie2.setMaxAge(60*60*24*7*2);
response.addCookie(cookie2);
%>
  </body>
</html>
