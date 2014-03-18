package com.lillosoft.simpsonmusic;

import java.util.ArrayList;

import modelos.Episode;
import modelos.Item;
import modelos.Season;
import util.DataManager;
import util.EntryAdapter;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class GuiaEpisodiosActivity extends ListActivity {
    /** Called when the activity is first created. */
	
	 ArrayList<Item> items = new ArrayList<Item>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	setContentView(R.layout.guia_episodios);
        

		DataManager dm = DataManager.getInstance();
		ArrayList<Season> temporadas = dm.getSeason();
		 
        
        for (int i = 0; i<temporadas.size(); i++){
        	items.add(temporadas.get(i)); //incluimos temporada
        	
        	ArrayList<Episode> episodios = temporadas.get(i).getEpisodeList();
        	
        	for (int j = 0; j<episodios.size(); j++){
        		items.add(episodios.get(j)); //incluimos episodios
        		
        	}
        	
        	
        }
         
        ListView lv = getListView();
        lv.setFastScrollEnabled(true);
        lv.setScrollingCacheEnabled(true);
     
        EntryAdapter adapter = new EntryAdapter(this, items);
        
        setListAdapter(adapter);

    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	
    	if(!items.get(position).isSection()){
    		
    		Episode item = (Episode)items.get(position);
    		
    		Toast.makeText(this, "You clicked " + item.getName() , Toast.LENGTH_SHORT).show();

    		
    	}
    	
    	super.onListItemClick(l, v, position, id);
    }
}
