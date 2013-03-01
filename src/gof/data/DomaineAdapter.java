package gof.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import gof.model.Domaine;

public class DomaineAdapter extends XmlAdapter<String, Domaine>{

	private Map<String, Domaine> domaines = new HashMap<String, Domaine>();

	public DomaineAdapter(){
		
	}
	
	public DomaineAdapter(List<Domaine> ldomaines){
		for(int i=0; i<ldomaines.size(); i++)
			domaines.put(ldomaines.get(i).getCode(), ldomaines.get(i));
	}
	
	@Override
	public String marshal(Domaine domaine) throws Exception {
		return domaine.getCode();
	}

	@Override
	public Domaine unmarshal(String code) throws Exception {
		System.out.println("unmarshal DomaineAdapter: "+code);
		return domaines.get(code);
	}
}