package com.test.amdocs.command;

import com.test.amdocs.model.Car;

public class RightCommand implements Command {
	
	Car car;
	
	public RightCommand(Car car){
		this.car = car;
	}		

	@Override
	public void execute() {
			car.turnRight();
	}

}
