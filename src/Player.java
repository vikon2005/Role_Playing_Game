import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player extends Person {

    private int gold;
    private int xp;
    Inventory inventory = new Inventory();

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.gold = 1000;
        this.skill = 20;
        this.xp = 80;
        this.power = 30;
        this.level = 1;
        this.count = 0;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    private void upLevel() {
        if (level == 1) {
            hp = 300;
            this.skill = 15;
            this.power = 25;
            this.level = 2;
        } else {
            hp = 500;
            this.skill = 20;
            this.power = 40;
            this.level = 3;
        }
        System.out.println("Поздравляем ваш уровень повышен");
        System.out.println("Ваш уровень" + level);
    }

    private void recoveryPlayer() {
        count = 0;
        if (level == 1) {
            gold = gold + 10;
            xp = xp + 20;
        } else if (level == 2) {
            gold = gold + 15;
            xp = xp + 40;
        } else {
            gold = gold + 20;
            xp = xp + 100;
        }
    }

    private void checkPlayer() {
        recoveryPlayer();
        if (xp == 100 || xp == 500) upLevel();
    }

    public void playerWin() {
        checkPlayer();
    }

    public void playerLooser() {
        count = 0;
        if (level == 1) {
            hp = 100;
            if (xp != 0) {
                if (xp > 20) xp = xp - 20;
                else xp = 0;
            }
        } else if (level == 2) {
            hp = 300;
            if (xp != 0) {
                if (xp > 40) xp = xp - 40;
                else xp = 0;
            }
        } else {
            hp = 500;
            if (xp != 0) {
                if (xp > 100) xp = xp - 100;
                else xp = 0;
            }

        }
    }

    public void playerInfo() {
        System.out.println("Герой " + name.toUpperCase());
        System.out.println();
        System.out.println("Уровень = " + level);
        System.out.println("Ловкость = " + skill);
        System.out.println("Сила = " + power);
        System.out.println("Жизнь = " + hp);
        System.out.println("Опыт = " + xp);
        System.out.println("Золото = " + gold);
        System.out.println();
        inventory.inventoriPrintInfo();
        System.out.println();
        System.out.println("1 - лечить");
        System.out.println("2 - в меню игры");
        try {
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    inventory.menuCure();
                    break;
                case 2:
                    Main.game.menuGame();
                    break;
                default:
                    System.out.println("Неверно введено значение.");
            }
        } catch (InputMismatchException a) {
            System.out.println("Неверное ззначение");
            playerInfo();
        }
    }

    class Inventory {

        int elixirLvl1;
        int elixirLvl2;
        int elixirLvl3;
        private List<Elixir> elixirList = new ArrayList<Elixir>();

        public void addElixir(Elixir elixir) {
            elixirList.add(elixir);
        }

        void inventoriPrintInfo() {
            System.out.println("Инвентарь");
            inventoriPrintInfo();
            System.out.println("Эликсир уровень 1 " + elixirLvl1 + " шт");
            System.out.println("Эликсир уровень 2 " + elixirLvl2 + " шт");
            System.out.println("Эликсир уровень 3 " + elixirLvl3 + " шт");
        }

        void inventoryInfo() {
            elixirLvl1 = 0;
            elixirLvl2 = 0;
            elixirLvl3 = 0;
            for (Elixir a : elixirList) {
                if (a instanceof ElixirLv1) elixirLvl1++;
                else if (a instanceof ElixirLv2) elixirLvl2++;
                else elixirLvl3++;
            }
        }

        void menuCure() {
            inventoryInfo();
            System.out.println();
            System.out.println("Выберите эликсир");
            System.out.println("1 - Эликсир уровень 1 " + elixirLvl1 + " шт");
            System.out.println("2 - Эликсир уровень 2 " + elixirLvl2 + " шт");
            System.out.println("3 - Эликсир уровень 3 " + elixirLvl3 + " шт");
            System.out.println("4 - Назад");
            cure();
        }

        void cure() {
            try {
                int n = new Scanner(System.in).nextInt();
                switch (n) {
                    case 1:
                        if (elixirLvl1 > 0) {
                            for (Elixir a : elixirList) {
                                if (a instanceof ElixirLv1) {
                                    a.cure();
                                    elixirLvl1--;
                                    elixirList.remove(a);
                                    menuCure();
                                    break;
                                }
                            }

                        } else System.out.println("У вас нет этого этого элексира");
                        menuCure();
                        break;

                    case 2:
                        if (elixirLvl2 > 0) {
                            for (Elixir a : elixirList) {
                                if (a instanceof ElixirLv2) {
                                    a.cure();
                                    elixirLvl2--;
                                    elixirList.remove(a);
                                    menuCure();
                                    break;
                                }
                            }
                        } else System.out.println("У вас нет этого этого элексира");
                        menuCure();
                        break;

                    case 3:
                        if (elixirLvl3 > 0) {
                            for (Elixir a : elixirList) {
                                if (a instanceof ElixirLv2) {
                                    a.cure();
                                    elixirLvl3--;
                                    elixirList.remove(a);
                                    menuCure();
                                    break;
                                }
                            }
                        } else System.out.println("У вас нет элексира");
                        menuCure();
                        break;

                    case 4:
                        elixirLvl1 = 0;
                        elixirLvl2 = 0;
                        elixirLvl3 = 0;
                        playerInfo();
                        break;
                    default:
                        System.out.println("Неверно введено значение");
                        menuCure();
                }
                } catch(InputMismatchException a){
                    System.out.println("Неверное значение");
                    menuCure();
                }
            }
        }
    }





