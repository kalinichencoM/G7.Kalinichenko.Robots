package Robots;/*Завдання на екзаменаційний проект:

        Боротьба двох роботів

        Усі значення зчитуються з консольки.

        Етап перший – підготовка:
        - Кожному роботу потрібно дати ім'я (Ввести з клавіатури та зберегти в самому об'єкті)
        - У робота за замовчанням здоров'я = 100 (теж зберігається в об'єкті)
        - Використовуючи рендомайзер серед літер QWEASDZXC призначити 5 шт ті, які зніматимуть по 20 відсотків життя (літери мають вибиратися при створенні об'єкта Робота)

        Кнопка може відпрацьовувати лише один раз.
        Вихід із гри - 'P'.

        Етап 2: гравці по черзі ходять, натискаючи кнопки з списку QWEASDZXC (кнопки виводяться на екран списком). Якщо кнопка збіглася із заданою – то знімається 20 від життя.
        Після натискання кнопки – перевіряємо, якщо вона не збігається з однією з активних, виводимо повідомлення "Кнопка не активна".
        Після кожної циклу пострілів потрібно виводити на екран ім'я та здоров'я всіх роботів.

        Хто має здоров'я <=0 той вибуває з гри. Виграє єдиний гравець, що залишився.*/

public class MainRobots {
    public static void main(String[] args) {
        AbstractRobot robot_1 = new AbstractRobot(AbstractRobot.robotName("robot_1")) {
        };
        AbstractRobot robot_2 = new AbstractRobot(AbstractRobot.robotName("robot_2")) {
        };
        final String EXIT_CHAR = new String("p");
        int minRobotHels = robot_1.getRobotHels();
        String buttonChar = "p";
        do {

            buttonChar = Fight.oneRobotHit(EXIT_CHAR, robot_1, robot_2, buttonChar);
            if (robot_1.isButtonExit(buttonChar, EXIT_CHAR, robot_1, robot_2)) {
                break;
            }
            if (robot_1.getRobotHels() < minRobotHels) {
                minRobotHels = robot_1.getRobotHels();
            }
            if (Menu.isRobotHes0(robot_1, robot_2, minRobotHels)) {
                break;
            }
            buttonChar = Fight.oneRobotHit(EXIT_CHAR, robot_2, robot_1, buttonChar);
            if (robot_2.isButtonExit(buttonChar, EXIT_CHAR, robot_1, robot_2)) {
                break;
            }
            if (robot_2.getRobotHels() < minRobotHels) {
                minRobotHels = robot_2.getRobotHels();
            }
            if (Menu.isRobotHes0(robot_1, robot_2, minRobotHels)) {
                break;
            }
        } while (minRobotHels != 0);

    }

}
