import java.sql.*;

public class Update{
    Connection conn=null;
    Statement st=null;
    int id;
    String name;
    int age;
    Update(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public void Updating() throws Exception{
        try{
            conn=Create.Connection();
        }
        catch(Exception ex){
            System.out.println("Could not connect, I am from Update class");
        }
        String query="Update mytable set uname='"+name+"',age="+age+" where Id="+id;
        Statement st=conn.createStatement();
        int s=st.executeUpdate(query);
        if(s>0){
            System.out.println("Updated Successfully");
        }else{
            System.out.println("Could not Update, Sorry :(");
        }
        st.close();
    }
}