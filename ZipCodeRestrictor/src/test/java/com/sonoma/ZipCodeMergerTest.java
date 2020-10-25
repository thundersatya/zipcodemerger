package com.sonoma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sonoma.beans.RangeBean;
import com.sonoma.exception.InvalidInputException;

class ZipCodeMergerTest {

	private ZipCodeMerger zipCodeMerger;

	@BeforeEach
	void setUp() throws Exception {
		zipCodeMerger = new ZipCodeMerger();
	}

	@Test
	public void FindMergedZipCodesList_With_Valid_Three_Range_Input_Retrun_Two_Merged_Ranges_Success() {
		String rangeInput = "[94133,94133] [94200,94299] [94226,94399]";
		List<RangeBean> meredOutput;
		try {
			meredOutput = zipCodeMerger.findMergedZipCodesList(rangeInput);
			assertEquals(2, meredOutput.size());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void FindMergedZipCodesList_With_Valid_Three_Range_Input_Retrun_Three_Merged_Ranges_Success() {
		String rangeInput = "[94133,94133] [94200,94299] [94600,94699]";
		List<RangeBean> meredOutput;
		try {
			meredOutput = zipCodeMerger.findMergedZipCodesList(rangeInput);
			assertEquals(3, meredOutput.size());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void FindMergedZipCodesList_With_Valid_Three_Range_Input_In_Reverse_Order_Retrun_Merged_Ranges_Success() {
		String rangeInput = "[94133,94133] [94299,94200] [94600,94699]";
		List<RangeBean> meredOutput;
		try {
			meredOutput = zipCodeMerger.findMergedZipCodesList(rangeInput);
			assertEquals(3, meredOutput.size());
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void FindMergedZipCodesList_With_Invalid_Three_Range_Input_Retrun_Exception() {
		String rangeInput = "[94133,94133 ] [94200, 94299] [94600,94699]";
		try {
			zipCodeMerger.findMergedZipCodesList(rangeInput);
		} catch (InvalidInputException e) {
			assertTrue(e.getMessage().equals("Invalid input format"));
		}
	}

	@Test
	void testMergeZipCodes() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetInputRangeSet_With_Single_Range_Input_Expect_Single_Number() {
		String[] rangeInput = new String[] { "[94133,94133]" };
		SortedSet<Integer> inputRangeSet = zipCodeMerger.getInputRangeSet(rangeInput);
		inputRangeSet.stream().forEach(element -> {
			assertEquals(94133, element);
		});
	}

	@Test
	void testGetInputRangeSet_With_Multiple_Range_Input_Expect_Single_Number() {
		String[] rangeInput = new String[] { "[94133,94133]", "[94900,94910]", "[94899,94910]" };
		Integer[] expected = new Integer[] {94133,94899,94900,94901,94902,94903,94904,94905,94906,94907,94908,94909,94910 };
		SortedSet<Integer> sortedSet = zipCodeMerger.getInputRangeSet(rangeInput);
		assertEquals(13, sortedSet.size());
		int i=0;
		for (Integer actual : sortedSet) {
			//System.out.println(expected[i] +" : "+actual);
			assertEquals(expected[i], actual);
			i++;
		}
	}
}
