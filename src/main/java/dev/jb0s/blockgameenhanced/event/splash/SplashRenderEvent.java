package dev.jb0s.blockgameenhanced.event.splash;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.util.ActionResult;

public interface SplashRenderEvent {
    Event<SplashRenderEvent> EVENT = EventFactory.createArrayBacked(SplashRenderEvent.class, (listeners) -> (splash, matrices, mouseX, mouseY, delta) -> {
        for (SplashRenderEvent listener : listeners) {
            ActionResult x = listener.render(splash, matrices, mouseX, mouseY, delta);
            if(x != ActionResult.PASS) return x;
        }
        return ActionResult.PASS;
    });

    ActionResult render(SplashOverlay splash, MatrixStack matrices, int mouseX, int mouseY, float delta);
}
