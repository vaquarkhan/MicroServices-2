
package com.person.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.person.dto.OrganizationDTO;
import com.person.entity.Person;
import com.person.mapper.PersonMapper;
import com.person.model.PersonResponseModel;
import com.person.repository.PersonRepository;

/**
 * @author chandresh.mishra
 *
 */
@Service
public class PersonService {

	
	@Autowired
	private OrganizationServiceData organizationServiceData;
	
	@Autowired
	private PersonServiceData personServiceData;
	
	@Autowired
	private PersonMapper personMapper;
	
	//BO to Entity should be used but BO is not used just for simplification.
	public void savePerson(Person person)
	{
		personServiceData.savePerson(person);
	}
	
	//It should return a business object in place of model. Model used just for simplification.
	//Hystrix command works on separate class files. As it works on Spring AOP
	public PersonResponseModel getPerson(String nino,int id)
	{
		//person data from database
		Person person=personServiceData.fetchPerson(nino);
		PersonResponseModel personResponseModel=personMapper.personToPersonResponse(person);
		
		//Get org data from extenal resource
		OrganizationDTO organizationDTO=organizationServiceData.getOrganizationData(id);
		
		personResponseModel.setEmployerName(organizationDTO.getOrganizationName());
		personResponseModel.setLocation(organizationDTO.getLocation());
		return personResponseModel;
		
	}
	
	
	

}