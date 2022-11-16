import java.sql.*;
public class Create{
     static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    public static Connection Connection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/dab";
        String uname="root";
        String pw="admin";
        conn=DriverManager.getConnection(url,uname,pw);
        return conn;
    }
    public int id;
    public String name1;
    public int age;
    Create(int id, String name1,int age){
        this.id=id;
        this.name1=name1;
        this.age=age;
    }
    public void Insert() throws Exception{
        try{
            conn=Connection();
        }
        catch(Exception ex){
            System.out.println("Could not connect, Leave me alone");
        }
        String query="Insert into mytable VALUES("+id+",'"+name1+"',"+age+")";
        st=conn.createStatement();
        int a=st.executeUpdate(query);
        if(a>0){
            System.out.println("Data Inserted Successfully");
        }else{
            System.out.println("Could not Insert, Sorry :(");
        }
        st.close();
    }
}
