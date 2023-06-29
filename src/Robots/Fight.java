package Robots;

public class Fight {
    public static String oneRobotHit(String exit_char, AbstractRobot robot_A, AbstractRobot robot_B, String buttonChar) {
        do {
            Menu.printFigthMenu(robot_A.getRobotName());
            buttonChar = Menu.getCharFromConsole();
            if (Menu.equalsExit_char(exit_char, buttonChar)) {
                break;
            }
            if (AbstractRobot.isButtonCorrect(AbstractRobot.getListOfButtons() ,buttonChar)) {
                Menu.printRobotsHealth(robot_A, robot_B);
                continue;
            } else if (!Menu.isButtonUsed(buttonChar, robot_B)) {
                break;
            } else if (Menu.isButtonBoom(buttonChar, robot_B)) {
                System.out.println("Good shot!! BaBah. the health of " + robot_A.getRobotName() + " decreased for -20");
                robot_B.setNotUsedKeys(robot_B.changeNotUsedKeys(robot_B.getNotUsedKeys(), buttonChar));
                robot_A.setRobotHels(robot_A.getRobotHels() - 20);
                break;
            } else {
                System.out.println("Key does no damage");
                robot_B.setNotUsedKeys(robot_B.changeNotUsedKeys(robot_B.getNotUsedKeys(), buttonChar));
                break;
            }
        } while (!exit_char.equals(buttonChar));
        return buttonChar;
    }
}
