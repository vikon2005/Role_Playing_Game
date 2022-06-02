public class Skeleton extends Person {

    Player player;

    public Skeleton(Player player) {
        this.player = player;
        this.count =0;
        if (player.level ==1) {
            this.name = "Skeleton Ltvel 1 ";
            this.hp = 100;
            this.skill = 2;
            this.level = 1;
        }else if (player.level ==2) {
            this.name = "Skeleton Level 2";
            this.hp = 400;
            this.skill = 5;
            this.power = 40;
            this.level = 2;
        }else {
            this.name = "Skeleton Level 3";
            this.hp =700;
            this.skill =10;
            this.power =60;
            this.level =3;
        }
    }
}
