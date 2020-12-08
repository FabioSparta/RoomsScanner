# RoomsScanner
IES Project 3º Year 2020

# Initial User Stories
Title: João should be able to see if the library has empty slots or not.

Business/User Value: As João I want to see if there are any empty rooms in the library because I want to study with my colleagues.

GIVEN I enter the web page
AND I navigate to the rooms list page
WHEN I select the library option in the combo box
THEN I see which floors are not full, and so, still have seats available for studying.

**DEV NOTES**
The sensors keep tracking of the occupancy of every floor.

**DESIGN Notes**
We can use colors to represent the state of a room. Green for rooms that still have space available and red for those that have already been fully occupied.

# ---

Title: Pedro should be able to see if a room is being cleaned or not.

Business/User Value: As Pedro I want to see which empty rooms were recently cleaned or are being cleaned at the moment.

GIVEN I enter the web page
AND I navigate to the rooms list page
WHEN look through the table filtered by ‘cleaning’ or ‘cleaned’ state (chosen on a comboBox)
THEN I see which rooms are on the specified state

**DEV NOTES**
Filter the rooms in the table according to the specified state.
**DESIGN Notes**
We can yellow a room that is being cleaned and blue for a clean one.

# ---

Title: António should be able to see how many seats are available in a department.

Business/User Value: As António I want to see how many seats are available in DETI because the library was already occupied.

GIVEN I enter the web page
AND I navigate to the rooms list page 
WHEN I select a department in the comboBox
THEN I can see the availability of every room in that department 

**DEV NOTES**
Filter the rooms in the table that belong to the selected department.

**DESIGN Notes**
…

# ---

Title: Gonçalo should be able to reserve a room in the library for a predetermined amount of time.

Business/User Value: As Gonçalo I want to search for a free room to work on a project with my classmates.

GIVEN I enter the web page
AND I log in and navigate to the Room Reservations page
WHEN I fill a form with my info and amount of time I want to use the room
THEN I just need to submit my request, and the room will be reserved in that period.

**DEV NOTES**
Save the request in the database’s reservation’s table.

**DESIGN Notes**
Load the Reservations for this user above the table of rooms.
Add Option to cancel a reservation or increase its time.




