package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by User on 7/29/2016.
 */

public final class DatabaseConnection {

    private final String username = "root";
    private final String password = "root";

    private final String url = "jdbc:mysql://localhost:3306/demo";

    Connection connection = null;

    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Database connected!!!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final PreparedStatement getPreparedStatement(String query)
    {
        PreparedStatement pstm = null;
        try
        {
            pstm = connection.prepareStatement(query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pstm;
    }
}
