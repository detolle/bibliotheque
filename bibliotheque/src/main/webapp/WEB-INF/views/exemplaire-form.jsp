<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header.jsp" %>

<div class="container">


<c:if test="${not empty exemplaire.idExemplaire}">
<h4><spring:message code="exemplaire.upd" arguments="${exemplaire.idExemplaire}"/></h4>
</c:if>
<c:if test="${empty exemplaire.idExemplaire}">
<h4><spring:message code="exemplaire.ins"/></h4>
</c:if>

<form:form modelAttribute="exemplaire" action="${action}" method="POST">
<form:hidden path="idExemplaire"/>
<form:hidden path="status" id="hstatus"/>

<fieldset class="form-group">
<form:label path="isbn"><spring:message code="isbn"/></form:label>
<form:input path="isbn" type="text" class="form-control" required="required"/>
<form:errors path="isbn" cssClass="text-warning" /></fieldset>

<fieldset class="form-group">
<form:label path="dateAchat"><spring:message code="dateAchat"/></form:label>
<form:input path="dateAchat" type="date" class="form-control" required="required"/>
<form:errors path="dateAchat" cssClass="text-warning" /></fieldset>

<fieldset class="form-group">
<form:label path="status"><spring:message code="status"/></form:label>
<form:input path="status" type="text" class="form-control" id="status"/>
<form:errors path="status" cssClass="text-warning" /></fieldset>

<input type="submit" class="btn btn-success" value="<spring:message code="val"/>"/>
</form:form>

</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--
document.getElementById("status").disabled = true;
//-->
</script>
  
</body>
</html>