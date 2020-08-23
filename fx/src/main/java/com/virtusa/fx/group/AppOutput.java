package com.virtusa.fx.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.virtusa.fx.beans.FileObject;

public class AppOutput {
	
	public void groupAndPrintCountry(List<FileObject> convertedList) {
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
