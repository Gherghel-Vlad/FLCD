package com.flcd.dsa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PifFileWriter {

    public static void writePifToFile(List<Pair> pifTable, final String fileName){
        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write(String.format(" ------------------------------------\n"));
            writer.write(String.format(" | Token                | Pos in ST |\n"));
            writer.write(String.format(" ------------------------------------\n"));
            for(Pair p :  pifTable){
                writer.write(String.format(" | %-20s | %9d |\n", p.getFirst(), p.getSecond()));
            }
            writer.write(String.format(" ------------------------------------\n"));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
