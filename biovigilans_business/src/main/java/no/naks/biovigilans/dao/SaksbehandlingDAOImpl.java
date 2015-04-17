package no.naks.biovigilans.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;

import no.naks.biovigilans.model.Annenkomplikasjon;
import no.naks.biovigilans.model.Giverkomplikasjon;
import no.naks.biovigilans.model.Pasientkomplikasjon;
import no.naks.biovigilans.model.Vigilansmelding;
import no.naks.biovigilans.service.SaksbehandlingService;
import no.naks.rammeverk.kildelag.dao.AbstractAdmintablesDAO;

public class SaksbehandlingDAOImpl extends AbstractAdmintablesDAO implements
		SaksbehandlingDAO{

	private String[] vigilandsMeldingTableDefs;
	private String[] pasientMeldingTableDefs;
	private String[] giverMeldingTableDefs;
	private String[] annenMeldingTableDefs;
	
	private String selectvigilansMeldingSQL;
	private String selectpasientMeldingSQL;
	private String selectgiverMeldingSQL;
	private String selectannenMeldingSQL;
	
	
	private String selectannenKomplikasjonSQL;
	private String[] annenkomplikasjonTableDefs;
	private String selectpasientKomplikasjonSQL;
	private String[] pasientkomplikasjonTableDefs;
	private String selectgiverKomplikasjonSQL;
	private String[] giverkomplikasjonTableDefs;
	
	private VigilansSelect vigilansSelect;
	private AnnenmeldingSelect annenmeldingSelect;
	private AnnenkomplikasjonSelect andremeldingSelect = null;
	private PasientkomplikasjonSelect pasientmeldingSelect = null;
	private GiverkomplikasjonSelect givermeldingSelect = null;
	
	private String pasientKey = "pasientKomp"; // Nøkkel dersom melding er av type pasientkomplikasjon
	private String giverKey = "giverkomp"; 	// Nøkkel dersom melding er at type giverkomplikasjon
	private String andreKey = "annenKomp";
	private String delMeldingKey = null;
	
	
	public String getSelectannenKomplikasjonSQL() {
		return selectannenKomplikasjonSQL;
	}


	public void setSelectannenKomplikasjonSQL(String selectannenKomplikasjonSQL) {
		this.selectannenKomplikasjonSQL = selectannenKomplikasjonSQL;
	}


	public String[] getAnnenkomplikasjonTableDefs() {
		return annenkomplikasjonTableDefs;
	}


	public void setAnnenkomplikasjonTableDefs(String[] annenkomplikasjonTableDefs) {
		this.annenkomplikasjonTableDefs = annenkomplikasjonTableDefs;
	}


	public String getSelectpasientKomplikasjonSQL() {
		return selectpasientKomplikasjonSQL;
	}


	public void setSelectpasientKomplikasjonSQL(String selectpasientKomplikasjonSQL) {
		this.selectpasientKomplikasjonSQL = selectpasientKomplikasjonSQL;
	}


	public String[] getPasientkomplikasjonTableDefs() {
		return pasientkomplikasjonTableDefs;
	}


	public void setPasientkomplikasjonTableDefs(
			String[] pasientkomplikasjonTableDefs) {
		this.pasientkomplikasjonTableDefs = pasientkomplikasjonTableDefs;
	}


	public String getSelectgiverKomplikasjonSQL() {
		return selectgiverKomplikasjonSQL;
	}


	public void setSelectgiverKomplikasjonSQL(String selectgiverKomplikasjonSQL) {
		this.selectgiverKomplikasjonSQL = selectgiverKomplikasjonSQL;
	}


	public String[] getGiverkomplikasjonTableDefs() {
		return giverkomplikasjonTableDefs;
	}


	public void setGiverkomplikasjonTableDefs(String[] giverkomplikasjonTableDefs) {
		this.giverkomplikasjonTableDefs = giverkomplikasjonTableDefs;
	}


	public VigilansSelect getVigilansSelect() {
		return vigilansSelect;
	}


	public void setVigilansSelect(VigilansSelect vigilansSelect) {
		this.vigilansSelect = vigilansSelect;
	}


	public String[] getPasientMeldingTableDefs() {
		return pasientMeldingTableDefs;
	}


	public void setPasientMeldingTableDefs(String[] pasientMeldingTableDefs) {
		this.pasientMeldingTableDefs = pasientMeldingTableDefs;
	}


	public String[] getGiverMeldingTableDefs() {
		return giverMeldingTableDefs;
	}


	public void setGiverMeldingTableDefs(String[] giverMeldingTableDefs) {
		this.giverMeldingTableDefs = giverMeldingTableDefs;
	}


	public String[] getAnnenMeldingTableDefs() {
		return annenMeldingTableDefs;
	}


	public void setAnnenMeldingTableDefs(String[] annenMeldingTableDefs) {
		this.annenMeldingTableDefs = annenMeldingTableDefs;
	}


	public String getSelectpasientMeldingSQL() {
		return selectpasientMeldingSQL;
	}


	public void setSelectpasientMeldingSQL(String selectpasientMeldingSQL) {
		this.selectpasientMeldingSQL = selectpasientMeldingSQL;
	}


	public String getSelectgiverMeldingSQL() {
		return selectgiverMeldingSQL;
	}


	public void setSelectgiverMeldingSQL(String selectgiverMeldingSQL) {
		this.selectgiverMeldingSQL = selectgiverMeldingSQL;
	}


	public String getSelectannenMeldingSQL() {
		return selectannenMeldingSQL;
	}


	public void setSelectannenMeldingSQL(String selectannenMeldingSQL) {
		this.selectannenMeldingSQL = selectannenMeldingSQL;
	}


	public String[] getVigilandsMeldingTableDefs() {
		return vigilandsMeldingTableDefs;
	}


	public void setVigilandsMeldingTableDefs(String[] vigilandsMeldingTableDefs) {
		this.vigilandsMeldingTableDefs = vigilandsMeldingTableDefs;
	}


	public String getSelectvigilansMeldingSQL() {
		return selectvigilansMeldingSQL;
	}


	public void setSelectvigilansMeldingSQL(String selectvigilansMeldingSQL) {
		this.selectvigilansMeldingSQL = selectvigilansMeldingSQL;
	}


	@Override
	public List collectMessages() {
		vigilansSelect = new VigilansSelect(getDataSource(),selectvigilansMeldingSQL,vigilandsMeldingTableDefs);
		List meldinger = vigilansSelect.execute();
		return meldinger;
	}
	public List collectPasientMeldinger(List<Vigilansmelding>meldinger){
		
		return null;
	}
	public List collectGiverMeldinger(List<Vigilansmelding>meldinger){
		
		return null;
	}
	public Map collectAnnenMeldinger(List<Vigilansmelding>meldinger){
		long p1 = 0;
		List andreMeldinger = new ArrayList<Annenkomplikasjon>();
		List pasientMeldinger = new ArrayList<Pasientkomplikasjon>();
		List giverMeldinger = new ArrayList<Giverkomplikasjon>();
		Map alleMeldinger = new HashMap<String,List>();
		annenmeldingSelect = new AnnenmeldingSelect(getDataSource(),selectannenMeldingSQL,annenMeldingTableDefs);
		int type = Types.INTEGER;
		annenmeldingSelect.declareParameter(new SqlParameter(type));
		for (Vigilansmelding melding : meldinger){
			Long id = melding.getMeldeid();
			p1 = id.longValue();
			List delMelding = velgMeldinger(id,type);
			if (delMeldingKey.equals(andreKey) && delMelding != null && !delMelding.isEmpty()){
				andreMeldinger.add(delMelding.get(0));
			}
			if (delMeldingKey.equals(pasientKey) && delMelding != null && !delMelding.isEmpty()){
				pasientMeldinger.add(delMelding.get(0));
			}	
			if (delMeldingKey.equals(giverKey) && delMelding != null && !delMelding.isEmpty()){
				giverMeldinger.add(delMelding.get(0));
			}		
		}
		alleMeldinger.put(andreKey, andreMeldinger);
		alleMeldinger.put(pasientKey, pasientMeldinger);
		alleMeldinger.put(giverKey, giverMeldinger);
		return alleMeldinger;
	}
	/**
	 * velgMeldinger
	 * Denne rutinen henter en delmelding til en vigilansmelding basert på meldingsid.
	 * En delmelding er enten av type annenkomplikasjon,pasientkomplikasjon eller giverkomplikasjon
	 * @param mId  meldingsid
	 * @param nType
	 * @return
	 */
	private List velgMeldinger(Long mId,int nType){
		andremeldingSelect = new AnnenkomplikasjonSelect(getDataSource(),selectannenKomplikasjonSQL, annenkomplikasjonTableDefs);
		andremeldingSelect.declareParameter(new SqlParameter(nType));
		List<Vigilansmelding> delMeldinger = andremeldingSelect.execute(mId);
		delMeldingKey = andreKey;
		if (delMeldinger.isEmpty()){
			annenmeldingSelect = null;
			delMeldingKey = pasientKey;
			pasientmeldingSelect = new PasientkomplikasjonSelect(getDataSource(),selectpasientKomplikasjonSQL,pasientkomplikasjonTableDefs);
			pasientmeldingSelect.declareParameter(new SqlParameter(nType));
			delMeldinger = pasientmeldingSelect.execute(mId);
		}
		if (delMeldinger.isEmpty()){
			pasientmeldingSelect = null;
			delMeldingKey = giverKey;
			givermeldingSelect = new GiverkomplikasjonSelect(getDataSource(),selectgiverKomplikasjonSQL,giverkomplikasjonTableDefs);
			givermeldingSelect.declareParameter(new SqlParameter(nType));
			delMeldinger = givermeldingSelect.execute(mId);
		}
		return delMeldinger;
		
	}
}
