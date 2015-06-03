package ro.esolutions.demo.interfaces_default_methods;

import java.util.List;

/**
 * Created by Bogdan Stoean on 29.05.2015.
 */
public interface PersonService {

	/**
	 * Add person to persistence.
	 * @param person - person to be added.
	 */
	void addPerson(Person person);

	/**
	 * Delete person from persistence.
	 * @param person - person to be deleted
	 */
	void deletePerson(Person person);

	/**
	 * Returns the number of persons.
	 */
	int count();

	/**
	 * List all existing persons into persistence.
	 */
	List<Person> list();

	/**
	 * Get a specific person by index.
	 * @param index - index
	 */
	Person getPerson(int index);

	/**
	 * Get person full name. Default implementation.
	 * @param person - person entity.
	 */
	default String getPersonName(Person person) {
		return person.getFirstName() + " " + person.getLastName();
	}

	/**
	 * Get to lower case of a person's full name. We consider in this demo that a persons full name is unique.
	 * @param person - person entity.
	 */
	default String toLowerCasePersonName(Person person) {
		return getPersonName(person).toLowerCase().trim();
	}
}
