package modelos;

import java.util.ArrayList;


public class Episode implements Item{

	private String idMedia;
	private String name;
	private String name_es;
	private String numberEpisode;
	private String season;
	private ArrayList<String> songsList;
	
	public Episode() {      
	}	
	
	public Episode(String idMedia, String name, String name_es,
			String numberEpisode, String season, ArrayList<String> songsList) {
		super();
		this.idMedia = idMedia;
		this.name = name;
		this.name_es = name_es;
		this.numberEpisode = numberEpisode;
		this.season = season;
		this.songsList = songsList;
	}

	public String getIdMedia() {
		return idMedia;
	}

	public void setIdMedia(String idMedia) {
		this.idMedia = idMedia;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_es() {
		return name_es;
	}

	public void setName_es(String name_es) {
		this.name_es = name_es;
	}

	public String getNumberEpisode() {
		return numberEpisode;
	}

	public void setNumberEpisode(String numberEpisode) {
		this.numberEpisode = numberEpisode;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public ArrayList<String> getSongsList() {
		return songsList;
	}

	public void setSongsList(ArrayList<String> songsList) {
		this.songsList = songsList;
	}
	
	@Override
	public boolean isSection() {
		return false;
	}

		
	
}
