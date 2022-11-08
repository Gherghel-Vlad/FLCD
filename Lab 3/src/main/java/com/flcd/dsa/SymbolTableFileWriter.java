package com.flcd.dsa;

import java.io.FileWriter;
import java.io.IOException;

public class SymbolTableFileWriter {

    public static void writeSymbolTableToFile(final String fileName, final HashTable<String, Integer> identifiersTable,
                                              final HashTable<String, Integer> constantsTable) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(String.format(" ------------------------------------\n"));
            writer.write(String.format(" |        Identifier's table        |\n"));
            writer.write(String.format(" ------------------------------------\n"));
            writer.write(String.format(" | Value                | Pos       |\n"));
            writer.write(String.format(" ------------------------------------\n"));
            for (HashNode<String, Integer> p : identifiersTable.getHashNodes()) {
                if (p != null) {
                    writer.write(String.format(" | %-20s | %9d |\n", p.getKey(), p.getValue()));
                }
            }
            writer.write(String.format(" ------------------------------------\n"));

            writer.write(String.format("\n\n ------------------------------------------------\n"));
            writer.write(String.format(" |                Constant's table              |\n"));
            writer.write(String.format(" ------------------------------------------------\n"));
            writer.write(String.format(" | Value                            | Pos       |\n"));
            writer.write(String.format(" ------------------------------------------------\n"));
            for (HashNode<String, Integer> p : constantsTable.getHashNodes()) {
                if (p != null) {
                    writer.write(String.format(" | %-32s | %9d |\n", p.getKey(), p.getValue()));
                }
            }
            writer.write(String.format(" ------------------------------------------------\n"));
        } catch (IOException e) {
            System.out.println("An error occurred while writing in st.");
            e.printStackTrace();
        }
    }


}
