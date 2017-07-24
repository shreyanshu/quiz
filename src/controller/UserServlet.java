package controller;

import domains.User;
import service.UserAnsService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 9/9/2016.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,IOException {
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);
            if (user != null) {
                HttpSession session = request.getSession(false);
                session.setAttribute("uid", user.getId());
                session.setAttribute("user", user);
                request.setAttribute("msg", "Login Success!");

                //delete previous record of the user
                UserAnsService u = new UserAnsService();
                u.deleteData(user.getId());

                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid User or Password!");

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
        if(checkStatus(request,response)) {

            if (page.equalsIgnoreCase("logout")) {
                HttpSession session = request.getSession(false);
                session.invalidate();
//                System.out.println(session.getAttribute("user"));
                request.setAttribute("msg", "Logout Success");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("home")) {
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("list")) {
                //get user list from db
                //set list to request
                //redirect to list page

                List<User> userList = new UserService().getUserList();
                request.setAttribute("userList", userList);
                RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("userForm")) {

                RequestDispatcher rd = request.getRequestDispatcher("user/userForm.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("addUser")) {
                User user = new User();
                user.setName(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setRole(request.getParameter("role"));
                new UserService().insert(user);
                List<User> userList = new UserService().getUserList();
                request.setAttribute("userList", userList);
                RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                UserService userService = new UserService();
                userService.delete(id);
                List<User> userList = new UserService().getUserList();
                request.setAttribute("userList", userList);
                RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                User user = null;
                user = new UserService().getRow(id);
                request.setAttribute("id", id);
                request.setAttribute("user", user);

                RequestDispatcher rd = request.getRequestDispatcher("user/userUpdateForm.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("edituser")) {
                User user = new User();
                int id = Integer.parseInt(request.getParameter("id"));
                user.setName(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setRole(request.getParameter("role"));
                try {
                    new UserService().edit(id, user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                List<User> userList = new UserService().getUserList();
                request.setAttribute("userList", userList);
                RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
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
