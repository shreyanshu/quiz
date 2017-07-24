package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domains.Question;
import domains.User;
import domains.UserAnswer;
import service.QuestionService;
import service.UserAnsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 10/26/2016.
 */
public class QuizServlet extends javax.servlet.http.HttpServlet
{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String page = request.getParameter("page");
        if(checkStatus(request,response)) {
//        System.out.println(page);
//        String page = request.getParameter("page");
            System.out.println(page);
            if (page.equalsIgnoreCase("getQuestion")) {
                Question question = null;
                int id = Integer.parseInt(request.getParameter("id"));
                question = new QuestionService().getRow(id);
                request.setAttribute("question", question);
                request.setAttribute("id", id);
                RequestDispatcher rd = request.getRequestDispatcher("quiz/playQuiz.jsp");
                rd.forward(request, response);
            }
            if (page.equalsIgnoreCase("getFirstQuestion")) {
                Question question = null;
                int id;
                id = new QuestionService().getMinId();
                //            System.out.println(id);
                if (id == 0) {
                    request.setAttribute("msg", "No questions added");
                    RequestDispatcher rd = request.getRequestDispatcher("Quiz/noQuestionsLeft.jsp");
                    rd.forward(request, response);
                } else {
                    question = new QuestionService().getRow(id);
                    request.setAttribute("question", question);
                    request.setAttribute("id", id);
                    RequestDispatcher rd = request.getRequestDispatcher("Quiz/playQuiz.jsp");
                    rd.forward(request, response);
                }
            }
            if (page.equalsIgnoreCase("getNextQuestion")) {

                int id = Integer.parseInt(request.getParameter("id"));
                int ans = Integer.parseInt(request.getParameter("val"));
                //            System.out.println("1");
                Question quest = new QuestionService().getRow(id);
                UserAnswer userAns = new UserAnswer();
                if (Integer.parseInt(quest.getCorrectAnswer()) == ans) {
                    userAns.setMarks(10);
                } else {
                    userAns.setMarks(0);
                }
                userAns.setQuestion(quest.getQuestion());
                userAns.setCorrectAns(Integer.parseInt(quest.getCorrectAnswer()));
                HttpSession session = request.getSession(false);
                userAns.setUid((Integer) session.getAttribute("uid"));
                System.out.println("2");
                userAns.setQid(id);
                userAns.setUserAns(ans);
                new UserAnsService().insert(userAns);
                //            System.out.println("3");

                int maxId = new QuestionService().getMaxId();
                if (id == maxId) {
                    List<UserAnswer> userAnsL = new UserAnsService().getUserList((Integer) session.getAttribute("uid"));
                    request.setAttribute("userAns", userAnsL);
                    int totMrks = new UserAnsService().getTotalMarks((Integer) session.getAttribute("uid"));
                    System.out.println(totMrks);
                    request.setAttribute("totMarks",totMrks);
                    System.out.println(userAnsL);
                    request.setAttribute("msg", "Final Result");
                    List<Question> ques = new QuestionService().getQuestionList();

                    request.setAttribute("questions", ques) ;
                    RequestDispatcher rd = request.getRequestDispatcher("Quiz/noQuestionsLeft.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    try {
                        Question question = new QuestionService().getNextQuestion(id);
                        request.setAttribute("question", question);
                        request.setAttribute("id", question.getId());
                        RequestDispatcher rd = request.getRequestDispatcher("Quiz/playQuiz.jsp");
                        rd.forward(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
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
