import java.sql.*;
import java.util.*;
import java.io.*;

class MenuItem
{
  int price;
  int itemid;
  String menuName;
  String type;
  public MenuItem(int itemid, int price ,String menuName ,String type)
  {
    this.price = price ;
    this.menuName = menuName;
    this.type = type;
    this.itemid = itemid;
  }
  public String getmenuName()
  {
    return menuName;
  }
  public int getPrice()
  {
    return price;
  }
  public String getType()
  {
    return type;
  }
  public int getitemid()
  {
    return itemid;
  }
}

public class HotelManagement
{
  
  static int generateBill()
  {
     ArrayList<MenuItem> m = new ArrayList<MenuItem>();
       m.add(new MenuItem(0,100,"Veg Kolhapuri","Main Course"));
       m.add(new MenuItem(1,200,"Samosa","Main Course"));
       m.add(new MenuItem(2,300,"Vadapav","Main Course"));
       m.add(new MenuItem(3,400,"Biryani","Main Course"));
       m.add(new MenuItem(4,500,"Dal Bhat","Main Course"));
      int id, p=0;
      Scanner sc = new Scanner(System.in);
      while(true)
      {  
       
          System.out.println("Enter Item Code : ");
          id = sc.nextInt();
          if(id == -1)
          {
            break;
          }
          p += m.get(0).getPrice();
      }
      return p;
   }
  
  public static void main(String[] args) throws Exception
  {
    
    int table_nox;
    int order_nox;
    String cus_namex;
    int tot_billx;
    
    String url = "jdbc:mysql://localhost:3306/sys";
    String uname = "root";
    String pass = "Mrunal123";
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded successfully");
    Connection conn = DriverManager.getConnection(url, uname, pass);
    System.out.println("Connection Established");
    
    Statement stmt = conn.createStatement();
     tot_billx = generateBill();
      
    
    //1. Insert
    // Inputed via User
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter Customer Name : ");
    cus_namex = sc.nextLine();
    
    System.out.println("Enter Order No. : ");
    order_nox = sc.nextInt();
    
    System.out.println("Enter Table Number : ");
    table_nox = sc.nextInt();
    
    System.out.println("---Inputed by User---"); 
    
    // Inserted to Table (Database)
        System.out.println("Inserting records into the table..."); 
        
        String ins = "INSERT INTO HotelOrder(order_no, table_no, cust_name, total_bill) VALUES ("+order_nox+", "+table_nox+", "+cus_namex+",  100)";
        stmt.executeUpdate(ins);
        
        
    //2. Select 
        // Displaying content of Table
        String disp = "select order_no, table_no, cust_name, total_bill from HotelOrder";
        ResultSet rs = stmt.executeQuery(disp);
        while(rs.next()){
            //Display values
            System.out.print(" Order No: " + rs.getInt("order_no"));
            System.out.print(", Table No: " + rs.getInt("table_no"));
            System.out.print(", Name: " + rs.getString("cust_name"));
            System.out.println(", Total Bill: " + rs.getInt("total_bill"));
         }
        
        System.out.println("---Select Ended---"); 
        
 
    // Update 
        String upd = "update HotelOrder " + "set cust_name = 'Rahul Sharma' where order_no=102";
        stmt.executeUpdate(upd);

		rs = stmt.executeQuery(disp);
         while(rs.next()){
            //Display values
           System.out.print(" Order No: " + rs.getInt("order_no"));
             System.out.print(", Table No: " + rs.getInt("table_no"));
             System.out.print(", Name: " + rs.getString("cust_name"));
             System.out.println(", Total Bill: " + rs.getInt("total_bill"));
         }
         
    
  }

}
