package org.mineplugin.locusazzurro.icaruswings.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.mineplugin.locusazzurro.icaruswings.data.WingsType;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber
public class FeatherWings extends AbstractWings {

	public FeatherWings(WingsType type) {
		super(type);
	}
	
	@Deprecated
	public FeatherWings() {
		this(WingsType.FEATHER);
	}

	@Override
	public boolean canElytraFly(net.minecraft.world.item.ItemStack stack, LivingEntity entity) {
		return entity.level.dimension() != Level.END;
	}

	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level.isClientSide() && (flightTicks + 1) % 20 == 0) {
			int dmg = 1;
			if ((entity instanceof Player) && (stack.getItem() instanceof FeatherWings)) {
				if (entity.level.dimension() == Level.NETHER) {
					dmg = 5;
					if(((FeatherWings)stack.getItem()).getType() != WingsType.FEATHER_GOLDEN)
					entity.setSecondsOnFire(10);
				}
				else {
					int y = (int) entity.getY();
					dmg = randomRound(Math.max(1, y / 64.0), entity.level.getRandom());
				}
			}
			stack.hurtAndBreak(dmg, entity,	e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
			return true;
		}
		return true;
	}

	int randomRound(double value, Random random) {
		int intValue = (int)Math.floor(value);
		if (random.nextDouble() < value - intValue) intValue++;
		return intValue;
	}


}
