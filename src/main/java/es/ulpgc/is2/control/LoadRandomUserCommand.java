package es.ulpgc.is2.control;

import es.ulpgc.is2.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoadRandomUserCommand implements Command {
	private final int count;

	private final List<User> users = new ArrayList<>();

	public LoadRandomUserCommand(int count) {
		this.count = count;

	}

	@Override
	public void execute() {
		users.clear();
		RandomUserProvider provider = new RandomUserProvider();
		for (int i = 0; i < count; i++) {
			try {
				users.add(provider.provideNew());
			} catch (IOException e) {
				Logger.getAnonymousLogger().severe(e.getMessage());
			}
		}
	}

	public List<User> getUsers() {
		return users;
	}
}
