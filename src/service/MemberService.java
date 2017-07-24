package service;

import domains.Member;
import utils.DatabaseConnection;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10/26/2016.
 */
public class MemberService
{
    public List<Member> getMemberList()
    {
        List<Member> memberList = new ArrayList<Member>();
        String query = "select * from member";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Member member = new Member();

                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setPhoneNo(rs.getString("phoneNo"));
                member.setId(rs.getInt("id"));

                memberList.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    public void insert(Member member) {
        String query = "insert into member (name,password,phoneNo) values(?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, member.getName());
            pstm.setString(2, member.getPassword());
            pstm.setString(3, member.getPhoneNo());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void delete(int id)
    {
        String query = "delete from member where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Member getRow(int id)
    {
        Member member = new Member();
        String query = "select * from member where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setPhoneNo(rs.getString("phoneNo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }
    public void edit(int id, Member member) throws SQLException {
        String query = "update member set name = ?, password = ?, phoneNo = ? where id = ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        pstm.setString(1,member.getName());
        pstm.setString(2,member.getPassword());
        pstm.setString(3,member.getPhoneNo());
        pstm.setInt(4,id);
        pstm.execute();
    }
}
