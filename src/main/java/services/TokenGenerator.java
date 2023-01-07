package services;

import javax.persistence.Column;
import java.util.Random;

public class TokenGenerator {




    public static String generateRandomToken_32(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int random = 0;
        char c = '1';

        for(int i = 0; i < 32; i++) {
            random = rand.nextInt(93);
            random += 33;
            c = (char)random;
            sb.append(c);
        }
        return sb.toString();
    }

    public static String generateRandomToken_64(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int random = 0;
        char c = '1';

        for(int i = 0; i < 64; i++) {
            random = rand.nextInt(93);
            random += 33;
            c = (char)random;
            sb.append(c);
        }
        return sb.toString();
    }


    public static String generateRandomToken(int len){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int random = 0;
        char c = '1';

        for(int i = 0; i < len; i++) {
            random = rand.nextInt(93);
            random += 33;
            c = (char)random;
            sb.append(c);
        }
        return sb.toString();
    }
}
