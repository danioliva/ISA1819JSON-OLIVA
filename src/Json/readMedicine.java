package Json;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class readMedicine extends cMando{
	
	private static final String MEDICINES_TAGNAME = "medicines";
	private static final String NAME_FIELD_TAGNAME = "name";
	
	readMedicine(cMando s) {
		setSucesor(s);
	}
	
	private StringBuffer readMedicines(JsonReader reader) throws IOException {
		StringBuffer medicineData = new StringBuffer();
		reader.beginArray();
		while (reader.hasNext()) {
			reader.beginObject();
			medicineData.append(readMedicineEntry(reader)).append("\n");
			reader.endObject();
		}
		medicineData.append("\n");
		reader.endArray();
		return medicineData;
	}
	
	private String readMedicineEntry(JsonReader reader) throws IOException {
		String medName = null;
		while(reader.hasNext()){
			String name = reader.nextName();
			switch (name) {
			case NAME_FIELD_TAGNAME:
				medName = reader.nextString();
				break;
			default:
				reader.skipValue();
			}
		}

		return medName;
	}
	@Override
	public String analisis(String n, JsonReader j) throws IOException {
		StringBuffer data=new StringBuffer();
		if(n.equals(MEDICINES_TAGNAME)) {
			data.append(readMedicines(j).append("/n"));
		}else if(sucesor==null) {
			data.append(sucesor.analisis(n, j));
		} else {
			j.skipValue();
			data.append("Category " + n + " not processed.").append("\n");
		}
		return data.toString();
	}
	
}
