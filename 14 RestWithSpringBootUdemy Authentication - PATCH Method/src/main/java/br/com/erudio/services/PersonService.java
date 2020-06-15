package br.com.erudio.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}
	
	@Transactional
	public PersonVO disablePerson(Long id) {
		repository.disablePerson(id);
		var entity = DozerConverter.parseObject(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonVO.class);
		return entity;
	}

	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	public PersonVO findById(Long id) {
		var entity = DozerConverter.parseObject(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonVO.class);
		return entity;
	}

	public List<PersonVO> findAll() {
		System.out.println("aqui");
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

}
