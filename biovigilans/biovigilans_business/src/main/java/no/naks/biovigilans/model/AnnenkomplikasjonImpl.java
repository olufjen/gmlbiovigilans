package no.naks.biovigilans.model;

import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Vigilansmelding som annen komplikasjon
 */

public class AnnenkomplikasjonImpl extends AbstractVigilansmelding implements Vigilansmelding,Annenkomplikasjon{

	
	/**
	 * Klassifikasjon av hendelsen (beskrivelse)
	 */
	private String klassifikasjon;
	/**
	 * Klassifikasjonskode
	 */
	private String Klassifikasjonkode;
	/**
	 * Beskrivelse av hendelsen
	 */
	private String komplikasjonbeskrivelse;
	/**
	 * Hva slags hendelse er dette?
	 */
	private String komplikasjondefinisjon;
	/**
	 * Årsak til avviket
	 */
	private String avvikarsak;
	/**
	 * Under hvilken prosess skjedde hendelsen?
	 */
	private String hovedprosess;
	/**
	 * Gjennomførte eller planlagte tiltak
	 */
	private String tiltak;
	/**
	 * Kommentarer til hendelsen
	 */
	private String kommentar;
	/**
	 * Hvordan ble hendelsen oppdaget
	 */
	private String oppdaget;
	private String delkode;
	
	/**
	 * check update the database table or insert
	 */
	private boolean isUpdat =false;
	
	/**
	 * Dato når komplikasjonen ble oppdaget for kvittering
	 */
	private String datoforhendelseKvittering;

//	private Long meldeid; Meldeid finnes i AbstractVigelansmelding OLJ 16.01.15 !!
	private Map<String,String> annenKomplikasjonsFields;
	private String[] keys;
	
	
	public AnnenkomplikasjonImpl() {
		super();
		types = new int[]  {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		utypes = new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		annenKomplikasjonsFields = new HashMap<String,String>();
	}
	public String getKlassifikasjon() {
		if(klassifikasjon==null){
			klassifikasjon = "";
		}
		return klassifikasjon;
	}
	public void setKlassifikasjon(String klassifikasjon) {
		if(klassifikasjon == null){
			klassifikasjon = (annenKomplikasjonsFields.get(keys[3])==null ? "" : annenKomplikasjonsFields.get(keys[3])) ;
			/*for(int i=9;i<16;i++){
				if(annenKomplikasjonsFields.get(keys[i])!=null){
					klassifikasjon = klassifikasjon +" ; " + annenKomplikasjonsFields.get(keys[i]);
					i=16;
				}
			}*/
		}
		this.klassifikasjon = klassifikasjon;
	}
	
	
	public boolean isUpdat() {
		return isUpdat;
	}
	public void setUpdat(boolean isUpdat) {
		this.isUpdat = isUpdat;
	}
	public String getDelkode() {
		if(delkode == null){
			delkode = "";
		}
		return delkode;
	}
	
	public void setDelkode(String delkode) {
		if(delkode == null){
			delkode = annenKomplikasjonsFields.get(keys[9]);
		}
		this.delkode = delkode;
	}
	public String getDatoforhendelseKvittering() {
		if(datoforhendelseKvittering == null){
			datoforhendelseKvittering = "";
		}
		return datoforhendelseKvittering;
	}
	public void setDatoforhendelseKvittering(String datoforhendelseKvittering) {
		this.datoforhendelseKvittering = datoforhendelseKvittering;
	}
	public String getKlassifikasjonkode() {
		if(Klassifikasjonkode == null){
			Klassifikasjonkode = "";
		}
		return Klassifikasjonkode;
	}
	public void setKlassifikasjonkode(String klassifikasjonkode) {
		
		Klassifikasjonkode = klassifikasjonkode;
	}
	public String getKomplikasjonbeskrivelse() {
		if(komplikasjonbeskrivelse == null){
			komplikasjonbeskrivelse="";
		}
		return komplikasjonbeskrivelse;
	}
	public void setKomplikasjonbeskrivelse(String komplikasjonbeskrivelse) {
		if(komplikasjonbeskrivelse == null){
			komplikasjonbeskrivelse = (annenKomplikasjonsFields.get(keys[1])==null ? "" : annenKomplikasjonsFields.get(keys[1])) ;
		}
		this.komplikasjonbeskrivelse = komplikasjonbeskrivelse;
	}
	public String getKomplikasjondefinisjon() {
		if(komplikasjondefinisjon == null){
			komplikasjondefinisjon ="--- Select ---";
		}
		return komplikasjondefinisjon;
	}
	public void setKomplikasjondefinisjon(String komplikasjondefinisjon) {
		if(komplikasjondefinisjon == null){
			komplikasjondefinisjon = (annenKomplikasjonsFields.get(keys[2])==null ? "" : annenKomplikasjonsFields.get(keys[2])) ;
		}
		this.komplikasjondefinisjon = komplikasjondefinisjon;
	}
	public String getAvvikarsak() {
		if(avvikarsak == null){
			avvikarsak = "--- Select ---";
		}
		return avvikarsak;
	}
	public void setAvvikarsak(String avvikarsak) {
		if(avvikarsak == null){
			avvikarsak = (annenKomplikasjonsFields.get(keys[4])==null ? "" : annenKomplikasjonsFields.get(keys[4])) ;
			if(avvikarsak.equalsIgnoreCase("--- Select ---")){
				avvikarsak=null;
			}
		}
		this.avvikarsak = avvikarsak;
	}
	public String getHovedprosess() {
		if(hovedprosess == null){
			hovedprosess = "--- Select ---";
		}
		return hovedprosess;
	}
	public void setHovedprosess(String hovedprosess) {
		if(hovedprosess == null){
			hovedprosess = (annenKomplikasjonsFields.get(keys[5])==null ? "" : annenKomplikasjonsFields.get(keys[5])) ;
			if(hovedprosess.equalsIgnoreCase("--- Select ---")){
				hovedprosess=null;
			}
		}
		this.hovedprosess = hovedprosess;
	}
	public String getTiltak() {
		if(tiltak == null){
			tiltak ="";
		}
		return tiltak;
	}
	public void setTiltak(String tiltak) {
		if(tiltak == null){
			tiltak = (annenKomplikasjonsFields.get(keys[7])==null ? "" : annenKomplikasjonsFields.get(keys[7])) ;
		}
		this.tiltak = tiltak;
	}
	public String getKommentar() {
		if(kommentar == null){
			kommentar = "";
		}
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		if(kommentar == null){
			kommentar = (annenKomplikasjonsFields.get(keys[8])==null ? "" : annenKomplikasjonsFields.get(keys[8])) ;
		}
		this.kommentar = kommentar;
	}
	public String getOppdaget() {
		if(oppdaget == null ){
			oppdaget = "--- Select ---";
		}
		return oppdaget;
	}
	public void setOppdaget(String oppdaget) {
		if(oppdaget == null){
			oppdaget = (annenKomplikasjonsFields.get(keys[6])==null ? "" : annenKomplikasjonsFields.get(keys[6])) ;
			if(oppdaget.equalsIgnoreCase("--- Select ---")){
				oppdaget=null;
			}
		}
		this.oppdaget = oppdaget;
	}
	public Map<String, String> getAnnenKomplikasjonsFields() {
		return annenKomplikasjonsFields;
	}
	public void setAnnenKomplikasjonsFields(
			Map<String, String> annenKomplikasjonsFields) {
		this.annenKomplikasjonsFields = annenKomplikasjonsFields;
	}
	public String[] getKeys() {
		return keys;
	}
	public void setKeys(String[] keys) {
		this.keys = keys;
	}
	public void setKladd(String kladd) {
		if (kladd == null){
			int l = keys.length - 1;
			kladd = annenKomplikasjonsFields.get(keys[l]);
		}
		super.setKladd(kladd);
	}
	public void setParams(){
		Long id = getMeldeid();
		if (id == null){
			params = new Object[]{getKlassifikasjon(),getKlassifikasjonkode(),getKomplikasjonbeskrivelse(),getKomplikasjondefinisjon(),getAvvikarsak(),getHovedprosess(),getTiltak(),getKommentar(),getOppdaget(),getDelkode(),getMeldeid()};
		}else
			params = new Object[]{getKlassifikasjon(),getKlassifikasjonkode(),getKomplikasjonbeskrivelse(),getKomplikasjondefinisjon(),getAvvikarsak(),getHovedprosess(),getTiltak(),getKommentar(),getOppdaget(),getDelkode(),getMeldeid()};
		}
	/**
	 * setAnnenkomplicationfieldMaps
	 * Denne rutinen setter opp hvilke skjermbildefelter som hører til hvilke databasefelter
	 * @param userFields En liste over skjermbildefelter
	 */
	public void setAnnenkomplicationfieldMaps(String[]userFields){
		keys = userFields;
		int size = keys.length;
		for (int i = 0; i<size;i++){
			annenKomplikasjonsFields.put(userFields[i],null);
		}
	
		
	}
	/**
	 * saveField
	 * Denne rutinen lagrer skjermbildefelter til riktig databasefelt
	 * @param userField
	 * @param userValue
	 */
	public void saveField(String userField, String userValue) {
		if (annenKomplikasjonsFields.containsKey(userField) && userValue != null && !userValue.equals("")){
			annenKomplikasjonsFields.put(userField,userValue);	
	
		}
		
	}

	public void saveToAnnenKomplikasjon(){
		setTiltak(null);
		setKomplikasjonbeskrivelse(null);
		setKlassifikasjonkode(null);
		setKlassifikasjon(null);
		setAvvikarsak(null);
		setHovedprosess(null);
		setOppdaget(null);
		setKomplikasjondefinisjon(null);
		setKommentar(null);
		setDelkode(null);
		setKladd(null);
	
	}
	
}

