package com.jacobray.zippyportals.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Portal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.world.entity.PortalProcessor")
public class ExampleMixin {

	@Redirect(
			method = "processPortalTeleportation",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/Portal;getPortalTransitionTime(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Entity;)I"
			)
	)
	private int zippyPortals$instantPortal(
			Portal portal,
			ServerLevel level,
			Entity entity
	) {
		return 0;
	}
}