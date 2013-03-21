package gof.services;

import gof.model.ElemStruct;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface ElemStructManager {
	
	Collection<ElemStruct> findAllElemStructs();

	ElemStruct findElemStruct(String code);
	
	void saveElemStruct(ElemStruct element);
	
	void deleteElemStruct(ElemStruct element);

}
