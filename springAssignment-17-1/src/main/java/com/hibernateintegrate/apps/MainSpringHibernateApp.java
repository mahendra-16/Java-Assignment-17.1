package com.hibernateintegrate.apps;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpringHibernateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********************************************************************Beginning Program***********************************************************************************");
		
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		
		PersonService personService = (PersonService) con.getBean("personService");
		
		Person person = new Person();
		person.setId(1);
		person.setName("Mahendra");
		person.setEmail("mahendra@gmail.com");
		personService.addPerson(person);
		System.out.println("Person : " + person + " added Succesfully");
		
		System.out.println("The list of all Person : " + person);
		
		/*
		List<Person> persons = personService.fetchAllPersons();
			for(Person p : persons){
				System.out.println("The list of all person : " + " id = " + p.getId() + " ; name = " + p.getName() + " ; email = " + p.getEmail());
				break;
			}
		*/System.out.println("****************************************************************************The End*******************************************************************************************************");
	}

}
