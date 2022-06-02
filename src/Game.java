import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Player player;

    public void startGame() {
        System.out.println("Добро пожаловать в ROLE PLAYING GAME");
        System.out.println();
        System.out.println("Создайте нового персонажа");
        System.out.println();
        System.out.println("Введите имя Героя:      ");
        String name = new Scanner(System.in).nextLine();
        System.out.println();
        player = new Player(name);
        System.out.println("герой " + player.name + " успешно создан");
        System.out.println();
        menuGame();

    }
public void menuGame() {
    while (true) {
        System.out.println("Выберите действие.");
        System.out.println();
        System.out.println("1 -К торговцу");
        System.out.println();
        System.out.println("2 -В тёмный лес");
        System.out.println();
        System.out.println("3 -Информация о герое");
        System.out.println();
        System.out.println("4 -Выход");
        try {
            int n = new Scanner(System.in).nextInt();
            work(n);
        } catch (InputMismatchException a) {
            System.out.println("Неверное значение");
        }

    }
}
     private void work(int n) {
        switch (n) {
            case 1:
                new Dealer(player).printMenu();
                break;
            case 2:
                new Battle(player).run();
                break;
            case 3:
                player.playerInfo();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Неверно введена команда");
        }
    }
}
