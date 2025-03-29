import java.sql.*;
public class DbConnection {
    private static final  String url="jdbc:mysql://localhost:3306/busresv";
    private static final    String username="root";
    private static final  String password="abcd";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,username,password);
    }
}
