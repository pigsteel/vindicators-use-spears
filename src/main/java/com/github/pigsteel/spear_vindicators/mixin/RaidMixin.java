package com.github.pigsteel.spear_vindicators.mixin;

import com.github.pigsteel.spear_vindicators.util.GiveVindicatorSpear;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Raid.class)
public class RaidMixin {

	@Inject(
			method = "spawnGroup",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/raid/Raider;startRiding(Lnet/minecraft/world/entity/Entity;ZZ)Z",
					shift = At.Shift.AFTER
			)
	)
	public void makeRiderVindicatorsUseSpears(ServerLevel level, BlockPos pos, CallbackInfo ci, @Local(name = "groupNumber") int groupNumber, @Local(name = "ridingRaider") Raider ridingRaider) {
		if(ridingRaider instanceof Vindicator vindicator && vindicator.getVehicle() instanceof Ravager) {
			GiveVindicatorSpear.apply(level, groupNumber, vindicator);
		}
	}
}
