package modelos;

import java.util.ArrayList;

public class Season implements Item{

	private String idSeason;
	private ArrayList<Episode> episodeList;
	
	public Season() {      
	}

	public String getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(String idSeason) {
		this.idSeason = idSeason;
	}

	public ArrayList<Episode> getEpisodeList() {
		return episodeList;
	}

	public void setEpisodeList(ArrayList<Episode> episodeList) {
		this.episodeList = episodeList;
	}	

	@Override
	public boolean isSection() {
		return true;
	}
	
	
}
	