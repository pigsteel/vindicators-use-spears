package com.github.pigsteel.spear_vindicators.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.VindicatorRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(VindicatorRenderer.class)
public abstract class VindicatorRendererMixin {

	@WrapOperation(
			method = "<init>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/renderer/entity/VindicatorRenderer;addLayer(Lnet/minecraft/client/renderer/entity/layers/RenderLayer;)Z"
			)
	)
	private boolean animateUseSpear(VindicatorRenderer instance, RenderLayer renderLayer, Operation<Boolean> original) {
		return original.call(instance,
				new ItemInHandLayer<>(instance) {
					{
						Objects.requireNonNull(instance);
					}

					@Override
					public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, IllagerRenderState state, float yRot, float xRot) {
						if (state.isAggressive) {
							if (state.armPose.equals(AbstractIllager.IllagerArmPose.ATTACKING) && state.getMainHandItemStack().is(ItemTags.SPEARS)) {
								if (state.mainArm == HumanoidArm.RIGHT) {
									state.rightArmPose = HumanoidModel.ArmPose.SPEAR;
								} else {
									state.leftArmPose = HumanoidModel.ArmPose.SPEAR;
								}
							} else {
								if (state.mainArm == HumanoidArm.RIGHT) {
									state.rightArmPose = HumanoidModel.ArmPose.EMPTY;
								} else {
									state.leftArmPose = HumanoidModel.ArmPose.EMPTY;
								}
							}

							super.submit(poseStack, submitNodeCollector, lightCoords, state, yRot, xRot);
						}
					}
				}
		);
	}

}
