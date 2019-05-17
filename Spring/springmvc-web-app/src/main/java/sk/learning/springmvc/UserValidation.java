package sk.learning.springmvc;

public class UserValidation {

	public static boolean isValidUser(String name, String pass) {

		if (name.equalsIgnoreCase("SK") && pass.equals("somepass")) {
			return true;
		}
		return false;
	}
}