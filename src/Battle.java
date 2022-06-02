import java.util.Random;

public class Battle extends Thread {
    Player player;
    Person monster;
    Person winBattle;


    public Battle(Player player) {
        this.player = player;
        this.monster = choiceMonster();
    }

    Person choiceMonster() {
        if (new Random().nextInt(2) == 0) return new Skeleton(player);
        else return new Goblin(player);
    }

    void startBattle() {
        while (true) {
            player.attac(monster);
            if (checkPerson(monster) == false) {
                winBattle = player;
                break;
            }
            monster.attac(player);
            if (checkPerson(player) == false) {
                winBattle = monster;
                break;
            }
        }
        System.out.println("Бой окончен");
        System.out.println("Выйграл " + winBattle.name);
    }

    boolean checkPerson(Person person) {
        if (person.hp > 0) return true;
        else return false;
    }

@Override
    public void run() {
        startBattle();
        if (winBattle.name.equals(player.name))player.playerWin();
       else player.playerLooser();
    }
}
