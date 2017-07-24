<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Demo Project</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css"/>
    <link href="css/table.css" rel="stylesheet" type="text/css"/>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <div id="templatemo_header">

            <h2>${msg}</h2>
        </div>
        <!-- end of templatemo_header -->

        <div id="templatemo_menu">

            <%@include file="../includes/menu.jsp"%>

        </div>
        <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <%@include file="../includes/sidemenu.jsp"%>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>


            <div id="templatemo_content">

                <div class="content_section">

                    <h2>Question List</h2>

                    <h2><a href="questionForm?page=questionForm">Add New Question</a></h2>
                </div>

                <!-- CSS goes in the document HEAD or added to your external stylesheet -->

                <!-- Table goes in the document BODY -->
                <table class="imagetable">
                    <tr>
                        <th>Question</th>
                        <th>option1</th>
                        <th>option2</th>
                        <th>option3</th>
                        <th>option4</th>
                        <th>Correct Answer</th>
                        <th>Category</th>
                        <th>edit</th>
                        <th>delete </th>
                    </tr>

                    <c:forEach items="${questionList}" var="question">

                        <tr>
                            <td>${question.question}</td>
                            <td>${question.option1}</td>
                            <td>${question.option2}</td>
                            <td>${question.option3}</td>
                            <td>${question.option4}</td>
                            <td>${question.correctAnswer}</td>
                            <td>${question.category}</td>
                            <td><a href="deleteQuestion?page=edit&id=${question.id}"><img src="../images/edit.jpg" height="20px" width="20px"></a></td>
                            <td><a href="deleteQuestion?page=delete&id=${question.id}"><img src="../images/delete.png" height="20px" width="20px"></a></td>

                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">
            <%@include file="../includes/footer.jsp"%>
        </div>
        <!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>
</table>