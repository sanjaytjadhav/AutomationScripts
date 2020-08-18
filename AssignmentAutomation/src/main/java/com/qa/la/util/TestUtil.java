package com.qa.la.util;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qa.la.base.TestBase;

public class TestUtil extends TestBase {

	public static long page_Load_TimeOut = 20;
	public static long implicitwait = 30;

	HashMap<String, String> map = new HashMap<>();

	public HashMap<String, String> readjssonValue(String path)
			throws FileNotFoundException {
		JsonParser jsonParse = new JsonParser();
		java.io.FileReader reader = new java.io.FileReader(
				".\\src\\main\\resources\\testData\\" + path);
		JsonElement weatherForecastObj = jsonParse.parse(reader);
		JsonObject weatherDetails = (JsonObject) weatherForecastObj;

		Set<Entry<String, JsonElement>> set = weatherDetails.entrySet();
		for (Entry<String, JsonElement> element : set) {
			map.put(element.getKey(), element.getValue().getAsString());
		}
		System.out.println(map);

		return map;

	}

}
