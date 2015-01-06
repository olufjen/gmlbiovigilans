package no.naks.biovigilans.web.server.resource;

import no.naks.biovigilans.web.control.AnnenKomplikasjonWebService;
import no.naks.biovigilans.web.control.DonasjonWebService;
import no.naks.biovigilans.web.control.GiverWebService;
import no.naks.biovigilans.web.control.ICD10WebService;
import no.naks.biovigilans.web.control.HendelseWebService;
import no.naks.biovigilans.web.control.KomDiagnosegiverWebService;
import no.naks.biovigilans.web.control.MelderWebService;
import no.naks.biovigilans.web.control.SessionAdmin;
import no.naks.biovigilans.web.control.TableWebService;

import org.restlet.resource.ServerResource;

public class ProsedyreServerResource extends ServerResource {

	protected SessionAdmin sessionAdmin = null;
	protected TableWebService tablewebservice;
	protected HendelseWebService hendelseWebService; // OBS: Get/set heter innmeldingWebService !!!
	protected ICD10WebService icd10WebService;
	protected GiverWebService giverWebService; 
	protected DonasjonWebService donasjonWebService;
	protected MelderWebService melderWebService;
	protected KomDiagnosegiverWebService komDiagnosegiverWebService;
	protected AnnenKomplikasjonWebService annenKomplikasjonWebService;
	
	
	protected String[]sessionParams;
	
	
	public AnnenKomplikasjonWebService getAnnenKomplikasjonWebService() {
		return annenKomplikasjonWebService;
	}
	public void setAnnenKomplikasjonWebService(
			AnnenKomplikasjonWebService annenKomplikasjonWebService) {
		this.annenKomplikasjonWebService = annenKomplikasjonWebService;
	}
	public SessionAdmin getSessionAdmin() {
		return sessionAdmin;
	}
	public void setSessionAdmin(SessionAdmin sessionAdmin) {
		this.sessionAdmin = sessionAdmin;
	}
	public TableWebService getTablewebservice() {
		return tablewebservice;
	}
	public void setTablewebservice(TableWebService tablewebservice) {
		this.tablewebservice = tablewebservice;
	}
	public String[] getSessionParams() {
		return sessionParams;
	}
	public void setSessionParams(String[] sessionParams) {
		this.sessionParams = sessionParams;
	}
	public HendelseWebService getInnmeldingWebService() {
		return hendelseWebService;
	}
	public void setInnmeldingWebService(HendelseWebService hendelseWebService) {
		this.hendelseWebService = hendelseWebService;
	}
	public ICD10WebService getIcd10WebService() {
		return icd10WebService;
	}
	public void setIcd10WebService(ICD10WebService icd10WebService) {
		this.icd10WebService = icd10WebService;
	}
	public GiverWebService getGiverWebService() {
		return giverWebService;
	}
	public void setGiverWebService(GiverWebService giverWebService) {
		this.giverWebService = giverWebService;
	}
	public DonasjonWebService getDonasjonWebService() {
		return donasjonWebService;
	}
	public void setDonasjonWebService(DonasjonWebService donasjonWebService) {
		this.donasjonWebService = donasjonWebService;
	}
	public MelderWebService getMelderWebService() {
		return melderWebService;
	}
	public void setMelderWebService(MelderWebService melderWebService) {
		this.melderWebService = melderWebService;
	}
	public KomDiagnosegiverWebService getKomDiagnosegiverWebService() {
		return komDiagnosegiverWebService;
	}
	public void setKomDiagnosegiverWebService(
			KomDiagnosegiverWebService komDiagnosegiverWebService) {
		this.komDiagnosegiverWebService = komDiagnosegiverWebService;
	}
	
	

}
