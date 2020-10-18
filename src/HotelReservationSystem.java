import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Mentalist
 *
 */
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
		public static void getCheapestHotel()
		{
			Date startDate=null;
			Date endDate=null;
			System.out.println("Enter the Start Date: ");
			String start=sc.next();
			System.out.println("Enter the End Date: ");
			String end=sc.next();
			try {
				startDate = new SimpleDateFormat("ddMMMyyyy").parse(start);
				endDate = new SimpleDateFormat("ddMMMyyyy").parse(end); 
				}
			catch (ParseException e) 
			{
				e.printStackTrace();
			} 
			long numberOfDays = (endDate.getTime()- startDate.getTime())/1000/60/60/24;
			int minimumCost = hotelList.get(0).getRegularCustomerRate();
			String cheapestHotel= hotelList.get(0).getHotelName();
			for(int i = 1; i < hotelList.size(); i++) 
				if(hotelList.get(i).getRegularCustomerRate()< minimumCost) {
					minimumCost = hotelList.get(i).getRegularCustomerRate();
					cheapestHotel = hotelList.get(i).getHotelName();
				}
			System.out.println(cheapestHotel+" ,Total Cost: "+minimumCost*numberOfDays);
		}
    public static void main( String[] args )
    {
        addHotel();
        System.out.println("Enter dates for finding cheapest hotel: ");
        getCheapestHotel();
        System.out.println(hotelList);
    }
}
