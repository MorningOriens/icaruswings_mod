package org.mineplugin.locusazzurro.icaruswings.items;

import net.minecraft.world.entity.ai.attributes.Attributes;
import org.mineplugin.locusazzurro.icaruswings.data.WingsType;
import org.mineplugin.locusazzurro.icaruswings.render.IWingsExpandable;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class SynapseWingsDelta extends SynapseWings implements IWingsExpandable{
	
	public SynapseWingsDelta() {
		super(WingsType.SYNAPSE_DELTA);
	}

	protected double getDirectSpeedMod(){return 0.3d;}
	protected double getInertialSpeedMod(){return 1.6d;}
	protected double getTotalSpeedMod(){return 0.5d;}

	@Override
	public float getExpansionFactor() {
		return 1.4f;
	}

	@Override
	protected Multimap<Attribute, net.minecraft.world.entity.ai.attributes.AttributeModifier> getModifiers() {
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	    builder.put(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR, new net.minecraft.world.entity.ai.attributes.AttributeModifier(MODIFIER_UUID, "Armor modifier", 3,	net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADDITION));
	    builder.put(Attributes.ARMOR_TOUGHNESS, new net.minecraft.world.entity.ai.attributes.AttributeModifier(MODIFIER_UUID, "Armor toughness", 1, AttributeModifier.Operation.ADDITION));
	    builder.put(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, new net.minecraft.world.entity.ai.attributes.AttributeModifier(MODIFIER_UUID, "movement_speed", 0.03f, AttributeModifier.Operation.ADDITION));
		return builder.build();
	}
	
}
