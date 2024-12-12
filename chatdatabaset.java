import java.sql.*;

class chatdatabaset{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/chatapp";
            String username="root";
            String passworld="w@2915djkq#";

            Connection con=DriverManager.getConnection(url,username,passworld);
            String q="create table messaget(meg TEXT(55), content TEXT(55))"; 
           
              Statement stmt=con.createStatement();
            stmt.executeUpdate(q);
              System.out.println("table created in database...");
              con.close();

        }catch(Exception e)
        {
            e.printStackTrace();

        }
    }

}