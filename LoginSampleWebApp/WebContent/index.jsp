
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jsp"%>

<c:set var="errMsg" value="${null}"/>
<c:set var="displayForm" value="${true}"/>
<c:if test="${\"POST\".equalsIgnoreCase(pageContext.request.method)
&& pageContext.request.getParameter(\"submit\") != null}">
  <jsp:useBean id="loginBean" class="Avante.proyecto.LoginBean">
    <jsp:setProperty name="loginBean" property="*"/>
  </jsp:useBean>
  <c:choose>
    <c:when test="${!loginBean.isValidUser()}">
      <c:set var="errMsg" value="Usuario invalido o cnotraseña. Intentelo otra vez"/>
    </c:when>
    <c:otherwise> 
    <% response.sendRedirect("IniciaApp"); %>
    </c:otherwise>
  </c:choose>
</c:if>

<c:if test="${displayForm}">
<body>
  <h2>Login:</h2>
  <!-- Check error message. If it is set, then display it -->
  <c:if test="${errMsg != null}">
    <span style="color: red;">
      <c:out value="${errMsg}"></c:out>
    </span>
  </c:if>
  <form method="post">
    User Name: <input type="text" name="userName"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit" name="submit">Submit</button>
    <button type="reset">Reset</button>
  </form>
  <%@include file="footer.jsp"%>
</body>
</c:if>
</html>