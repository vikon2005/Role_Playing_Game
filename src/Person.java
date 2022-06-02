import java.util.Random;

abstract public class Person {
    int hp;
    int skill;
    int power;
    int level;
    int count;
    String name;

    public void attac(Person personage) {
        if (skill * 3 > (new Random().nextInt(101))) {
            if (count ==3){
                personage.hp = personage.hp - power * 2;
                System.out.println(name + " нанес удар критический удар ссилой "+ power *2 );
                count = 0;
            }else {
                personage.hp = personage.hp - power;
                System.out.println(name + "нанес удар с силой" + power);
                count++;
            }
        }else {
            System.out.println(name+ "промахнулся");
            count = 0;
        }
    }
}

