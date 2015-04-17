package no.naks.biovigilans.service;

import java.util.List;
import java.util.Map;

import no.naks.biovigilans.dao.SaksbehandlingDAO;
import no.naks.biovigilans.model.Vigilansmelding;

public class SaksbehandlingServiceImpl implements SaksbehandlingService {
	private SaksbehandlingDAO saksbehandlingDAO;
	
	
	public SaksbehandlingDAO getSaksbehandlingDAO() {
		return saksbehandlingDAO;
	}


	public void setSaksbehandlingDAO(SaksbehandlingDAO saksbehandlingDAO) {
		this.saksbehandlingDAO = saksbehandlingDAO;
	}


	@Override
	public List collectMessages() {
		
		return saksbehandlingDAO.collectMessages();
	}
	public List collectPasientMeldinger(List<Vigilansmelding>meldinger){
		
		return null;
	}
	public List collectGiverMeldinger(List<Vigilansmelding>meldinger){
		
		return null;
	}
	public Map collectAnnenMeldinger(List<Vigilansmelding>meldinger){
		Map andreMeldinger = saksbehandlingDAO.collectAnnenMeldinger(meldinger);
		return andreMeldinger;
	}
}
