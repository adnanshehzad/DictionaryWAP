<%--
  Created by IntelliJ IDEA.
  User: INNOVATION
  Date: 11/19/2019
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page isELIgnored="false" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/sty.css">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <title>Sign-In</title>
</head>
<body>
<%@ include file="FRAGMENTS/header.jsp"%>

<div class="login-div">
    <div class="row">
        <div class="logo">
            <img src="images/di.png" style="height: 100px; width: 100px;" alt="">
        </div>
    </div>
    <div class="row center-align">
        <h5>Sign in</h5>
        <h6>MUM Dictionary Account</h6>
    </div>


    <form action="signin-form-data-validator" method="post">
    
    <c:if test="${isErrMsgsPresent == true }">
                    <div>
                        <p>
                            ${errMsgs}
                        </p>
                    </div>
                </c:if>
                
            <c:if test="${isAccountNotExist == true}">
            	<div>
            		<p>${errAccount}</p>
            	</div>            
            </c:if>
    
    
    
        <div class="row">
            <div class="input-field col s12">
                <input id="username_input" type="text" name="userName" class="validate">
                <label for="username_input">Username</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input name="password" id="password_input" type="password" class="validate">
                <label for="password_input">Password</label>
                <div><a href="#"><b>Forgot Password?</b></a></div>
            </div>
        </div>

        <div class="row">
            <div class="col s12">Not your computer? Use a Private Window to sign in.
            </div>
        </div>
        <div class="row"></div>

        <div class="row">
            <div class="col s6"><a href="./SignUp.jsp">Create account</a></div>
            <div class="col s6 right-align"><button type="submit" class="waves-effect waves-light btn">Login</button></div>
        </div>

    </form>

</div>

<%-- <%@ include file="FRAGMENTS/footer.jsp"%>
 --%>
</body>
</html>
