import java.util.HashMap;

/**
 * Problem description:
 * 
 * Design a collection that will hold objects of Person.
 * The collection should allow:
 * - adding new objects with unique id, and independently unique name
 * - fast lookup for known id or name
 * 
 */

public class CollectionWith2Identifiers {

	public static void main(String[] args) {
		SpecialCollection special = new SpecialCollection();
		
		// Valid values (will be included)
		special.add(new Person(1, "Felipe"));
		special.add(new Person(2, "Pereira"));
		
		// Should Not be included
		special.add(new Person(2, "Not included")); // same id
		special.add(new Person(5, "Felipe")); // same name
		
		special.printList();
	}
}

class SpecialCollection {
	private HashMap<Integer, Person> peopleById = new HashMap<>();
	private HashMap<String, Person> peopleByName = new HashMap<>();
	
	public void add(Person person) {
		boolean isNotInIdList = peopleById.get(person.getId()) == null;
		boolean isNotInNameList = peopleByName.get(person.getName()) == null;
		
		if (isNotInIdList && isNotInNameList) {
			peopleById.put(person.getId(), person);
			peopleByName.put(person.getName(), person);
		}
	}
	
	public Person getById(Integer id) {
		return peopleById.get(id);
	}
	
	public Person getByName(String name) {
		return peopleByName.get(name);
	}
	
	public void printList() {
		peopleById.forEach((key, value) -> System.out.println(value));
	}
}

class Person {
    private int id;
    private String name;
    
    public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
