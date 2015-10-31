#Requirements
Write a maven java project using Spring MVC and simple JDBC or myBatis persistence layer to address the following requirement:

##Create RESTFul services to perform the CRUD operations (SAVE (INSERT/UPDATE), DELETE, GET) on customer information 
* Full Name
** First Name, Middle Name, Surname
*	Initials
*	Title
*	Residence Address/ Mailing Address
**	Unit/Apartment/Street No
**	Street Name
**	Suburb
**	City
**	State
**	Country
**	Pin code
*	Sex
*	Marital Status
*	Credit Rating
**	Values 0 to 100 (O being the lowest Credit Rating)
*	Is NAB Customer
**	Boolean field to identify if the customer is already a NAB customer

##Implicit Requirements:
*	Ensure to test the application for quality
*	Code coverage to be minimum of 80%

#Solution

##Maven Project
mvn archetype:generate -DgroupId=com.test -DartifactId=rest -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

##MySQL DB
CREATE TABLE `entdb`.`customer` (
  `customer_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `middle_name` VARCHAR(45) NULL,
  `sur_name` VARCHAR(45) NULL,
  `initials` VARCHAR(5) NULL,
  `title` VARCHAR(5) NULL,
  `street_number` INT NULL,
  `street_name` VARCHAR(45) NULL,
  `suburb` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `pincode` INT NULL,
  `sex` VARCHAR(1) NULL,
  `marital_status` VARCHAR(10) NULL,
  `credit_rating` INT NULL,
  `nab_customer` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`));
