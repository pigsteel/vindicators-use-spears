package com.github.pigsteel.spear_vindicators;

import com.github.pigsteel.spear_vindicators.platform.Platform;

import com.github.pigsteel.spear_vindicators.util.EnumExtensions;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import com.github.pigsteel.spear_vindicators.platform.fabric.FabricPlatform;
//?} neoforge {
/*import com.github.pigsteel.spear_vindicators.platform.neoforge.NeoforgePlatform;
 *///?}

@SuppressWarnings("LoggingSimilarMessage")
public class SpearVindicators {

	public static final String MOD_ID = /*$ mod_id*/ "spear_vindicators";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		EnumExtensions.load();
	}

	public static void onInitializeClient() {
		EnumExtensions.load();
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?}
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
