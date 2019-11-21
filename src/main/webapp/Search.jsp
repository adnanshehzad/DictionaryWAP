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

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div class="search-div">
    <div class="header">
        <h1>MUM Dictionary</h1>
    </div>

    <div class="wrapper">
        <div class="words">

            <div class="column">
                <div class="input-field col s12">
                    <input id="search" type="text" placeholder="search..." name="search" class="validate">
                    <label for="search_input">Search</label>
                    <button onclick="search()">Go</button>
                </div>
            </div>




            <h5>Existing Words</h5>

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

</div>

<script src="script/app.js"></script>

</body>
</html>
