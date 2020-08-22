package com.virtusa.fx.util;

import java.util.List;

import com.virtusa.fx.beans.FileObject;

public class CurrencyToEUR {

	
	public static List<FileObject> convertCurrencyToEUR(List<FileObject> objList) {
//		System.out.print(objList);
		CurrencyConversion cc = new CurrencyConversion();
		for (FileObject fileData : objList) {
			Double amount = fileData.getAmount();
			
			switch (fileData.getCurrency()) {
			case "GBP":
				fileData.setAmount(cc.GBPToEUR(amount));
				break;
			case "CHF":
				fileData.setAmount(cc.CHFToEUR(amount));
				break;
			case "EUR":
				fileData.setAmount(cc.USDToEUR(amount));
				break;
			default:
				fileData.setAmount(amount);
				break;
			}

		}
		return objList;
	}
}
