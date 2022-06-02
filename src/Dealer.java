import java.util.InputMismatchException;
import java.util.Scanner;

public class Dealer {

    Player player;
    boolean buy = true;

    public Dealer(Player player) {
        this.player = player;
    }

    public void printMenu() {
        System.out.println("Добро пожаловать в торговую лавку!");
        System.out.println();
        System.out.println("Ваши редства равны " + player.getGold() + " монет");
        System.out.println();
        if (buy == true) {
            System.out.println("Выберете эликсир:");
            System.out.println();
            switch (player.level) {
                case 1:
                    printMenuLvl1();
                    break;
                case 2:
                    printMenuLvl2();
                    break;
                case 3:
                    printMenuLvl3();
                    break;
            }
            System.out.println();
            System.out.println("0 - В меню игры");
            buyElixir();
        } else Main.game.menuGame();
    }

    private void printMenuLvl1() {
        System.out.println("1 -Эликсир уровент 1 10 монет");

    }

    private void printMenuLvl2() {
        System.out.println("1 - Элексир уровень 1 10 монет");
        System.out.println("2 - Элексир уровень 2 30 монет");
    }

    private void printMenuLvl3() {
        System.out.println("1 - Элексир уровень 1 10 монет");
        System.out.println("2 - Элексир уровень 2 30 монет");
        System.out.println("3 - Элексир уровень 3 60 монет");
    }

    private void buyElixir() {
        try {
            int n = new Scanner(System.in).nextInt();

            switch (n) {
                case 1:
                    if (player.getGold() >= 10) {
                        player.inventory.addElixir(new ElixirLv1(player));
                        player.setGold(player.getGold() - 10);
                        System.out.println("Эликсир куплен и добпален в ваш инвентарь");
                    } else System.out.println("Недостаточно монет");
                    printMenu();
                    break;

                case 2:
                    if (player.level >= 2) {
                        if (player.getGold() >= 30) {
                            player.inventory.addElixir(new ElixirLv2(player));
                            player.setGold(player.getGold() - 30);
                            System.out.println("Эликсир куплен и добавлен в ваш инвентарь");
                        } else System.out.println("Недостаточно монет");
                    } else System.out.println("У вас слижком низкий уровень");
                    printMenu();
                    break;

                case 3:
                    if (player.level == 3) {
                        if (player.getGold() >= 60) {
                            player.inventory.addElixir(new ElixirLv3(player));
                            player.setGold(player.getGold() - 60);
                            System.out.println("Эликсир куплен и добавлен в ваш инвентарь");
                        } else System.out.println("Недостаточно монет");
                    } else System.out.println("У вас слижком низкий уровень");
                    printMenu();
                    break;

                case 0:
                    buy = false;
                    printMenu();
                    break;
                default:
                    System.out.println("Неверно введено значение");
                    printMenu();
            }

    } catch( InputMismatchException a) {
        System.out.println("Неверное значение");
        printMenu();
    }
}
}
