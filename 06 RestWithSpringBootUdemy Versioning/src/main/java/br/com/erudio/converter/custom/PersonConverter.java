package br.com.erudio.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v2.PersonVOV2;

@Service
public class PersonConverter {

	public PersonVOV2 convertEntityToView(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDate(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOV2 person) {
		Person vo = new Person();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
}
