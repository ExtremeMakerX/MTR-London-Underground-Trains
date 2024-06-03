package net.londonundergroundtrains.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import mtr.mappings.Text;
import mtr.screen.WidgetBetterCheckbox;
import net.londonundergroundtrains.JSONChanger;
import net.londonundergroundtrains.client.WidgetSetter;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.function.Supplier;

public class ConfigScreen extends Screen {
    private WidgetBetterCheckbox trainsComplementaryReimaginedSupport;
    private ButtonExtender buttonDone;
    public static final Button.CreateNarration DEFAULT_NARRATION = Supplier::get;

    public ConfigScreen(Component component) {
        super(component);
    }

    public ConfigScreen() {
        this(Component.literal("Config Screen"));
        trainsComplementaryReimaginedSupport = new WidgetBetterCheckbox(0, 0, 0, 20, Text.translatable("gui.londonundergroundtrains.trains_complementary_reimagined_support"), checked -> {
        if (checked) {
            try {
                JSONChanger.enableLUComplementaryReimagined();
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                JSONChanger.disableLUComplementaryReimagined();
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        });
        buttonDone = new ButtonExtender(0, 0, 0, 20, Text.translatable("gui.londonundergroundtrains.done"), button -> onClose(), DEFAULT_NARRATION);
    }

    @Override
    protected void init() {
        super.init();
        WidgetSetter.setAdjustableWidget(trainsComplementaryReimaginedSupport, width / 2, 40, 20);
        WidgetSetter.setAdjustableWidget(buttonDone, width / 2 - 80, height - 80, 160);
        addRenderableWidget(trainsComplementaryReimaginedSupport);
        addRenderableWidget(buttonDone);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int i, int j, float f) {
        renderBackground(poseStack);
        drawCenteredString(poseStack, font, Text.translatable("gui.londonundergroundtrains_options"), width / 2, 12, -1);
        super.render(poseStack, i, j, f);
    }

    @Override
    public void onClose() {
        super.onClose();
    }
}
