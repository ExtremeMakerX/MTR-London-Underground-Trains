package net.londonundergroundtrains.init;

import net.fabricmc.api.ModInitializer;
import net.londonundergroundtrains.mod.Init;

public class MainFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		Init.init();
	}
}
