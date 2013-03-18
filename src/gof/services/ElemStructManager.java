package gof.services;

import gof.model.ElemStruct;

import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface ElemStructManager {
	
	Collection<ElemStruct> findAllElemStructs();

	ElemStruct findElemStruct(String code);
	
	Set<ElemStruct> getElemStructTree(String code);
}
