package Robots;

import java.util.Random;
import java.util.Scanner;

abstract public class AbstractRobot {
    private int robotHels = 100;
    private String robotName;

    public AbstractRobot(String robotName) {

        this.robotName = robotName;
        buttonsBoom();
    }

    private String notUsedKeys = "qweasdzxc";

    public String getNotUsedKeys() {
        return notUsedKeys;
    }

    public void setNotUsedKeys(String notUsedKeys) {
        this.notUsedKeys = notUsedKeys;
    }

    public String changeNotUsedKeys(String notUsedKeys, String buttonForReplase) {
        notUsedKeys = notUsedKeys.replace(String.valueOf(buttonForReplase), "");
        return notUsedKeys;
    }

    public String getRobotName() {
        return robotName;
    }

    public int getRobotHels() {
        return robotHels;
    }

    public void setRobotHels(int robotHels) {
        this.robotHels = robotHels;
    }

    private String listNotBoomKey = "qweasdzxc";
    private static String listOfButtons = "qweasdzxc";

    public static String getListOfButtons() {
        return listOfButtons;
    }

    public static boolean isButtonCorrect(String listOfButtons, String buttonChar) {

        for (int i = 0; i < listOfButtons.length(); i++) {
            if (buttonChar.charAt(0) == listOfButtons.charAt(i)) {
                return false;
            }
        }
        System.out.println(buttonChar + " - Wrong enters, use only key from QWEASDZXC keys");
        return true;
    }

    public String getListNotBoomKey() {
        return listNotBoomKey;
    }

    private String buttonsBoom() {


        for (int i = 0; i < 5; i++) {
            int randIdx = new Random().nextInt(listNotBoomKey.length());
            char randChar = listNotBoomKey.charAt(randIdx);
            listNotBoomKey = listNotBoomKey.replace(String.valueOf(randChar), "");
        }
        return listNotBoomKey;
    }


    public static String robotName(String robot) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of " + robot + ":");
        String scannerString = scanner.nextLine();
        return scannerString;
    }
}

