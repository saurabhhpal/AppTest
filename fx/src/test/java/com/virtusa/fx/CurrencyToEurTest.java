package com.virtusa.fx;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.virtusa.fx.beans.FileObject;
import com.virtusa.fx.util.CurrencyToEUR;

public class CurrencyToEurTest {
	List<FileObject> dataList = Arrays.asList(
			 new FileObject(1101, 110011L, "Chennai", "India", "BBB", "GBP", -10.22337),
			 new FileObject(1102, 110022L, "Colombo", "", "A", "GBP", 456.85014), 
			 new FileObject(1103, 110033L, "Atlanta", "USA","AAA+", "CHF", 2.54842));
	
	List<FileObject> actualDataList = Arrays.asList(
			 new FileObject(1101, 110011L, "Chennai", "India", "BBB", "GBP", -11.501291249999998),
			 new FileObject(1102, 110022L, "Colombo", "", "A", "GBP", 578.2009584375), 
			 new FileObject(1103, 110033L, "Atlanta", "USA","AAA+", "CHF", 2.197362142857143));
	
	@Test
	public void convertCurrencyToEUR() {
		 List<FileObject> expected = new CurrencyToEUR().convertCurrencyToEUR(dataList);
		assertArrayEquals(actualDataList.toArray(), expected.toArray());
		System.out.print(CurrencyToEUR.convertCurrencyToEUR(dataList));
		
	}
	
}
