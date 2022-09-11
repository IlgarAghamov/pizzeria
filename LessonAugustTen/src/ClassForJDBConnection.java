import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class ClassForJDBConnection {
    public static ArrayList methodForJDBC() throws ClassNotFoundException {
        ArrayList <String> arrayList=new ArrayList<String>();
        Class.forName("org.postgresql.Driver");
        try {
            Connection connection= DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "Aa114860");
            System.out.println("Connection work");
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select *from verification");
            while (resultSet.next()){
                arrayList.addAll(Collections.singleton(resultSet.getString("login")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arrayList;
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String str ="user1";
        ClassForJDBConnection classes =new ClassForJDBConnection();
        ArrayList<String > arrayList =new ArrayList<String>(classes.methodForJDBC());
        for (String s : arrayList) {
            if (s.equals(str)){
                System.out.println("login zanat");
            }
        }




    }
}
