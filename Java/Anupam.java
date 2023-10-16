import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        try {
            Person person = new Person("Alice", 30);

            // Serialization
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"));
            out.writeObject(person);
            out.close();

            // Deserialization
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"));
            Person deserializedPerson = (Person) in.readObject();
            in.close();

            deserializedPerson.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
