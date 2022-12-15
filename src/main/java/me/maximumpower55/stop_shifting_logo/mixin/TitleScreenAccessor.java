package me.maximumpower55.stop_shifting_logo.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.resources.ResourceLocation;

@Mixin(TitleScreen.class)
public interface TitleScreenAccessor {
    @Accessor("MINECRAFT_LOGO")
    static ResourceLocation stop_shifting_logo$getLogo() {
        throw new AbstractMethodError();
    }
}
