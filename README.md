# CSCI 313 
## Data Structures and Alorithms Projects
### Project 1 
First Submission for Semester Project Fall 2022 (HW#3-4)

Please submit the following files:
Student.jav
StudentRecord.jav
Course.jav
CourseRoster.jav
sortedLinkedList.jav
LLNode.jav
Registration.jav (driver program)

Create a “document” by pasting all of the above files into one text file (notepad is fine – please set all fonts to black in this file)
The Registration program should be able to:

create a master list of StudentRecord (sortedLinkedList) with initially empty courseArray by inputting students manually.
create a master list of CourseRoster (array using courses CS313, CS240, CS320, CS343) by inputting the courses manually.
This will eventually be done through loading text files!
The user will have options to:
Add a course to a StudentRecord.  When a student “registers” for a course, the student will also be added to the courseRoster registeredStudents for that course.
Drop a course for a student. When a student “drops” a course, the student will also be removed from that courseRoster.
Search for a course in a studentRecord
Search for a student in a courseRoster
Display a studentRecord
Display a courseRoster
Display the master list of studentRecords
Display the master list of courseRosters.
Eventually these will also be saved as text files!
Every Object should include a toString method.  You can format the toString any way you want.
public String toString() //return a formatted String of the class data.


Project Second Submit
1.	Compile  and save a BST (orBinarySearchTree) class using the Comparable object type.

2.	Replace the SortedLinkedList class with the BST class in both the main Registration and the Course.studentRoster.

3.	For extra credit, add a waitingList to the Course class. Set a class size limit of 5 (not a realistic number, just won’t need too much data to check it out!) so that if a course is full, any new students that try to add the course will be placed in the waiting list, and when a student drops a course, the first student on the waiting list will be added to the course.

4.	If you want to make corrections to the first submit, you may do so. You will receive ½ of the points that were deducted, if the correction is good.
Please submit by Sunday November 27, 11:59 PM

