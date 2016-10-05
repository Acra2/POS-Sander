package Repositories;

import java.sql.*;

/**
 * Created by Sander on 5-10-2016.
 */
public class JdbcConnection {

    Connection connection;

//    public void openConnection() {
//        try {
//            Class.forName("oracle.jdbc.OracleDriver");
//            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "pos", "pos");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public ResultSet getResultSet(String query) throws SQLException {
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "pos", "pos");
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void closeConnection() throws SQLException {
        connection.close();
    }
}
