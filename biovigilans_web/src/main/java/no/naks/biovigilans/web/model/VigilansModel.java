package no.naks.biovigilans.web.model;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.Parameter;

/**
 * @author olj
 * Denne klassen er superklassen til alle modelklasser som representerer et skjermbilde (et brukergrensesnitt)
 *
 */
public class VigilansModel {

	private Map formMap; // Inneholder brukers input verdier fra skjermbildet
	private String[] formNames; // Inneholder navn på input felt i skjermbildet
	private String accountRef;
	
	

	
	public VigilansModel() {
		super();
		formMap = new HashMap<String,String>();
		// TODO Auto-generated constructor stub
	}


	/**
	 * setValues
	 * Denne rutinen setter alle verdier mottatt fra bruker.
	 * Verdier må lagres avhengig av hvilke knapper bruker har valgt
	 * @param entry
	 */
	public void setValues(Parameter entry){
		String name = entry.getName();
		String value = entry.getValue();
		boolean finnes = formMap.containsKey(name);
		formMap.put(name, value);
	
	}


	public Map getFormMap() {
		return formMap;
	}


	public void setFormMap(Map formMap) {
		this.formMap = formMap;
	}


	public String[] getFormNames() {
		return formNames;
	}


	public void setFormNames(String[] formNames) {
		this.formNames = formNames;
	}


	public String getAccountRef() {
		return accountRef;
	}


	public void setAccountRef(String accountRef) {
		this.accountRef = accountRef;
	}
	
	
}