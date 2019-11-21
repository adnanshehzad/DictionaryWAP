<%--
  Created by IntelliJ IDEA.
  User: INNOVATION
  Date: 11/19/2019
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/sty.css">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <title>Sign-Up</title>
</head>
<body>
<div class="signup-div">
    <div class="row">
        <div class="logo">
            <img src="images/di.png" style="height: 100px; width: 100px;" alt="">
        </div>
    </div>
    <div class="row center-align">
        <h5>Sign up</h5>
        <h6>Sign up to create MUM Dictionary Account</h6>
    </div>


    <form action="" method="post">
        <div class="row">
            <div class="input-field col s12">
                <input id="username_input" name="username" type="text" class="validate">
                <label for="username_input">Create your username</label>
            </div>
        </div>

        <div class="row">

            <div class="column">

                <div class="input-field col s6">
                    <input id="fname_input" name="firstname" type="text" class="validate">
                    <label for="fname_input">Enter your First name</label>
                </div>

            </div>


            <div class="column">
                <div class="input-field col s6">
                    <input id="lname_input" name="lastname" type="text" class="validate">
                    <label for="lname_input">Enter your Last name</label>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="email_input" name="email" type="email" class="validate">
                <label for="email_input">Enter your Email</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="password_input" name="password" type="password" class="validate">
                <label for="password_input">Choose Password</label>
            </div>
        </div>

        <div class="row">
            <div class="col s12">Not your computer? Use a Private Window to sign up. </div>
        </div>
        <div class="row"></div>

        <div class="row">
            <div class="col s6"><a href="./SignIn.jsp">Already have an account?</a></div>
            <div class="col s6 right-align"><button type="submit" class="waves-effect waves-light btn">SignUp</button></div>
        </div>

    </form>

</div>

</body>
</html>
