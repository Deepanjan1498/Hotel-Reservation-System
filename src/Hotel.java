
/**
 * @author Mentalist
 *
 */
/**
 * @author Mentalist
 *
 */
public class Hotel {
      
	   public String hotelName;
	   public int weekdayRate;
	   public int weekendRate;
	   public int totalCost;
	   

	public Hotel(String hotelName, int weekdayRate, int weekendRate) {
		super();
		this.hotelName = hotelName;	
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}
	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Hotel [HotelName=" + hotelName + ", WeekdayRate="
				+ weekdayRate + ", WeekendRate=" + weekendRate + "]";
	}
}
