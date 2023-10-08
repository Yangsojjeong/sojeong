public class PhoneBook {
    private Person[] people;
    private int size;

    public PhoneBook(int capacity) {
        people = new Person[capacity];
        size = 0;
    }

    public void addPerson(String name, String phoneNumber) {
        if (size < people.length) {
            people[size] = new Person(name, phoneNumber);
            size++;
        } else {
            System.out.println("Phone book is full. Cannot add more entries.");
        }
    }

    public String findPhoneNumber(String name) {
        for (int i = 0; i < size; i++) {
            if (people[i].getName().equals(name)) {
                return people[i].getPhoneNumber();
            }
        }
        return "Phone number not found for " + name;
    }
}
