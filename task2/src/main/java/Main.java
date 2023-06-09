import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<Person> persons = getPersons();

        long underageCount = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();

        List<String> conscriptNames = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        List<Person> educatedWorkers = persons.stream()
                .filter(Main::isEducatedWorker)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        System.out.println(underageCount);
        System.out.println(conscriptNames.stream().limit(40).toList());
        System.out.println(educatedWorkers.stream().limit(40).toList());
    }

    private static Collection<Person> getPersons() {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        return persons;
    }

    private static boolean isEducatedWorker(Person person) {
        if (person.getEducation() != Education.HIGHER) {
            return false;
        }

        if (person.getSex() == Sex.MAN) {
            return person.getAge() >= 18 && person.getAge() <= 65;
        } else {
            return person.getAge() >= 18 && person.getAge() <= 60;
        }
    }
}