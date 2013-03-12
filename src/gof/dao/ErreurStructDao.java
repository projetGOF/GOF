package gof.dao;

import gof.model.ErreurStruct;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface ErreurStructDao {
	
	Collection<ErreurStruct> findAllErreursStruct();

	ErreurStruct findErreurStruct(int id);

	void saveErreurStruct(ErreurStruct es);

	void deleteErreurStruct(ErreurStruct es);

}
