package com.virtusa.fx;

import com.virtusa.fx.constants.Constants;

/**
 * Test!
 *
 */
public class App {
	public static void main(String[] args) {
	
		FileReading fr = new FileReading();
		fr.readDATFile(Constants.FILE_PATH);
	}

	
}
