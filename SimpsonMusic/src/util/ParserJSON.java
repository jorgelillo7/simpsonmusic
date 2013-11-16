package util;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetManager.AssetInputStream;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import util.DataManager;

public class ParserJSON{

	public void parserJSON (InputStream in){


		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

			StringBuilder string_builder = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				string_builder.append(line);
			}
			in.close();

			JSONArray json = new JSONArray(string_builder.toString());

			for (int i = 0; i < json.length(); i++) {

				JSONObject jsonObj = json.getJSONObject(i);

				if(jsonObj.has("name")){
					String name = (jsonObj.getString("name").toString());
					Log.e("excepcion", name);
				}
			
				if(jsonObj.has("seasons_episodes")){

					JSONArray descArray = jsonObj.getJSONArray("seasons_episodes");
					
					ArrayList<String> t = new ArrayList<String>();
					ArrayList<String> n = new ArrayList<String>();
					ArrayList<String> m = new ArrayList<String>();
				
				
					for (int j=0; j < descArray.length(); j++){

						JSONObject descObject = descArray.getJSONObject(j);

						
						if(descObject.has("title")){		//info adicional t
							String tinfo = new String();
							tinfo = descObject.getString("title");
																							
							//descr.setTi(tinfo);
						}
						 if(descObject.has("title_es")){		//info adicional n
							String ninfo = new String();
							ninfo = descObject.getString("title_es");																
							//descr.setNi(ninfo);
						}
						 if(descObject.has("mi")){		//info adicional m
								String minfo = new String();
								minfo = descObject.getString("mi");																
							
							}
						 if(descObject.has("si")){		//info adicional s
								String sinfo = new String();
								sinfo = descObject.getString("si");																
							
							}
						 if(descObject.has("bi")){		//info adicional b
								String binfo = new String();
								binfo = descObject.getString("bi");																
						
							}
						 if(descObject.has("gi")){		//info adicional grado
								String ginfo = new String();
								ginfo = descObject.getString("gi");																
							
							}
						 if(descObject.has("ui")){		//info adicional ubicacion
								String uinfo = new String();
								uinfo = descObject.getString("ui");																
							
							}
						 if(descObject.has("i")){
								String i2 = descObject.getString("i");
								
							}
						 
					
					//tnm.setDescripcion(descr);
				}
				//result.add(tnm);
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("excepcion", e.toString());
		}

		DataManager dm = DataManager.getInstance();
		//dm.setTNM(result);

	}
}



