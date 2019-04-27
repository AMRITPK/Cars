package Invoker;

import java.util.HashMap;

import Commands.Command;


public class Operation {

	private final HashMap<String, Command> commandMap = new HashMap<>();

	public void register(String commandName, Command command) {

		commandMap.put(commandName, command);
	}

	public Object execute(String commandName) throws Exception {
		Command command = commandMap.get(commandName);
		if (command == null) {
			throw new IllegalStateException("no command registered for " + commandName);
		}
		return command.execute();
	}


}
