<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Simple Agenda Organizer</title>
	
	<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		$("#lightning_checkbox").change(function() {
		    if(this.checked) {
		    	$("#input_duration").prop('disabled', true);
		    } else {
		    	$("#input_duration").prop('disabled', false);
		    }
		}); 
	});
	
	
    </script>
	


</head>
<body>
<h1><spring:message code="event.create.title"/></h1>
<!--  a href="<spring:url value="/list_events.html" />"><spring:message code="event.list"/></a-->
<form:form method="POST" id="myform" action="/save_event.html" modelAttribute="form">
<form:errors path="" element="div"/>
	<table border="0" >
    <tr>
        <td><form:label path="topic"><spring:message code="event.topic"/></form:label></td>
        <td><form:input path="topic"/></td>
        <td><form:errors path="topic"/></td>
    </tr>
    <tr>
        <td><form:label path="duration"><spring:message code="event.duration"/></form:label></td>
        <td><form:input path="duration" id="input_duration" /> or <form:checkbox path="lightning" id="lightning_checkbox" />Lightning </td>
        <td><form:errors path="duration"/></td>
     </tr>
     <tr>
     	<td></td> 
        <td><input type="submit" value="Save"/></td>
     </tr>
    </table>
</form:form>
<a href="<spring:url value="/list_events.html" />"><spring:message code="event.list"/></a>
</body>
</html>