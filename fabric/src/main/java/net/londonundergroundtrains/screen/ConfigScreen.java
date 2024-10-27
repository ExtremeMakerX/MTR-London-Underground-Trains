package net.londonundergroundtrains.screen;

import com.terraformersmc.modmenu.gui.ModsScreen;
import org.mtr.mapping.holder.ClickableWidget;
import org.mtr.mapping.holder.MinecraftClient;
import org.mtr.mapping.holder.Screen;
import org.mtr.mapping.holder.Text;
import org.mtr.mapping.mapper.*;
import org.mtr.mod.client.IDrawing;
import org.mtr.mod.data.IGui;

public class ConfigScreen extends ScreenExtension implements IGui {

    private final CheckboxWidgetExtension trainsComplementaryReimaginedSupport;
    private final ButtonWidgetExtension buttonDone;

    public ConfigScreen() {
        super();
        trainsComplementaryReimaginedSupport = new CheckboxWidgetExtension(0, 0, 0, 20, true, checked -> {
        });
        buttonDone = new ButtonWidgetExtension(0, 0, 0, 20, TextHelper.translatable("gui.londonundergroundtrains.done"), button -> onClose2());
        trainsComplementaryReimaginedSupport.setMessage2(Text.cast(TextHelper.literal("Trains Complementary Reimagined Support")));
    }

    @Override
    public void init2() {
        super.init2();

        IDrawing.setPositionAndWidth(trainsComplementaryReimaginedSupport, width / 2, 40, 20);
        IDrawing.setPositionAndWidth(buttonDone, width / 2 - 80, height - 80, 160);

        addChild(new ClickableWidget(buttonDone));
        addChild(new ClickableWidget(trainsComplementaryReimaginedSupport));
    }

    @Override
    public void render(GraphicsHolder graphicsHolder, int mouseX, int mouseY, float delta) {
        renderBackground(graphicsHolder);
        graphicsHolder.drawCenteredText("LU Trains Options", width / 2, TEXT_PADDING, ARGB_WHITE);
        super.render(graphicsHolder, mouseX, mouseY, delta);
    }

    @Override
    public void onClose2() {
        MinecraftClient.getInstance().openScreen(new Screen(new ModsScreen(this)));
    }
}
