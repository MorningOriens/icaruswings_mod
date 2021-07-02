package org.mineplugin.locusazzurro.icaruswings.render;

import org.mineplugin.locusazzurro.icaruswings.data.Utils;
import org.mineplugin.locusazzurro.icaruswings.items.AbstractWings;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WingsLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {
	
	private static final ResourceLocation WINGS_FEATHER = new ResourceLocation(Utils.MOD_ID, "textures/entity/feather_wings.png");

	public WingsLayer(IEntityRenderer<T, M> renderIn) {
		super(renderIn);
	}
	
	@Override
	public boolean shouldRender(ItemStack stack, T entity) {
	    return (stack.getItem() instanceof AbstractWings);
	}
	
	@Override
	public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
		Item item = stack.getItem();
		if (item instanceof AbstractWings)
		{
			return ((AbstractWings) item).getType().getTexture();
		}
		return WINGS_FEATHER;
	}
	
	@Override
	public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_)
	{
		super.render(p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_7_, p_225628_8_, p_225628_9_, p_225628_10_);
	}

}