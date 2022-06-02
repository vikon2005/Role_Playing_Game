public class ElixirLv2 implements Elixir {

    Player player;

    public ElixirLv2(Player player) {
        this.player = player;
    }


    @Override
    public void cure() {
        switch (player.level) {
            case 2:
                if (player.hp <= 250) player.hp = player.hp + 50;
                else player.hp = 300;
                break;

            case 3:
                if (player.hp <=450) player.hp += 50;
                else player.hp = 500;
                break;
        }
        System.out.println("Изцеление прошло успешно");
        System.out.println("Ваше здоровье =" + player.hp);
    }
}
