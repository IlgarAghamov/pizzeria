import java.sql.*;
import java.util.ArrayList;

public class JDBConnection {
    public static Statement createStatement() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection;
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "Aa114860");
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return createStatement();
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            Statement statement = createStatement();

            ResultSet rs = statement.executeQuery("Select * from verification");

            while (rs.next()) {
                arrayList.add(new User(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public static void setUsers(String login, String password) {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            Statement statement = createStatement();

            ResultSet rs = statement.executeQuery("Select * from verification");


                rs = statement.executeQuery(
                        "insert into verification(login,password)values('" + login + "','" + password + "')");

        } catch (Exception e) {
        }


    }
}
