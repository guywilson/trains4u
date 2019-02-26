package trains4u;

public class MockedBookingSystem
{
	final static int maximumReservationPercent = 70;
	
	static int getAvailability(int numSeatsBooked, int totalSeatsAvailable, int numSeatsOut) {
		int numSeatsAvailable = 
				((maximumReservationPercent * totalSeatsAvailable) / 100) - numSeatsBooked;
		
		return numSeatsAvailable - numSeatsOut;
	}
	
	static boolean bookSeats(int numSeatsRequested, int numSeatsAvailable) {
		if (numSeatsRequested <= numSeatsAvailable) {
			return true;
		}
		else {
			return false;
		}
	}
}




