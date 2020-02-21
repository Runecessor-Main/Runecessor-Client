package Runecessor;

/**
 * Handle all hitsplats.
 */
public class HitSplat {

	/**
	 * Draw the hitsplats.
	 * @param object
	 */
	public static void draw(Object object) {
		draw317HitSplat(object);
		draw562HitSplat(object);
		draw634HitSplat(object);
	}

	/**
	 * Draw the advanced settings behind the 634 hitsplats such as the fade/icon etc..
	 * @param object
	 */
	public static void hitmarkDraw(Entity e, int hitLength, int type, int icon, int damage, int soak, int move, int opacity, int mask) {
		int drawPos = 0;
		if (mask == 0) {
			e.hitMarkPos[0] = Client.spriteDrawY + move - 17;
			drawPos = e.hitMarkPos[0];
		}
		if (mask != 0) {
			e.hitMarkPos[mask] = e.hitMarkPos[0] + (19 * mask);
			drawPos = e.hitMarkPos[mask];
		}
		if (damage > 0) {
			Sprite end1 = null, middle = null, end2 = null;
			int x = 0;
			switch (hitLength) {
				case 1:
					x = 8;
					break;
				case 2:
					x = 4;
					break;
				case 3:
					x = 1;
					break;
			}
			end1 = Client.cacheSprite[424 + (type * 3)];
			middle = Client.cacheSprite[424 + (type * 3) + 1];
			end2 = Client.cacheSprite[424 + (type * 3) + 2];
			if (icon != 255) {
				Client.cacheSprite[457 + icon].drawTransparentSprite(Client.spriteDrawX - 34 + x, drawPos - 14, opacity);
			}
			end1.drawSprite3(Client.spriteDrawX - 12 + x, drawPos - 12, opacity);
			x += 4;
			for (int i = 0; i < hitLength * 2; i++) {
				middle.drawSprite3(Client.spriteDrawX - 12 + x, drawPos - 12, opacity);
				x += 4;
			}
			end2.drawSprite3(Client.spriteDrawX - 12 + x, drawPos - 12, opacity);
			(type == 1 ? Client.instance.bigHit : Client.instance.smallHit).drawOpacityText(0xffffff, String.valueOf(damage), drawPos + (type == 1 ? 2 : 32), Client.spriteDrawX + 4 + (soak > 0 ? -16 : 0), opacity);
		}
		else {
			Client.cacheSprite[463].drawSprite3(Client.spriteDrawX - 12, drawPos - 14, opacity);
		}
	}

	/**
	 * Draw the 317 hitsplats.
	 * @param object
	 */
	private static void draw317HitSplat(Object object) {
		if (!Client.hitsplatRevision("474")) {
			return;
		}
		for (int hitSplatIdentity = 0; hitSplatIdentity < 4; hitSplatIdentity++) {
			Entity entity = ((Entity) (object));
			long time = System.currentTimeMillis();
			if (time >= entity.hitsLoopCycleStartTime[hitSplatIdentity] && entity.hitsLoopCycleEndTime[hitSplatIdentity] > time) {
				Client.instance.npcScreenPos(entity, entity.height / 2, "");
				if (Client.spriteDrawX > -1) {
					switch (hitSplatIdentity) {
						case 0:
							if (entity.hitArray[0] == 0 && entity.hitArray[1] == 0) {
								Client.spriteDrawY += 4;
							}
							break;
						case 1:
							// If dds spec is both 0s, make them appear closer like RS.
							if (entity.hitArray[0] == 0 && entity.hitArray[1] == 0) {
								Client.spriteDrawY -= 15;
							}
							else {
								Client.spriteDrawY -= 18; // The position of the top hitsplat when dragon dagger special attacking.
							}
							break;
						case 2:
							Client.spriteDrawX -= 15;
							if (entity.hitArray[2] >= 100) {
								Client.spriteDrawX -= 10;
							}
							else if (entity.hitArray[2] > 9) {
								Client.spriteDrawX -= 5;
							}
							else if (entity.hitArray[2] == 0 && entity.hitArray[1] >= 100) {
								Client.spriteDrawX -= 8;
							}
							else if ((entity.hitArray[1] == 0 || entity.hitArray[0] == 0) && entity.hitArray[2] == 0) {
								Client.spriteDrawX -= 3;
							}

							if (entity.hitArray[1] == 0 && entity.hitArray[0] == 0) {
								Client.spriteDrawY += 3;
							}
							Client.spriteDrawY -= 10;
							break;
						case 3:
							Client.spriteDrawX += 15;
							if (entity.hitArray[hitSplatIdentity] > 99 && entity.hitArray[0] != 0 && entity.hitArray[1] != 0) {
								Client.spriteDrawX += 10;
							}
							else if (entity.hitArray[hitSplatIdentity] > 9) {
								Client.spriteDrawX += 5;
							}
							else if (entity.hitArray[3] == 0 && entity.hitArray[1] >= 100) {
								Client.spriteDrawX += 8;
							}
							else if ((entity.hitArray[1] == 0 || entity.hitArray[0] == 0) && entity.hitArray[3] == 0) {
								Client.spriteDrawX += 3;
							}

							if (entity.hitArray[1] == 0 && entity.hitArray[0] == 0) {
								Client.spriteDrawY += 3;
							}
							Client.spriteDrawY -= 10;
							break;
					}
					if (entity.hitMarkTypes[hitSplatIdentity] != 2 && entity.hitMarkTypes[hitSplatIdentity] != 6) // 2 = poison, 6 = venom.
					{
						if (entity.hitArray[hitSplatIdentity] > 0) {
							Client.instance.hitMarks[1].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 20);
						}
						else {
							Client.instance.hitMarks[0].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 20);
						}
					}
					else {
						Client.instance.hitMarks[entity.hitMarkTypes[hitSplatIdentity]].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 20); //poison
					}
					Client.instance.smallText.drawText(0, String.valueOf(entity.hitArray[hitSplatIdentity]), Client.spriteDrawY - 3, Client.spriteDrawX);
					Client.instance.smallText.drawText(0xffffff, String.valueOf(entity.hitArray[hitSplatIdentity]), Client.spriteDrawY - 4, (Client.spriteDrawX - 1));
				}
			}
		}
	}

	/**
	 * Draw the 562 hitsplats.
	 * @param object
	 */
	private static void draw562HitSplat(Object object) {
		if (!Client.hitsplatRevision("562") && !Client.hitsplatRevision("562+")) {
			return;
		}
		for (int hitSplatIdentity = 0; hitSplatIdentity < 4; hitSplatIdentity++) {
			Entity entity = ((Entity) (object));
			long time = System.currentTimeMillis();
			if (time >= entity.hitsLoopCycleStartTime[hitSplatIdentity] && entity.hitsLoopCycleEndTime[hitSplatIdentity] > time) {
				Client.instance.npcScreenPos(entity, entity.height / 2, "");
				if (Client.spriteDrawX > -1) {
					switch (hitSplatIdentity) {
						case 0:
							if (entity.hitArray[0] == 0 && entity.hitArray[1] == 0) {
								Client.spriteDrawY += 4;
							}
							break;
						case 1:
							// If dds spec is both 0s, make them appear closer like RS.
							if (entity.hitArray[0] == 0 && entity.hitArray[1] == 0) {
								Client.spriteDrawY -= 18;
							}
							else {
								Client.spriteDrawY -= 20; // The position of the top hitsplat when dragon dagger special attacking.
							}
							break;
						case 2:
							Client.spriteDrawX -= 15;
							if (entity.hitArray[2] >= 100) {
								Client.spriteDrawX -= 10;
							}
							else if (entity.hitArray[2] > 9) {
								Client.spriteDrawX -= 5;
							}
							else if (entity.hitArray[2] == 0 && entity.hitArray[1] >= 100) {
								Client.spriteDrawX -= 8;
							}
							else if ((entity.hitArray[1] == 0 || entity.hitArray[0] == 0) && entity.hitArray[2] == 0) {
								Client.spriteDrawX -= 3;
							}
							if (entity.hitArray[1] == 0 && entity.hitArray[0] == 0) {
								Client.spriteDrawY += 2;
							}
							Client.spriteDrawY -= 10;
							break;
						case 3:
							Client.spriteDrawX += 15;
							if (entity.hitArray[hitSplatIdentity] > 99 && entity.hitArray[0] != 0 && entity.hitArray[1] != 0) {
								Client.spriteDrawX += 10;
							}
							else if (entity.hitArray[hitSplatIdentity] > 9) {
								Client.spriteDrawX += 5;
							}
							else if (entity.hitArray[3] == 0 && entity.hitArray[1] >= 100) {
								Client.spriteDrawX += 8;
							}
							else if ((entity.hitArray[1] == 0 || entity.hitArray[0] == 0) && entity.hitArray[3] == 0) {
								Client.spriteDrawX += 3;
							}
							if (entity.hitArray[1] == 0 && entity.hitArray[0] == 0) {
								Client.spriteDrawY += 2;
							}
							Client.spriteDrawY -= 10;
							break;
					}
					if (entity.hitMarkTypes[hitSplatIdentity] != 2 && entity.hitMarkTypes[hitSplatIdentity] != 6) // 2 = poison, 6 = venom
					{
						if (entity.hitArray[hitSplatIdentity] > 0) // Damage more than 0.
						{
							if (entity.hitArray[hitSplatIdentity] >= 100) // Damage more than or equal to 100.
							{
								Client.cacheSprite[467].draw24BitSprite(Client.spriteDrawX - 20, Client.spriteDrawY - 19); // Postion of a single damage hitsplat (the red part) not the text.
							}
							else {
								Client.cacheSprite[465].draw24BitSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 19);
							}
						}
						else {
							Client.cacheSprite[464].draw24BitSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 19);
						}
					}
					else {
						Client.cacheSprite[entity.hitMarkTypes[hitSplatIdentity] == 2 ? 466 : 1003].draw24BitSprite(Client.spriteDrawX - 10, Client.spriteDrawY - 22);
					}
					if (!Client.hitsplatRevision("562+")) {
						Client.instance.smallText.drawText(0, String.valueOf(entity.hitArray[hitSplatIdentity]), Client.spriteDrawY - 2, Client.spriteDrawX);
					}
					Client.instance.smallText.drawText(0xffffff, String.valueOf(entity.hitArray[hitSplatIdentity]), Client.spriteDrawY - 3, (Client.spriteDrawX - 1));
				}
			}
		}
	}

	/**
	 * Draw the 634 hitsplats.
	 * @param object
	 */
	private static void draw634HitSplat(Object object) {
		if (!Client.hitsplatRevision("634")) {
			return;
		}

		for (int hitSplatIdentity = 0; hitSplatIdentity < 4; hitSplatIdentity++) {
			Entity entity = ((Entity) (object));
			long time = System.currentTimeMillis();
			if (time >= entity.hitsLoopCycleStartTime[hitSplatIdentity] && entity.hitsLoopCycleEndTime[hitSplatIdentity] > time) {
				Client.instance.npcScreenPos(entity, entity.height / 2, "");
				if (Client.spriteDrawX > -1) {
					if (entity.moveTimer[hitSplatIdentity] == 0) {
						if (entity.hitmarkMove[hitSplatIdentity] > -6 && System.currentTimeMillis() - entity.fadeAppliedTime[hitSplatIdentity] > 50) {
							entity.hitmarkMove[hitSplatIdentity]--;
							entity.fadeAppliedTime[hitSplatIdentity] = System.currentTimeMillis();
						}
						entity.moveTimer[hitSplatIdentity] = 2;
					}
					else {
						entity.moveTimer[hitSplatIdentity]--;
					}
					if (System.currentTimeMillis() - entity.hitSplatAppliedTime[hitSplatIdentity] >= 750) {
						entity.hitmarkTrans[hitSplatIdentity] -= 21;
					}
					if (entity.hitmarkTrans[hitSplatIdentity] < 0) {
						entity.hitmarkTrans[hitSplatIdentity] = 0;
					}
					hitmarkDraw(entity, String.valueOf(entity.hitArray[hitSplatIdentity]).length(), entity.hitMarkTypes[hitSplatIdentity], entity.hitIcon[hitSplatIdentity], entity.hitArray[hitSplatIdentity], entity.soakDamage[hitSplatIdentity], entity.hitmarkMove[hitSplatIdentity], entity.hitmarkTrans[hitSplatIdentity], hitSplatIdentity);
				}
			}
		}
	}
}