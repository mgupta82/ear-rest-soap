package com.test.amdocs.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.test.amdocs.model.Direction;
import com.test.amdocs.model.Grid;
import com.test.amdocs.model.Position;
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
}
