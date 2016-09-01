<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<body>
<h1><spring:message code="event.list.title"/></h1>

<%--@elvariable id="users" type="java.util.List"--%>
<c:forEach items="${tracks}" var="track">
    <table>
    	<caption style="text-align:left">${track.getTrackNumber()}</caption>
        <c:forEach items="${track.getMorningSchedule()}" var="morning">
	        <tr>
	        	<td>
	            	<c:out value="${morning.getTimeString()}"/>
	            </td>
	            <td>
	            	<c:out value="${morning.getTopic()}"/>
	            </td>
	        </tr>
        </c:forEach>
        <c:forEach items="${track.getAfternoonSchedule()}" var="afternoon">
	        <tr>
	        	<td>
	            	<c:out value="${afternoon.getTimeString()}"/>
	            </td>
	            <td>
	            	<c:out value="${afternoon.getTopic()}"/>
	            </td>
	        </tr>
        </c:forEach>
    </table>
    <br><br>
</c:forEach>


<a href="<spring:url value="/save_event.html" />"><spring:message code="event.create"/></a>
</body>
</html>