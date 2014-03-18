package util;

import java.util.ArrayList;

import modelos.Episode;
import modelos.Item;
import modelos.Season;
 

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lillosoft.simpsonmusic.R;

public class EntryAdapter extends ArrayAdapter<Item> {

	private Context context;
	private ArrayList<Item> items;
	private LayoutInflater vi;

	public EntryAdapter(Context context,ArrayList<Item> items) {
		super(context,0, items);
		this.context = context;
		this.items = items;
		vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final Item i = items.get(position);
		if (i != null) {
			if(i.isSection()){
				Season si = (Season)i;
				v = vi.inflate(R.layout.section, null);

				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);
				v.setBackgroundColor(Color.GREEN);
				
				final TextView sectionView = (TextView) v.findViewById(R.id.list_item_section_text);
				sectionView.setText("Temporada " + si.getIdSeason());
			}else{
				Episode ei = (Episode)i;
				v = vi.inflate(R.layout.list_helper, null);
				final TextView title = (TextView)v.findViewById(R.id.list_item_entry_title);
			//	final TextView subtitle = (TextView)v.findViewById(R.id.list_item_entry_summary);
				
				if (title != null) {
					title.setText(ei.getNumberEpisode() + " - " + ei.getName());
				title.setSingleLine(false);
				}
				}
			//	if(subtitle != null)
			//		subtitle.setText(ei.getNumberEpisode());
			//}
		}
		return v;
	}

}
