package derp.tpsounds.mixin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

@Mixin(EnderPearlEntity.class)
public abstract class EnderPearlEntityMixin {
	@Inject(method = "onCollision", at = @At("HEAD"))
	private void playSoundOnCollision(HitResult hitResult, CallbackInfo ci) {
		World world = ((EnderPearlEntity)(Object)this).world;
		if (!world.isClient) {
			ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
			scheduler.schedule(() -> {
				world.playSound(null, ((EnderPearlEntity)(Object)this).getX(), ((EnderPearlEntity)(Object)this).getY(), ((EnderPearlEntity)(Object)this).getZ(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
				scheduler.shutdown();
			}, 100, TimeUnit.MILLISECONDS);
		}
	}
}



