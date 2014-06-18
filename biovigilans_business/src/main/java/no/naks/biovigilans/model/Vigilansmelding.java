package no.naks.biovigilans.model;

import java.util.Date;

public interface Vigilansmelding {

	public long getMeldeid();
	public void setMeldeid(long meldeid);
	public Date getDatoforhendelse();
	public void setDatoforhendelse(Date datoforhendelse);
	public java.lang.String getKlokkesletthendelse();
	public void setKlokkesletthendelse(java.lang.String klokkesletthendelse);
	public Date getDatooppdaget();
	public void setDatooppdaget(Date datooppdaget);
	public java.lang.String getDonasjonoverforing();
	public void setDonasjonoverforing(java.lang.String donasjonoverforing);
	public java.lang.String getSjekklistesaksbehandling();
	public void setSjekklistesaksbehandling(
			java.lang.String sjekklistesaksbehandling);
	public java.lang.String getSupplerendeopplysninger();
	public void setSupplerendeopplysninger(java.lang.String supplerendeopplysninger);
	public Date getMeldingsdato();
	public void setMeldingsdato(Date meldingsdato);
}