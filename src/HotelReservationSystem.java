import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
		{System.out.println("Do You Want to add more Hotels(Y/N)");
		char choice=sc.next().charAt(0);
		if(choice=='Y') {
        System.out.println("Enter Hotel Name:");
        String hotelName=sc.next();
        System.out.println("Enter Weekday Rate:");
        int weekdayRate=sc.nextInt();
        System.out.println("Enter Weekend Rate:");
        int weekendRate=sc.nextInt();
        System.out.println("Enter Hotel Rating:");
        int hotelRating = sc.nextInt();
        System.out.println("Enter Weekday Rate for Reward Customers:");
        int weekdayRewardRate=sc.nextInt();
        System.out.println("Enter Weekend Rate for Reward Customers:");
        int weekendRewardRate=sc.nextInt();
		Hotel hotel=new Hotel(hotelName,weekdayRate, weekendRate,hotelRating,weekdayRewardRate,weekendRewardRate);
		hotelList.add(hotel);}
		else
			break;
		}
	}
		/**
		 * 
		 */
		public static void returnBestRatedAndCheapestHotel(int index) throws EntryInvalidException
		{
			Date startDate=null;
			Date endDate=null;
			System.out.println("Enter Start Date :");
			String start=sc.next();
			System.out.println("Enter End date :");
			String end=sc.next();
			try {
				startDate = new SimpleDateFormat("dd/MM/yyyy").parse(start);
				endDate = new SimpleDateFormat("dd/MM/yyyy").parse(end); 
				}
			catch (ParseException e) 
			{
				e.printStackTrace();
			} 
			long noOfDays = 1+(endDate.getTime()- startDate.getTime())/1000/60/60/24;
			Calendar startCalendar=Calendar.getInstance();
			startCalendar.setTime(startDate);
			Calendar endcalendar=Calendar.getInstance();
			endcalendar.setTime(endDate);
			long noOfWeekdays=0;
			while(startCalendar.getTimeInMillis()<=endcalendar.getTimeInMillis())
			{
			if((startCalendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY )&&(startCalendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY ))
			{
				noOfWeekdays++;
			}
			 startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			}
			long noOfWeekends=noOfDays-noOfWeekdays;
			 long minimumCost=0;
			 if(index==1)
			 {
			   for(Hotel hotel: hotelList) 
			      {
		        	long totalCost = noOfWeekdays*hotel.getWeekdayRate()+noOfWeekends*hotel.getWeekendRate();
		        	hotel.setTotalCost((int) totalCost);
		        	if(minimumCost==0)
		        		minimumCost=hotel.getTotalCost();
		        	 if(hotel.getTotalCost()<minimumCost)
						 minimumCost=hotel.getTotalCost();
		           }
			 }
			   else
				   if(index==2)
				   { for(Hotel hotel: hotelList) 
				      {
			        	long totalCost = noOfWeekdays*hotel.getWeekdayRewardRate()+noOfWeekends*hotel.getWeekendRewardRate();
			        	hotel.setTotalCost((int) totalCost);
			        	if(minimumCost==0)
			        		minimumCost=hotel.getTotalCost();
			        	 if(hotel.getTotalCost()<minimumCost)
							 minimumCost=hotel.getTotalCost();
				      }
				   }				   
			List<Hotel> cheapestListOfHotelName=new ArrayList<Hotel>();
			 for(int i = 0; i < hotelList.size(); i++) 
			 {
				 if(hotelList.get(i).getTotalCost()==minimumCost)
				cheapestListOfHotelName.add(hotelList.get(i));}
		Hotel cheapestBestRatedHotel = cheapestListOfHotelName.stream().max((hotelOne, hotelTwo) -> hotelOne.getHotelRating() - hotelTwo.getHotelRating()).orElse(null);
		String cheapestAndHighestRatedHotel=cheapestBestRatedHotel.getHotelName();
		System.out.println(cheapestAndHighestRatedHotel+", Rating: "+cheapestBestRatedHotel.getHotelRating()+" and Total Cost :$"+minimumCost);
		}
			 			 
				
		/**
		 * uc7
		 */
		public static String returnBestRatedHotel() {
			Date startDate=null;
			Date endDate=null;
			System.out.println("Enter Start Date :");
			String start=sc.next();
			System.out.println("Enter End date :");
			String end=sc.next();
			try {
				startDate = new SimpleDateFormat("dd/MM/yyyy").parse(start);
				endDate = new SimpleDateFormat("dd/MM/yyyy").parse(end); 
				}
			catch (ParseException e) 
			{
				e.printStackTrace();
			} 
			long noOfDays = 1+(endDate.getTime()- startDate.getTime())/1000/60/60/24;
			Calendar startCalendar=Calendar.getInstance();
			startCalendar.setTime(startDate);
			Calendar endcalendar=Calendar.getInstance();
			endcalendar.setTime(endDate);
			long noOfWeekdays=0;
			while(startCalendar.getTimeInMillis()<=endcalendar.getTimeInMillis())
			{
			if((startCalendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY )&&(startCalendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY ))
			{
				noOfWeekdays++;
			}
			 startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			}
			long noOfWeekends=noOfDays-noOfWeekdays;
			int maximumRating=0;
			int count=0;
			for(Hotel hotel: hotelList) 
			 {
		        	long totalCost = noOfWeekdays*hotel.getWeekdayRate()+noOfWeekends*hotel.getWeekendRate();
		        	hotel.setTotalCost(totalCost);
		        	if(maximumRating==0)
		        		maximumRating=hotel.getHotelRating();
		        	 if(hotel.getHotelRating()>maximumRating)
						 maximumRating=hotel.getHotelRating();
		     }
			 List<String> bestRatedHotelNameList=new ArrayList<>();
			 for(int i = 0; i < hotelList.size(); i++) 
			 {
				 if(hotelList.get(i).getHotelRating()==maximumRating)
				 {
					 count=i;
					 bestRatedHotelNameList.add(hotelList.get(i).getHotelName());
				 }
			 }
			 System.out.println("Highest Rated Hotel :"+bestRatedHotelNameList+" with rating :"+maximumRating+"and total cost $"+hotelList.get(count).getTotalCost());
			return null;	
		}
		public int countNumberOfHotels() {
			// TODO Auto-generated method stub
			return hotelList.size();
		}
    public static void main( String[] args )
    {
        addHotel();
        Customer customerCategory=new Customer();
        System.out.println("Enter the Customer Type :1 for Regular Customer:2 for Reward Customer");
        int index=sc.nextInt();
        if(index==1)
        	customerCategory.setCustomerType("Regular");
        else
        	customerCategory.setCustomerType("Reward");
        System.out.println("Enter the dates between which we need to find best rated cheapest hotel: ");
        try {
        	 returnBestRatedAndCheapestHotel(index);
		} catch (EntryInvalidException e) {
			e.printStackTrace();
		}
        System.out.println("Enter the dates to find the best Rated Hotel: ");
        returnBestRatedHotel();
        System.out.println(hotelList);
    }
	
}