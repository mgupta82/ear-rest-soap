package com.test.amdocs.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.test.amdocs.model.Car;
import com.test.amdocs.model.Direction;
import com.test.amdocs.model.Grid;
import com.test.amdocs.model.Position;

public class CommandExecutor {
	
	Car car = null;
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}

	public void executeCommand(String filename) throws Exception{
		String line = "";
		car = new Car(filename.substring(0, filename.indexOf('.')), new Grid(5,5));
		Command command = null;
		 try (BufferedReader br = 
				 new BufferedReader(
						 new InputStreamReader(
								 getClass().getClassLoader().
								 getResourceAsStream(filename)))) {
			 while ((line = br.readLine()) != null) {
				 	System.out.println("Executing Command:"+line);
					String[] commandLine = line.split(" ");
					switch (commandLine[0]){
						case "INIT"		:String[] commandParams = commandLine[1].split(",");
										command = new InitCommand(car, 
														new Position(Integer.valueOf(commandParams[0]), 
																	Integer.valueOf(commandParams[1]), 
																	Direction.valueOf(commandParams[2])));
										break;
						case "FORWARD"	:command = new ForwardCommand(car);
										break;
						case "TURN_LEFT":command = new LeftCommand(car);
										break;
						case "TURN_RIGHT":command = new RightCommand(car);
										break;
						case "GPS_REPORT":command = new ReportCommand(car);
										break;

					}
					 if(command!=null){
						 command.execute();
					 }					
				}			 
			 
		 }

	}

}
