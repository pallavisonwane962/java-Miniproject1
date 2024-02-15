import java.util.*;
class Passenger
{
	private int seatno;
	private String name;
	private String contact;
	private String source;
	private String destination;
	
	public void setseatno(int sno)
	{
		seatno=sno;
	}
	public int getseatno()
	{
		return seatno;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return name;
	}
	public void setcontact(String contact)
	{
		this.contact=contact;
	}
	public String getcontact()
	{
		return contact;
	}
	public void setsource(String source)
	{
		this.source=source;
	}
	public String getsource()
	{
		return source;
	}
	public void setdestination(String destination)
	{
		this.destination=destination;
	}
	public String getdestination()
	{
		return destination;
	}
}
class TravelAgency
{
	Stack s=new Stack();
	private static int seatno;
	public TravelAgency()
	{
		seatno=0;
	}
	public void addnewPassenger(Passenger p)
	{
		++seatno;
		p.setseatno(seatno);
		s.push(p);
	}
	public ListIterator getAllPassenger()
	{
		ListIterator li=s.listIterator(s.size());
		return li;
	}
	public void removePassenger()
	{
		boolean b=s.isEmpty();
		if(b)
		{
			System.out.println("no passenger in bus");
		}
		else
		{
			s.pop();
		}
	}
	public int getpassengerCount()
	{
		int count=s.size();
		return count;
	}
}
public class Index
{
	public static void main(String args[])
	{
		TravelAgency agency=new TravelAgency();
		Scanner sc=new Scanner(System.in);
		int choice;
		do{
			System.out.println("1:add new passenger");
			System.out.println("2:view all passenger");
			System.out.println("3:remove passenger");
			System.out.println("4:count the number of passenger");
			System.out.println("enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					sc.nextLine();
					Passenger p=new Passenger();
					System.out.println("enter the name of passenger");
					String name=sc.nextLine();
					System.out.println("enter the contact of passenger");
					String contact=sc.nextLine();
					System.out.println("enter the source location of passenger");
					String source=sc.nextLine();
					System.out.println("enter the destination of passenger");
					String destination=sc.nextLine();
					p.setname(name);
					p.setcontact(contact);
					p.setsource(source);
					p.setdestination(destination);
					agency.addnewPassenger(p);
				break;
				case 2:
				ListIterator li=agency.getAllPassenger();
				while(li.hasPrevious())
				{
					Object obj=li.previous();
					p=(Passenger)obj;
					System.out.println(p.getseatno()+"\t"+p.getname()+"\t"+p.getcontact()+"\t"+p.getsource()+"\t"+p.getdestination());
					
				}
				break;
				case 3:
					agency.removePassenger();
					System.out.println("remove passenger from booking");
				break;
				case 4:
					System.out.println("no of passenger in bus : " +agency.getpassengerCount());
				break;
				default:
				
				System.out.println("wrong choice");
			}
		}while(true);
	}
}