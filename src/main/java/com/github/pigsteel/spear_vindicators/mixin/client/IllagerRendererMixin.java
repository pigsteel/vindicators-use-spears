package com.github.pigsteel.spear_vindicators.mixin.client;

import net.minecraft.client.model.monster.illager.IllagerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IllagerRenderer.class)
public abstract class IllagerRendererMixin<T extends AbstractIllager, S extends IllagerRenderState> extends MobRenderer<T, S, IllagerModel<S>> {

	public IllagerRendererMixin(EntityRendererProvider.Context context, IllagerModel<S> model, float shadow) {
		super(context, model, shadow);
	}

	@Inject(
			method = "extractRenderState(Lnet/minecraft/world/entity/monster/illager/AbstractIllager;Lnet/minecraft/client/renderer/entity/state/IllagerRenderState;F)V",
			at = @At("TAIL")
	)
	public void populateMissingRenderStateValues(T entity, S state, float partialTicks, CallbackInfo ci) {
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, itemModelResolver, partialTicks);
		state.useItemHand = entity.getUsedItemHand();
		state.isUsingItem = entity.isUsingItem();
	}
}
