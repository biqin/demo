import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setName("Tom");
        person.setAge(40);
        String jsonString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(person);
        Person deserializedPerson = mapper.readValue(jsonString, Person.class);
    }
}
