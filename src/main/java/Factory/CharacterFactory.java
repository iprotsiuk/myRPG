package Factory;

import models.DBmodels.*;
import models.DBmodels.Class;
import services.ServiceManager;

public class CharacterFactory {

//    public Unit(Race race, Class _class, int currentMana, int currentHp) {


    public static GameCharacter createGameCharacter(Race race, Class _class, String name){
        int stamina = race.getStamina();
        int intellect = race.getIntellect();
        double mana = (intellect * _class.getIntMultiplier()) * 10;
        double hp = (stamina * _class.getStaMultiplier()) * 10;
        Unit unit = new Unit(race, _class, (int) mana, (int) hp);
        GameCharacter character = new GameCharacter(name, unit);
        return character;
    }
}
