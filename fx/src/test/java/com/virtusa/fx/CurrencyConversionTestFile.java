package com.virtusa.fx;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.virtusa.fx.util.CurrencyConversion;

public class CurrencyConversionTestFile {

	@Test
	public void testGBPToEURConversion() {

		assertEquals(1.125, new CurrencyConversion().GBPToEUR(1.0), 0);
		assertEquals(0.0, new CurrencyConversion().GBPToEUR(0.0), 0);
		assertEquals(-1.125, new CurrencyConversion().GBPToEUR(-1.0), 0);
	}

	@Test
	public void testCHFToEURConversion() {
		assertEquals(.928, new CurrencyConversion().CHFToEUR(1.0), 2);
		assertEquals(0.0, new CurrencyConversion().CHFToEUR(0.0), 2);
		assertEquals(-0.928, new CurrencyConversion().CHFToEUR(-1.0), 1);

	}

	@Test
	public void testEURToUSDConversion() {
		assertEquals(-1.12, new CurrencyConversion().EURToUSD(-1.0), 0);
		assertEquals(0.0, new CurrencyConversion().EURToUSD(0.0), 0);
		assertEquals(1.12, new CurrencyConversion().EURToUSD(1.0), 0);

	}

	@Test
	public void testUSDToEURConversion() {
		assertEquals(1.0, new CurrencyConversion().USDToEUR(1.12), 0);
		assertEquals(0.0, new CurrencyConversion().USDToEUR(0.0), 0);

	}

}
