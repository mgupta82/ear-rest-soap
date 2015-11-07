package com.test.amdocs.command;

import com.test.amdocs.model.Car;

public class ReportCommand implements Command {
	
	Car car;
	
	public  ReportCommand(Car car){
		this.car = car;
	}

	@Override
	public void execute() {
		if(car.getPosition() != null)
			System.out.println(car.getPosition());
	}

}
