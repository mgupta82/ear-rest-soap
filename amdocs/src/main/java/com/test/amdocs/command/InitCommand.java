package com.test.amdocs.command;

import com.test.amdocs.model.Car;
import com.test.amdocs.model.Position;

public class InitCommand implements Command{
	
	Car car;
	Position position;
	
	public InitCommand(Car car,Position position){
		this.car = car;
		this.position = position;
	}

	@Override
	public void execute() {
		if(car!=null 
				&& position.getXpos() < car.getGrid().getBreadth()-1 
				&& position.getYpos()<car.getGrid().getLength()-1){		
			car.setPosition(position);
		}
	}

}
