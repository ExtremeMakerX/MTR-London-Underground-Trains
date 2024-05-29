package net.londonundergroundtrains.mod;

import org.mtr.mapping.registry.RegistryClient;

public final class InitClient {

	public static final RegistryClient REGISTRY_CLIENT = new RegistryClient(Init.REGISTRY);

	public static void init() {

		REGISTRY_CLIENT.init();
	}
}
