package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domains.Member;
import service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 10/26/2016.
 */
public class MemberServlet extends javax.servlet.http.HttpServlet
{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String page = request.getParameter("page");
        if(checkStatus(request,response))
        {
            if (page.equalsIgnoreCase("list")) {
                List<Member> memberList = new MemberService().getMemberList();
                request.setAttribute("memberList", memberList);
                RequestDispatcher rd = request.getRequestDispatcher("member/list.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("memberForm")) {
                RequestDispatcher rd = request.getRequestDispatcher("member/memberForm.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("addMember")) {
                Member member = new Member();
                member.setName(request.getParameter("username"));
                member.setPassword(request.getParameter("password"));
                member.setPhoneNo(request.getParameter("phoneNo"));

                new MemberService().insert(member);

                List<Member> memberList = new MemberService().getMemberList();
                request.setAttribute("memberList", memberList);
                RequestDispatcher rd = request.getRequestDispatcher("member/list.jsp");
                rd.forward(request, response);

            }
            if (page.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                MemberService memberService = new MemberService();
                memberService.delete(id);

                List<Member> memberList = new MemberService().getMemberList();
                request.setAttribute("memberList", memberList);
                RequestDispatcher rd = request.getRequestDispatcher("member/list.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Member member = null;
                member = new MemberService().getRow(id);
                request.setAttribute("id", id);
                request.setAttribute("member", member);

                RequestDispatcher rd = request.getRequestDispatcher("member/memberUpdateForm.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("editmember")) {
                Member member = new Member();
                int id = Integer.parseInt(request.getParameter("id"));
                member.setName(request.getParameter("name"));
                member.setPassword(request.getParameter("password"));
                member.setPhoneNo(request.getParameter("phoneNo"));
                try {
                    new MemberService().edit(id, member);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                List<Member> memberList = new MemberService().getMemberList();
                request.setAttribute("memberList", memberList);
                RequestDispatcher rd = request.getRequestDispatcher("member/list.jsp");
                rd.forward(request, response);
            }
        }
        else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,IOException {
        doPost(request,response);
    }

    public boolean checkStatus(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        boolean status = false;
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user")!=null){
            status = true;
        }
        return status;
    }

}