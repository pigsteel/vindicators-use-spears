package com.github.pigsteel.spear_vindicators.util;

import net.minecraft.world.entity.monster.illager.AbstractIllager;

public class EnumExtensions {
	public static final AbstractIllager.IllagerArmPose SPEAR;

	static {
		//? fabric {
		SPEAR = AbstractIllager.IllagerArmPose.VINDICATORS_USE_SPEARS_SPEAR;
		//?} neoforge {
		/*SPEAR = AbstractIllager.IllagerArmPose.valueOf("VINDICATORS_USE_SPEARS_SPEAR");
		*///?}
	}

	public static void load() {}
}
