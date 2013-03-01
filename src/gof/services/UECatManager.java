package gof.services;

import gof.model.UECat;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface UECatManager {
	
	Collection<UECat> findAllUECats();

	UECat findUECat(String code);

	void saveUECat(UECat ue);

	void deleteUECat(UECat ue);

}
