import java.util.*;
public class HotelReservationSystem {
	   static Scanner sc=new Scanner(System.in);
	public static List<Hotel> hotelList=new ArrayList<>();
	public static void addHotel()
	{
		while(true)
		{
		System.out.println("Adding a Hotel:");
        System.out.println("Enter Hotel Name:");
        String hotelName=sc.nextLine();
        System.out.println("Enter the rate for regular customer");
        int regularCustomerRate=sc.nextInt();
		Hotel hotel=new Hotel(hotelName,regularCustomerRate);
		hotelList.add(hotel);
		System.out.println("Do You Want to add more Hotels(Y/N)");
		char choice=sc.next().charAt(0);
		if(choice!='Y')
			break;
		}
	}
    public static void main( String[] args )
    {
        addHotel();
    }
}
