package service;

import domains.Question;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/16/2017.
 */
public class QuestionService 
{
    public List<Question> getQuestionList()
    {
        List<Question> QuestionList = new ArrayList<Question>();
        String query = "select * from Question";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Question Question = new Question();

                Question.setQuestion(rs.getString("question"));
                System.out.println(rs.getString("question"));
                Question.setOption1(rs.getString("option1"));
                Question.setOption2(rs.getString("option2"));
                Question.setOption3(rs.getString("option3"));
                Question.setOption4(rs.getString("option4"));
                Question.setCorrectAnswer(rs.getString("correctAnswer"));
                Question.setCategory(rs.getString("category"));
                Question.setId(rs.getInt("id"));
                QuestionList.add(Question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return QuestionList;
    }

    public void insert(Question Question) {
        String query = "insert into question (question,option1,option2,option3,option4,correctAnswer,category) values(?,?,?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, Question.getQuestion());
            pstm.setString(2, Question.getOption1());
            pstm.setString(3, Question.getOption2());
            pstm.setString(4, Question.getOption3());
            pstm.setString(5, Question.getOption4());
            pstm.setString(6, Question.getCorrectAnswer());
            pstm.setString(7, Question.getCategory());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void delete(int id)
    {
        String query = "delete from question where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Question getRow(int id)
    {
        Question question = new Question();
        String query = "select * from question where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectAnswer(rs.getString("correctAnswer"));
                question.setCategory(rs.getString("category"));
//                System.out.println(rs.getString("correctAnswer"));
                System.out.println(question.getQuestion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public int getMinId()
    {
        String query = "select min(id) as min from question";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            rs.next();
            return rs.getInt("min");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getMaxId()
    {
        String query = "select max(id) as max from question";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            rs.next();
            return rs.getInt("max");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Question getNextQuestion(int id) throws SQLException{
        String query = "select * from question where id > "+id+" limit 1";
        Question question = new Question();
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        ResultSet rs = pstm.executeQuery();
        while(rs.next())
        {
            question.setQuestion(rs.getString("question"));
            question.setOption1(rs.getString("option1"));
            question.setOption2(rs.getString("option2"));
            question.setOption3(rs.getString("option3"));
            question.setOption4(rs.getString("option4"));
            question.setCorrectAnswer(rs.getString("correctAnswer"));
            question.setCategory(rs.getString("category"));
            question.setId(rs.getInt("id"));
        }
        return question;
    }
    public void edit(int id, Question question) throws SQLException {
        String query = "update question set question = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correctAnswer = ?, category = ? where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,question.getQuestion());
        System.out.println(question.getOption2());
        pstm.setString(2,question.getOption1());
        pstm.setString(3,question.getOption2());
        pstm.setString(4,question.getOption3());
        pstm.setString(5,question.getOption4());
        pstm.setString(6,question.getCorrectAnswer());
        pstm.setString(7,question.getCategory());
        pstm.setInt(8,id);
        pstm.execute();
    }
}
