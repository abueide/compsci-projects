import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Anagrams {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid arguments. Write in the form of java Anagrams int string");
            System.exit(0);
        }
        // Create a new instance of the Anagrams class, passing in the info, and store the sorted set of answers in
        // in a set sorted alphabetically
        SortedSet<String> anagrams = new Anagrams(Integer.parseInt(args[0]), args[1], "/usr/share/dict/american").getAnagrams();
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    // The hashset we load the entire dictionary into
    private HashSet<String> dictionary = new HashSet<>();
    private int n;
    private String word;

    public Anagrams(int n, String word, String dictionaryPath) {
        this.n = n;
        this.word = word.toLowerCase();

        try {
            BufferedReader dictionaryReader = new BufferedReader(new FileReader(new File(dictionaryPath)));
            String line;
            while ((line = dictionaryReader.readLine()) != null) {
                dictionary.add(line.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SortedSet<String> getAnagrams() {
        SortedSet<String> anagrams = new TreeSet<>();
        // Iterate over every word in the dictionary, and check if that word is an anagram. If it is, add it to the
        // alphabetically sorted set to be returned.
        for (String dictionaryWord : dictionary) {
            if (dictionaryWord.length() == n && checkAnagram(word, dictionaryWord)) {
                anagrams.add(dictionaryWord);
            }
        }
        return anagrams;
    }

    // Checks if one string is an anagram of another string.
    public boolean checkAnagram(String word, String anagram) {
        // Create 2 hashmaps where we will store the count how many of each character each string has
        HashMap<Character, Integer> wordLetterCount = new HashMap();
        HashMap<Character, Integer> anagramLetterCount = new HashMap();
        // Count the number of characters, and insert into hashmap
        for (char c : word.toCharArray()) {
            wordLetterCount.put(c, wordLetterCount.getOrDefault(c, 0) + 1);
        }
        for (char c : anagram.toCharArray()) {
            anagramLetterCount.put(c, anagramLetterCount.getOrDefault(c, 0) + 1);
        }
        // If the second string "anagram" ends up having more of any 1 character, we return false immediately.
        // Otherwise we'll return true
        for (char c : anagramLetterCount.keySet()) {
            if (anagramLetterCount.getOrDefault(c, 0) > wordLetterCount.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }
}
