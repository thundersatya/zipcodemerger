package com.sonoma.util;

import java.util.regex.Pattern;

import com.sonoma.exception.InvalidInputException;


/**
 * @author satyak
 * <pre>
 * Its utility class to validate the input provided by the user.
 *</pre>
 */
public class Util {

	/**
	 * @author satyak
	 * <pre>
	 * @param String of Arrays of zip code range numbers
	 * @return Boolean. Returns true if the input in proper format or else false
	 *</pre>
	 */
	public boolean isVaidInput(String[] rangeInput) throws InvalidInputException {
		boolean isValid = true;
		//System.out.println(rangeInput);
		if (rangeInput.length == 0) {
			System.out.println("Invalid format.. exiting");
			throw new InvalidInputException("Invalid input format");
		} else {

			for (String input : rangeInput) {
				//System.out.println(input);
				if (!Pattern.matches("\\[\\d{5}\\,\\d{5}\\]", input))
				isValid = false;

			}
		}
		return isValid;
	}

}
