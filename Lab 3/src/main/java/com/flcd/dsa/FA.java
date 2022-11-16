package com.flcd.dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class FA {

    private final String fileName;
    private Hashtable<StringPair, List<String>> transitionsHashTable;
    private List<String> alphabet;
    private List<String> endingNodes;

    public Hashtable<StringPair, List<String>> getTransitionsHashTable() {
        return transitionsHashTable;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public List<String> getEndingNodes() {
        return endingNodes;
    }

    public List<String> getAllNodes() {
        return allNodes;
    }

    public String getStartingNode() {
        return startingNode;
    }

    private List<String> allNodes;
    private String startingNode;

    public FA(final String fileName) {
        this.fileName = fileName;
        transitionsHashTable = new Hashtable<>();
        alphabet = new ArrayList<>();
        endingNodes = new ArrayList<>();
        allNodes = new ArrayList<>();

        start();
    }

    public void start() {
        List<String> faFileLines = readFromFAFile();

        createLogic(faFileLines);

    }

    private void createLogic(final List<String> faFileLines) {
        allNodes = List.of(faFileLines.get(0).split(" "));
        alphabet = List.of(faFileLines.get(1).split(" "));
        startingNode = faFileLines.get(2);
        endingNodes = List.of(faFileLines.get(3).split(" "));

        for (int index = 4; index < faFileLines.size(); index++) {
            String line = faFileLines.get(index);
            List<Character> characterList = convertStringToCharList(line);
            transitionsHashTable.put(new StringPair(characterList.get(0).toString(),
                    characterList.get(characterList.size() - 1).toString()), List.of(line.substring(2, line.length() - 1).split(" ")));
        }
    }

    public static List<Character> convertStringToCharList(String str) {
        List<Character> chars = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }

        return chars;
    }

    private List<String> readFromFAFile() {
        try {
            List<String> tokenList = new ArrayList<>();
            Path path = Paths.get(fileName);
            BufferedReader reader = Files.newBufferedReader(path);

            String line;
            while ((line = reader.readLine()) != null) {
                tokenList.add(line);
            }

            return tokenList;
        } catch (IOException e) {
            System.out.println("Could not read FA file " + fileName);
            System.out.println(e.getMessage());
        }

        return List.of();
    }

    public boolean verify(final String str){
        String currentNode = this.startingNode;
        int posVerified = 0;

        for (char ch : str.strip().toCharArray()) {
            for(StringPair sp : this.transitionsHashTable.keySet()){
                if(Objects.equals(sp.getFirst(), currentNode)){
                    if(transitionsHashTable.get(sp).contains(String.valueOf(ch))){
                        currentNode = sp.getSecond();
                        posVerified++;
                        break;
                    }
                }
            }
        }

        if(posVerified == str.length() && endingNodes.contains(currentNode)){
            return true;
        }
        return false;
    }


}
