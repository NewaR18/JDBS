import java.sql.*;
public class Retrieve {
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    Retrieve(){
    }
    public void FetchAll() throws Exception{
        try {
            conn=Create.Connection();
        }catch(Exception ex){
            System.out.println("Could not connect in Retrieve class");
        }
        String query="Select* from mytable";
        st=conn.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt("id") + " "+ rs.getString("uname")+ " "+ rs.getInt("age"));
        }
        st.close();
    }
}