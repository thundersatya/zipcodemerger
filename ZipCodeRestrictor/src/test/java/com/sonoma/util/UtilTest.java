package com.sonoma.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sonoma.exception.InvalidInputException;


/**
 * @author thund
 *
 */
class UtilTest {

	private Util util;
	@BeforeEach
	void setUp() throws Exception {
		util = new Util();
	}

	@Test
	void isVaidInput_With_Valid_Input() {
		String[] input = new String[] {"[94133,94133]","[94200,94299]","[94600,94698]"};
		try {
			assertEquals(true,util.isVaidInput(input));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
	}

}
