package com.test.amdocs.command;

import com.test.amdocs.model.Car;

public class ForwardCommand implements Command {
	
	Car car;
	
	public ForwardCommand(Car car){
		this.car = car;
	}	

	@Override
	public void execute() {
		car.moveForward();
	}

}
