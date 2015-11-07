#Requirements
Implement a program to simulate a car driving on a 5 by 5 grid. The program should be implemented in Java.

The car is free to move around the grid, but must be prevented from exiting the grid.Any movement that would result in the car going outside the grid must be prevented, however further valid movement must still be allowed.

Create an application that can read in commands of the following form -
* INIT <X>,<Y>,<F> - will put the car at position X,Y facing NORTH, SOUTH, EAST or WEST. Assuming 0,0 is the south-west corner.
  The program should discard all commands until a valid INIT command has been executed. 
  After that, any sequence of commands may be issued, in any order, including another INIT command.
* FORWARD - FORWARD will move the car one unit forward in the direction it is currently facing.
* TURN_LEFT - will rotate the car in the specified direction without changing its position on the grid.
* TURN_RIGHT - will rotate the car in the specified direction without changing its position on the grid.
* GPS_REPORT - will output the car's position and facing

Input for the car can be from a file or standard input.

##Constraints:

* The car must not exit the grid during movement.  This includes the INIT command. 
* Any move that would cause the car to leave the grid must be ignored.

##Example:

###
1. INIT 0,0,NORTH
2. FORWARD
3. GPS_REPORT

Output: 0,1,NORTH

###
1. INIT 0,0,NORTH
2. TURN_LEFT
3. GPS_REPORT
Output: 0,0,WEST

###
1. INIT 1,2,EAST
2. FORWARD
3. FORWARD
4. TURN_LEFT
5. FORWARD
6. GPS_REPORT
Output: 3,3,NORTH

##Deliverables:
* All Java source code and any test code.
* It is not required to provide any graphical output.

The solution will be judged on the following criteria:
* Correctness
* Code structure
* Extensibility
* Maintainability
* Test coverage
* Performance

#Solution

##Maven Project
mvn archetype:generate -DgroupId=com.test -DartifactId=amdocs -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

##MySQL DB
