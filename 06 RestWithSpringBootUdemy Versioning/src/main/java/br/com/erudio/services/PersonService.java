package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.converter.custom.PersonConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonConverter converter;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntityToView(repository.save(entity));
		return vo;
	}

	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	public PersonVO findById(String id) {
		var entity = DozerConverter.parseObject(repository.findById(Long.parseLong(id))
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonVO.class);
		return entity;
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

}
