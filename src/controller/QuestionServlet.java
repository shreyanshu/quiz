package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domains.Question;
import service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 10/26/2016.
 */
public class QuestionServlet extends javax.servlet.http.HttpServlet
{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String page = request.getParameter("page");
        if(checkStatus(request,response)) {
//        System.out.println(page);
            if (page.equalsIgnoreCase("list")) {
                List<Question> QuestionList = new QuestionService().getQuestionList();
                request.setAttribute("questionList", QuestionList);
                RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("QuestionForm")) {
                RequestDispatcher rd = request.getRequestDispatcher("question/questionForm.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("addQuestion")) {
                Question Question = new Question();
                Question.setQuestion(request.getParameter("question"));
                Question.setOption1(request.getParameter("option1"));
                Question.setOption2(request.getParameter("option2"));
                Question.setOption3(request.getParameter("option3"));
                Question.setOption4(request.getParameter("option4"));
                Question.setCorrectAnswer(request.getParameter("correctAnswer"));
                Question.setCategory(request.getParameter("category"));

                new QuestionService().insert(Question);

                List<Question> QuestionList = new QuestionService().getQuestionList();
                request.setAttribute("questionList", QuestionList);
                RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
                rd.forward(request, response);

            }
            if (page.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                QuestionService QuestionService = new QuestionService();
                QuestionService.delete(id);

                List<Question> QuestionList = new QuestionService().getQuestionList();
                request.setAttribute("questionList", QuestionList);
                RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Question question = null;
                question = new QuestionService().getRow(id);
                request.setAttribute("id", id);
                request.setAttribute("question", question);
                System.out.println(question.getQuestion());
                RequestDispatcher rd = request.getRequestDispatcher("question/questionUpdateForm.jsp");
                rd.forward(request, response);
            }

            if (page.equalsIgnoreCase("editQuestion")) {
                Question question = new Question();
                int id = Integer.parseInt(request.getParameter("id"));
                question.setQuestion(request.getParameter("question"));
                question.setOption1(request.getParameter("option1"));
                question.setOption2(request.getParameter("option2"));
                question.setOption3(request.getParameter("option3"));
                question.setOption4(request.getParameter("option4"));
                question.setCorrectAnswer(request.getParameter("correctAnswer"));
                question.setCategory(request.getParameter("category"));
                System.out.println(id);
                try {
                    new QuestionService().edit(id, question);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                List<Question> QuestionList = new QuestionService().getQuestionList();
                request.setAttribute("questionList", QuestionList);
                RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
                rd.forward(request, response);
            }
        }
        else
        {
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
        if(session.getAttribute("user")!=null)
        {
            status = true;
        }
        return status;
    }

}