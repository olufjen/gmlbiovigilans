package no.naks.biovigilans.model;

import java.sql.Time;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import no.naks.rammeverk.kildelag.model.AbstractModel;



/**
 * En AbstractVigilansmelding er en melding om uønskede hendelser eller komplikasjoner ved blodoverføringer, celler og vev, eller organsdonasjoner. 
 * En AbstractVigilansmelding er enten en Giverkomplikasjon eller en PasientkomplikasjonImpl.
 * 
 */

public class AbstractVigilansmelding extends AbstractModel implements Vigilansmelding{

	protected Map formMap; // Inneholder brukers input verdier fra skjermbildet
	
	/**
	 * Id til meldingen
	 */
	private Long meldeid;

	/**
	 * Fremmednøkkel til melder
	 */
	private Long melderId;
	
	/**
	 * Dato for hendelsen
	 */
	protected String[]keys;
	
	private Date datoforhendelse;
	/**
	 * Klokkeslett for hendelsen
	 */
	private Time klokkesletthendelse;
	/**
	 * Dato når komplikasjonen ble oppdaget
	 */
	private Date datooppdaget;
	/**
	 * Tidspunkt for donasjon eller overføring
	 */
	private Date donasjonoverforing;
	/**
	 * Denne sjekklisten omfatter følgende definisjoner:
	 * Skal meldes videre til HDIR
	 * Skal diskuteres på neste møte
	 * Egnet som eksempler i rapport
	 * Egnet som oppgave på seminar
	 * Trenger ytterligere opplysninger
	 * Trenger å følges opp
	 * Ferdig behandlet
	 */
	private String sjekklistesaksbehandling;
	/**
	 * Eventuelle supplerende opplysninger ved meldingen.
	 */
	private String supplerendeopplysninger;
	/**
	 * Dato meldingen er mottatt
	 */
	private Date meldingsdato;

	private String meldingsnokkel;
	
	private String kladd; // Om denne meldingen er en kladd
	private String godkjent; // Om denne meldingen er godkjent
	
	protected String[]vigilansKeys;	
	protected Map<String,String>vigilansFields;

	
	
	public AbstractVigilansmelding() {
		formMap = new HashMap<String,String>();
	}
	
	
	public Map getFormMap() {
		return formMap;
	}

	public void setFormMap(Map formMap) {
		this.formMap = formMap;
	}

	public Long getMeldeid() {
		return meldeid;
	}
	public void setMeldeid(Long meldeid) {
		this.meldeid = meldeid;
	}
	
	public Long getMelderId() {
		return melderId;
	}
	public void setMelderId(Long melderId) {
		this.melderId = melderId;
	}

	public String getKladd() {
		return kladd;
	}
	public void setKladd(String kladd) {
		this.kladd = kladd;
	}
	public String getGodkjent() {
		return godkjent;
	}
	public void setGodkjent(String godkjent) {
		this.godkjent = godkjent;
	}
	
	public Date getDatoforhendelse() {
		if(datoforhendelse==null){
			DateFormat dateFormat = 
			            new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			try {
				String strDate = dateFormat.format(date);
				datoforhendelse =   dateFormat.parse(strDate);
			} catch (ParseException e) {
				System.out.println("date format problem: " + e.toString());
			}
		}
		return datoforhendelse;
	}
	
	public void setDatoforhendelse(Date datoforhendelse) {
		
		this.datoforhendelse = datoforhendelse;
	}
	
	public Time getKlokkesletthendelse() {
		if(klokkesletthendelse==null){
			DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Date date = new Date();
			try {
				Time time = Time.valueOf(dateFormat.format(date));
				System.out.print(time);
				klokkesletthendelse=time;
				
			} catch (Exception e) {
				System.out.println("date format problem: " + e.toString());
			}
		}
		return klokkesletthendelse;
	}
	public void setKlokkesletthendelse(Time klokkesletthendelse) {
		this.klokkesletthendelse = klokkesletthendelse;
	}
	public Date getDatooppdaget() {
		if(datooppdaget==null){
			DateFormat dateFormat = 
			            new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			try {
				String strDate = dateFormat.format(date);
				datooppdaget =   dateFormat.parse(strDate);
			} catch (ParseException e) {
				System.out.println("date format problem: " + e.toString());
			}
		}
		return datooppdaget;
	}
	public void setDatooppdaget(Date datooppdaget) {
		
		this.datooppdaget = datooppdaget;
	}
	public Date getDonasjonoverforing() {
		if(donasjonoverforing==null){
			DateFormat dateFormat = 
			            new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			try {
				String strDate = dateFormat.format(date);
				donasjonoverforing =   dateFormat.parse(strDate);
			} catch (ParseException e) {
				System.out.println("date format problem: " + e.toString());
			}
		}
		return donasjonoverforing;
	}
	public void setDonasjonoverforing(Date donasjonoverforing) {
		this.donasjonoverforing = donasjonoverforing;
	}
	public String getSjekklistesaksbehandling() {
		return sjekklistesaksbehandling;
	}
	public void setSjekklistesaksbehandling(
			String sjekklistesaksbehandling) {
		this.sjekklistesaksbehandling = sjekklistesaksbehandling;
	}
	public String getSupplerendeopplysninger() {
		return supplerendeopplysninger;
	}
	public void setSupplerendeopplysninger(String supplerendeopplysninger) {
		this.supplerendeopplysninger = supplerendeopplysninger;
	}
	
	public String getMeldingsnokkel() {
		if(meldingsnokkel == null){
			 Calendar cal = Calendar.getInstance();
			    cal.setTime(getMeldingsdato());
			int day =  cal.get(Calendar.DAY_OF_MONTH) ;
			int month= cal.get(Calendar.MONTH)+1;
			int year = cal.get(Calendar.YEAR);
			String date= Integer.toString(day);
			date = date + Integer.toString(month);
			date = date + Integer.toString(year);
			
			meldingsnokkel = "Hem" + getMeldeid() + date ;
		}
		return meldingsnokkel;
	}
	public Date getMeldingsdato() {
		if(meldingsdato==null){
			 SimpleDateFormat dateFormat = 
			            new SimpleDateFormat("yyyy/MM/dd");
		//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			try {
				String strDate = dateFormat.format(date);
				meldingsdato =   dateFormat.parse(strDate);
			} catch (ParseException e) {
				System.out.println("date format problem: " + e.toString());
			}
		}
		return meldingsdato;
	}
	
	public void setMeldingsnokkel(String meldingsnokkel) {
		this.meldingsnokkel = meldingsnokkel;
	}

	public void setMeldingsdato(Date meldingsdato) {
		
		this.meldingsdato = meldingsdato;
	}
	
	public void setMeldingTypes(){
		types = new int[] {Types.DATE,Types.TIME,Types.DATE,Types.DATE,Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.VARCHAR};
		utypes = new int[] {Types.DATE,Types.TIME,Types.DATE,Types.DATE,Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
	}
	public void setMeldingParams(){
		Long id = getMeldeid();
		if (id == null){
			params = new Object[]{getDatoforhendelse(),getKlokkesletthendelse(),getDatooppdaget(),getDonasjonoverforing(),getSjekklistesaksbehandling(),getSupplerendeopplysninger(),getMeldingsdato(),getKladd()};
		}else
			params = new Object[]{getDatoforhendelse(),getKlokkesletthendelse(),getDatooppdaget(),getDonasjonoverforing(),getSjekklistesaksbehandling(),getSupplerendeopplysninger(),getMeldingsdato(),getMeldingsnokkel(),getKladd(),getMeldeid()};
	}
	
	/**
	 * setMelderTypes
	 * Rutine for oppsett av types til oppdatering av melderId fremmednøkkel og godkjentflagg og flagg for kladd
	 */
	public void setMelderTypes(){
		types = new int[] {Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.INTEGER};
	}
	/**
	 * setMelderParams
	 * Rutine for oppsett av parametre til oppdatering av melderid fremmednøkkel
	 */
	public void setMelderParams(){
		params =  new Object[] {getGodkjent(),getKladd(),getMelderId(),getMeldeid()};
	}
	/**
	 * setVigilansmeldingfieldMaps
	 * Denne rutinen setter opp hvilke skjermbildefelter som hører til hvilke databasefelter
	 * @param userFields En liste over skjermbildefelter
	 */
	public void setVigilansmeldingfieldMaps(String[]userFields){
		keys = userFields;
		int size =userFields.length;
		for (int i = 0;i<size;i++){
			vigilansFields.put(userFields[i],null);
		}
	}
	
	/**
	 * saveField
	 * Denne rutinen lagrer skjermbildefelter til riktig databasefelt
	 * @param userField
	 * @param userValue
	 */
	public void saveField(String userField, String userValue) {
		if (vigilansFields.containsKey(userField) && userValue != null && !userValue.equals("")){
			vigilansFields.put(userField,userValue);	
	
		}
		
	}

	public void saveToVigilansmelding(){
		setDatoforhendelse(null);
		setKlokkesletthendelse(null);
		setDatooppdaget(null);
		setDonasjonoverforing(null);
		setMeldingsdato(null);
	}

	
}