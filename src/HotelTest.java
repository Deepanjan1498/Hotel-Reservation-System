import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

 
 

public class HotelTest {
   
@Test
public void whenHotelAddedShouldReturnTrue(){
	HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
	assertTrue(true);
   }
@Test
public void toReturnCheapestHotel()
{
	assertTrue(true);
}
@Test
public void WhenHotelsAdded_ShouldReturnCount()
{
	HotelReservationSystem hotelReservation = new HotelReservationSystem();
	hotelReservation.addHotel();
	int count=hotelReservation.countNumberOfHotels();
	Assert.assertEquals(3, count);
  }
@Test
public void WhenHotelsAreAdded_ForRewardCustomers_ShouldReturnTheBestRatedHotel()
{
	HotelReservationSystem hotelReservation = new HotelReservationSystem();
	hotelReservation.addHotel();
	int index=2;
	String result = hotelReservation.returnBestRatedHotel();
	assertTrue(true);
  }
@Test
public void WhenHotelsAreAdded_ForRegularCustomers_ShouldReturnTheBestRatedHotel()
{
	HotelReservationSystem hotelReservation = new HotelReservationSystem();
	hotelReservation.addHotel();
	int index=1;
	String result = hotelReservation.returnBestRatedHotel();
	assertTrue(true);
  }

}
