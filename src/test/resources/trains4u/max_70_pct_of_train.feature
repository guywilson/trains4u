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
		And there are <out> seats out of action
		When I try to book <requestedSeats> seats
		Then the booking request is <status>
		
		Examples:
			| booked	| total	| out		| requestedSeats	| status	|
			| 698			|	1000	| 0			| 4								|	false		|
			| 696			|	1000	|	0			| 4								|	true		|
			| 575			|	1000	|	125		| 2								|	false		|
			| 696			|	1000	|	4			| 2								|	false		|
			| 650			|	1000	|	0			| 3								|	true		|
			| 650			|	1000	|	0			| 5								|	true		|
			| 697			|	1000	|	0			| 4								|	false		|
		
