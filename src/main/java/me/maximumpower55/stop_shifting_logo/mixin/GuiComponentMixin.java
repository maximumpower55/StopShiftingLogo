package me.maximumpower55.stop_shifting_logo.mixin;

import java.util.function.BiConsumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.maximumpower55.stop_shifting_logo.StopShiftingLogo;
import net.minecraft.client.gui.GuiComponent;

@Mixin(GuiComponent.class)
public abstract class GuiComponentMixin {
    @Inject(method = "blitOutlineBlack", at = @At(value = "HEAD"), cancellable = true)
    private void stop_shifting_logo$stopOutlineBlit(int width, int height, BiConsumer<Integer, Integer> boxXYConsumer, CallbackInfo ci) {
        if (!StopShiftingLogo.noOutlineBlit) return;
        boxXYConsumer.accept(width, height);
        StopShiftingLogo.noOutlineBlit = false;
        ci.cancel();
    }
}
