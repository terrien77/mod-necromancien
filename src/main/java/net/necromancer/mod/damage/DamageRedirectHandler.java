package net.necromancer.mod.damage;

import net.necromancer.mod.component.NecromancerPlayerData;
import net.necromancer.mod.entity.NecroSkeletonStats;

public class DamageRedirectHandler {

public static float redirectDamage(NecromancerPlayerData playerData, float incomingDamage) {
if (!playerData.hasLivingSkeleton()) {
return incomingDamage;
}

NecroSkeletonStats target = playerData.getSummonedSkeletons().get(0);

target.damage(incomingDamage);

if (target.isDead()) {
playerData.removeDeadSkeleton(target);
}

return 0f;
}
}
