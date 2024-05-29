package net.londonundergroundtrains.init;

import net.fabricmc.api.ClientModInitializer;
import net.londonundergroundtrains.mod.InitClient;

public class MainFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		InitClient.init();
	}
}
