package com.test.amdocs.util;

import com.test.amdocs.command.CommandExecutor;

public class CarStart {
	
	public static void main(String args[]) throws Exception{
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.executeCommand("test.txt");
	}

}
