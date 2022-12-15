package me.maximumpower55.stop_shifting_logo;

import java.util.function.BiConsumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.screens.TitleScreen;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/TitleScreen;blitOutlineBlack(IILjava/util/function/BiConsumer;)V"))
    private void stopShift(TitleScreen self, int i, int j, BiConsumer<Integer, Integer> biConsumer) {
        biConsumer.accept(i, j);
    }
}
