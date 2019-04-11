package Json;

import java.io.IOException;
import com.google.gson.stream.JsonReader;

/**
 * Created by jmalvarez on 11/5/16.
 * http://developer.android.com/intl/es/training/basics/network-ops/xml.html
 */
public class DatabaseJSonReader {

	private JsonReader j;
	private cMando mando;
	
	public DatabaseJSonReader(JsonReader j){
		this.j=j;
	}

	public void setCadena(cMando mando) {
		this.mando=mando;
	}
	
	public String parse() throws IOException {

		j.beginObject();
		StringBuffer data=new StringBuffer();
		while(j.hasNext()) {
			String n=j.nextName();
			data.append(mando.sum(n,j));
		}

		j.endObject();
		j.close();

		return data.toString();
	}

	

	

}
