package Robots;

import java.util.Scanner;

public class Menu {

    public static String getCharFromConsole() {
        Scanner scannerString = new Scanner(System.in);
        String scannerChar;

do {
     scannerChar = scannerString.nextLine().trim().toLowerCase();
    if (scannerChar.length() > 1) {
        System.out.println("The key is too long work first char = " + scannerChar.substring(0, 1));
        scannerChar = scannerChar.substring(0, 1);
        break;
    } else if (scannerChar.length() == 0) {
        System.out.println("The key is too short try again");
        continue;
    }
    return scannerChar;
}while (scannerChar == "");
        return scannerChar;
    }


    public static void printFigthMenu(String robot) {
        System.out.println("");
        System.out.println("For exit press \"p\"");
        System.out.println("A shoot at the robot: " + robot);
        System.out.println("Your step: press key (QWEASDZXC)");
    }

    public static boolean equalsExit_char(String exit_char, String charFromConsole) {
        if (charFromConsole.equals(exit_char)) {
            return true;
        }
        return false;
    }


    public static boolean isButtonUsed(String buttonFromConsole, AbstractRobot robot) {
        for (int i = 0; i < robot.getNotUsedKeys().length(); i++) {
            if (buttonFromConsole.charAt(0) == robot.getNotUsedKeys().charAt(i)) {
                return true;
            }
        }
        System.out.println(buttonFromConsole + " - Key is not active");
        return false;
    }

    public static boolean isButtonBoom(String buttonFromConsole, AbstractRobot robot) {
        for (int i = 0; i < robot.getListNotBoomKey().length(); i++) {
            if (robot.getListNotBoomKey().charAt(i) == buttonFromConsole.charAt(0)) {
                return false;
            }
        }
        return true;

    }

    public static void printRobotsHealth(AbstractRobot robot_1, AbstractRobot robot_2) {
        if (robot_1.getRobotHels() == 0) {
            System.out.println("-----------");
            System.out.println("Robot" + robot_1.getRobotName() + " - was killed");
            System.out.println("Robot" + robot_2.getRobotName() + " - Win!!!");
            System.out.println("------------");
        } else if (robot_2.getRobotHels() == 0) {
            System.out.println("-----------");
            System.out.println("Robot" + robot_1.getRobotName() + " - Win!!!");
            System.out.println("Robot" + robot_2.getRobotName() + " - was killed");
            System.out.println("------------");
        } else {
            System.out.println("-----------");
            System.out.println("Robot" + robot_1.getRobotName() + " health = " + robot_1.getRobotHels());
            System.out.println("Robot" + robot_2.getRobotName() + " health = " + robot_2.getRobotHels());
            System.out.println("------------");
        }
    }
}
