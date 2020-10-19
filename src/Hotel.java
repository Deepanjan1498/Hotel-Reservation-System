public class Hotel {
      
	   public String hotelName;
	   public int weekdayRate;
	   public int weekendRate;
	   public long totalCost;
	   public int hotelRating;
	   public int weekdayRewardRate;
	   public int weekendRewardRate;
	   

	public Hotel(String hotelName, int weekdayRate, int weekendRate, int hotelRating, int weekdayRewardRate,
			int weekendRewardRate) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.hotelRating = hotelRating;
		this.weekdayRewardRate = weekdayRewardRate;
		this.weekendRewardRate = weekendRewardRate;
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
	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	
	public int getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}
	

	public int getWeekdayRewardRate() {
		return weekdayRewardRate;
	}

	public void setWeekdayRewardRate(int weekdayRewardRate) {
		this.weekdayRewardRate = weekdayRewardRate;
	}

	public int getWeekendRewardRate() {
		return weekendRewardRate;
	}

	public void setWeekendRewardRate(int weekendRewardRate) {
		this.weekendRewardRate = weekendRewardRate;
	}

	@Override
	public String toString() {
		return "Hotel [HotelName=" + hotelName + ", WeekdayRate="
				+ weekdayRate + ", WeekendRate=" + weekendRate + ",HotelRating=" + hotelRating + "]";
	}
}