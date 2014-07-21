package no.naks.biovigilans.model;

import java.sql.Types;
import java.util.HashMap;

public class UtredningImpl extends AbstractUtredning implements Utredning {

	public UtredningImpl() {
		super();
		types = new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		utypes = new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		utredningsFields = new HashMap();
	}
	
	public void setParams(){
		Long id = getUtredningId();
		if (id == null){
			params = new Object[]{};
		}else
			params = new Object[]{getUtredningId()};
		
	}	
	/**
	 * setutredningfieldMaps
	 * Denne rutinen setter opp hvilke skjermbildefelter som hører til hvilke databasefelter
	 * @param userFields En liste over skjermbildefelter
	 */
	public void setutredningfieldMaps(String[]userFields){
		keys = userFields;
		
		utredningsFields.put(userFields[0],getHemolyseparameter());
	}
}
