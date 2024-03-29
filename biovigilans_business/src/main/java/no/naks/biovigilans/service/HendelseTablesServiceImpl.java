package no.naks.biovigilans.service;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.SqlParameter;

import no.naks.biovigilans.dao.HendelsehemovigilansDAO;
import no.naks.biovigilans.model.Vigilansmelding;
import no.naks.rammeverk.kildelag.dao.TablesUpdateImpl;


/**
 * Denne klassen er en implementasjon av klassen HendelseTablesService og 
 * håndterer lagring/oppdatering av Vigilansmeldinger
 * Følgende tabeller blir berørt i db:
 * 		
 **/
public class HendelseTablesServiceImpl implements HendelseTablesService {
	
	private HendelsehemovigilansDAO hendelsehemovigilansDAO;

	public HendelsehemovigilansDAO getHendelsehemovigilansDAO() {
		return hendelsehemovigilansDAO;
	}

	public void setHendelsehemovigilansDAO(
			HendelsehemovigilansDAO hendelsehemovigilansDAO) {
		this.hendelsehemovigilansDAO = hendelsehemovigilansDAO;
	}

	public void saveVigilansmelding(Vigilansmelding melding){
		hendelsehemovigilansDAO.updateVigilansMelding(melding);
	}

	public List<Vigilansmelding> collectMeldinger(Long melderId){
		return hendelsehemovigilansDAO.collectMeldinger(melderId);
		
	}
	
	

}