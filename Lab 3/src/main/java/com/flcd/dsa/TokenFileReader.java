package com.flcd.dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TokenFileReader {

    private final static String TOKEN_FILE_NAME = "src/main/java/tokens.in";

    public static List<String> readTokens() {
        try {
            List<String> tokenList = new ArrayList<>();
            Path path = Paths.get(TOKEN_FILE_NAME);
            BufferedReader reader = Files.newBufferedReader(path);

            String line;
            while ((line = reader.readLine()) != null) {
                switch (line) {
                    case "<tab>":
                        tokenList.add("\t");
                        break;
                    case "<space>":
                        tokenList.add(" ");
                        break;
                    case "<newline>":
                        tokenList.add("\n");
                        break;
                    default:
                        tokenList.add(line);
                }
            }

            return tokenList;
        } catch (IOException e) {
            System.out.println("Could not read tokens.in!!");
            System.out.println(e.getMessage());
        }

        return List.of();
    }

}
