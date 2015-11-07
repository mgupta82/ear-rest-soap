package com.test.amdocs.command;

import com.test.amdocs.model.Car;

public class LeftCommand implements Command {
	
	Car car;
	
	public LeftCommand(Car car){
		this.car = car;
	}		

	@Override
	public void execute() {
			car.turnLeft();
	}

}
