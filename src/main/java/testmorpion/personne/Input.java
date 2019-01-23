package testmorpion.personne;

import java.util.Scanner;

public class Input {

	public static int lecturePosition(Scanner scan) {
		String input = scan.nextLine();
		int result = -1;
		
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
		}
		return result;
	}
}
