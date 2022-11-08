import com.flcd.dsa.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> identifiersTable = new HashTable<>(20);

        HashTable<String, Integer> constantsTable = new HashTable<>(20);

        List<Pair> pifTable = Scanner.runScanner("src/main/java/p1.txt", identifiersTable, constantsTable, TokenFileReader.readTokens());

        PifFileWriter.writePifToFile(pifTable, "PIF.out");
        SymbolTableFileWriter.writeSymbolTableToFile("ST.out", identifiersTable, constantsTable);
    }
}
