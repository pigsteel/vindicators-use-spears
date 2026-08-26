package com.github.pigsteel.spear_vindicators.mixin.client;

import com.github.pigsteel.spear_vindicators.util.EnumExtensions;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.effects.SpearAnimations;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.monster.illager.IllagerModel;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IllagerModel.class)
public class IllagerModelMixin<S extends IllagerRenderState> extends EntityModel<S> {
	@Shadow
	@Final
	private ModelPart head;

	@Shadow
	@Final
	private ModelPart rightArm;

	@Shadow
	@Final
	private ModelPart leftArm;

	protected IllagerModelMixin(ModelPart root) {
		super(root);
	}

	@Inject(
			method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/IllagerRenderState;)V",
			at = @At("TAIL")
	)
	public void addSpearAnimation(S state, CallbackInfo ci) {
		AbstractIllager.IllagerArmPose pose = state.armPose;

		if(pose.equals(EnumExtensions.SPEAR)) {
			if(state.mainArm == HumanoidArm.RIGHT) {
				SpearAnimations.thirdPersonHandUse(this.rightArm, this.head, true, state.getUseItemStackForArm(HumanoidArm.RIGHT), state);
			} else {
				SpearAnimations.thirdPersonHandUse(this.leftArm, this.head, false, state.getUseItemStackForArm(HumanoidArm.LEFT), state);
			}
		}
	}
}
