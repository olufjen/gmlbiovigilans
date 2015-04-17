package no.naks.biovigilans.service;

import java.util.List;
import java.util.Map;

import no.naks.biovigilans.dao.SaksbehandlingDAO;
import no.naks.biovigilans.model.Vigilansmelding;

public interface SaksbehandlingService {
	
	public SaksbehandlingDAO getSaksbehandlingDAO();


	public void setSaksbehandlingDAO(SaksbehandlingDAO saksbehandlingDAO);

	public List collectMessages();
	public List collectPasientMeldinger(List<Vigilansmelding>meldinger);
	public List collectGiverMeldinger(List<Vigilansmelding>meldinger);
	public Map collectAnnenMeldinger(List<Vigilansmelding>meldinger);
}
