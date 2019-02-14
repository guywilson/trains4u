#
# Max 70% of train can be reserved
#
Feature: Max 70% of entire train can be reserved
  Enforce rule that a maximum of 70% of the train can be reserved

  Scenario: We want more seats than are available
    Given that we do not have enough seats available
    When we attempt to book too many seats
    Then the request is denied

	Scenario Outline: Max 70% of the train can be reserved
		Given that the train has <booked> booked seats 
		And the total capacity is <total> seats
		When I try to book <requestedSeats> seats
		Then the booking request is <status>
		
		Examples:
			| booked	| total	| requestedSeats	| status	|
			| 68			|	100		| 4								|	false		|
			| 66			|	100		|	4								|	true		|
			| 66			|	100		|	2								|	true		|
			| 70			|	100		|	2								|	false		|
			| 65			|	100		|	3								|	true		|
			| 65			|	100		|	5								|	true		|
			| 67			|	100		|	4								|	false		|
		
