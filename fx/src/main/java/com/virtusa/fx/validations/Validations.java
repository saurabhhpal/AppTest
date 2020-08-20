package com.virtusa.fx.validations;

import java.util.List;

import com.virtusa.fx.beans.FileObject;
import com.virtusa.fx.constants.Constants;
import com.virtusa.fx.exceptions.ValidationException;

public class Validations {
	
	public static boolean fileDataValidation(List<FileObject> dataList) throws ValidationException {
		 
		for (FileObject objectData : dataList) {
			// Validating Currency
			if(objectData.getCurrency().length() != 3)
				throw new ValidationException(Constants.CURRENCY_VALIDATION_ERROR_CODE, Constants.CURRENCY_VALIDATION_ERROR_MSG);
			
			if(! (objectData.getCompanyCode() > 0 && objectData.getCompanyCode() < Integer.MAX_VALUE))
				throw new ValidationException(Constants.COMPANY_CODE_ERROR_CODE , Constants.COMPANY_CODE_ERROR_MSG);
		}
		
		
		
		return true;
	}
	
	

}