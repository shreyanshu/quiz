<%@ page import="domains.UserAnswer" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/22/2017
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Demo Project</title>
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/table.css" rel="stylesheet" type="text/css"/>

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



                <!-- CSS goes in the document HEAD or added to your external stylesheet -->

                <!-- Table goes in the document BODY -->

                <h2>${msg}</h2>


                <table class="imagetable">
                    <tr>
                        <th>Question</th>
                        <th>Correct Answer</th>
                        <th>Chosen Answer</th>
                        <th>Marks</th>
                    </tr>

                    <c:forEach items="${userAns}" var="userAns">
                        <c:choose>
                            <c:when test="${userAns.correctAns == userAns.userAns}">
                                <tr>
                                    <td style="background-color:limegreen; !important;">${userAns.question}</td>
                                    <td style="background-color:limegreen; !important;">${userAns.correctAnswerSt}</td>
                                    <td style="background-color:limegreen; !important;">${userAns.chosenAnswerSt}</td>
                                    <td style="background-color:limegreen; !important;">${userAns.marks}</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <tr >
                                    <td style="background-color:red; !important;">${userAns.question}</td>
                                    <td style="background-color:red; !important;">${userAns.correctAnswerSt}</td>
                                    <td style="background-color:red; !important;">${userAns.chosenAnswerSt}</td>
                                    <td style="background-color:red; !important;">${userAns.marks}</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </table>
                <br>
                <h3>Total Marks=${totMarks}</h3>


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