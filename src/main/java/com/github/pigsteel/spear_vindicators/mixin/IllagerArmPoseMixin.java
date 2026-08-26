package com.github.pigsteel.spear_vindicators.mixin;

import net.minecraft.world.entity.monster.illager.AbstractIllager;
import org.spongepowered.asm.mixin.Mixin;

//? fabric {
@Mixin(AbstractIllager.IllagerArmPose.class)
public enum IllagerArmPoseMixin {
	VINDICATORS_USE_SPEARS_SPEAR
}
//?} neoforge {


//?}
