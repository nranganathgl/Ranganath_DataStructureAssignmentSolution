package com.gl.build.skyscraper;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.gl.build.skyscraper.exception.DuplicateFloorSizeException;
import com.gl.build.skyscraper.service.SkyScraperService;

/**
 * 
 * @author Ranganath
 *
 *         This is the implementation of SkyScraperService.
 * 
 *         The skyscraper needs to be constructed in N days with the following
 *         conditions : a) Every day a floor is constructed in a separate
 *         factory of distinct size. b) The floor with the larger size must be
 *         placed at the bottom of the building. c) The floor with the smaller
 *         size must be placed at the top of the building. Note: A floor cannot
 *         be assembled in the building until all floors larger in size are
 *         placed. As a friend he wants you to build a small program that will
 *         help him analyze the construction process, to avoid manual work and
 *         errors. Input First Line: contains the total floors N in the building
 *         Second Line onwards: Contains N inputs in which the ith integer
 *         denotes the size of the floor that will be given to architect by
 *         factories on the ith day.
 */
public class SkyScraperImpl implements SkyScraperService {

	private int[] floorSizeInfo;
	private Scanner scanner = new Scanner(System.in);
	private Set<Integer> intSet = new HashSet<>();
	private Stack<Integer> stack = new Stack<>();

	public SkyScraperImpl(int totalFloors) throws Exception {
		if (totalFloors <= 0) {
			throw new Exception("Total floors should be greaterthan 0");
		}
		floorSizeInfo = new int[totalFloors];
	}

	@Override
	public void insertFloorSizes() throws DuplicateFloorSizeException, Exception {

		for (int i = 0; i < floorSizeInfo.length; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			int floorSize = scanner.nextInt();
			if (floorSize <= 0) {
				throw new Exception("Floor size should be greaterthan 0");
			}
			floorSizeInfo[i] = floorSize;
		}

		if (!isFloorSizeDistinct()) {
			throw new DuplicateFloorSizeException("Floor size values shoud be distinct.");
		}
	}

	public boolean isFloorSizeDistinct() {

		for (int val : floorSizeInfo) {
			if (intSet.add(val) == false) {
				return false;
			}
		}
		return true;
	}

	public int checkTheStack(int floorSize) {

		for (int i = 0; i < stack.size(); i++) {

			if (Math.abs(floorSize - stack.peek()) == 1) {
				System.out.print(stack.pop() + " ");
				floorSize = floorSize - 1;
			}
		}
		return floorSize - 1;
	}

	public void printStack() {
		for (int val : stack) {
			System.out.print(val + " ");
		}
	}

	@Override
	public void assembleFloors() throws Exception {
		int largestFloor = floorSizeInfo.length;
		insertFloorSizes();
		System.out.println("The order of construction is as follows");

		try {
			for (int i = 0; i < floorSizeInfo.length; i++) {

				// System.out.print(
				// "iteration: " + i + " value: " + floorSizeInfo[i] + " " + " largest floor " +
				// largestFloor);

				System.out.println("\nDay: " + (i + 1));
				if (floorSizeInfo[i] == largestFloor) {
					System.out.print(floorSizeInfo[i] + " ");
					largestFloor = checkTheStack(largestFloor);
				} else {
					// System.out.println("Inserting into stack " + floorSizeInfo[i]);
					stack.push(floorSizeInfo[i]);
				}

			}
		} catch (Exception e) {
			throw e;
		}
		// printStack();
		// System.out.println("After stack printing");
		while (!stack.isEmpty()) {
			// System.out.println(stack.size());
			System.out.print(stack.pop() + " ");
		}

	}

}
