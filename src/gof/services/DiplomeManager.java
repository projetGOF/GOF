package gof.services;

import java.util.Collection;
import gof.model.*;

import org.springframework.stereotype.Service;

@Service
public interface DiplomeManager {

	Collection<Diplome> findAllDiplomes();

	Diplome findDiplome(String code);

	void saveDiplome(Diplome d);

	void deleteDiplome(Diplome d);
}