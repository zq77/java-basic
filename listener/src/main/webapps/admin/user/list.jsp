<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>User list</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <table border="1" width="70%">
     		<tr>
     			<td>
     				姓名
     			</td>
     			<td>
     				创建时间
     			</td>
     			<td>
     				lTime
     			</td>
     			<td>
     				IP
     			</td>
     			<td>
     				操作
     			</td>
     		</tr>
     		<c:forEach items="${list}" var="map">
     			<tr>
     				<td>
     					<c:out value="${map.user.name}"></c:out>
     				</td>
     				<td>
     					${map.cTime}
     				</td>
     				<td>
     					${map.lTime}
     				</td>
     				<td>
     					${map.ip}
     				</td>
     				<td>
     					<a href="<c:url value='kickupSevlet?id=${map.id}'/>">踢出</a>
     				</td>
     			</tr>
     		</c:forEach>
     	</table>
  </body>
</html>
