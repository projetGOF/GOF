package gof.data;

import java.util.List;

import gof.data.XLP;

import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Personne;
import gof.model.UECat;
import gof.model.Diplome;

public interface Import {

	public List<Personne> getPersonnes();
	public List<UECat> getCatalogues();
	public List<Composante> getComposantes();
	public List<Domaine> getDomaines();
	public List<Diplome> getDiplomes();
	public List<XLP> getXLPS();
}