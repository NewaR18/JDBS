import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        char re;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dab";
        String uname = "root";
        String pw = "admin";
        Connection conn=DriverManager.getConnection(url, uname, pw);
        System.out.println("Enter 1 to Insert New Entity");
        System.out.println("Enter 2 to Retrieve all information");
        System.out.println("Enter 3 to Delete row");
        System.out.println("Enter 4 to Update information");
        do {
            System.out.print("\nEnter your choice: ");
            int ch = sc1.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = sc1.nextInt();
                    System.out.print("Enter name: ");
                    String name = sc1.next();
                    System.out.print("Enter age: ");
                    int age = sc1.nextInt();
                    Create c1 = new Create(id, name, age);
                    c1.Insert();
                    break;
                case 2:
                    Retrieve r1 = new Retrieve();
                    r1.FetchAll();
                    break;
                case 3:
                    System.out.print("Enter id that you want to delete: ");
                    int id1 = sc1.nextInt();
                    Delete d1 = new Delete(id1);
                    d1.Deleting();
                    break;
                case 4:
                    System.out.print("Enter id that you want to modify: ");
                    int id2 = sc1.nextInt();
                    String query = "Select* from mytable where id=" + id2;
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    rs.next();
                    String myname = rs.getString("uname");
                    int myage = rs.getInt("age");
                    System.out.println("Enter name: (Current Name is " + myname + ")");
                    String updatename = sc1.next();
                    System.out.println("Enter Age: (Current Age is " + myage + ")");
                    int updateage = sc1.nextInt();
                    Update u1 = new Update(id2, updatename, updateage);
                    u1.Updating();
                    break;
                default:
                    System.out.println("Choose between 1 to 4");
            }
            System.out.print("Do you want to continue(y/n): ");
            re=sc1.next().charAt(0);
        }while(re=='y');
        conn.close();
    }
}
