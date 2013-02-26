package gof.dao;

import gof.model.UECat;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface UECatDao {

	Collection<UECat> findAllUECats();

	UECat findUECat(String code);

	void saveUECat(UECat ue);

	void deleteUECat(UECat ue);

}
