package es.ulpgc.is2;

import es.ulpgc.is2.control.LoadRandomUserCommand;
import es.ulpgc.is2.model.User;
import es.ulpgc.is2.view.SwingImageVisualizer;

public class Main {

	public static void main(String[] args) {
		LoadRandomUserCommand command = new LoadRandomUserCommand(5);
		command.execute();
		SwingImageVisualizer imageVisualizer = new SwingImageVisualizer();
		imageVisualizer.show(command.getUsers().getFirst().getPhoto());
		for (User user : command.getUsers()) {
			System.out.println(user.getPhoto());
		}
	}
}
