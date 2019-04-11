package Json;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class cMando {
	protected cMando sucesor;
	
	public void setSucesor(cMando sucesor) {
		this.sucesor=sucesor;
	}
	
	abstract String sum(String n, JsonReader j) throws IOException;
	
}
