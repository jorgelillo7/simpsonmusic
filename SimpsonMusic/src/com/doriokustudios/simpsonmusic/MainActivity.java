package com.doriokustudios.simpsonmusic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import modelos.Episode;
import modelos.Season;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.json.JSONArray;
import org.json.JSONObject;

import com.lillosoft.simpsonmusic.R;
 

import util.*;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	//private static ParserJSON api = new ParserJSON(); 
	/*
	"name":"Los Simpson","idm":788,"mediaType":1,"id_media":"CUE2CNKTN6","rating":9.46,
	auth_token = 044da2519762b9ef949f7ae9a4739907;
	method episode full http://api.series.ly/docs/media/full_info
	http://api.series.ly/v2/media/full_info?auth_token={auth_token}&idm={idm}&mediaType={mediaType}
	
	http://api.series.ly/v2/media/full_info?auth_token=044da2519762b9ef949f7ae9a4739907&idm=788&mediaType=1
	
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GetAuthToken task = new GetAuthToken();
	    task.execute(new String[] { "http://www.vogella.com" });
	    
		Button boton1 = (Button) findViewById(R.id.button1);
		
		boton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), TabSample.class);
				intent.putExtra("tabselected", 0);
				startActivity(intent);
			}
		});
		
	/*Button boton2 = (Button) findViewById(R.id.buttonInfo);
		
		boton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
				DataManager dm = DataManager.getInstance();
				Season aux = dm.getSeason().get(24);
				Toast.makeText(MainActivity.this, aux.getEpisodeList().get(0).getName(), Toast.LENGTH_SHORT).show();
				
			}
		});
		*/
		
	}
	
	  private class GetAuthToken extends AsyncTask<String, Void, String> {
		    @Override
		    protected String doInBackground(String... urls) {
		      String auth_token = "";
		     
		      	 try
					{
					    String APIID = "1681"; //Your API Application ID
					    String APIkey = "CqEWAHZ4XtyTFkRRYXP4";//Your API Application KEY
					    //URL to obtain the AUTH_TOKEN
					    String URL = "http://api.series.ly/v2/auth_token/?id_api="+APIID+"&secret="+APIkey;
					    /////////
					    //Connect to the server and will obtain a JSON object
					    /////////
					    BufferedReader in = null;
					    HttpClient client = new DefaultHttpClient();
					    client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "android");
					    HttpGet request = new HttpGet();
					    request.setHeader("Content-Type", "text/plain; charset=utf-8");
					    request.setURI(new URI(URL));
					    HttpResponse response = client.execute(request);
					    in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					 
					    StringBuffer sb = new StringBuffer("");
					    String line = "";
					 
					    String NL = System.getProperty("line.separator");
					    while ((line = in.readLine()) != null)
					    {
					        sb.append(line + NL);
					    }
					    in.close();
					    String page = sb.toString();
					    JSONObject jsonobject = new JSONObject(page);
					    /////////
					    //Extract AUTH_TOKEN from JSONObject
					    /////////
					    auth_token = jsonobject.getString("auth_token");
					    
					   
					}
					catch(Exception e){
					    //An error occurred
											
					}
		      
		      return auth_token;
		    }

		    @Override
		    protected void onPostExecute(String result) {
		    	// TextView authText = (TextView) findViewById(R.id.authID);
				//    authText.setText(result);
				    GetListEpisodes list = new GetListEpisodes();
					list.execute(new String[] { result });	
					
			
		    }
		  }

	  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	 private class GetListEpisodes extends AsyncTask<String, Void, String> {
		    @Override
		    protected String doInBackground(String... urls) {
		      String auth_token = "";
		     
		      	 try
					{
					    //URL to obtain the AUTH_TOKEN
					    String URL =  "http://api.series.ly/v2/media/full_info?auth_token="+urls[0] +"&idm=788&mediaType=1";
					    /////////
					    //Connect to the server and will obtain a JSON object
					    /////////
					    BufferedReader in = null;
					    HttpClient client = new DefaultHttpClient();
					    client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "android");
					    HttpGet request = new HttpGet();
					    request.setHeader("Content-Type", "text/plain; charset=utf-8");
					    request.setURI(new URI(URL));
					    HttpResponse response = client.execute(request);
					    in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					 
					    StringBuffer sb = new StringBuffer("");
					    String line = "";
					 
					    String NL = System.getProperty("line.separator");
					    while ((line = in.readLine()) != null)
					    {
					        sb.append(line + NL);
					    }
					    in.close();
					    String page = sb.toString();
					    
					    JSONObject jsonobject = new JSONObject(page);
					    
					    Iterator<String> keys = jsonobject.keys();
					    
					    /////////
					    //Extract AUTH_TOKEN from JSONObject
					    /////////
					    auth_token = jsonobject.getString("name");
					    
					  
					/*   
					    
					 // Parser JSON
						InputStream inS;
						try {
							inS = getAssets().open("data.json");
							api.parserJSON(inS);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							Log.e("ERROR", "ParserRTOG");
							e.printStackTrace();
						}
						
					  */  
					    
					    Map<String,String> map = new HashMap<String,String>();
					    Iterator iter = jsonobject.keys();
					    while(iter.hasNext()){
			 		        String key = (String)iter.next();
					        String value = jsonobject.getString(key);
					        
 					        map.put(key,value);
					    }
					    
					    String numberOfSeasons = jsonobject.getString("seasons");
					    ArrayList<Season> listSeasons = new ArrayList<Season>();
					 for (int i = 1; i<= Integer.parseInt(numberOfSeasons);i++){
						 
					    JSONArray season = null;
					    Season newSeason = new Season();
					    newSeason.setIdSeason(String.valueOf(i));
					    if (i<10){
					     season = jsonobject.getJSONObject("seasons_episodes").getJSONArray("season_0" + i);
					     }
					    else {
					     season = jsonobject.getJSONObject("seasons_episodes").getJSONArray("season_" + i);
					    }
					   
					    //Toast.makeText(MainActivity.this, auth_token.toString(), Toast.LENGTH_SHORT).show();
					     ArrayList<Episode> listEpisodes = new ArrayList<Episode>();
					     for (int j = 0; j<season.length();j++){
					    	 JSONObject episodeAux = season.getJSONObject(j);
					    	 Episode epi = new Episode();
					    	 epi.setIdMedia(episodeAux.getString("idm"));
					    	 epi.setName(episodeAux.getString("title"));
					    	 epi.setName_es(episodeAux.getString("title_es"));
					    	 epi.setNumberEpisode(episodeAux.getString("episode"));
					    	 epi.setSeason(episodeAux.getString("season"));
					    	 
					    	 listEpisodes.add(epi);
					    	 
					     }
					     newSeason.setEpisodeList(listEpisodes);
					     
					     listSeasons.add(newSeason);
					    
					}
					 
						DataManager dm = DataManager.getInstance();
						dm.setSeason(listSeasons);
					}
		      	 
					catch(Exception e){
						e.printStackTrace(); 
					    //An error occurred
						
					}
		      	 
		      
					
		      
		      return auth_token;
		    }


		    @Override
		    protected void onPostExecute(String result) {
		    	// Button but = (Button) findViewById(R.id.buttonInfo);
				 //  but.setText(result);
				   findViewById(R.id.progressCircle).setVisibility(View.GONE);
				   findViewById(R.id.button1).setVisibility(View.VISIBLE);
					
			
		    }
		  }

	
	 

}
