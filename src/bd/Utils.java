package bd;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {

	public static int getLengthOfAnArray(String field, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONArray array = json.getJSONArray(field);
		return array.length();
	}
	public static String readString(String field, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		field = json.getString(field);
		return field;
	}
	public static String readObjectId(String field, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONObject id = (JSONObject)json.get(field);
		field = id.get("$oid").toString();
		return field;
	}
	public static int readInteger(String field, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		int value = json.getInt(field);
		return value;
	}
	public static double readDouble(String field, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		double value = json.getDouble(field);
		return value;
	}
	public static int readIntegerInObject(String field, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONObject _field = json.getJSONObject(field);
		int value = _field.getInt(in);
		return value;
	}
	public static String readStringInObject(String field, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONObject _field = json.getJSONObject(field);
		String string = _field.getString(in);
		return string;
	}
	public static String readStringInArray(String field, int in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONArray _field = json.getJSONArray(field);
		
		//JSONObject jsonObject = _field.getJSONObject(in);
		String string = _field.get(in).toString();
		
		return string;
	}
	public static String readStringIntoObjectInObject(String field, String subfield, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONObject _field = json.getJSONObject(field);
		JSONObject _subfield = _field.getJSONObject(subfield);
		String string = _subfield.getString(in);
		return string;
	}
	public static int readIntegerIntoObjectInObject(String field, String subfield, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONObject _field = json.getJSONObject(field);
		JSONObject _subfield = _field.getJSONObject(subfield);
		int value = _subfield.getInt(in);
		return value;
	}
	public static int readIntegerIntoAnArrayInObject(String array, int object_index, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONArray _array = json.getJSONArray(array);
		JSONObject _object = _array.getJSONObject(object_index);
		int value = _object.getInt(in);
		return value;
	}
	public static String readStringIntoAnArrayInObject(String array, int object_index, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONArray _array = json.getJSONArray(array);
		JSONObject _object = _array.getJSONObject(object_index);
		String string = _object.getString(in);
		return string;
	}
	public static String readStringIntoAnArrayIntoAnObjectInObject(String array, int object_index, String object, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONArray _array = json.getJSONArray(array);
		JSONObject _object = _array.getJSONObject(object_index);
		JSONObject __object = _object.getJSONObject(object);
		String string = __object.getString(in);
		return string;
	}
	public static int readIntegerIntoAnArrayIntoAnObjectInObject(String array, int object_index, String object, String in, String fromJSONString) {
		JSONObject json = new JSONObject(fromJSONString);
		JSONArray _array = json.getJSONArray(array);
		JSONObject _object = _array.getJSONObject(object_index);
		JSONObject __object = _object.getJSONObject(object);
		int value = __object.getInt(in);
		return value;
	}
}