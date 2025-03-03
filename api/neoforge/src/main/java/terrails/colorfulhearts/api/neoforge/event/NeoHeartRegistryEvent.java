package terrails.colorfulhearts.api.neoforge.event;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import terrails.colorfulhearts.api.event.HeartRegistry;
import terrails.colorfulhearts.api.heart.drawing.OverlayHeart;

/**
 * Used to register custom heart types. Currently, it can only be used to register overlay hearts.
 * IMPORTANT: Make sure to register an event listener on the mod-loader bus and not on the regular Neo bus
 *              as the event is run before the regular event bus is initialized
 */
public class NeoHeartRegistryEvent extends Event implements IModBusEvent {

    private final HeartRegistry registry;

    public NeoHeartRegistryEvent(HeartRegistry registry) {
        this.registry = registry;
    }

    public <T extends OverlayHeart> T registerOverlayHeart(T heart) {
        return this.registry.registerOverlayHeart(heart);
    }
}
