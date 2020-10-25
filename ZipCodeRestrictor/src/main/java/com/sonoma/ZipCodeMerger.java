package com.sonoma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.sonoma.beans.RangeBean;
import com.sonoma.exception.InvalidInputException;
import com.sonoma.util.Util;



/**
 * @author satyak
 *
 */
public class ZipCodeMerger {

	private static final String INVALID_INPUT_MESSAGE = "Invalid input. Enter the input in exact format [94133,94133] [94200,94299] ...";
	private static final String COMMA_REGEX = ",";
	private static final String SPACE_REGEX = " ";

	/**
	 * @author satyak
	 *
	 */
	public List<RangeBean> findMergedZipCodesList(String rangeInput) throws InvalidInputException {

		Util util = new Util();
		String[] inputZipCodeArray = rangeInput.split(SPACE_REGEX);
		List<RangeBean> mergedBeanList = new ArrayList<RangeBean>();
		if (util.isVaidInput(inputZipCodeArray)) {
			SortedSet<Integer> rangeNumSet = getInputRangeSet(inputZipCodeArray);
			mergedBeanList = mergeZipCodes(rangeNumSet);
		} else {
			System.out.println(INVALID_INPUT_MESSAGE);
		}
		return mergedBeanList;
	}
	/**
	 * @author satyak
	 *
	 */
	public List<RangeBean> mergeZipCodes(SortedSet<Integer> rangeNumSet) {
		List<RangeBean> mergedBeanList = new ArrayList<RangeBean>();
		int previousNum = 0;
		int startNum = rangeNumSet.first();
		for (Integer currrentNum : rangeNumSet) {
			if (previousNum != 0 && currrentNum != previousNum + 1) {
				if (previousNum == 1) {
					addRangeBeanToList(mergedBeanList, previousNum, previousNum);
					startNum = currrentNum;
				} else {
					addRangeBeanToList(mergedBeanList, previousNum, startNum);
					startNum = currrentNum;
				}
			}
			if (currrentNum == rangeNumSet.last()) {
				addRangeBeanToList(mergedBeanList, previousNum, startNum);
			}
			previousNum = currrentNum;
		}
		System.out.println("Output:" + mergedBeanList);
		return mergedBeanList;
	}

	/**
	 * @author satyak
	 *
	 */
	private void addRangeBeanToList(List<RangeBean> rangeBeanList, int previousNum, int startNum) {
		RangeBean rangeBean = new RangeBean();
		rangeBean.setStart(startNum);
		rangeBean.setEnd(previousNum);
		rangeBeanList.add(rangeBean);
	}

	/**
	 * @author satyak
	 *
	 */
	public SortedSet<Integer> getInputRangeSet(String[] rangeInput) {
		SortedSet<Integer> rangeNumSet = new TreeSet<Integer>();
		Arrays.asList(rangeInput).forEach(input -> {
			String[] range = input.substring(1, input.length() - 1).split(COMMA_REGEX);
			if (Integer.parseInt(range[0]) <= Integer.parseInt(range[1])) {
				for (int i = Integer.parseInt(range[0]); i <= Integer.parseInt(range[1]); i++) {
					rangeNumSet.add(i);
				}

			} else {
				for (int i = Integer.parseInt(range[1]); i <= Integer.parseInt(range[0]); i++) {
					rangeNumSet.add(i);
				}
			}
		});
		return rangeNumSet;
	}
}
