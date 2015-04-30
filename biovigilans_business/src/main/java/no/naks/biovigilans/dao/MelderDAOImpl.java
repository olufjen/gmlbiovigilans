package no.naks.biovigilans.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;

import no.naks.biovigilans.model.Blodprodukt;
import no.naks.biovigilans.model.Donasjon;
import no.naks.biovigilans.model.Giverkomplikasjon;
import no.naks.biovigilans.model.Melder;
import no.naks.biovigilans.model.Pasient;
import no.naks.biovigilans.model.Pasientkomplikasjon;
import no.naks.biovigilans.model.Produktegenskap;
import no.naks.biovigilans.model.Transfusjon;
import no.naks.biovigilans.model.Vigilansmelding;
import no.naks.rammeverk.kildelag.dao.AbstractAdmintablesDAO;
import no.naks.rammeverk.kildelag.dao.TablesUpdateImpl;
import no.naks.rammeverk.kildelag.dao.Tablesupdate;

public class MelderDAOImpl extends AbstractAdmintablesDAO  implements MelderDAO {
	
	private String insertMelderSQL;
	private String updateMelderSQL;
	private String selectMeldingSQL;
	private String melderPrimaryKey;
	private String[] melderprimarykeyTableDefs;
	private String[] vigilandsMeldingTableDefs;
	private String selectvigilansMeldingSQL;
	private String selectannenKomplikasjonSQL;
	private String[] annenkomplikasjonTableDefs;
	private String selectpasientKomplikasjonSQL;
	private String[] pasientkomplikasjonTableDefs;
	private String selectgiverKomplikasjonSQL;
	private String[] giverkomplikasjonTableDefs;
	private String selectDonasjonSQL;
	private String[] donasjonTabledefs;
	private String selectgiverSQL;
	private String[] giverTableDefs;
	private String giveroppfolgingSQL;
	private String[] giveroppfolgingTableDefs;
	private String komplikasjonsdiagnosegiverSQL;
	private String[] komplikasjonsdiagnosegiverTableDefs;
	private String selecttransfusjonSQL;
	private String[] transfusjonTableDefs;
	private String selectPasientSQL;
	private String[] pasientTableDefs;
	private String selectSykdomSQL;
	private String[] sykdomTableDefs;
	private String komplikasjonSQL;
	private String[]komplikasjonTableDefs;
	private String annenkomplikasjonSQL;
	
	private String utredningSQL;
	private String[] utredningTableDefs;
	private String blodProduktSQL;
	private String[] blodproduktTableDefs;
	private String produktegenskapSQL;
	private String[] produktegenskapTableDefs;
	
		
	private String pasientKey = "pasientKomp"; // Nøkkel dersom melding er av type pasientkomplikasjon
	private String giverKey = "giverkomp"; 	// Nøkkel dersom melding er at type giverkomplikasjon
	private String andreKey = "annenKomp";
/*
 * Nøkler for giverkomplikasjoner	
 */
	private String donasjonKey = "donasjonen";
	private String giverenKey = "giver";
	private String giverOppfolgingKey = "giveroppfolging";
	private String giverkomplikasjondiagnoseKey = "giverkomplikasjondiagnose";
/*
 * Nøkler for pasientkomplikasjoner	
 */
	private String pasientenKey = "pasienten";
	private String transfusjonsKey = "transfusjon";
	private String sykdomKey = "sykdom";
	private String klassifikasjonKey = "komplikasjonklassifikasjon";
	private String utredningKey = "utredning";
	private String blodproduktKey = "blodprodukt";
	private String produktegenskapKey = "produktegenskap";
	
	private String delMeldingKey = null;
	
	private Tablesupdate tablesUpdate = null;
	private VigilansSelect vigilansSelect = null;
	private AnnenkomplikasjonSelect annenmeldingSelect = null;
	private PasientkomplikasjonSelect pasientmeldingSelect = null;
	private GiverkomplikasjonSelect givermeldingSelect = null;
	private DonasjonSelect donasjonSelect = null;
	private GiverSelect giverSelect = null;
	private GiveroppfolgingSelect giveroppfolgingSelect = null;
	private KomplikasjonsdiagnoseGiverSelect giverkomplikasjonSelect = null;
	private TransfusjonSelect transfusjonSelect = null;
	private PasientSelect pasientSelect = null;
	private SykdomSelect sykdomSelect = null;
	private KomplikasjonklassifikasjonSelect komplikasjonklassifikasjonSelect = null;
	private UtredningSelect utredningSelect = null;
	private BlodproduktSelect blodproduktSelect = null;
	private ProduktegenskapSelect produktegenskapSelect = null;
	
	private Map alleMeldinger = null;

	
	public String getUtredningSQL() {
		return utredningSQL;
	}
	public void setUtredningSQL(String utredningSQL) {
		this.utredningSQL = utredningSQL;
	}
	public String[] getUtredningTableDefs() {
		return utredningTableDefs;
	}
	public void setUtredningTableDefs(String[] utredningTableDefs) {
		this.utredningTableDefs = utredningTableDefs;
	}
	public String getBlodProduktSQL() {
		return blodProduktSQL;
	}
	public void setBlodProduktSQL(String blodProduktSQL) {
		this.blodProduktSQL = blodProduktSQL;
	}
	public String[] getBlodproduktTableDefs() {
		return blodproduktTableDefs;
	}
	public void setBlodproduktTableDefs(String[] blodproduktTableDefs) {
		this.blodproduktTableDefs = blodproduktTableDefs;
	}
	public String getProduktegenskapSQL() {
		return produktegenskapSQL;
	}
	public void setProduktegenskapSQL(String produktegenskapSQL) {
		this.produktegenskapSQL = produktegenskapSQL;
	}
	public String[] getProduktegenskapTableDefs() {
		return produktegenskapTableDefs;
	}
	public void setProduktegenskapTableDefs(String[] produktegenskapTableDefs) {
		this.produktegenskapTableDefs = produktegenskapTableDefs;
	}
	
	public String getAnnenkomplikasjonSQL() {
		return annenkomplikasjonSQL;
	}
	public void setAnnenkomplikasjonSQL(String annenkomplikasjonSQL) {
		this.annenkomplikasjonSQL = annenkomplikasjonSQL;
	}
	public String getKomplikasjonSQL() {
		return komplikasjonSQL;
	}
	public void setKomplikasjonSQL(String komplikasjonSQL) {
		this.komplikasjonSQL = komplikasjonSQL;
	}
	public String[] getKomplikasjonTableDefs() {
		return komplikasjonTableDefs;
	}
	public void setKomplikasjonTableDefs(String[] komplikasjonTableDefs) {
		this.komplikasjonTableDefs = komplikasjonTableDefs;
	}
	public String getSelecttransfusjonSQL() {
		return selecttransfusjonSQL;
	}
	public void setSelecttransfusjonSQL(String selecttransfusjonSQL) {
		this.selecttransfusjonSQL = selecttransfusjonSQL;
	}
	public String[] getTransfusjonTableDefs() {
		return transfusjonTableDefs;
	}
	public void setTransfusjonTableDefs(String[] transfusjonTableDefs) {
		this.transfusjonTableDefs = transfusjonTableDefs;
	}
	public String getSelectPasientSQL() {
		return selectPasientSQL;
	}
	public void setSelectPasientSQL(String selectPasientSQL) {
		this.selectPasientSQL = selectPasientSQL;
	}
	public String[] getPasientTableDefs() {
		return pasientTableDefs;
	}
	public void setPasientTableDefs(String[] pasientTableDefs) {
		this.pasientTableDefs = pasientTableDefs;
	}
	public String getSelectSykdomSQL() {
		return selectSykdomSQL;
	}
	public void setSelectSykdomSQL(String selectSykdomSQL) {
		this.selectSykdomSQL = selectSykdomSQL;
	}
	public String[] getSykdomTableDefs() {
		return sykdomTableDefs;
	}
	public void setSykdomTableDefs(String[] sykdomTableDefs) {
		this.sykdomTableDefs = sykdomTableDefs;
	}
	
	public String getGiveroppfolgingSQL() {
		return giveroppfolgingSQL;
	}
	public void setGiveroppfolgingSQL(String giveroppfolgingSQL) {
		this.giveroppfolgingSQL = giveroppfolgingSQL;
	}
	public String[] getGiveroppfolgingTableDefs() {
		return giveroppfolgingTableDefs;
	}
	public void setGiveroppfolgingTableDefs(String[] giveroppfolgingTableDefs) {
		this.giveroppfolgingTableDefs = giveroppfolgingTableDefs;
	}
	public String getKomplikasjonsdiagnosegiverSQL() {
		return komplikasjonsdiagnosegiverSQL;
	}
	public void setKomplikasjonsdiagnosegiverSQL(
			String komplikasjonsdiagnosegiverSQL) {
		this.komplikasjonsdiagnosegiverSQL = komplikasjonsdiagnosegiverSQL;
	}
	public String[] getKomplikasjonsdiagnosegiverTableDefs() {
		return komplikasjonsdiagnosegiverTableDefs;
	}
	public void setKomplikasjonsdiagnosegiverTableDefs(
			String[] komplikasjonsdiagnosegiverTableDefs) {
		this.komplikasjonsdiagnosegiverTableDefs = komplikasjonsdiagnosegiverTableDefs;
	}
	
	public String getSelectDonasjonSQL() {
		return selectDonasjonSQL;
	}
	public void setSelectDonasjonSQL(String selectDonasjonSQL) {
		this.selectDonasjonSQL = selectDonasjonSQL;
	}
	public String[] getDonasjonTabledefs() {
		return donasjonTabledefs;
	}
	public void setDonasjonTabledefs(String[] donasjonTabledefs) {
		this.donasjonTabledefs = donasjonTabledefs;
	}
	public String getSelectgiverSQL() {
		return selectgiverSQL;
	}
	public void setSelectgiverSQL(String selectgiverSQL) {
		this.selectgiverSQL = selectgiverSQL;
	}
	public String[] getGiverTableDefs() {
		return giverTableDefs;
	}
	public void setGiverTableDefs(String[] giverTableDefs) {
		this.giverTableDefs = giverTableDefs;
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
	public String[] getAnnenkomplikasjonTableDefs() {
		return annenkomplikasjonTableDefs;
	}
	public void setAnnenkomplikasjonTableDefs(String[] annenkomplikasjonTableDefs) {
		this.annenkomplikasjonTableDefs = annenkomplikasjonTableDefs;
	}
	public String getSelectannenKomplikasjonSQL() {
		return selectannenKomplikasjonSQL;
	}
	public void setSelectannenKomplikasjonSQL(String selectannenKomplikasjonSQL) {
		this.selectannenKomplikasjonSQL = selectannenKomplikasjonSQL;
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
	
	public String getInsertMelderSQL() {
		return insertMelderSQL;
	}
	public void setInsertMelderSQL(String insertMelderSQL) {
		this.insertMelderSQL = insertMelderSQL;
	}
	public String getMelderPrimaryKey() {
		return melderPrimaryKey;
	}
	public void setMelderPrimaryKey(String melderPrimaryKey) {
		this.melderPrimaryKey = melderPrimaryKey;
	}
	public String[] getMelderprimarykeyTableDefs() {
		return melderprimarykeyTableDefs;
	}
	public void setMelderprimarykeyTableDefs(String[] melderprimarykeyTableDefs) {
		this.melderprimarykeyTableDefs = melderprimarykeyTableDefs;
	}
	public Tablesupdate getTablesUpdate() {
		return tablesUpdate;
	}
	public void setTablesUpdate(Tablesupdate tablesUpdate) {
		this.tablesUpdate = tablesUpdate;
	}
	
	public String getUpdateMelderSQL() {
		return updateMelderSQL;
	}
	public void setUpdateMelderSQL(String updateMelderSQL) {
		this.updateMelderSQL = updateMelderSQL;
	}
	
	public String getSelectMeldingSQL() {
		return selectMeldingSQL;
	}
	public void setSelectMeldingSQL(String selectMeldingSQL) {
		this.selectMeldingSQL = selectMeldingSQL;
	}
	public void saveMelder(Melder melder){
		melder.setParams();
		int[] types= melder.getTypes();
		Object[] params = melder.getParams();
		String sql=insertMelderSQL;
		Long id = melder.getMelderId();
		if(id!=null){
			sql = updateMelderSQL;
			types = melder.getUtypes();
		}
		
		tablesUpdate = new TablesUpdateImpl(getDataSource(), sql, types);
		tablesUpdate.insert(params);
		
		if(id==null){
			melder.setMelderId(getPrimaryKey(melderPrimaryKey,melderprimarykeyTableDefs));
		}
		
	}
	
	public List<Map<String, Object>> selectMelder(String epost){
		String sql = selectMeldingSQL;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,epost);
		return rows;
	}
	/**
	 * selectMeldinger
	 * Denne rutinen henter alle meldinger til en melder basert på en meldingsnøkkel
	 * @param meldingsNokkel
	 * @return
	 */
	public Map<String,List> selectMeldinger (String meldingsNokkel){
		int type = Types.VARCHAR;
		alleMeldinger = new HashMap<String,List>();
		vigilansSelect = new VigilansSelect(getDataSource(),selectvigilansMeldingSQL,vigilandsMeldingTableDefs);
		vigilansSelect.declareParameter(new SqlParameter(type));
		List meldinger = vigilansSelect.execute(meldingsNokkel);
		alleMeldinger.put(meldingsNokkel, meldinger);
		if (!meldinger.isEmpty()){
			Vigilansmelding melding = (Vigilansmelding)meldinger.get(0);
			Long mId = melding.getMeldeid();
			int nType = Types.INTEGER;
			List delMelding = velgMeldinger(mId,nType);
			alleMeldinger.put(delMeldingKey, delMelding);
		}
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
		annenmeldingSelect = new AnnenkomplikasjonSelect(getDataSource(),selectannenKomplikasjonSQL, annenkomplikasjonTableDefs);
		annenmeldingSelect.declareParameter(new SqlParameter(nType));
		List<Vigilansmelding> delMeldinger = annenmeldingSelect.execute(mId);
		delMeldingKey = andreKey;
		if (delMeldinger.isEmpty()){
			annenmeldingSelect = null;
			delMeldingKey = pasientKey;
			pasientmeldingSelect = new PasientkomplikasjonSelect(getDataSource(),selectpasientKomplikasjonSQL,pasientkomplikasjonTableDefs);
			pasientmeldingSelect.declareParameter(new SqlParameter(nType));
			delMeldinger = pasientmeldingSelect.execute(mId);
			Pasientkomplikasjon pasientKomplikasjon  = null;
			if (delMeldinger != null && !delMeldinger.isEmpty()){
				pasientKomplikasjon = (Pasientkomplikasjon)delMeldinger.get(0);
				Long tId = pasientKomplikasjon.getTransfusjonsId();
				List transfusjoner = velgTransfusjon(tId, nType);
				alleMeldinger.put(transfusjonsKey, transfusjoner);
				Transfusjon transfusjon = null;
				if(transfusjoner != null && !transfusjoner.isEmpty()){
					transfusjon = (Transfusjon)transfusjoner.get(0);
					Long pId = transfusjon.getPasient_Id();
					List pasienter =  velgPasient(pId, nType);
					alleMeldinger.put(pasientenKey,pasienter);
					Pasient pasient = null;
					if(pasienter != null && !pasienter.isEmpty()){
						pasient = (Pasient)pasienter.get(0);
						List sykdommer = velgSykdom(pId, nType);
						alleMeldinger.put(sykdomKey,sykdommer);
					}
					List<Blodprodukt> blodprodukter = velgblodProdukter(tId, nType);
					alleMeldinger.put(blodproduktKey, blodprodukter);
					List utredninger = velgUtredning(mId, nType);
					alleMeldinger.put(utredningKey, utredninger);
					List produktEgenskaper = new ArrayList<Produktegenskap>();
					if (blodprodukter != null && !blodprodukter.isEmpty()){
						for (Blodprodukt blodProdukt :blodprodukter){
							Long bId = blodProdukt.getBlodProduktId();
							List egenskaper = velgproduktEgenskap(bId, nType);
							produktEgenskaper.addAll(egenskaper);
						}						
					}
				
					alleMeldinger.put(produktegenskapKey, produktEgenskaper);
				}
				List klassifikasjoner = velgKomplikasjonklassifikasjon(mId, nType,komplikasjonSQL);
				alleMeldinger.put(klassifikasjonKey,klassifikasjoner);
				
			}
		}
		if (delMeldinger.isEmpty()){
			pasientmeldingSelect = null;
			delMeldingKey = giverKey;
			givermeldingSelect = new GiverkomplikasjonSelect(getDataSource(),selectgiverKomplikasjonSQL,giverkomplikasjonTableDefs);
			givermeldingSelect.declareParameter(new SqlParameter(nType));
			delMeldinger = givermeldingSelect.execute(mId);
			Giverkomplikasjon komplikasjon = null;
			if (delMeldinger != null && !delMeldinger.isEmpty()){
				komplikasjon = (Giverkomplikasjon) delMeldinger.get(0);
				Long dId = komplikasjon.getDonasjonid();
				List donasjoner = velgDonasjon(dId,nType);
				alleMeldinger.put(donasjonKey,donasjoner);
				Donasjon donasjon = null;
				if (donasjoner != null && !donasjoner.isEmpty()){
					donasjon = (Donasjon)donasjoner.get(0);
					int gId = donasjon.getGiveId();
					Long giverId = new Long(gId);
					List givere = velgGiver(giverId,nType);
					alleMeldinger.put(giverenKey,givere);
				}
				List giveroppfolginger = velgGiveroppfolging(mId, nType);
				List komplikasjonsdiagnoser = velgkomplikasjonsdiagnoseGiver(mId, nType);
				alleMeldinger.put(giverOppfolgingKey, giveroppfolginger);
				alleMeldinger.put(giverkomplikasjondiagnoseKey, komplikasjonsdiagnoser);
				
				
			}
			
		}
		return delMeldinger;
		
	}
	/**
	 * velgdonasjon
	 * Denne rutinen henter donasjoner til en gitt giverkomplikasjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgDonasjon(Long dId, int nType){
		donasjonSelect = new DonasjonSelect(getDataSource(),selectDonasjonSQL,donasjonTabledefs);
		donasjonSelect.declareParameter(new SqlParameter(nType));
		List donasjoner = donasjonSelect.execute(dId);
		return donasjoner;
	}
	/**
	 * velgGiver
	 * Denne rutinen henter giver til en gitt donasjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgGiver(Long dId, int nType){
		giverSelect = new GiverSelect(getDataSource(),selectgiverSQL,giverTableDefs);
		giverSelect.declareParameter(new SqlParameter(nType));
		List givere = giverSelect.execute(dId);
		return givere;
	}
	/**
	 * velgGiveroppfolging
	 * Denne rutinen henter giveroppfolging til en gitt giverkomplikasjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgGiveroppfolging(Long dId, int nType){
		giveroppfolgingSelect = new GiveroppfolgingSelect(getDataSource(),giveroppfolgingSQL,giveroppfolgingTableDefs);
		giveroppfolgingSelect.declareParameter(new SqlParameter(nType));
		List giveoppfolginger = giveroppfolgingSelect.execute(dId);
		return giveoppfolginger;
	}
	/**
	 * velgkomplikasjonsdiagnoseGiver
	 * Denne rutinen henter komplikasjonsdiagnoser til en gitt giverkomplikasjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgkomplikasjonsdiagnoseGiver(Long dId, int nType){
		giverkomplikasjonSelect = new KomplikasjonsdiagnoseGiverSelect(getDataSource(),komplikasjonsdiagnosegiverSQL,komplikasjonsdiagnosegiverTableDefs);
		giverkomplikasjonSelect.declareParameter(new SqlParameter(nType));
		List komplikasjonsdiagnoser = giverkomplikasjonSelect.execute(dId);
		return komplikasjonsdiagnoser;
	}
	/**
	 * velgTransfusjon
	 * Denne rutinen henter transfusjon til en gitt pasientkomplikasjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgTransfusjon(Long dId, int nType){
		transfusjonSelect = new TransfusjonSelect(getDataSource(),selecttransfusjonSQL,transfusjonTableDefs);
		transfusjonSelect.declareParameter(new SqlParameter(nType));
		List transfusjoner = transfusjonSelect.execute(dId);
		return transfusjoner;
	}
	/**
	 * velgPasient
	 * Denne rutinen henter pasient til en gitt transfusjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgPasient(Long dId, int nType){
		pasientSelect = new PasientSelect(getDataSource(),selectPasientSQL,pasientTableDefs);
		pasientSelect.declareParameter(new SqlParameter(nType));
		List pasienter = pasientSelect.execute(dId);
		return pasienter;
	}
	/**
	 * velgSykdom
	 * Denne rutinen henter sykdommer til en gitt pasient
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgSykdom(Long dId, int nType){
		sykdomSelect = new SykdomSelect(getDataSource(),selectSykdomSQL,sykdomTableDefs);
		sykdomSelect.declareParameter(new SqlParameter(nType));
		List sykdommer = sykdomSelect.execute(dId);
		return sykdommer;
	}
	/**
	 * velgUtredning
	 * Denne rutinen henter utredninger til en gitt pasientkomplikasjon
	 * Denne tabellen inneholder årsaksdetaljer knyttet til klasifikasjonen
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgUtredning(Long dId, int nType){
		utredningSelect = new UtredningSelect(getDataSource(),utredningSQL,utredningTableDefs);
		utredningSelect.declareParameter(new SqlParameter(nType));
		List utredninger = utredningSelect.execute(dId);
		return utredninger;
	}
	/**
	 * velgblodProdukter
	 * Denne rutinen henter blodprodukter til en gitt transfusjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgblodProdukter(Long dId, int nType){
		blodproduktSelect = new BlodproduktSelect(getDataSource(),blodProduktSQL,blodproduktTableDefs);
		blodproduktSelect.declareParameter(new SqlParameter(nType));
		List blodprodukter = blodproduktSelect.execute(dId);
		return blodprodukter;
	}
	/**
	 * velgproduktEgenskap
	 * Denne rutinen henter produktegenskaper til et gitt blodprodukt
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgproduktEgenskap(Long dId, int nType){
		produktegenskapSelect = new ProduktegenskapSelect(getDataSource(),produktegenskapSQL,produktegenskapTableDefs);
		produktegenskapSelect.declareParameter(new SqlParameter(nType));
		List egenskaper = produktegenskapSelect.execute(dId);
		return egenskaper;
	}		
	/**
	 * velgKomplikasjonklassifikasjon
	 * Denne rutinen henter klassifikasjoner til en gitt pasientkomplikasjon eller annen komplikasjon
	 * @param dId
	 * @param nType
	 * @return
	 */
	private List velgKomplikasjonklassifikasjon(Long dId, int nType,String sql){
		komplikasjonklassifikasjonSelect = new KomplikasjonklassifikasjonSelect(getDataSource(),sql,komplikasjonTableDefs);
		komplikasjonklassifikasjonSelect.declareParameter(new SqlParameter(nType));
		List klassifikasjoner = komplikasjonklassifikasjonSelect.execute(dId);
		return klassifikasjoner;
	}
}	
