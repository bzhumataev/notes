<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notes</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/index.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
<h1>Notes</h1>

<div>
    <table>
        <tr>
            <td>Title:</td>
            <td><input id="titleId" type="text" name="title"></td>
        </tr>
        <tr>
            <td>Text:</td>
            <td><input id="textId" type="text" name="text"></td>
        </tr>
    </table>
    <input type="button" onclick="sendNote()" value="Add">
    <input type="button" onclick="searchNote()" value="Search">
</div>

<div>
    <c:choose>
        <c:when test="${notes.size() == 0}" >
            <b>You do not have any notes</b>
        </c:when>
        <c:otherwise>
            <form id="form1" method="get">
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Text</th>
                    </tr>
                    <c:forEach items="${notes}" var="note" >
                        <tr>
                            <td>${note.title}</td>
                            <td>${note.text}</td>
                            <td><span class="fake-link" id="${note.id}" onclick="submitData(this.id, '0071')">Remove</span></td>
                        </tr>
                    </c:forEach>
                </table>
                <input id="0071" type="hidden" name="hideId">
            </form>
        </c:otherwise>
    </c:choose>
</div>

<div class="separator bottom auto" ></div>
</body>
</html>
