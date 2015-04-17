package no.naks.biovigilans.dao;

import java.util.List;
import java.util.Map;

import no.naks.biovigilans.model.Vigilansmelding;

public interface SaksbehandlingDAO {

	public List collectMessages();
	
	public String[] getVigilandsMeldingTableDefs();


	public void setVigilandsMeldingTableDefs(String[] vigilandsMeldingTableDefs);


	public String getSelectvigilansMeldingSQL();


	public void setSelectvigilansMeldingSQL(String selectvigilansMeldingSQL);
	public List collectPasientMeldinger(List<Vigilansmelding>meldinger);
	public List collectGiverMeldinger(List<Vigilansmelding>meldinger);
	public Map collectAnnenMeldinger(List<Vigilansmelding>meldinger);
	
	public String[] getPasientMeldingTableDefs();


	public void setPasientMeldingTableDefs(String[] pasientMeldingTableDefs);


	public String[] getGiverMeldingTableDefs();


	public void setGiverMeldingTableDefs(String[] giverMeldingTableDefs);


	public String[] getAnnenMeldingTableDefs();


	public void setAnnenMeldingTableDefs(String[] annenMeldingTableDefs);


	public String getSelectpasientMeldingSQL();


	public void setSelectpasientMeldingSQL(String selectpasientMeldingSQL);


	public String getSelectgiverMeldingSQL();


	public void setSelectgiverMeldingSQL(String selectgiverMeldingSQL);


	public String getSelectannenMeldingSQL();


	public void setSelectannenMeldingSQL(String selectannenMeldingSQL);

	
	public String getSelectannenKomplikasjonSQL();


	public void setSelectannenKomplikasjonSQL(String selectannenKomplikasjonSQL);


	public String[] getAnnenkomplikasjonTableDefs();


	public void setAnnenkomplikasjonTableDefs(String[] annenkomplikasjonTableDefs);


	public String getSelectpasientKomplikasjonSQL();


	public void setSelectpasientKomplikasjonSQL(String selectpasientKomplikasjonSQL);


	public String[] getPasientkomplikasjonTableDefs();


	public void setPasientkomplikasjonTableDefs(
			String[] pasientkomplikasjonTableDefs);


	public String getSelectgiverKomplikasjonSQL();


	public void setSelectgiverKomplikasjonSQL(String selectgiverKomplikasjonSQL);


	public String[] getGiverkomplikasjonTableDefs();


	public void setGiverkomplikasjonTableDefs(String[] giverkomplikasjonTableDefs);


	public VigilansSelect getVigilansSelect();


	public void setVigilansSelect(VigilansSelect vigilansSelect);



}
