<%--
  Created by IntelliJ IDEA.
  User: pawn
  Date: 11/20/2019
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="header">
    <h1>MUM Dictionary</h1>
</div>
<hr>
<div class="wrapper">
    <div class="words">
        <form action="" method ="GET">
            <input type="text" id="search" name="search" placeholder="search...">
            <button onclick="search()">Go</button>
        </form>


        <h3>Existing Words</h3>

        <ul id="word_list"></ul>

    </div>

    <div class="word">
        <h3 id="word_text">WORD</h3>
        <p id="definition">this is definition </p>
        <hr>

        <h3>Synonyms: </h3>
        <li id="synonym"> syn1</li>



    </div>
</div>

<script src="script/app.js"></script>

</body>
</html>
