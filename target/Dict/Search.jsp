<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pawn
  Date: 11/20/2019
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Search Page</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

<%
if (session.getAttribute("username") == null)
    response.sendRedirect(request.getContextPath() + "/SignIn.jsp");

    List<String> newWords = (List<String>)session.getAttribute("previouswords");
    System.out.println("In Search List is "+ newWords.toString());
%>



<div class="search-div">
    <div class="header">
        <h1>MUM Dictionary</h1>
        <form action="logout" method="post">
            <input id="logout" type="submit" value="Logout"></input>
        </form>

    </div>

    <div class="wrapper">
        <div class="words">

            <div class="column">
                <form action="search" method ="post">
                    <%--<input type="text" id="search" name="searchkeyword" placeholder="search...">
                    <button >Go</button>--%>

                <div class="input-field col s12">
                    <input id="search" type="text" placeholder="search..." name="searchkeyword" class="validate" required>
                    <label for="search_input">Search</label>
                    <button id="search_input" type="submit">Go</button>
                </div>
                </form>
            </div>
            <h5>Existing Words</h5>

            <ul id="word_lst"></ul>

            <%
                for (int i=0;i<newWords.size();i++){
                    String st = newWords.get(i);

               %>


            <li><%=st  %>  </li>

            <%

                }
                %>




        </div>

        <%

            String newWord = (String) request.getAttribute("word");
            System.out.println("Word in JSP is: "+newWord);
            String newPos = (String) request.getAttribute("pos");
            String newDef = (String) request.getAttribute("def");



        %>

        <div class="word">
            <h3 id="word_tex"><%=newWord%></h3>
            <p id="defiition"><%=newDef%></p>
            <hr>

            <h3>Part of Speech: </h3>
            <p id="pos"><%=newPos%></p>

        </div>
    </div>

</div>

<script src="script/app.js"></script>

</body>
</html>
