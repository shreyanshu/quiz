<ul>
    <li><a href="home?page=home">Home</a></li>

    <c:if test="${sessionScope.user.role=='admin'}">
        <li><a href="userList?page=list">User</a></li>
        <li><a href="questionList?page=list">Question</a></li>
    </c:if>

    <li><a href="getFirstQuestion?page=getFirstQuestion">Play Quiz</a></li>
    <li><a href="logout?page=logout">Logout </a></li>
    <%-- <li><a href="memberList?page=list">Member</a></li>--%>
</ul>