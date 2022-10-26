import com.flcd.dsa.HashNode;
import com.flcd.dsa.HashTable;

public class Main {
    public static void main(String[] args) {

        HashTable<String, Integer> identifiersTable = new HashTable<>(20);

        identifiersTable.addNode("a", 0);
        identifiersTable.addNode("b", 1);
        identifiersTable.addNode("a14", 2);
        identifiersTable.addNode("fds", 3);
        identifiersTable.addNode("fd76", 4);

        System.out.println("\nIdentifiers table");
        System.out.println(identifiersTable);
        System.out.println("\nConstants table");
        HashTable<String, String> constantsTable = new HashTable<>(20);
        constantsTable.addNode("asd", "asd");
        constantsTable.addNode("asddfa", "asddfa");
        constantsTable.addNode("asgfsdd", "asgfsdd");
        constantsTable.addNode("asfdsad", "asfdsad");
        System.out.println(constantsTable);
    }
}
