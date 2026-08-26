package com.github.pigsteel.spear_vindicators.platform.fabric;

//? fabric {

import com.github.pigsteel.spear_vindicators.SpearVindicators;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		SpearVindicators.onInitialize();
	}
}
//?}
