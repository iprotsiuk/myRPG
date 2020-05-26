package myrpg.items.gear;

import myrpg.items.gear.accesoires.AccesoireSlots;
import myrpg.items.gear.armor.ArmorSlots;
import myrpg.items.gear.weapon.WeaponSlots;

public class GearConverter {


    public static AccesoireSlots convertToAccessoire(GearSlots gearSlot){
        switch (gearSlot) {
            case lFinger: return AccesoireSlots.lFinger;
            case rFinger: return AccesoireSlots.rFinger;
            case neck: return AccesoireSlots.neck;
            case trinket: return AccesoireSlots.trinket;
            default: return AccesoireSlots.trinket;
        }
    }


    public static WeaponSlots convertToWeapon(GearSlots gearSlot){
        switch (gearSlot) {
            case lHand: return WeaponSlots.lHand;
            case rHand: return WeaponSlots.rHand;
            case twoHand: return WeaponSlots.twoHand;
            default: return WeaponSlots.rHand;
        }
    }

    public static ArmorSlots convertToArmor(GearSlots gearSlot){
        switch (gearSlot){
            case body: return ArmorSlots.body;
            case boots: return ArmorSlots.boots;
            case head: return ArmorSlots.head;
            default: return ArmorSlots.head;
        }
    }


    public static GearSlots convertToGear(AccesoireSlots accesoireSlot){
        switch (accesoireSlot) {
            case trinket: return GearSlots.trinket;
            case neck: return GearSlots.neck;
            case rFinger: return GearSlots.rFinger;
            case lFinger: return GearSlots.lFinger;
            default: return GearSlots.trinket;
        }
    }

    public static GearSlots convertToGear(ArmorSlots armorSlot){
        switch (armorSlot){
            case head: return GearSlots.head;
            case body: return GearSlots.body;
            case boots: return GearSlots.boots;
            default: return GearSlots.head;
        }
    }

    public static GearSlots convertToGear(WeaponSlots weaponSlot){
        switch (weaponSlot){
            case rHand: return GearSlots.rHand;
            case lHand: return GearSlots.lHand;
            case twoHand: return GearSlots.twoHand;
            default: return GearSlots.rHand;
        }
    }

}
