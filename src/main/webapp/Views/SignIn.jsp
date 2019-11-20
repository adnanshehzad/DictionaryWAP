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
    <%--    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">--%>
    <%--  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">  --%>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="css/style.css">--%>

    <title>Sign-In</title>
</head>
<body>

<div class="container"><br/>
    <form id="formCustomerContact" method="post" action="SignIn">
        <fieldset>
            <legend>Sign In Form</legend>
                <div>
                    <p>
                    </p>
                </div>
            <div class="form-group">
                <label for="userName">*Username:</label>
                <input type="text" class="form-control" id="userName" name="userName" aria-describedby="userNameHelp" placeholder="e.g. John321" title="Enter your username" autofocus>
                <small id="userNameHelp" class="form-text text-muted">Enter your username.</small>
            </div>
            <div class="form-group">
                <label for="password">*Password:</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="userNameHelp" placeholder="xxxxx" title="Enter your password" autofocus>
            </div>
            <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Submit</button>
        </fieldset>
    </form>
</div>
<div class="container">
    <br/>
    <br/>
    <span class="text-muted">Hit Count for this page: 1</span>
    <span style="float:right;" class="text-muted">Total Hit Count for the entire WebApp: 4</span>
</div>


</body>
</html>
