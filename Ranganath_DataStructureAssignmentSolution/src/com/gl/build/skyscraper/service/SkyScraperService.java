package com.gl.build.skyscraper.service;

/**
 * 
 * @author Ranganath
 *
 *         This is SkyScraperService interface contains abstract methods to
 *         implement for assembling the floors and construction of a skyscraper.
 */
public interface SkyScraperService {

	/*
	 * To input the floor sizes for each floor if floor size is less than 0 then it
	 * throws exception if any of the two floor sizes are same then it throws
	 * DuplicateFloorSizeException.
	 */
	public void insertFloorSizes() throws Exception;

	/*
	 * To assemble the floors of a skyscraper throws exception if there is any error
	 * during the program
	 */
	public void assembleFloors() throws Exception;
}
