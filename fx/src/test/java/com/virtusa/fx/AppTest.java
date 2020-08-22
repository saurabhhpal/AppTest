package com.virtusa.fx;

import static org.junit.Assert.assertTrue;

import java.io.File;
import org.junit.Test;

public class AppTest {

	@Test
	public void testFilePath() {

		String path = "src\\test\\resources\\FILE.DAT";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();

		assertTrue(absolutePath.endsWith(("src\\test\\resources\\FILE.DAT")));
	}

}
