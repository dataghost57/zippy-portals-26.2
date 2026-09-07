package com.jacobray.zippyportals.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.NetherPortalBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NetherPortalBlock.class)
public class ExampleMixin {

	@Inject(
			method = "getPortalTransitionTime",
			at = @At("HEAD"),
			cancellable = true
	)
	private void zippyPortals$instantNetherPortal(
			ServerLevel level,
			Entity entity,
			CallbackInfoReturnable<Integer> cir
	) {
		cir.setReturnValue(0);
	}
}