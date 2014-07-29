package no.naks.biovigilans.model;

import java.util.Map;

public interface Giveroppfolging {

	
	public String getKlassifikasjongiveroppfolging();
	public void setKlassifikasjongiveroppfolging(
			String klassifikasjongiveroppfolging);
	public String getGiveroppfolgingbeskrivelse();
	public void setGiveroppfolgingbeskrivelse(String giveroppfolgingbeskrivelse);
	public String getAvregistering();
	public void setAvregistering(String avregistering);
	public Map<String, String> getGiveroppfolgingFields();
	public void setGiveroppfolgingFields(Map<String, String> giveroppfolgingFields);
	public String[] getKeys();
	public void setKeys(String[] keys);
	
}