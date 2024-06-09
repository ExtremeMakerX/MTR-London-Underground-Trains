package net.londonundergroundtrains.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import mtr.mappings.ScreenMapper;
import mtr.mappings.Text;
import mtr.screen.WidgetBetterCheckbox;
import net.londonundergroundtrains.JSONChanger;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;

public class ConfigScreen extends ScreenMapper {
    private final WidgetBetterCheckbox trainsComplementaryReimaginedSupport;

    public ConfigScreen() {
        super(Component.literal("Config Screen"));
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
        //buttonDone = new ButtonExtender(0, 0, 0, 20, Text.translatable("gui.londonundergroundtrains.done"), button -> onClose(), DEFAULT_NARRATION);
    }

    @Override
    protected void init() {
        super.init();
        addRenderableWidget(trainsComplementaryReimaginedSupport);
        //addRenderableWidget(buttonDone);
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
