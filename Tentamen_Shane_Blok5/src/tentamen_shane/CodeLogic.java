/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen_shane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author shane
 */
public class CodeLogic {
    
/**
 * warning is a given String for exception.
 * the ph1 is a placeholder for each character to go trough the for loop.
 * ArrayList is a list with all characters from the text file.
 * total is a integer that counts all the nucleotides.
 * xCount are counters for each nucleotide.
 * xPerc are integers with percentages for each nucleotide.
 * Place One, Two, Three are the integers with the percentages of the winning nucleotides.
 * first, second, third are Strings with the winning nucleotides A, C, T or G
 */    
    
    public static String warning = "Dit is geen aminozuur!";
    public String ph1; 
    public ArrayList <String> allAA = new ArrayList<>();
    
    public int total;
    public int aCount;
    public int tCount;
    public int cCount;
    public int gCount;
    public int nCount;
    
    public int aPerc;
    public int tPerc;
    public int cPerc;
    public int gPerc;
    
    public int placeOne;
    public int placeTwo;
    public int placeThree;
    
    public String first;
    public String second;
    public String third;
    
    public int firstPerc;
    public int secondPerc;
    public int thirdPerc;

/**
 * this method reads the textlines, and counts the nucleotides.
 * after that, the method will select a First, Second and Third winner which are given to GUI though getters.
 * 
 * @param seq
 * @return
 * @throws NotAnAA 
 */
    public String DNA (String seq) throws NotAnAA {
        
         for (int i = 0; i < seq.length(); i++) {
            char lijst = seq.charAt(i);
            ph1 = Character.toString(lijst);
            // System.out.println(ph1);
         
         String pattern = "[ATCGN]";         
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(ph1);

            if (!m.find()) {
                seq = warning;
                System.out.println("Dit gaat fout man");
               
            } else if (ph1.equals("A")) {
                aCount +=1;
                
            } else if (ph1.equals("T")) {
                tCount +=1;
                
            } else if (ph1.equals("C")) {
                cCount +=1;
                
            } else if (ph1.equals("G")) {
                gCount +=1;
                
            } else if (ph1.equals("N")) {
                nCount +=1;
            }
        }
        total = aCount + tCount + cCount + gCount + nCount;
        
        aPerc =100 * aCount / total;
        tPerc =100 * tCount / total;
        cPerc =100 * cCount / total;
        gPerc =100 * gCount / total;
        
        int[] allPerc = {aPerc, tPerc, cPerc, gPerc};
        Arrays.sort(allPerc);
        placeOne = allPerc[3];
        placeTwo = allPerc[2];
        placeThree = allPerc[1];
        
        System.out.println(placeOne);
        System.out.println("A "+aPerc);
        System.out.println("T "+tPerc);
        System.out.println("C "+cPerc);
        System.out.println("G"+gPerc);
        
        //eerste plaats met de bijbehorende nucleotide vergelijken:
               if (placeOne == aPerc){
            first = "A";
            firstPerc = aPerc;
        } else if (placeOne == tPerc) {
            first = "T";
            firstPerc = tPerc;
        } else if (placeOne == cPerc) {
            first = "C";
            firstPerc = cPerc;
        } else if (placeOne == gPerc) {
            first = "G";
            firstPerc = gPerc;
        } else {
            System.out.println("Geen winnaar!");
        }
        // tweede plaats met de bijbehorende nucleotide vergelijken:
                if (placeTwo == aPerc){
            second = "A";
            secondPerc = aPerc;
        } else if (placeTwo == tPerc) {
            second = "T";
            secondPerc = tPerc;
        } else if (placeTwo == cPerc) {
            second = "C";
            secondPerc = cPerc;
        } else if (placeTwo == gPerc) {
            second = "G";
            secondPerc = gPerc;
        } else {
            System.out.println("Geen 2e");
        }
        
        // derde plaats met de bijbehorende nucleotide vergelijken:
                if (placeThree == aPerc){
            third = "A";
            thirdPerc = aPerc;
        } else if (placeThree == tPerc) {
            third = "T";
            thirdPerc = tPerc;
        } else if (placeThree == cPerc) {
            third = "C";
            thirdPerc = cPerc;
        } else if (placeThree == gPerc) {
            third = "G";
            thirdPerc = gPerc;
        } else {
            System.out.println("Geen 3e");
        }

        return seq;
    }
/**
 * 
 * @return 
 */
    public String getFirst() {
        return first;
    } public String getSecond() {
        return second;
    } public String getThird() {
        return third;
    } public int getTotaal() {
        return total;
    } public int getFirstPerc() {
        return firstPerc;
    } public int getSecondPerc() {
        return secondPerc;
    } public int getThirdPerc() {
        return thirdPerc;
    }
    
}
/**
 * 
 * Custom exception
 */
class NotAnAA extends Exception {

/**
* Overschrijven van de constructor van Exception
*/
  public NotAnAA() {
  /** call van de constructor van de super class: Exception
  */
    super();
  }

  public NotAnAA(String err) {
    super(err);
  }
}