//package se450_assignment;
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

}

//https://stackoverflow.com/questions/5864159/count-words-in-a-string-method