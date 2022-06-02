public class Goblin extends Person {

    Player player;

    public Goblin(Player player) {
        this.player = player;
        this.count = 0;
        if (player.level == 1) {
            this.name = "Goblin Level 1";
            this.hp = 100;
            this.skill = 15;
            this.power = 5;
            this.level = 1;
        } else if (player.level == 2) {
            this.name = "Goblin Level 2";
            this.hp = 350;
            this.skill = 25;
            this.power = 15;
            this.level = 2;
        } else {
            this.name = "Goblin Level 3";
            this.hp = 490;
            this.skill = 35;
            this.power = 25;
            this.level = 3;
        }
    }
}


