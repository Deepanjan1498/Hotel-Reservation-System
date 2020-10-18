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
		Hotel hotel=new Hotel(hotelName,weekdayRate, weekendRate);
		hotelList.add(hotel);}
		else
			break;
		}
	}
		public static void returnCheapestHotel()
		{
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
			System.out.println("Enter the Start Date: ");
			String start=sc.next();
			System.out.println("Enter the End Date: ");
			String end=sc.next();
			LocalDate startDate = LocalDate.parse(start, dateFormat);
			LocalDate endDate = LocalDate.parse(end, dateFormat);
			final DayOfWeek startWeek = startDate.getDayOfWeek();
		    final DayOfWeek endWeek = endDate.getDayOfWeek();
		    long days = ChronoUnit.DAYS.between(startDate, endDate);
		    long daysInWeekday = days - 2 * ((days + startWeek.getValue())/7);
		    long weekdays= daysInWeekday + (startWeek == DayOfWeek.SUNDAY ? 1 : 0) + (endWeek == DayOfWeek.SUNDAY ? 1 : 0);
			long weekend= days-daysInWeekday;
			int minimumCost = (int) (hotelList.get(0).weekdayRate*weekdays + hotelList.get(0).weekendRate*weekend);
		}
    public static void main( String[] args )
    {
        addHotel();
        System.out.println("Enter the dates between which we need to find cheapest hotel: ");
        returnCheapestHotel();
        System.out.println(hotelList);
    }
}
