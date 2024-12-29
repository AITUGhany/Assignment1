package Assignment;
import java.util.ArrayList;

public class School {
    private ArrayList<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person p : members) {
            result.append(p.toString()).append("\n");
        }
        return result.toString();
    }
}
//.