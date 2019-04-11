package Json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

public class GsonDatabaseClient {

	public static void main(String[] args) {
		try{
			InputStream usersIS = new FileInputStream (new File("resources/datos.json"));
			JsonReader reader = new JsonReader(new InputStreamReader(usersIS, "UTF-8"));
			DatabaseJSonReader dbjp = new DatabaseJSonReader(reader);
			
			readRescueMedicine rrm = new readRescueMedicine(null);
			readMedicine rm = new readMedicine(rrm);
			
			dbjp.setCadena(rm);
			
			try {
				System.out.println(dbjp.parse());
				
			} finally {
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
