package com.testautomation.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.testautomation.testscripts.Module01;

public class ExcelHandler {

	private static final Logger logger = LogManager.getLogger(ExcelHandler.class);

	public static List<Map<String, String>> getTestDataByQuery(String testDatafilepath, String query) {
		List<Map<String, String>> testDataForAllRows = null;
		Map<String, String> testDataMap = null;
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordset = null;
		try {
			logger.info("Test data path: " + getValidExcelPath(testDatafilepath));
			conn = fillo.getConnection(getValidExcelPath(testDatafilepath));
			recordset = conn.executeQuery(query);
			testDataForAllRows = new ArrayList<Map<String, String>>();
			while (recordset.next()) {
				testDataMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
				for (String field : recordset.getFieldNames()) {
					testDataMap.put(field, recordset.getField(field));
				}
				testDataForAllRows.add(testDataMap);
			}
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			recordset.close();
			conn.close();
		}
		return testDataForAllRows;
	}

	public static synchronized Map<String, String> getTestDataInMap(String testDataFile, String sheetName,
			String testCaseId) throws Exception {
		Map<String, String> TestDataInMap = new TreeMap<String, String>();
		String query = String.format("SELECT * FROM %s WHERE Run_ThisRow='Yes' and TestCaseId='%s'", sheetName,
				testCaseId);
		Fillo fillo = new Fillo();
		Connection conn = null;
		Recordset recordset = null;
		try {
			logger.info("Test data file : " + getValidExcelPath(testDataFile));
			logger.info("Test data sheet : " + sheetName);
			logger.info("Test case id : " + testCaseId);
			conn = fillo.getConnection(getValidExcelPath(testDataFile));
			recordset = conn.executeQuery(query);
			while (recordset.next()) {
				for (String field : recordset.getFieldNames()) {
					TestDataInMap.put(field, recordset.getField(field));
				}
			}
		} catch (FilloException e) {
			e.printStackTrace();
			throw new Exception("Test data cannot find . . .");
		}
		conn.close();
		return TestDataInMap;
	}

	public static synchronized void UpdateTestResultsToExcel(String testDataFilePath, String sheetName,
			String testCaseStatus, String testCaseId) {
		Connection conn = null;
		Fillo fillo = new Fillo();
		try {
			conn = fillo.getConnection(testDataFilePath);
			String query = String.format("UPDATE %s SET TestCaseStatus='%s' where TestCaseId='%s'", sheetName,
					testCaseStatus, testCaseId);
			int result = conn.executeUpdate(query);
			conn.close();
			logger.info("Updated sheet with " + result + " row");
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}

	public synchronized static String getValidExcelPath(String testDataFile) {
		String environment = new TestDataHandler().getEnvironment();
		String commonPath = "./src/test/resources/testdata/";
		String testDataPath = commonPath + environment + "/" + testDataFile;
		return testDataPath;
	}

}