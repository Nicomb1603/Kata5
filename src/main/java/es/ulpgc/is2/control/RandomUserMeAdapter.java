package es.ulpgc.is2.control;

import es.ulpgc.is2.control.pojo.RandomUserMe;
import es.ulpgc.is2.control.pojo.RandomUserMeResponse;
import es.ulpgc.is2.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class RandomUserMeAdapter implements UserAdapter<RandomUserMeResponse> {
	@Override
	public User adapt(RandomUserMeResponse response) {
		RandomUserMe userMe = response.getResults().getFirst();
		User user = adapt(userMe);
		user.setPhoto(downloadPhoto(userMe.getPicture().large()));
		return user;
	}

	private byte[] downloadPhoto(String url) {
		try {
			URLConnection conn = new URI(url).toURL().openConnection();
			return conn.getInputStream().readAllBytes();
		} catch (URISyntaxException | IOException e) {
			return new byte[0];
		}
	}

	private static User adapt(RandomUserMe userMe) {
		User user = new User(userMe.getName().first(),
				userMe.getName().last(),
				userMe.getEmail(),
				User.Gender.valueOf(firstUpperCase(userMe.getGender())));
		return user;
	}

	private static String firstUpperCase(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}
}
