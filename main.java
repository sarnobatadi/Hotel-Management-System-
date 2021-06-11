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

class OrderItem()
{
	int table_no;
	int order_no;
	String cus_name;
	long int cus_mno;
	int tot_bill;
	public OrderItem(int table_no , int order_no , String cus_name , String cus_mno )
	{
		this.table_no = table_no;
		this.order_no = order_no;
		this.cus_name = cus_name;
		this.cus_mno = cus_mno;
	}
	ArrayList<MenuItem> m = new ArrayList<MenuItem>();
	m.add(new MenuItem(101,100,"Veg Kolhapuri","Main Course"));
	void generateBill()
	{
		int id,p=0;
		Scanner sc = new Scanner(System.in);
		while(true)
		{	
			System.out.println("Enter Item Code : ");
			id = sc.nextInt();
			if(id == -1)
			{
				break;
			}
			p += m.get(id-101).getPrice();
			
			
		}
		System.out.println("Total Bill : " +  p);
		
	}
	void insert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Table Number : ");
		table_no = sc.nextInt();
		System.out.println("Enter Order No. : ");
		order_no = sc.nextInt();
		System.out.println("Enter Customer Mobile No. : ");
		cus_mno = sc.nextLine();
		System.out.println("Enter Customer Name : ");
		cus_name = sc.nextLine();
		tot_bill = p;
		
	}
	
	
	
	
}

class 
