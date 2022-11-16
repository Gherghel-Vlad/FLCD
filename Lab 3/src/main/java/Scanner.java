import com.flcd.dsa.FA;
import com.flcd.dsa.HashNode;
import com.flcd.dsa.HashTable;
import com.flcd.dsa.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scanner {

    private static final List<Pair> fipTable = new ArrayList<>();


    public static List<Pair> runScanner(final String fileName, final HashTable<String, Integer> identifiersTable,
                                        final HashTable<String, Integer> constantsTable, final List<String> tokens) {
        try {
            boolean correct = true;
            Path path = Paths.get(fileName);
            BufferedReader reader = Files.newBufferedReader(path);

            String line;
            List<String> tokensDetected;
            int nrPosConstant = 0;
            int nrPosIdentifier = 0;
            int lineNr = 1;
            while ((line = reader.readLine()) != null) {
                tokensDetected = detectTokens(line, tokens);

                for (String token : tokensDetected) {
                    if (tokens.contains(token)) {
                        addToFip(token, -1);
                    } else {
                        if (isIdentifier(token)) {
                            int nr = addToHashTableOrGetTheIndex(token, identifiersTable, nrPosIdentifier);
                            if (nr > nrPosIdentifier) {
                                addToFip("id", nr-1);
                                nrPosIdentifier = nr;
                            }
                            else {
                                addToFip("id", nr);
                            }
                        } else {
                            if (isConstant(token)) {
                                int nr = addToHashTableOrGetTheIndex(token, constantsTable, nrPosConstant);
                                if (nr > nrPosConstant) {
                                    addToFip("const", nr-1);
                                    nrPosConstant = nr;
                                }
                                else {
                                    addToFip("const", nr);
                                }
                            } else {
                                System.out.println("Lexical error at line " + lineNr + " at token: " + token);
                                correct = false;
                            }
                        }
                    }
                }
                lineNr++;
            }
            if (correct) {
                System.out.println("Lexical correct");
            }
            return fipTable;
        } catch (IOException e) {
            System.out.println("Could not read tokens.in!!");
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    private static int addToHashTableOrGetTheIndex(String token, HashTable<String, Integer> hashTable, int nrPos) {
        boolean found = false;
        HashNode<String, Integer> foundNode = null;
        for (HashNode<String, Integer> node : hashTable.getHashNodes()) {
            if (node != null && Objects.equals(node.getKey(), token)) {
                foundNode = node;
                found = true;
                break;
            }
        }
        if (found) {
            return foundNode.getValue();
        } else {
            hashTable.addNode(token, nrPos);
            return ++nrPos;
        }

    }

    private static boolean isConstant(String token) {
        boolean isConst = false;
        int i;
        FA fa = new FA("src/integerConstantsFA.txt");

        if (token.length() > 0 && token.charAt(0) == '"' && token.charAt(token.length() - 1) == '"') {
            isConst = true;
        } else {
//            int startIndex = 0;
//            if(token.charAt(0) == '-' || token.charAt(0) == '+'){
//                startIndex = 1;
//            }

//            for (i = startIndex; i < token.length(); i++) {
//                if (!Character.isDigit(token.charAt(i))) {
//                    break;
//                }
//            }
//
//            if (i >= token.length()) {
//                isConst = true;
//            }

            if (fa.verify(token.strip())) {
                isConst = true;
            }
        }

        return isConst;
    }

    private static boolean isIdentifier(String token) {
        boolean isIden = false;
        int i;
        FA fa = new FA("src/identifiersFA.txt");

//        if (token.length() > 0 && Character.isLetter(token.charAt(0))) {
//            for (i = 0; i < token.length(); i++) {
//                if (!Character.isLetterOrDigit(token.charAt(i))) {
//                    break;
//                }
//            }
//            if (i >= token.length()) {
//                isIden = true;
//            }
//        }

        if(fa.verify(token)){
            isIden = true;
        }

        return isIden;
    }

    public static void addToFip(String token, int index) {
        fipTable.add(new Pair(token, index));
    }

    public static List<String> detectTokens(final String line, final List<String> tokenList) {
        int startIndex = 0, finalIndex = 0;
        boolean specialOp = false;
        String token;
        List<String> tokensDetected = new ArrayList<>();
        while (startIndex < line.length()) {
            if (Character.isLetterOrDigit(line.charAt(finalIndex)) || line.charAt(startIndex) == '"' || line.charAt(startIndex) == '-' || line.charAt(startIndex) == '+') {
                if(line.charAt(startIndex) == '-' || line.charAt(startIndex) == '+'){
                    finalIndex++;
                }

                while (finalIndex < line.length() && Character.isLetterOrDigit(line.charAt(finalIndex))) {
                    finalIndex++;
                }



                if(line.charAt(startIndex) == '"'){
                    finalIndex++;
                    while(finalIndex < line.length() && line.charAt(finalIndex) != '"'){
                        finalIndex++;
                    }
                    finalIndex++;
                }
            } else {
                while (finalIndex < line.length() && !Character.isLetterOrDigit(line.charAt(finalIndex)) && !Character.isWhitespace(line.charAt(finalIndex))
                        && tokenList.contains(line.substring(startIndex, finalIndex + 1))) {
                    finalIndex++;
                }

                while (finalIndex + 2 < line.length() && tokenList.contains(line.substring(startIndex, finalIndex + 2))) {
                    finalIndex = finalIndex + 2;
                }
            }

            if (startIndex == finalIndex) { // this means that it s only 1 character long
                if (!Character.isWhitespace(line.charAt(finalIndex))) {
                    tokensDetected.add(line.substring(startIndex, finalIndex + 1));
                }
                finalIndex++;
            } else {
                if (!Character.isWhitespace(line.charAt(finalIndex - 1))) {
                    tokensDetected.add(line.substring(startIndex, finalIndex));
                }

            }

            startIndex = finalIndex;
        }
        return tokensDetected;
    }
}
