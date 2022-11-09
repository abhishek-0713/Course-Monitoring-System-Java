CREATE DATABASE LearningHub;


USE LearningHub;


CREATE TABLE Admin(
username VARCHAR(24),
password VARCHAR(24)
);


CREATE TABLE Faculty(
facultyId INT PRIMARY KEY auto_increment,
facultyName VARCHAR(50),
facultyAddress VARCHAR(100),
mobile VARCHAR(13),
email VARCHAR(24),
username VARCHAR(24),
password VARCHAR(24)
);


CREATE TABLE Course(
courseId INT PRIMARY KEY auto_increment,
courseName VARCHAR(50),
fee INT,
courseDescription VARCHAR(100)
);


CREATE TABLE Batch(
batchid INT PRIMARY KEY auto_increment,
courseId INT,
facultyId INT,
numberofStudents INT,
batchstartDate date,
duration VARCHAR(50),
FOREIGN KEY (courseId) REFERENCES Course (courseid),
FOREIGN KEY (facultyId) REFERENCES faculty (facultyid)
);


CREATE TABLE CoursePlan(
planid INT PRIMARY KEY auto_increment,
batchId INT,
daynumber INT,
topic VARCHAR(50),
status BOOLEAN,
FOREIGN KEY (batchId) REFERENCES Batch (batchid)
);

