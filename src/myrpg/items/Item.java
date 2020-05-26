package myrpg.items;

import myrpg.effects.IEffect;
import myrpg.items.gear.GearSlots;

import java.util.List;

public abstract class Item implements IItem{
    ItemType itemType;
    String itemName;
    int itemLevel;
    boolean isUnique;
    List<IEffect> IEffectList;

    public Item(ItemType itemType, String itemName, int itemLevel, boolean isUnique, List<IEffect> IEffectList) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemLevel = itemLevel;
        this.isUnique = isUnique;
        this.IEffectList = IEffectList;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public boolean isUnique() {
        return isUnique;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    @Override
    public List<IEffect> getEffectsList() {
        return this.IEffectList;
    }

    @Override
    public List<GearSlots> getPossibleSlots() {
        return null;
    }

}
