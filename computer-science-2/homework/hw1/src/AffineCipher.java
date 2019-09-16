import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AffineCipher {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private int m = alphabet.length();
    private int a, b;

    public static void main(String[] args) {
        //Exit program if number of arguments are wrong
        if (args.length != 3) {
            System.out.println("Invalid arguments. Please enter in the form: int int \"path/to/input.txt\"");
            System.exit(0);
        }
        AffineCipher cipher = new AffineCipher(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        String encrypted_message = cipher.encrypt(new File(args[2]));
        System.out.println(encrypted_message);
    }

    //A and B must be coprime, they are the encryption keys
    public AffineCipher(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //Encrypt a message
    public String encrypt(String message) {
        StringBuilder encryptedMessageBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            //Iterate over message and turn each char into a number according to its index in alphabet
            encryptedMessageBuilder.append(encryptionCipher(message.charAt(i)));
        }
        return encryptedMessageBuilder.toString();
    }

    //Encrypt a file
    public String encrypt(File file) {
        return encrypt(readFile(file));
    }

    private char encryptionCipher(char c) {
        // Turn c into a number "x" based on its position in the alphabet string.
        int x = alphabet.indexOf(c);
        // If the character was not in our alphabet, just return the character unencrypted.
        if (x == -1)
            return c;
        // Encrypt the character using the formula
        int cipher = (a * x + b) % alphabet.length();
        // Turn the encrypted number back into a character.
        return alphabet.charAt(cipher);
    }

    // Reads entire file into a String
    private String readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            return scanner.useDelimiter("\\Z").next();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
