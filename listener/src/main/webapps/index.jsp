<%@ page language="java" import="java.util.*,com.z.model.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <a href="servlet/user?action=login">loginUI</a> <br/>
    <hr/>
    点击量 ： ${number} || sessionid : <%=session.getId() %><br/>
    <%
    	User u = new User();
    	u.setName("Rose");
    	application.setAttribute("user",u);
    %>
   user : <%=((User)application.getAttribute("user")).getName() %> <br/>
    ====================当前在线人数 : <%=application.getAttribute("current") %>==================== <br/>
    以下是IP地址 : <br/>
    <%
    	List<HttpSession> list = (List<HttpSession>)application.getAttribute("list");

    	for(HttpSession s : list) {
    		out.println(s.getAttribute("ip") + "<br/>");
    	}
    	
    	//将sessionid放到cookie中，并且设置cookie的存在时间是30分钟
    	Cookie cookie = new Cookie("JSESSIONID",session.getId());
    	cookie.setMaxAge(60*30);
    	cookie.setPath(request.getContextPath());
    	response.addCookie(cookie);
    %>
  </body>
</html>
