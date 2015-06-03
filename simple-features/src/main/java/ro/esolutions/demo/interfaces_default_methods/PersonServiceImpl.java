package ro.esolutions.demo.interfaces_default_methods;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan Stoean on 29.05.2015.
 *
 * PersonService implementation.
 */
public class PersonServiceImpl implements PersonService {

	final Logger logger = Logger.getLogger(PersonServiceImpl.class);
	private List<Person> persons = new ArrayList<>();


	@Override
	public void addPerson(Person person) {
		persons.add(person);
		logger.info("Added person: " + getPersonName(person));
	}

	@Override
	public void deletePerson(Person person) {
		String toLowerPersonName = toLowerCasePersonName(person);
		Person personToBeRemoved = null;

		for (Person p : persons) {
			if (toLowerPersonName.equals(toLowerCasePersonName(p))) {
				personToBeRemoved = p;
			}
		}
		if (personToBeRemoved != null) {
			persons.remove(personToBeRemoved);
		}
	}

	@Override
	public int count() {
		return persons.size();
	}

	@Override
	public List<Person> list() {
		return persons;
	}

	@Override
	public Person getPerson(int index) {
		if (index < count() && index >= 0) {
			return persons.get(index);
		}
		return null;
	}
}
