package com.testautomation.utilities;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Configuration {

	/*
	 * public static Map<String, String> getConfiguration() throws Exception {
	 * 
	 * Map<String, String> TestDataInMap = new TreeMap<String, String>(); Properties
	 * properties = new PropertiesFileReader().getPropertyForConfig(); Fillo fillo =
	 * new Fillo(); Connection conn = null; Recordset recordset = null;
	 * 
	 * String query = String.format("SELECT * FROM %s WHERE Configuration='Yes'",
	 * properties.getProperty("testdata.config.sheetname")); try { conn =
	 * fillo.getConnection(properties.getProperty("testdata.config.filepath"));
	 * recordset = conn.executeQuery(query); while (recordset.next()) { for (String
	 * field : recordset.getFieldNames()) { TestDataInMap.put(field,
	 * recordset.getField(field)); } } } catch (FilloException e) {
	 * e.printStackTrace(); throw new Exception("Test data cannot find . . ."); }
	 * conn.close(); return TestDataInMap; }
	 */

	/*
	 * implementation for excel public static Map<String,String> getConfiguration()
	 * throws Exception{
	 * 
	 * Map<String,String> TestDataInMap=new TreeMap<String,String>(); Properties
	 * properties=new PropertiesFileReader().getPropertyForConfig(); Fillo fillo=new
	 * Fillo(); Connection conn=null; Recordset recordset=null;
	 * 
	 * String query=String.format("SELECT * FROM %s WHERE Configuration='Yes'",
	 * properties.getProperty("testdata.config.sheetname")); try{
	 * conn=fillo.getConnection(properties.getProperty("testdata.config.filepath"));
	 * recordset=conn.executeQuery(query); while(recordset.next()){ for(String
	 * field:recordset.getFieldNames()){ TestDataInMap.put(field,
	 * recordset.getField(field)); } } } catch(FilloException e){
	 * e.printStackTrace(); throw new Exception("Test data cannot find . . ."); }
	 * conn.close(); return TestDataInMap; }
	 */

}