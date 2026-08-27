package com.github.pigsteel.spear_vindicators.mixin;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.SpearUseGoal;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Vindicator.class)
public abstract class VindicatorMixin extends AbstractIllager {

	protected VindicatorMixin(EntityType<? extends Vindicator> type, Level level) {
		super(type, level);
	}

	@Inject(
			method = "registerGoals",
			at = @At("TAIL")
	)
	private void addSpearUseGoal(CallbackInfo ci) {
		this.goalSelector.addGoal(2, new SpearUseGoal<>(this, 1.0, 1.0, 10.0F, 2.0F));
	}

	@Inject(
			method = "getArmPose",
			at = @At("HEAD"),
			cancellable = true
	)
	public void getArmPoseSpear(CallbackInfoReturnable<IllagerArmPose> cir) {
		if (this.isAggressive() && this.getMainHandItem().is(ItemTags.SPEARS)) {
			//cir.setReturnValue(ArmPo);
		}
	}

}
