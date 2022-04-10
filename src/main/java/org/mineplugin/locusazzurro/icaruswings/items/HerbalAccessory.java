package org.mineplugin.locusazzurro.icaruswings.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Vanishable;
import org.mineplugin.locusazzurro.icaruswings.data.ModArmorMaterial;
import org.mineplugin.locusazzurro.icaruswings.data.ModGroup;

public class HerbalAccessory extends ArmorItem implements Vanishable {
	
	private static final ModArmorMaterial material = ModArmorMaterial.HERBAL;

	public HerbalAccessory(EquipmentSlot slot) {
		super(material, slot, new Item.Properties().tab(ModGroup.itemGroup).defaultDurability(material.getDurabilityForSlot(slot)));
	}

}
