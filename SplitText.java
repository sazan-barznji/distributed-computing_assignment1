public class SplitText {

    // String text;
    // int ServerNumber;

    // public SplitText(String text, int ServerNumber){
    //     this.text = text;
    //     this.ServerNumber = ServerNumber;
    // }
    public String spiltText(String theText, int Server) {

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

		// System.out.println("total each part " + ((partPerServer * 5) + theReminder));

		partOne = theText.substring(0, partPerServer);

		partTwo = theText.substring(partPerServer, (partPerServer * 2));

		partThree = theText.substring((partPerServer * 2), (partPerServer * 3));

		partFour = theText.substring((partPerServer * 3), (partPerServer * 4));

		if (hasReminder) {
			partFive = theText.substring((partPerServer * 4), ((partPerServer * 5) + theReminder));
		} else {
			partFive = theText.substring((partPerServer * 4), (partPerServer * 5));
		}

		if (Server == 1) {
			return partOne;
		} else if (Server == 2) {
			return partTwo;
		} else if (Server == 3) {
			return partThree;
		} else if (Server == 4) {
			return partFour;
		} else {
			return partFive;
		}

	}

    
    
}
