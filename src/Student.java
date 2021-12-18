import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Student
{
    int id;
    String name;
    String Address;

    public Student(int id, String name, String address)
    {
        this.id = id;
        this.name = name;
        Address = address;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAddress(String address)
    {
        Address = address;
    }

              /*  connection with database*/
    public static Connection getConnection()
    {
        System.out.println("Trying to connect with DB>>>");
       Connection con1=null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");

           con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/shailesh", "root","Professor@17");

           System.out.println("Connection successfully");

           } catch (ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
       return con1;
    }

    public void CreateStudent(Student s1,Connection Con1) throws SQLException
    {
        System.out.println("Lets ADD Element into DB>>>>>");
        Connection con1=null;
        if (Objects.nonNull(s1) && Objects.nonNull(con1))
        {
            PreparedStatement pps=con1.prepareStatement("INSERT INTO student(id,name,address)VALUES(?,?,?)");
            pps.setInt(1, s1.getId());
            pps.setString(2, s1.getName());
            pps.setString(3, s1.getAddress());
            pps.executeUpdate();
            System.out.println("Student record added to DB>>>>>!!!");
        }
    }
                           /*read */
    public void readStudent(Connection con1)throws SQLException
    {
        System.out.println("Read record from db");
     PreparedStatement pps=con1.prepareStatement("SELECT * FROM shailesh.student");
       pps.executeQuery();
        System.out.println("read data successfully");
    }
                      /*Delete */
    public  void  deleteStudent(Connection con1) throws SQLException
    {
        System.out.println("Delete data from database>>>>");

        PreparedStatement pps=con1.prepareStatement("DELETE FROM student WHERE id=8");
        pps.executeUpdate();
        System.out.println("delete data successfully");
    }
                         /*update */
    public void updateStudent(Connection con1) throws SQLException
    {
        System.out.println("update data in Db>>>>>");

        PreparedStatement pps=con1.prepareStatement("UPDATE student set name='slash' WHERE name='kalpesh'");
        pps.executeUpdate();
        System.out.println("updates data successfully>>>>");
    }






    public static void main(String[] args) throws SQLException {
        try(Connection con1=getConnection())
        {
         Student s1=new Student(50,"JACK","VEGAS");
               s1.updateStudent(con1);
        }
        System.out.println("end");
    }

}
