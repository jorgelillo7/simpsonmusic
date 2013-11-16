package util;

import java.util.ArrayList;

import modelos.Season;
import android.util.Log;


public class DataManager {

	private static DataManager instance = null;
	public ArrayList<Season> data;

	
	DataManager() {      
	}	
	
	public static DataManager getInstance() {
		if (instance == null) {
			if (instance == null) {
				instance = new DataManager ();
			}
		}
		return instance;
	}

	public ArrayList<Season> getSeason() {
		return data;
	}

	public void setSeason(ArrayList<Season> data) {
		this.data = data;
	}

	
	
}
