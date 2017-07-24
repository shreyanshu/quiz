package service;

import domains.UserAnswer;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/17/2017.
 */
public class UserAnsService {
    public void insert(UserAnswer userAns) {
        String query = "insert into userAns (qid, uid, userAns, marks, question, correctAns) values(?,?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, userAns.getQid());
            pstm.setInt(2, userAns.getUid());
            pstm.setInt(3, userAns.getUserAns());
            pstm.setInt(4, userAns.getMarks());
            pstm.setString(5, userAns.getQuestion());
            pstm.setInt(6,userAns.getCorrectAns());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserAnswer> getUserList(int uid)
    {
        List<UserAnswer> userAnsList = new ArrayList<UserAnswer>();
        String query = "select * from userAns where uid = " + uid;
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        ResultSet rs = null;
        int optionCorrect = 0, optionUser = 0;

        try {
            rs = pstm.executeQuery();

            while (rs.next()) {
                UserAnswer userAns = new UserAnswer();
                userAns.setMarks(rs.getInt("marks"));
                userAns.setQid(rs.getInt("qid"));
                userAns.setUid(rs.getInt("uid"));
                userAns.setUserAns(rs.getInt("userAns"));
                userAns.setQuestion(rs.getString("question"));
                userAns.setCorrectAns(rs.getInt("correctAns"));
//                userAnsList.add(userAns);
                optionCorrect = rs.getInt("correctAns");
                optionUser= rs.getInt("userAns");

                String query2 = "select option"+ optionCorrect +" as a, option" + optionUser + " as b from question where id = " + rs.getInt("qid");
                PreparedStatement pstm2 =new DatabaseConnection().getPreparedStatement(query2);
                try {
                    ResultSet rs2 = pstm2.executeQuery();
                    while (rs2.next()) {
                        userAns.setCorrectAnswerSt(rs2.getString("a"));
                        userAns.setChosenAnswerSt(rs2.getString("b"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                userAnsList.add(userAns);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userAnsList;
    }

    public void deleteData(int uid)
    {
        String query = "delete from userAns where uid = " + uid;
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTotalMarks(int uid)
    {
        String query = "select sum(marks) from userAns where uid = " + uid;
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        int totMarks = 0;
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                totMarks = rs.getInt("sum(marks)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totMarks;
    }
}
