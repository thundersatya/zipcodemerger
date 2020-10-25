package com.sonoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sonoma.beans.RangeBean;
import com.sonoma.exception.InvalidInputException;


/**
 * @author satyak
 * To be updated
 * <pre>
 * Main class where the execution of the application starts.
 * It Prompts the users to enter the input in [num1,num2] [num3,num4]...
 * It gets the merged zip codes list in the output.
 * </pre>
 */
public class ApplicationMain {

	public static void main(String[] args) {

		Scanner inputReader = new Scanner(System.in);
		System.out.println("Please enter input in format: [94133,94133] [94200,94299]");
		String rangeInput = inputReader.nextLine();
		inputReader.close();
		ZipCodeMerger zipCodeMrger = new ZipCodeMerger();	
		List<RangeBean> meredOutputList=new ArrayList<RangeBean>();
		try {
			meredOutputList = zipCodeMrger.findMergedZipCodesList(rangeInput);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Merged List: ");
		meredOutputList.stream().forEach(mrgedRange -> System.out.print(mrgedRange+" "));
	}

}
