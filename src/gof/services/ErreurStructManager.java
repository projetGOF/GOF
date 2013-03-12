package gof.services;

import gof.model.ErreurStruct;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface ErreurStructManager {
	
	Collection<ErreurStruct> findAllErreursStruct();

	ErreurStruct findErreurStruct(int id);

	void saveErreurStruct(ErreurStruct es);

	void deleteErreurStruct(ErreurStruct es);

}
