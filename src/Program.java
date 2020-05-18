import myrpg.*;
import myrpg.classes.Archer;
import myrpg.classes.IClass;
import myrpg.classes.Warrior;
import myrpg.races.Human;
import myrpg.races.IRace;
import myrpg.races.Undead;

public class Program{

    public static void main(String[] args) {
        IClass archer = new Archer(5, 10);
        IClass warrior = new Warrior(6);
        IRace human = new Human();
        IRace undead = new Undead();
        IUnit unitArcher = new Unit(human, archer);
        IUnit unitArcherUndead = new Unit(undead, archer);

        System.out.println("human hp: " + unitArcher.getCurrentHP());
        System.out.println("undead hp: " + unitArcherUndead.getCurrentHP());
        unitArcher.focusTarget(unitArcherUndead);
        unitArcher.attackTarget();
        System.out.println("undead hp: " + unitArcherUndead.getCurrentHP());
    }

}
