package com.github.pigsteel.spear_vindicators.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.providers.EnchantmentProvider;
import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;

public class GiveVindicatorSpear {
	public static void apply(final ServerLevel level, final int wave, final Vindicator vindicator) {
		ItemStack spear = new ItemStack(Items.DIAMOND_SPEAR);
		Raid raid = vindicator.getCurrentRaid();
		boolean shouldEnchant = vindicator.getRandom().nextFloat() <= raid.getEnchantOdds();
		if (shouldEnchant) {
			ResourceKey<EnchantmentProvider> provider = wave > raid.getNumGroups(Difficulty.NORMAL) ? VanillaEnchantmentProviders.RAID_VINDICATOR_POST_WAVE_5 : VanillaEnchantmentProviders.RAID_VINDICATOR;
			EnchantmentHelper.enchantItemFromProvider(spear, level.registryAccess(), provider, level.getCurrentDifficultyAt(vindicator.blockPosition()), vindicator.getRandom());
		}

		vindicator.setItemSlot(EquipmentSlot.MAINHAND, spear);
	}
}
