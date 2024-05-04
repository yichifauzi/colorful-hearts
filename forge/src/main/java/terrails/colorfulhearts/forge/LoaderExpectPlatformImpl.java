package terrails.colorfulhearts.forge;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoader;
import terrails.colorfulhearts.CColorfulHearts;
import terrails.colorfulhearts.api.event.HeartRenderEvent;
import terrails.colorfulhearts.api.event.HeartRegistry;
import terrails.colorfulhearts.forge.api.event.ForgeHeartUpdateEvent;
import terrails.colorfulhearts.forge.api.event.ForgeHeartRegistryEvent;
import terrails.colorfulhearts.forge.api.event.ForgeHeartRenderEvent;
import terrails.colorfulhearts.api.heart.drawing.StatusEffectHeart;

import static terrails.colorfulhearts.CColorfulHearts.LOGGER;

public class LoaderExpectPlatformImpl {

    public static String getLoader() {
        return "forge";
    }

    public static void applyConfig() {
        ColorfulHearts.CONFIG_SPEC.save();
        LOGGER.debug("Successfully saved changes to {} config file.", CColorfulHearts.MOD_ID + ".toml");
    }

    public static boolean forcedHardcoreHearts() {
        return false;
    }

    public static HeartRenderEvent.Pre preRenderEvent(GuiGraphics guiGraphics, int x, int y, boolean blinking, boolean hardcore, StatusEffectHeart effectHeart) {
        ForgeHeartRenderEvent.Pre event = new ForgeHeartRenderEvent.Pre(guiGraphics, x, y, blinking, hardcore, effectHeart);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getEvent();
    }

    public static void postRenderEvent(GuiGraphics guiGraphics, int x, int y, boolean blinking, boolean hardcore, StatusEffectHeart effectHeart) {
        MinecraftForge.EVENT_BUS.post(new ForgeHeartRenderEvent.Post(guiGraphics, x, y, blinking, hardcore, effectHeart));
    }

    public static void heartRegistryEvent(HeartRegistry registry) {
        ModLoader.get().postEvent(new ForgeHeartRegistryEvent(registry));
    }

    public static void heartUpdateEvent() {
        MinecraftForge.EVENT_BUS.post(new ForgeHeartUpdateEvent());
    }
}
