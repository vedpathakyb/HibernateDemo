<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="com.AV" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Family</title>
</head>
<body>
All the members are as below. </br>
<%
if(request.getAttribute("All Members")!= null)
{
	ArrayList am=(ArrayList) request.getAttribute("All Members");
	for(int i=0;i< am.size();i++)
	{
		AV c=(AV)am.get(i);
		out.println(c.getId());
		out.println(c.getName());
		out.println(c.getAge());
		out.println("\n");		
		%></br><%
	}	
}
else
{
	out.println("No data in Array");
}
%> 
</body>
</html>