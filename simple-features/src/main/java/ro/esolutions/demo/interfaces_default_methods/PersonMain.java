package ro.esolutions.demo.interfaces_default_methods;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Bogdan Stoean on 29.05.2015.
 * Main class used for testing.
 */
public class PersonMain {

	public static void main(String[] args) {

		final Logger logger = Logger.getLogger(PersonMain.class);


		Person person0 = new Person("Gigi0", "Patratel", 21);
		Person person1 = new Person("Gigi1", "Patratel", 26);
		Person person2 = new Person("Gigi2", "Patratel", 22);
		Person person3 = new Person("Gigi3", "Patratel", 25);
		Person person4 = new Person("Gigi4", "Patratel", 20);
		PersonService personService = new PersonServiceImpl();
		logger.info("Adding persons ...");
		personService.addPerson(person1);
		personService.addPerson(person0);
		personService.addPerson(person2);
		personService.addPerson(person3);
		personService.addPerson(person4);

		logger.info("Counting persons ...");
		logger.info("We have stored: " + personService.count() + " persons");

		Person personToBeRemoved = new Person("Gigi1", "Patratel", 26);
		logger.info("Deleting persons ...");
		personService.deletePerson(personToBeRemoved);


		logger.info("Counting persons ...");
		logger.info("We have stored: " + personService.count() + " persons");

		if (personService.count() > 0) {
			Person person = personService.getPerson(0);
			logger.info("Our first person is: " + personService.getPersonName(person));
		}

		List<Person> persons = personService.list();
		logger.info("Listing all persons ...");
		for (Person person : persons) {
			logger.info(personService.getPersonName(person));
		}
	}
}
