public class ElixirLv1 implements Elixir{

    Player player;

    public ElixirLv1(Player player) {
        this.player = player;
    }

    @Override
    public void cure() {
        switch (player.level) {
            case 1:
                if (player.hp <= 90) player.hp = player.hp + 10;
                else player.hp = 100;
                break;

            case 2:
                if (player.hp <= 290) player.hp = player.hp + 10;
                else player.hp = 300;
                break;

            case 3:
                if (player.hp <= 490) player.hp += 10;
                else player.hp = 500;
                break;
        }

        System.out.println("Исцеление прошло успешно");
        System.out.println("Ваше здоровье =" + player.hp);
    }
}
