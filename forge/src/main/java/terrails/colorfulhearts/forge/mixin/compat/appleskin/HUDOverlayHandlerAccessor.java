package terrails.colorfulhearts.forge.mixin.compat.appleskin;

import org.jetbrains.annotations.Contract;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import squeek.appleskin.client.HUDOverlayHandler;

@Mixin(value = HUDOverlayHandler.class, remap = false)
public interface HUDOverlayHandlerAccessor {

    @Contract
    @Accessor static float getFlashAlpha() {
        throw new AssertionError();
    }
}
