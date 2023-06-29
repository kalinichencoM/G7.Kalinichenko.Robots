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
        AbstractRobot Robot_1 = new AbstractRobot(AbstractRobot.RobotName("Robot_1")) {
        };
        AbstractRobot Robot_2 = new AbstractRobot(AbstractRobot.RobotName("Robot_2")) {
        };
        final String EXIT_CHAR = new String("p");
        int minRobotHels = Robot_1.getRobotHels();
        String buttonChar = "p";
        do {

            Fight.oneRobotHit(EXIT_CHAR, Robot_1, Robot_2, buttonChar);
            if (!Menu.equalsExit_char(EXIT_CHAR, buttonChar)) {
                System.out.println("Was press exit key \"p\"");
                break;
            }
            if (Robot_1.getRobotHels() < minRobotHels) {
                minRobotHels = Robot_1.getRobotHels();
            }
            Menu.printRobotsHealth(Robot_1, Robot_2);
            if (minRobotHels == 0) {
                break;
            }
            Fight.oneRobotHit(EXIT_CHAR, Robot_2, Robot_1, buttonChar);
            if (!Menu.equalsExit_char(EXIT_CHAR, buttonChar)) {
                System.out.println("Was press exit key \"p\"");
                break;
            }
            if (Robot_1.getRobotHels() < minRobotHels) {
                minRobotHels = Robot_1.getRobotHels();
            }
            Menu.printRobotsHealth(Robot_1, Robot_2);
            if (minRobotHels == 0) {
                break;
            }
        } while (minRobotHels != 0);

    }

}
