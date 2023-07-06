package Robots;

import java.util.Scanner;

public class Menu {


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


    public static void printRobotsHealth(AbstractRobot robot_1, AbstractRobot robot_2) {
        if (robot_1.getRobotHels() == 0) {
            System.out.println("-----------");
            System.out.println("Robot " + robot_1.getRobotName() + " - was killed");
            System.out.println("Robot " + robot_2.getRobotName() + " - Win!!!");
            System.out.println("------------");
        } else if (robot_2.getRobotHels() == 0) {
            System.out.println("-----------");
            System.out.println("Robot " + robot_1.getRobotName() + " - Win!!!");
            System.out.println("Robot " + robot_2.getRobotName() + " - was killed");
            System.out.println("------------");
        } else {
            System.out.println("-----------");
            System.out.println("Robot " + robot_1.getRobotName() + " health = " + robot_1.getRobotHels());
            System.out.println("Robot " + robot_2.getRobotName() + " health = " + robot_2.getRobotHels());
            System.out.println("------------");
        }
    }


    public static boolean isRobotHes0(AbstractRobot robot_1, AbstractRobot robot_2, int minRobotHelth) {
        if (minRobotHelth == 0) {
            Menu.printRobotsHealth(robot_1, robot_2);
            return true;
        }
        Menu.printRobotsHealth(robot_1, robot_2);
        return false;
    }
}
