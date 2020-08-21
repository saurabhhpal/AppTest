package com.virtusa.fx;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.virtusa.fx.beans.FileObject;
import com.virtusa.fx.exceptions.ValidationException;
import com.virtusa.fx.validations.Validations;

public class AppTest {

	List<FileObject> dataList = Arrays.asList(
			 new FileObject(1101, 110011L, "Chennai", "India", "BBB", "GBP", -10.22337),
			 new FileObject(1102, 110022L, "Colombo", "", "A", "GBP", 456.85014), 
			 new FileObject(1103, 110033L, "Atlanta", "USA","AAA+", "CHF", 2.54842)); 
	
	@Test
	public void testFilePath() {
		
		String path = "src\\test\\resources\\FILE.DAT";
		 
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		 
		assertTrue(absolutePath.endsWith(("src\\test\\resources\\FILE.DAT")));
	}
	
	 
	 @Test
	 public void testValiData() throws ValidationException {
		 
		 assertTrue( Validations.fileDataValidation(dataList));
	 }
	 
	 
	 @Test (expected = ValidationException.class)
	 public void testInvalidCompanCode() throws ValidationException {
		 
		 List<FileObject> invalidDataList = Arrays.asList(
				 new FileObject(-1101, 110011L, "Chennai", "India", "BBB", "GBP", -10.22337),
				 new FileObject(1102, 110022L, "Colombo", "", "A", "GBP", 456.85014), 
				 new FileObject(1103, 110033L, "Atlanta", "USA","AAA+", "CHF", 2.54842));
		 
		 
		    Validations.fileDataValidation(invalidDataList);
	 }
	 
	 @Test (expected = ValidationException.class)
	 public void testInvalidCurrencyCode() throws ValidationException {
		 
		 List<FileObject> invalidDataList = Arrays.asList(
				 new FileObject(1101, 110011L, "Chennai", "India", "BBB", "GBPA", -10.22337),
				 new FileObject(1102, 110022L, "Colombo", "", "A", "GBP", 456.85014), 
				 new FileObject(1103, 110033L, "Atlanta", "USA","AAA+", "CHF", 2.54842));
		 
		 
		    Validations.fileDataValidation(invalidDataList);
	 }
	 
 
}
