package myrpg.items.gear;

import myrpg.items.gear.accesoires.AccesoireSlots;
import myrpg.items.gear.armor.ArmorSlots;
import myrpg.items.gear.weapon.WeaponSlots;

public class GearConverter {


    public static AccesoireSlots convertToAccessories(GearSlotType gearSlot){
        switch (gearSlot) {
            case lFinger: return AccesoireSlots.lFinger;
            case rFinger: return AccesoireSlots.rFinger;
            case neck: return AccesoireSlots.neck;
            case trinket: return AccesoireSlots.trinket;
            default: return AccesoireSlots.trinket;
        }
    }


    public static WeaponSlots convertToWeapon(GearSlotType gearSlot){
        switch (gearSlot) {
            case lHand: return WeaponSlots.lHand;
            case rHand: return WeaponSlots.rHand;
            case twoHand: return WeaponSlots.twoHand;
            default: return WeaponSlots.rHand;
        }
    }

    public static ArmorSlots convertToArmor(GearSlotType gearSlot){
        switch (gearSlot){
            case body: return ArmorSlots.body;
            case boots: return ArmorSlots.boots;
            case head: return ArmorSlots.head;
            default: return ArmorSlots.head;
        }
    }


    public static GearSlotType convertToGear(AccesoireSlots accesoireSlot){
        switch (accesoireSlot) {
            case trinket: return GearSlotType.trinket;
            case neck: return GearSlotType.neck;
            case rFinger: return GearSlotType.rFinger;
            case lFinger: return GearSlotType.lFinger;
            default: return GearSlotType.trinket;
        }
    }

    public static GearSlotType convertToGear(ArmorSlots armorSlot){
        switch (armorSlot){
            case head: return GearSlotType.head;
            case body: return GearSlotType.body;
            case boots: return GearSlotType.boots;
            default: return GearSlotType.head;
        }
    }

    public static GearSlotType convertToGear(WeaponSlots weaponSlot){
        switch (weaponSlot){
            case rHand: return GearSlotType.rHand;
            case lHand: return GearSlotType.lHand;
            case twoHand: return GearSlotType.twoHand;
            default: return GearSlotType.rHand;
        }
    }

}
