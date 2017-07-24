<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/19/2017
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link href="../css/table.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript">
        function showLoginDiv()
        {
            document.getElementById("loginDiv").style.display="";
        }
    </script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <div id="templatemo_header">

            <h2>${msg}</h2>
        </div> <!-- end of templatemo_header -->

        <div id="templatemo_menu">

            <%@include file="../includes/menu.jsp"%>

        </div> <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <h2>Our Services</h2>

                    <ul class="categories_list">
                        <li><a href="#">Test1</a></li>
                        <li><a href="#">Test2</a></li>
                    </ul>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>



            <div id="templatemo_content">

                <h2><a href="userForm?page=userForm">Edit Question</a></h2>
                <div class="content_section">
                    <form method="post" action="/editQuestion">
                        <input type="hidden" name="page" value="editquestion">
                        <input type="hidden" name="id" value=${id}>
                        <table id="t01">
                            <tr>
                                <th>Question</th><td><input type="text" name="question" value="${question.question}"></td>
                            </tr>
                            <tr>
                                <th>Option1</th><td><input type="text" name="option1" value="${question.option1}"></td>
                            </tr>
                            <tr>
                                <th>Option2</th><td><input type="text" name="option2" value="${question.option2}"></td>
                            </tr>
                            <tr>
                                <th>Option3</th><td><input type="text" name="option3" value="${question.option3}"></td>
                            </tr>
                            <tr>
                                <th>Option4</th><td><input type="text" name="option4" value="${question.option4}"></td>
                            </tr>
                            <tr>
                                <th>Correct Answer</th><td><input type="number" max="4" min="1" name="correctAnswer" value=${question.correctAnswer}></td>
                            </tr>
                            <tr>
                                <th>Category</th><td><input type="text" name="category" value=${question.category}></td>
                            </tr>
                            <tr>
                                <th></th><td><input type="submit" name="submit" value="Update User">
                            </td>
                        </tr>


                        </table>
                    </form>
                </div>



            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->


    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

<hr/>
<footer class="footer">
    <p align="center">
        &copy; Copyright@ dwit.edu.np
    </p>
</footer>

</body>
</html>
