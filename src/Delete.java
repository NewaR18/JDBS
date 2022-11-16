import java.sql.*;

public class Delete {
    Connection conn=null;
    Statement st=null;
    int id;
    Delete(int id){
        this.id=id;
    }
    public void Deleting() throws Exception{
        try{
            conn=Create.Connection();
        }
        catch(Exception ex){
            System.out.println("Could not connect, I am from Delete class");
        }
        String query="Delete from mytable where Id="+id;
        Statement st=conn.createStatement();
        int s=st.executeUpdate(query);
        if(s>0){
            System.out.println("Deleted Successfully");
        }else{
            System.out.println("Could not Delete, Sorry :(");
        }
        st.close();
    }
}