public class ReqFourB {
    public static void main(String[] args) {
        String theText = "Thus the length of the substring is endIndex-beginIndexxhelllos efpoeaimjfsa";

        int stringLength = theText.length();

        int partPerServer = stringLength / 5;
    
        boolean hasReminder = false;
        int theReminder = 0;

        String partOne;
        String partTwo;
        String partThree;
        String partFour;
        String partFive;

        // System.out.println("Total Length: " + stringLength);
        // System.out.println("each part " + partPerServer);

        if (stringLength % 5 != 0) {
            hasReminder = true;
            theReminder = stringLength % 5;
        }

        //System.out.println("total each part " + ((partPerServer * 5) + theReminder));

        partOne = theText.substring(0, partPerServer);

        partTwo = theText.substring(partPerServer, (partPerServer * 2));

        partThree = theText.substring((partPerServer * 2), (partPerServer * 3));

        partFour = theText.substring((partPerServer * 3), (partPerServer * 4));

        if (hasReminder) {
            partFive = theText.substring((partPerServer * 4), ((partPerServer * 5) + theReminder));
        } else {
            partFive = theText.substring((partPerServer * 4), (partPerServer * 5));
        }

        System.out.println(partOne + " --- and it is " + countWordsInSentence(partOne) + " words");
        System.out.println(partTwo  + " --- and it is " + countWordsInSentence(partTwo) + " words");
        System.out.println(partThree + " --- and it is " + countWordsInSentence(partThree)+ " words");
        System.out.println(partFour + " --- and it is " + countWordsInSentence(partFour) + " words");
        System.out.println(partFive + " --- and it is " + countWordsInSentence(partFive) + " words");

    }


    private static int countWordsInSentence(String input) {
        int wordCount = 0;
    
        if (input.trim().equals("")) {
            return wordCount;
        }
        else {
            wordCount = 1;
        }
    
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String str = new String("" + ch);
            if (i+1 != input.length() && str.equals(" ") && !(""+ input.charAt(i+1)).equals(" ")) {
                wordCount++;
            }
        }
    
        return wordCount;
     }
}

//https://stackoverflow.com/questions/5864159/count-words-in-a-string-method