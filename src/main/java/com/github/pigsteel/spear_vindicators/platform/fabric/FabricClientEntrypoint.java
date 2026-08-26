package com.github.pigsteel.spear_vindicators.platform.fabric;

//? fabric {

import com.github.pigsteel.spear_vindicators.SpearVindicators;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SpearVindicators.onInitializeClient();
	}

}
//?}
