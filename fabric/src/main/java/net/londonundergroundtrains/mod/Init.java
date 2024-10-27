package net.londonundergroundtrains.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mtr.mapping.registry.Registry;
import org.mtr.mapping.tool.DummyClass;

public final class Init {

	public static final String MOD_ID = "londonundergroundtrains";
	public static final Logger LOGGER = LogManager.getLogger("MTRLondonUndergroundTrains");
	public static final Registry REGISTRY = new Registry();

	public static void init() {
		DummyClass.enableLogging();
		REGISTRY.init();
	}
}
