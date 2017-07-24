<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/27/2016
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

                    <%@include file="../includes/sidemenu.jsp"%>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>



            <div id="templatemo_content">

                <h2><a href="userForm?page=userForm">Edit Member</a></h2>
                <div class="content_section">
                    <form method="post" action="/editMember">
                        <input type="hidden" name="page" value="editmember">
                        <input type="hidden" name="id" value=${id}>
                        <table id="t01">
                            <tr>
                                <th>Member Name</th><td><input type="text" name="name" value=${member.name}></td>
                            </tr>
                            <tr>
                                <th>Password</th><td><input type="text" name="password" value=${member.password}></td>
                            </tr> <tr>
                            <th>Phone No.</th><td><input type="text" name="phoneNo" value=${member.phoneNo}></td>
                        </tr> <tr>
                            <th></th><td><input type="submit" name="submit" value="Update User"></td>
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
    <%@include file="../includes/footer.jsp"%>
</footer>

</body>

</html>
