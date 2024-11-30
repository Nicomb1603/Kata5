package es.ulpgc.is2;

import es.ulpgc.is2.control.LoadRandomUserCommand;
import es.ulpgc.is2.model.User;

public class Main {

	public static void main(String[] args) {
		LoadRandomUserCommand command = new LoadRandomUserCommand(5);
		command.execute();
		for (User user : command.getUsers()) {
			System.out.println(user.getName());
		}
	}
}
