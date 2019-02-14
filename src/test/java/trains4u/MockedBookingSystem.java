package trains4u;


public class MockedBookingSystem
{
	final static int maximumReservationPercent = 70;
	
	static int getAvailability(int numSeatsBooked, int totalSeatsAvailable) {
		int pctSeatsBooked;
		
		pctSeatsBooked = (numSeatsBooked * 100) / totalSeatsAvailable;
		
		return ((maximumReservationPercent - pctSeatsBooked) * totalSeatsAvailable) / 100;
	}
	
	static boolean bookSeats(int numSeatsRequested, int availability) {
		if (numSeatsRequested <= availability) {
			return true;
		}
		else {
			return false;
		}
	}
}
