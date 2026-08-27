package com.github.pigsteel.spear_vindicators.mixin.client;

import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.client.renderer.entity.state.UndeadRenderState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(IllagerRenderState.class)
public class IllagerRenderStateMixin extends UndeadRenderState {
	@Shadow
	public float ticksUsingItem;

	@Override
	public float ticksUsingItem(final HumanoidArm arm) {
		return this.isUsingItem && this.useItemHand == InteractionHand.MAIN_HAND == (arm == this.mainArm) ? this.ticksUsingItem : 0.0F;
	}
}
