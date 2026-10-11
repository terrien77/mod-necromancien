package net.necromancer.mod.component;

import net.necromancer.mod.entity.NecroSkeletonStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NecromancerPlayerData {

private final List<NecroSkeletonStats> summonedSkeletons = new ArrayList<>();

private final Map<String, Integer> skillMastery = new HashMap<>();
private final Map<String, Integer> skillExperience = new HashMap<>();

private float summonPowerMultiplier = 1.0f;

public List<NecroSkeletonStats> getSummonedSkeletons() {
return summonedSkeletons;
}

public void addSkeleton(NecroSkeletonStats skeleton) {
summonedSkeletons.add(skeleton);
}

public void removeDeadSkeleton(NecroSkeletonStats skeleton) {
summonedSkeletons.remove(skeleton);
}

public boolean hasLivingSkeleton() {
return !summonedSkeletons.isEmpty();
}

public float getSummonPowerMultiplier() {
return summonPowerMultiplier;
}

public int getMastery(String skillId) {
return skillMastery.getOrDefault(skillId, 0);
}

public void addSkillExperience(String skillId, int amount) {
int currentExp = skillExperience.getOrDefault(skillId, 0);
int currentMastery = skillMastery.getOrDefault(skillId, 0);
int expNeeded = 50 + currentMastery * 25;

currentExp += amount;
while (currentExp >= expNeeded) {
currentExp -= expNeeded;
currentMastery++;
expNeeded = 50 + currentMastery * 25;

if (skillId.equals("power_multiplier")) {
summonPowerMultiplier = 1.0f + (currentMastery * 0.15f);
}
}

skillExperience.put(skillId, currentExp);
skillMastery.put(skillId, currentMastery);
}
}
