import java.sql.*;

public class MyJdbcConnection
{
    public static void main(String[] args) throws SQLException {
        System.out.println("Start process");
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/shailesh", "root","Professor@17");
            System.out.println("Connection successfully");

            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM shailesh.student");
            while (rs.next())
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3));
           } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            con.close();
            System.out.println("Connection close");
        }
    }
}
