package com.gl.build.skyscraper;

import java.util.Scanner;

import com.gl.build.skyscraper.exception.DuplicateFloorSizeException;
import com.gl.build.skyscraper.service.SkyScraperService;

/**
 * 
 * @author Ranganath
 *
 * This is the main program calls assembleFloors method in SkyScraperService
 * to print the order of construction
 */
public class MainApplicationSkyScraper {

	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MainApplicationSkyScraper object = new MainApplicationSkyScraper();
		System.out.println("enter the total no of floors in the building");
		int totalFloors = object.scanner.nextInt();
		SkyScraperService skyScraperService;
		try {
			skyScraperService = new SkyScraperImpl(totalFloors);
			skyScraperService.assembleFloors();
		} 
		catch(DuplicateFloorSizeException e) {
			System.out.println("Exception: "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
	}

}
