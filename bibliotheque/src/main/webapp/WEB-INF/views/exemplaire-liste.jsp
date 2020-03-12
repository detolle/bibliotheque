<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ include file="common/header.jsp" %>

<body class="bg-light">
<div class="container">
<h4><spring:message code="exemplaire.liste"/></h4>

	<table class="table table-striped">
	<!--caption><spring:message code="exemplaire.liste"/></caption-->
		<thead>
			<tr>
				<th><spring:message code="idExemplaire"/></th>
				<th><spring:message code="dateAchat" /></th>
				<th><spring:message code="status" /></th>
				<th><spring:message code="isbn" /></th>
			</tr>
		</thead>		
		<tbody>
			<c:forEach items="${liste}" var="liste">
				<tr>
					<td>${liste.idExemplaire}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${liste.dateAchat}"/></td>
					<td>${liste.status}</td>
					<td>${liste.isbn}</td>
					<td><a href="upd?id=${liste.idExemplaire}" class="btn btn-success"><spring:message code="upd"/></a></td>
					<td><a href="del?id=${liste.idExemplaire}" class="btn btn-danger delete"><spring:message code="del"/></a></td>
				</tr>			
			</c:forEach>
		</tbody>		
	</table>
	
	<div>
		<a class="btn btn-primary" href="ins"><spring:message code="ins"/></a>		
	</div>
	
</div>
<script src="<%=request.getContextPath()%>/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$(".delete").click(function(){
	    if(confirm("<spring:message code="del.confirm"/>")){
	        return true;
	    }
	    else{
	        return false;
	    }
	})
});
</script>
</body>
</html>