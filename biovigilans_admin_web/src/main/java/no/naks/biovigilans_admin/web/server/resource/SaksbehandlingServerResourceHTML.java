package no.naks.biovigilans_admin.web.server.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.naks.biovigilans.model.Annenkomplikasjon;
import no.naks.biovigilans.model.Giverkomplikasjon;
import no.naks.biovigilans.model.Pasientkomplikasjon;
import no.naks.biovigilans.model.Vigilansmelding;

import org.restlet.Request;
import org.restlet.data.Form;
import org.restlet.data.LocalReference;
import org.restlet.data.MediaType;
import org.restlet.data.Parameter;
import org.restlet.data.Reference;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import freemarker.template.SimpleScalar;
import no.naks.biovigilans.felles.server.resource.SessionServerResource;
import no.naks.biovigilans_admin.web.control.SaksbehandlingWebService;

public class SaksbehandlingServerResourceHTML extends SessionServerResource {

	private String meldeKey = "meldinger";
	protected SaksbehandlingWebService saksbehandlingWebservice;

	public SaksbehandlingWebService getSaksbehandlingWebservice() {
		return saksbehandlingWebservice;
	}

	public void setSaksbehandlingWebservice(
			SaksbehandlingWebService saksbehandlingWebservice) {
		this.saksbehandlingWebservice = saksbehandlingWebservice;
	}

	@Get
	public Representation getHemovigilans() {


	    Reference reference = new Reference(getReference(),"..").getTargetRef();
	
	    Request request = getRequest();
	
	    List<Vigilansmelding> meldinger = saksbehandlingWebservice.collectMessages();
	
	    for (Vigilansmelding melding: meldinger){
	    	if (melding.getSjekklistesaksbehandling() == null){
	    		melding.setSjekklistesaksbehandling("Levert");
	    	}
	    }
	    Map andreMeldinger = saksbehandlingWebservice.collectAnnenMeldinger(meldinger);
	    List<Annenkomplikasjon> annenListe =(List) andreMeldinger.get(andreKey);
	    List<Pasientkomplikasjon> pasientListe = (List) andreMeldinger.get(pasientKey);
	    List<Giverkomplikasjon> giverListe = (List)  andreMeldinger.get(giverKey);
	    for (Vigilansmelding melding: meldinger){
	    	melding.setSupplerendeopplysninger("Ukjent");
	    	for (Annenkomplikasjon annenKomplikasjon : annenListe){
	    		if (melding.getMeldeid().longValue() == annenKomplikasjon.getMeldeid().longValue()){
	    			melding.setSupplerendeopplysninger("Annen hendelse");
	    		}
	    	}
	    	for (Pasientkomplikasjon pasientKomplikasjon : pasientListe){
	    		if (melding.getMeldeid().longValue() == pasientKomplikasjon.getMeldeid().longValue()){
	    			melding.setSupplerendeopplysninger("Pasientkomplikasjon");
	    		}
	    	}
	    	for (Giverkomplikasjon giverKomplikasjon : giverListe){
	    		if (melding.getMeldeid().longValue() == giverKomplikasjon.getMeldeid().longValue()){
	    			melding.setSupplerendeopplysninger("Giverkomplikasjon");
	    		}
	    	}
	    }	    
/*
 * En Hashmap benyttes dersom en html side henter data fra flere javaklasser.	
 * Hver javaklasse får en id (ex pasientkomplikasjonId) som er tilgjengelig for html
 *      
*/	     
	     Map<String, Object> dataModel = new HashMap<String, Object>();
		 sessionAdmin.setSessionObject(getRequest(), meldinger, meldingsId);
	     dataModel.put(meldeKey,meldinger);
	     LocalReference pakke = LocalReference.createClapReference(LocalReference.CLAP_CLASS,
                 "/hemovigilans");
	    
	     LocalReference localUri = new LocalReference(reference);
	
// Denne client resource forholder seg til src/main/resource katalogen !!!	
	     ClientResource clres2 = new ClientResource(LocalReference.createClapReference(LocalReference.CLAP_CLASS,"/hemovigilans/saksbehandling.html"));
	     
	        // Load the FreeMarker template
	        Representation pasientkomplikasjonFtl = clres2.get();

	        TemplateRepresentation  templatemapRep = new TemplateRepresentation(pasientkomplikasjonFtl,dataModel,
	                MediaType.TEXT_HTML);
		 return templatemapRep;
	 }
	
	  /**
     * storeHemovigilans
     * Denne rutinen tar imot meldingsnøkkel fra bruker og henter frem meidngsinformasjon basert på 
     * oppgitt meldingsnøkkel
     * @param form
     * @return
     */
    @Post
    public Representation storeHemovigilans(Form form) {
        Map<String, Object> dataModel = new HashMap<String, Object>();
        Reference reference = new Reference(getReference(),"..").getTargetRef();
  	  List<Vigilansmelding> meldinger = (List)sessionAdmin.getSessionObject(getRequest(), meldingsId);
  	  dataModel.put(meldeKey,meldinger);
  	  String meldingsNokkel = null;
    	if (form != null){
    		for (Parameter entry : form) {
    			if (entry.getValue() != null && !(entry.getValue().equals(""))){
    					System.out.println(entry.getName() + "=" + entry.getValue());
    					meldingsNokkel = entry.getValue();
    			}
    		}
    	}
    	Map<String,List> meldingDetaljene = null;
    	if (meldingsNokkel != null){
    		 meldingDetaljene = (Map<String,List>)saksbehandlingWebservice.selectMeldinger(meldingsNokkel);
    	}
    	 List<Annenkomplikasjon> annenListe = null;
    	 List<Pasientkomplikasjon> pasientListe = null;
    	 List<Giverkomplikasjon> giverListe = null;
    	 List<Vigilansmelding> meldingen = null;
    	 Vigilansmelding melding = null;
    	 Annenkomplikasjon annenKomplikasjon = null;
    	 Giverkomplikasjon giverKomplikasjon = null;
    	 Pasientkomplikasjon pasientKomplikasjon = null;
    	if (meldingDetaljene != null){
    		meldingen = (List) meldingDetaljene.get(meldingsNokkel);
    	    annenListe = (List) meldingDetaljene.get(andreKey);
    	    pasientListe = (List) meldingDetaljene.get(pasientKey);
    	    giverListe = (List)  meldingDetaljene.get(giverKey);
    	    if (meldingen != null){
    	    	melding = meldingen.get(0);
    	    }
    	    if (annenListe != null){
    	    	annenKomplikasjon = annenListe.get(0);
    	    }
    	    if (pasientListe != null){
    	    	pasientKomplikasjon = pasientListe.get(0);
    	    }
    	    if (giverListe != null){
    	    	giverKomplikasjon = giverListe.get(0);
    	    }
    	}
		  String page =  "../hemovigilans/rapporter_andrehendelser.html";
//  			  setAndreHendelser(); // Setter opp andreHendelser session objekter
			    // setTransfusjonsObjects(); 
//  			  annenModel.setFormNames(sessionParams);
//  		      sessionAdmin.setSessionObject(getRequest(), annenModel,andreHendelseId);
		  if (annenKomplikasjon != null && melding != null){
			     setAndreHendelser(); // Setter opp andreHendelser session objekter
				    // setTransfusjonsObjects(); 
			     Vigilansmelding minmelding = (Vigilansmelding) annenKomplikasjon;
			     minmelding.setMeldingsnokkel(melding.getMeldingsnokkel());
			     minmelding.setMeldingsdato(melding.getMeldingsdato());
			     minmelding.setDatoforhendelse(melding.getDatoforhendelse());
			     minmelding.setDatooppdaget(melding.getDatooppdaget());
			     minmelding.setKladd(melding.getKladd());
				 annenModel.setFormNames(sessionParams);
				 annenModel.distributeTerms();
				 annenModel.setAnnenKomplikasjon(annenKomplikasjon); 
				 annenModel.setVigilansmelding(melding);
			   	 annenModel.setHendelseDato(melding.getMeldingsdato());
		    	 annenModel.setMeldingsNokkel(melding.getMeldingsnokkel());
		    	 SimpleScalar hendelseDate = new SimpleScalar(datePart);
		    	 dataModel.put(displaydateKey, hendelseDate);
				 dataModel.put(andreHendelseId, annenModel);
				 dataModel.put(annenHendelseId, annenKomplikasjon);
				 sessionAdmin.setSessionObject(getRequest(), annenModel,andreHendelseId);	
			  
 			  
		 	
				 redirectPermanent(page);
	    	
			  
		  }

    	
    	
    	
    	
    	
    	
	     LocalReference pakke = LocalReference.createClapReference(LocalReference.CLAP_CLASS,
              "/hemovigilans");
	    
	     LocalReference localUri = new LocalReference(reference);
	
//Denne client resource forholder seg til src/main/resource katalogen !!!	
	     ClientResource clres2 = new ClientResource(LocalReference.createClapReference(LocalReference.CLAP_CLASS,"/hemovigilans/saksbehandling.html"));
	     
	        // Load the FreeMarker template
	        Representation pasientkomplikasjonFtl = clres2.get();

	        TemplateRepresentation  templatemapRep = new TemplateRepresentation(pasientkomplikasjonFtl,dataModel,
	                MediaType.TEXT_HTML);
		 return templatemapRep;
    
    }

}
