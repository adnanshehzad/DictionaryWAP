<%--
  Created by IntelliJ IDEA.
  User: INNOVATION
  Date: 11/19/2019
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
     <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="<c:out value="${baseURL}"></c:out>">Dictionary ::: PowerWord</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="./index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./SignIn">SignIn</a>
                </li>
            </ul> 
            
            <%--
            <span style="float:right" >Wecome <span>${welcomeUser }</span></span>
            --%> 
            <span style="float:right">
            	<c:if test="${isAccountExist == true}">
            		<span>${welcomeUser}</span>
            	</c:if>            
            </span>
            
        </div>
    </nav>
</header>
