package javaapplication3;

import java.io.*;

public class JavaApplication3 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\XPRISTO\\Documents\\Trial"); // folder
        File[] fileArray = file.listFiles();

        if (fileArray != null) {
            String fileWithLongestWord = "";
            String longestWordAcrossFiles = "";
            
              String fileWithShortestWord = "";
            String ShortestWordAcrossFiles = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

            for (File f : fileArray) {
                if (f.isFile()) { // Check if it's a file (not a directory)
                    System.out.println("Reading contents of file: " + f.getName()); // get file name
                    readAndCountWords(f);
                      System.out.println("\n");
                    int isCount = countWordOccurrences(f, "is");
                    System.out.println("Number of 'is' occurrences in " + f.getName() + ": " + isCount  + "\n");

                    int areCount = countWordOccurrences(f, "are");
                    System.out.println("Number of 'are' occurrences in " + f.getName() + ": " + areCount + "\n");
                    
                    // Get and print the longest word in the file
                    String longestWord = getLongestWord(f);
                    System.out.println("Longest word in " + f.getName() + ": " + longestWord + "\n");
                    
                      String ShortestWord = getShortestWord(f);
                    System.out.println("ShortestWord in " + f.getName() + ": " + ShortestWord + "\n");

           
                    if (longestWord.length() > longestWordAcrossFiles.length()) {
                        longestWordAcrossFiles = longestWord;
                        fileWithLongestWord = f.getName();
                        System.out.println("----------------------");
                    }
                    if(ShortestWord.length()<ShortestWordAcrossFiles.length())
                    {
                       ShortestWordAcrossFiles=ShortestWord;
                        
                    fileWithShortestWord = f.getName();
                }}
            }

            // Print the file with the longest word and the longest word itself
            System.out.println("File with the longest word: " + fileWithLongestWord);
            System.out.println("Longest word across all files: " + longestWordAcrossFiles);
              System.out.println("----------------------");
             System.out.println("File with the Shortest word: " + fileWithShortestWord);
            System.out.println("Shortest word across all files: " + ShortestWordAcrossFiles );

           
          
        } else {
            System.out.println("The specified directory is empty or does not exist.");
        }
    }

    private static void readAndCountWords(File file) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                // Split the line into words using whitespace a
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            System.out.println("Number of words in " + file.getName() + ": " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWordOccurrences(File file, String word) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace 
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(word)) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    private static String getLongestWord(File file) {
        String longestWord = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace 
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.length() > longestWord.length()) {
                        longestWord = w;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestWord;
    }

  private static String getShortestWord(File file) {
       String ShortestWord = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.length() < ShortestWord.length()) {
                        ShortestWord = w;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ShortestWord;
    }
}
