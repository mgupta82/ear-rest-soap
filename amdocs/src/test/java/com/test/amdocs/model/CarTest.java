package com.test.amdocs.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.test.amdocs.model.Direction;
import com.test.amdocs.model.Grid;
import com.test.amdocs.model.Position;
import com.test.amdocs.command.CommandExecutor;
import com.test.amdocs.model.Car;

public class CarTest {

	@Test
	public void testCar(){
		Car car = new Car("test",new Grid(5, 5));
		car.setPosition(new Position(1, 2, Direction.valueOf("EAST")));
		car.moveForward();
		car.moveForward();
		car.turnLeft();
		car.moveForward();
		assertEquals("3,3,NORTH", car.getPosition().toString());
	}
	
	@Test
	public void testInvalidPalcement() throws Exception{
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.executeCommand("testinvalidplacement.txt");
		assertEquals(null,commandExecutor.getCar().getPosition());
	}
	
	@Test
	public void testNoPalcement() throws Exception{
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.executeCommand("testnoplacement.txt");
		assertEquals(null,commandExecutor.getCar().getPosition());
	}	
	
	@Test
	public void testRePalcement() throws Exception{
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.executeCommand("testreplacement.txt");
		assertEquals("3,2,NORTH",commandExecutor.getCar().getPosition().toString());
	}	
	
	@Test
	public void testOutOfGrid() throws Exception{
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.executeCommand("testoutofgrid.txt");
		assertEquals("3,4,NORTH",commandExecutor.getCar().getPosition().toString());
	}	
	
}
