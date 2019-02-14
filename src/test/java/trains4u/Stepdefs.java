package trains4u;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	private int totalSeatsAvailable = 100;
	private int numSeatsBooked = 68;
	private int numSeatsAvailable;
	private int numSeatsRequested;
	
	/**************************************************************************
	 * 
	 * Simple Scenario steps...
	 * 
	 *************************************************************************/
	@Given("^that we do not have enough seats available$")
	public void that_we_do_not_have_enough_seats_available() throws Exception {
		numSeatsAvailable = MockedBookingSystem.getAvailability(
													numSeatsBooked, 
													totalSeatsAvailable);
	}

	@When("^we attempt to book too many seats$")
	public void we_attempt_to_book_too_many_seats() throws Exception {
		numSeatsRequested = 4;
	}

	@Then("^the request is denied$")
	public void the_request_is_denied() throws Exception {
		boolean isBooked = MockedBookingSystem.bookSeats(
												numSeatsRequested, 
												numSeatsAvailable);
		
		assertFalse(isBooked);
	}

	/**************************************************************************
	 * 
	 * Scenario Outline steps...
	 * 
	 *************************************************************************/
	@Given("^that the train has (\\d+) booked seats$")
	public void that_the_train_has_booked_seats(int arg1) throws Exception {
		numSeatsBooked = arg1;
	}

	@Given("^the total capacity is (\\d+) seats$")
	public void the_total_capacity_is_seats(int arg1) throws Exception {
		totalSeatsAvailable = arg1;
	}

	@When("^I try to book (\\d+) seats$")
	public void i_try_to_book_seats(int arg1) throws Exception {
		numSeatsRequested = arg1;
		numSeatsAvailable = MockedBookingSystem.getAvailability(
													numSeatsBooked, 
													totalSeatsAvailable);
	}

	@Then("^the booking request is false$")
	public void the_booking_request_is_false() throws Exception {
		boolean isBooked = MockedBookingSystem.bookSeats(
												numSeatsRequested, 
												numSeatsAvailable);
		
		assertFalse(isBooked);
	}

	@Then("^the booking request is true$")
	public void the_booking_request_is_true() throws Exception {
		boolean isBooked = MockedBookingSystem.bookSeats(
												numSeatsRequested, 
												numSeatsAvailable);

		assertTrue(isBooked);
	}
}
