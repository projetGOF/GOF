package gof.data;

import java.util.List;

import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Personne;
import gof.model.UECat;

public interface Import {

	public List<Personne> getPersonnes();
	public List<UECat> getCatalogues();
	public List<Composante> getComposantes();
	public List<Domaine> getDomaines();
}