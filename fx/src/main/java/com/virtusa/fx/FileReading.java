package com.virtusa.fx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.virtusa.fx.beans.FileObject;
import com.virtusa.fx.constants.Constants;
import com.virtusa.fx.exceptions.FileException;
import com.virtusa.fx.exceptions.ValidationException;
import com.virtusa.fx.util.CurrencyToEUR;
import com.virtusa.fx.validations.Validations;

public class FileReading {
	
	public void readDATFile(String filePath) {
		

		boolean skipHeader = true;
		List<FileObject> objList = new ArrayList<FileObject>();
		File file = new File(filePath);
		Scanner scnr = null;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			try {
				throw new FileException(Constants.FILE_ERROR_CODE, Constants.FILE_ERROR_MSG + file.getAbsolutePath());
			} catch (FileException e1) {
				System.out.print(e1.getErrorCode() + " - " + e1.getMessage());
				return;
			}
		}
		while (scnr.hasNextLine()) {
			if (skipHeader) {
				scnr.nextLine();
				skipHeader = false;
			}
			String line = scnr.nextLine();

			String[] dataObjects = line.split("	");

//    	   System.out.println(Arrays.toString(dataObjects));

			for (int i = 0; i < dataObjects.length; i++) {
				FileObject obj = new FileObject();
				obj.setCompanyCode(Integer.valueOf(dataObjects[i++]));
				obj.setAccount(Long.valueOf(dataObjects[i++]));
				obj.setCity(dataObjects[i++]);
				obj.setCountry(dataObjects[i++]);
				obj.setCreditRating(dataObjects[i++]);
				obj.setCurrency(dataObjects[i++]);
				obj.setAmount(Double.valueOf(dataObjects[i++]));
				objList.add(obj);
			}

		}
		scnr.close();
		boolean valid = false;
		try {

			 valid = Validations.fileDataValidation(objList);
			System.out.println("VALID DATA " + valid);
		} catch (ValidationException e) {
			System.out.print(e.getErrorCode() + " - " + e.getMessage());
			return;
		}

		if(valid) {
			List<FileObject> convertedList= new CurrencyToEUR().convertCurrencyToEUR(objList);
			
			groupAndPrintCountry(convertedList);
			
			
		}
	}

	private void groupAndPrintCountry(List<FileObject> convertedList) {
		//Grouping and Printing Objects
		Map<Object, Double> countryList = convertedList.stream().filter(x -> !"".equals(x.getCountry().trim()))
				.collect(Collectors.groupingBy(
						x -> new ArrayList<String>(Arrays.asList(x.getCountry(), x.getCreditRating())),
						Collectors.averagingDouble(FileObject::getAmount)));

		Map<Object, Double> cityList = convertedList.stream().filter(x -> "".equals(x.getCountry().trim()))
				.collect(Collectors.groupingBy(
						x -> new ArrayList<String>(Arrays.asList(x.getCity(), x.getCreditRating())),
						Collectors.averagingDouble(FileObject::getAmount)));
		//Adding all city list to country
		countryList.putAll(cityList);

		for (Entry<Object, Double> entry : countryList.entrySet()) {
			ArrayList<String> outputObj = (ArrayList<String>) entry.getKey();
			System.out.println("Key: CreditRatingGroupingKey [countryCriteria= " + outputObj.get(0)
					+ ", creditRatingCriteria=" + outputObj.get(1) + "] Value: " + entry.getValue());
		}
	}
	
	

}
