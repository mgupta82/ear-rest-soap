# Requirement
Develop an enterprise Java application that implements RESTful and SOAP web services.
### The RESTful service will expose two methods: 
**public String push(int i1, int i2);**

which returns the status of the request to the caller as a String. The two parameters will be added to a JMS queue.

**public List list();**

which returns a list of all the elements ever added to the queue from a database in the order added as a JSON structure.

### The SOAP service will expose the following method as operations: 

**public int gcd();**

which returns the greatest common divisor* of the two integers at the head of the queue. These two elements will subsequently be discarded from the queue and the head replaced by the next two in line. 

**public List gcdList();**

which returns a list of all the computed greatest common divisors from a database. 

**public int gcdSum();**

which returns the sum of all computed greatest common divisors from a database.

_The application needs to support access by up to 20 concurrent users and the code be of production quality._

_Greatest Common Divisor (GCD) of two whole numbers is the largest whole number that's a divisor (factor) of both of them. For instance, the largest number that divides into both 20 and 16 is 4._

# Solution Overview

## Layered Architecture
Application has following layers
* Dao layer - Logic related to database
* Messaging Layer - Logic related to Active MQ
* Service Layer - Business logic. This layer is transactional and AOP has been used to rollback if any exception is thrown out of this layer
* Web layer - This layer contains SOAP and REST web services.
* Spring Container - has been used to bind all the layers

## Global Transaction
As per the requirement, adding in the queue and storing in the database has to be atomic operation, so we will have to implement Global Transactions (JTA) i.e. two phase commit.

## Durable Message
As per the requirement application should be tolerant of the server outage, we should persist the message in JMS queue by setting DeliveryMode as Persistent

## Connection Pool
For handling 20 concurrent users, we have implemented pooling strategy for database and JMS connections. Initial pool size and max pool size can be sent accordingly.

## Pending items
following item are yet to be completed
* JUNIT test case
* Converting to Global transaction
* Error/Exception Handling

#Technical Setup
## Maven Project
###EAR project 
mvn archetype:generate -DgroupId=com.unica -DartifactId=entapp -DarchetypeArtifactId=maven-archetype-j2ee-simple -DinteractiveMode=false
###Web Project 
mvn archetype:generate -DgroupId=com.unica -DartifactId=web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

##Pre-requisite
###Table in MySql
CREATE TABLE number_pair ( ID int NOT NULL AUTO_INCREMENT, FIRST_NUMBER INT NOT NULL, SECOND_NUMBER INT NOT NULL, PRIMARY KEY (ID) )
###Queue in Active MQ 
Queue Name : com.unica.gcd.input

##Third Party
JDK7

Eclipse Kepler

Active MQ 5.11

MySql 5.6

Apache Tomcat 7


