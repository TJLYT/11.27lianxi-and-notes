package net.sf.json;

import com.example.pojo.Person;

public class JSONObject {
	

	public static String fromObject(String jsonString) {
		String s2 = "[{\"name\":\"老彭\",\"age\":\"88\"},{\"name\":\"小彭\",\"age\":\"22\"}]";
		return s2;
	}

	public static Object toBean(String jsonObject, Person pojoCalss) {
		// TODO Auto-generated method stub
		return null;
	}
}
