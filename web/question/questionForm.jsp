<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/26/2016
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        </div> <!-- end of templatemo_menu -->
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
                </div>

                <!-- CSS goes in the document HEAD or added to your external stylesheet -->

                <!-- Table goes in the document BODY -->
                <form method="post" action="addQuestion">
                    <input type="hidden" name="page" value="addQuestion">
                    <table class="imagetable">

                        <tr>
                            <th>Question</th><td><input type="text" name="question"></td>
                        </tr>
                        <tr>
                            <th>Option1</th><td><input type="text" name="option1"></td>
                        </tr>
                        <tr>
                            <th>Option2</th><td><input type="text" name="option2"></td>
                        </tr>
                        <tr>
                            <th>Option3</th><td><input type="text" name="option3"></td>
                        </tr>
                        <tr>
                            <th>Option4</th><td><input type="text" name="option4"></td>
                        </tr>
                        <tr>
                            <th>Correct Ans.</th><td><input type="number" max="4" min="1" name="correctAnswer"></td>
                        </tr>
                        <tr>
                            <th>Category</th><td><input type="text" name="category"></td>
                        </tr>
                        <tr>
                            <th></th><td><input type="submit" value="Add Question"></td>
                        </tr>
                    </table>
                </form>
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