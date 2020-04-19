package com.avatarduel.phase;

import com.avatarduel.cards.*;
import com.avatarduel.gui.CardViewer;

public abstract class Phase {

	public Boolean resetPower;
	public Boolean canDraw;
	public Boolean canRemove;
	public Boolean canUseCard;
	public Boolean drawBtn;
	public Boolean mainBtn;
	public Boolean battleBtn;
	public Boolean endturnBtn;
	
	public Boolean canAttack;

	public Boolean skillActive;
	public Boolean attackActive;

	public Boolean destroyActive;

	public Boolean powerupActive;

	public SkillCard activeSkill;
	public CharacterCard activeAttackingCard;
	public CardViewer activeAttackingCardViewer;
}
