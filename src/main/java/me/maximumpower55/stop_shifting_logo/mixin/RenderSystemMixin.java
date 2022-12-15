package me.maximumpower55.stop_shifting_logo.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.systems.RenderSystem;

import me.maximumpower55.stop_shifting_logo.StopShiftingLogo;
import net.minecraft.resources.ResourceLocation;

@Mixin(RenderSystem.class)
public abstract class RenderSystemMixin {
    @Inject(method = "_setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", at = @At("HEAD"))
    private static void stop_shifting_logo$detectLogoTexture(int textureUnit, ResourceLocation textureId, CallbackInfo ci) {
        StopShiftingLogo.noOutlineBlit = textureId.getPath() == TitleScreenAccessor.stop_shifting_logo$getLogo().getPath();
    }
}
