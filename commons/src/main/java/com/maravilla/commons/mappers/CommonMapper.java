package com.maravilla.commons.mappers;


public abstract class CommonMapper <RQ, RS, E>{

	protected abstract RS entityToResponse(E entity);
	
	protected abstract E requestToEntity(RQ request);

}
