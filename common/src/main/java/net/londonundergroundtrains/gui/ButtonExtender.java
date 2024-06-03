package net.londonundergroundtrains.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class ButtonExtender extends Button {

    public ButtonExtender(int i, int j, int k, int l, Component component, OnPress onPress, CreateNarration createNarration) {
        super(i, j, k, l, component, onPress, createNarration);
    }
}
