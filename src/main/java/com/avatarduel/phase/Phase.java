package com.avatarduel.phase;

import com.avatarduel.cards.*;

public abstract class Phase {

	public Boolean resetPower;
	public Boolean canDraw;
	public boolean canUseCard;
	public Boolean drawBtn;
	public Boolean mainBtn;
	public Boolean battleBtn;
	public Boolean endturnBtn;
	
	public Boolean canAttack;

	public Boolean skillActive;

	public Boolean destroyActive;

	public SkillCard activeSkill;
}
