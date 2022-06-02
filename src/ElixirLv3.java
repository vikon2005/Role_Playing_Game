public class ElixirLv3 implements  Elixir {

    Player player;

    public ElixirLv3(Player player) {
        this.player = player;
    }


    @Override
    public void cure() {
        if (player.hp <=400) player.hp += 100;
        else player.hp = 500;
        System.out.println("Исцеление прошло успешно");
        System.out.println("Ваше здоровье = " + player.hp);
    }
}
