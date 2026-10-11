package net.necromancer.mod.entity;

public class NecroSkeletonStats {

private SkeletonClass skeletonClass;
private int level = 1;
private int experience = 0;
private int experienceToNextLevel = 20;

private float maxHealth;
private float attackDamage;
private float armor;
private float speed;
private float currentHealth;

public void damage(float amount) {
currentHealth -= amount;
if (currentHealth < 0) currentHealth = 0;
}

public boolean isDead() {
return currentHealth <= 0;
}

public float getCurrentHealth() {
return currentHealth;
}

public NecroSkeletonStats(SkeletonClass skeletonClass, float powerMultiplier) {
this.skeletonClass = skeletonClass;
applyBaseStats(powerMultiplier);
currentHealth = maxHealth;
}

private void applyBaseStats(float powerMultiplier) {
switch (skeletonClass) {
case WARRIOR:
maxHealth = 20f * powerMultiplier;
attackDamage = 5f * powerMultiplier;
armor = 2f * powerMultiplier;
speed = 1.0f;
break;
case ARCHER:
maxHealth = 14f * powerMultiplier;
attackDamage = 4f * powerMultiplier;
armor = 0f;
speed = 1.1f;
break;
case TANK:
maxHealth = 35f * powerMultiplier;
attackDamage = 3f * powerMultiplier;
armor = 6f * powerMultiplier;
speed = 0.8f;
break;
case MAGE:
maxHealth = 12f * powerMultiplier;
attackDamage = 6f * powerMultiplier;
armor = 0f;
speed = 1.0f;
break;
}
}

public void addExperience(int amount) {
experience += amount;
while (experience >= experienceToNextLevel) {
experience -= experienceToNextLevel;
levelUp();
}
}

private void levelUp() {
level++;
experienceToNextLevel = (int) (experienceToNextLevel * 1.3f);

maxHealth *= 1.1f;
attackDamage *= 1.1f;
armor *= 1.05f;
}

public SkeletonClass getSkeletonClass() { return skeletonClass; }
public int getLevel() { return level; }
public float getMaxHealth() { return maxHealth; }
public float getAttackDamage() { return attackDamage; }
public float getArmor() { return armor; }
public float getSpeed() { return speed; }
}
