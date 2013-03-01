package gof.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import gof.model.Composante;

public class ComposanteAdapter extends XmlAdapter<String, Composante>{

	private Map<String, Composante> composantes = new HashMap<String, Composante>();

	public ComposanteAdapter(){
		
	}
	
	public ComposanteAdapter(List<Composante> lcomposantes){
		for(int i=0; i<lcomposantes.size(); i++)
			composantes.put(lcomposantes.get(i).getCode(), lcomposantes.get(i));
	}
	
	@Override
	public String marshal(Composante composante) throws Exception {
		System.out.println("marshal ComposanteAdapter: "+composante.getCode());
		return composante.getCode();
	}

	@Override
	public Composante unmarshal(String code) throws Exception {
		System.out.println("unmarshal ComposanteAdapter: "+code+" "+composantes.get("ALL"));
		return composantes.get(code);
	}
}