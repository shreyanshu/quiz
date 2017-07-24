<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/22/2017
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
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



                <!-- CSS goes in the document HEAD or added to your external stylesheet -->

                <!-- Table goes in the document BODY -->

                <h2>${question.question}</h2>
                <div id="buttonx">
                    <a href="getNextQuestion?page=getNextQuestion&id=${id}&val=1"><button type="button" style="height:30px;width:80px">${question.option1}</button></a>
                    <a href="getNextQuestion?page=getNextQuestion&id=${id}&val=2"><button type="button" style="height:30px;width:80px">${question.option2}</button></a>
                </div>
                <br><br>
                <div id="buttony">
                    <a href="getNextQuestion?page=getNextQuestion&id=${id}&val=3"><button type="button" style="height:30px;width:80px">${question.option3}</button></a>
                    <a href="getNextQuestion?page=getNextQuestion&id=${id}&val=4"><button type="button" style="height:30px;width:80px">${question.option4}</button></a>
                </div>
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