# IntroToDatabaseProject
Final Group Project for Introduction to Databases Course. Development of relational database design in Java with SQL.

Part 1 includes the design of the database using entity relationship diagram and relational database schema diagram. My contribution to part 1 includes the main design of the database by building the majority of the entity relationship diagram and consulting for the building of the relational diagram. Part 2 includes the development and implementation of the database using Java. My specific contributions to part 2 can be found in the AddGrade functionality and GradeReport functionality. Throughout the process I collaborated with my team in other functionalities as needed.

**The description of the project requirements are the following:**

Develop a database (back-end) and a software application (front-end) for managing student grades at UNF as described below:

1. UNF keeps track of each student's name (first name, middle initial, and last name), student Nnumber (letter "N" followed by 8 digits), social security number (digit number in the format "AAA-GG-SSSS".), current address and phone, permanent address and phone (XXX-XXX-XXXX), birthdate (format MM-DD-YYYY), sex (male or female), class (freshman, sophomore, ..., graduate), major department, minor department (if any), and degree program (B.A., B.S., ..., Ph.D.). Some user applications need to refer to the city, state, and zip of the student's permanent address, and to the student's last name. Both social security numbers and student Nnumber have unique values for each student.
2. Each department is described by a name, department code (up to 4 characters), office number (4 digits), office phone, and college. Both name and code have unique values for each department.
3. Each course has a course name, description, course number (3 letters followed by 4 digits), number of semester hours, level, and offering department. The value of the course number is unique for each course.
4. Each section has an instructor, semester, year, course, and section number. The section number distinguishes different sections of the same course that are taught during the same semester/year; its values are 1, 2, 3, ..., up to the number of sections taught during each semester.
5. A student will be assigned a grade for a course/section based on the grade scale described here.

Users should be able to perform the following tasks using the front-end:
1. Add a student, department, course, and a course section.
2. Add students to a given course/section.
3. Given a student's Nnumber generate their grade report. Grade report should include student information, course/section, letter grade, grade point for each grade, and the grade point average (GPA) (you can find how to calculate GPA here).
4. Given a department name or code find the courses offered. 
5. Add a grade to a given student for a given course/section.
