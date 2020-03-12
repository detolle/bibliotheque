<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@page isErrorPage="true"%> 
<%@ include file="common/header.jsp" %>

<body>
<div class="container">
<h1>Error Page</h1> 

<h4>URL: ${url}</h4> 
<h4>Exception: ${exception.message}</h4>
<c:forEach items="${exception.stackTrace}" var="exceptionStackTrace">     
  ${exceptionStackTrace}  
</c:forEach>

</div>
</body>
