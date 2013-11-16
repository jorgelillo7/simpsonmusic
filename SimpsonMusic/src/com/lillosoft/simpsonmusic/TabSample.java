package com.lillosoft.simpsonmusic;

import com.lillosoft.simpsonmusic.R;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * @author Adil Soomro
 * 
 */
public class TabSample extends TabActivity {
	/** Called when the activity is first created. */
	private TabWidget tabLayout = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tabmain);
		setTabs();
		tabLayout = (TabWidget) findViewById(android.R.id.tabs);

		// Needed for back button working
		getTabWidget().getChildAt(0).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						tabLayout.setVisibility(View.VISIBLE);
						getIntent().putExtra("tabselected", 0);
						getTabHost().setCurrentTab(0);
					}
				});
		getTabWidget().getChildAt(1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						tabLayout.setVisibility(View.VISIBLE);
						getIntent().putExtra("tabselected", 1);
						getTabHost().setCurrentTab(1);
					}
				});
		getTabWidget().getChildAt(2).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						tabLayout.setVisibility(View.VISIBLE);
						getIntent().putExtra("tabselected", 2);
						getTabHost().setCurrentTab(2);

					}
				});
		getTabWidget().getChildAt(3).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						tabLayout.setVisibility(View.VISIBLE);
						getIntent().putExtra("tabselected", 3);
						getTabHost().setCurrentTab(3);
					}
				});

		 
	}

	// public void onResume(Bundle savedInstanceState)
	public void onResume() {
		super.onResume();

		int tabSelected = getIntent().getExtras().getInt("tabselected");

		/*
		 * if (tabSelected == 2){ tabLayout.setVisibility(View.GONE); }
		 */
		getTabHost().setCurrentTab(tabSelected);
	}

	private void setTabs() {

		addTab("Búsqueda rápida", R.drawable.tab_tnm, BuscadorActivity.class);
		addTab("Guia episodios", R.drawable.tab_calculadora,
				GuiaEpisodiosActivity.class);
		addTab("Listado canciones", R.drawable.tab_escalas, ListadoCancionesActivity.class);
		addTab("Configuración", R.drawable.tab_guia, AjustesActivity.class);
		 
	}

	private void addTab(String labelId, int drawableId, Class<?> c) {
		TabHost tabHost = getTabHost();
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

		// View tabIndicator =
		// LayoutInflater.from(this).inflate(R.layout.tab_indicator,
		// getTabWidget(), false);
		
		View tabIndicator = LayoutInflater.from(this).inflate(
				R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);

		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);

		spec.setIndicator(tabIndicator);
		
		spec.setContent(intent);
		
		tabHost.addTab(spec);
	}
}