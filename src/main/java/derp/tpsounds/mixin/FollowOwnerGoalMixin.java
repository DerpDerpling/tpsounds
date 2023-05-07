package derp.tpsounds.mixin;

import derp.tpsounds.TPSounds;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(FollowOwnerGoal.class)
public abstract class FollowOwnerGoalMixin<T extends TameableEntity> {
    @Shadow
    protected T tameable;

    @Inject(method = "tryTeleportTo", at = @At("RETURN"))
    private void playTeleportSound(int x, int y, int z, CallbackInfoReturnable<Boolean> ci) {
        if (ci.getReturnValue()) {
            this.tameable.getEntityWorld().playSound(null, this.tameable.getBlockPos(), TPSounds.PETWARP, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }
}
