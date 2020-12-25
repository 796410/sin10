package com.talentica.code.data;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.talentica.code.exception.FileReadException;

/**
 * Get the product data
 * present in basket
 * 
 * @author Sayantan Ganguly
 *
 */
public class BasketData {

	/**
	 * Get the basket data
	 * of products from
	 * a CSV file
	 * 
	 * @return List<String>
	 * @throws Exception
	 */
	public List<String> getCSVData() throws FileReadException {
		try {
			String CSV_FILE_NAME = "E:/Programming/TalenticaDocuments/productBasket.csv";
			return FileUtils.readLines(new File(CSV_FILE_NAME), Charset.defaultCharset());
		} catch (Exception e) {
			throw new FileReadException("Failed to read CSV file", e);
		}
	}

}
