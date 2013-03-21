package gof.dao;

import gof.model.ElemStruct;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface ElemStructDao {
	
	Collection<ElemStruct> findAllElemStructs();

	ElemStruct findElemStruct(String code);
	
	void saveElemStruct(ElemStruct element);
	
	void deleteElemStruct(ElemStruct element);

}
