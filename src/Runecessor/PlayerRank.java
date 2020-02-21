package Runecessor;

/**
 * Easy way to edit player rank icons.
 * @author Lava, created on 18-01-206.
 */
public class PlayerRank {
	public static String getIconText(int rank) {
		if (rank == 0) {
			return "";
		}
		else {
			return "<img=" + rank + ">";
		}
	}

	public static int getClanWidth(int rank) {
		switch (rank) {
			case 3:
			case 4:
			case 5:
			case 6:
			case 22:
			case 7:
			case 23:
				return 9;


			case 24:
			case 34 :
			case 35 :
			case 36 :
				return 15;

			case 9: //ironman
			case 26: //hardcore
				return 11;
			case 27: //lottery
			case 28:
				return 12;

			case 25: //ulti
			case 10:
			case 1:
			case 2:
			case 30:
			case 31:
			case 33:
			case 20:
			case 11:
			case 32:
			case 17:
			case 29:	
				return 14;
			case 8:
			case 21:
				return 15;
		}
		return 0;
	}

	public static void drawClanIcon(Client client, int rank, int j2, int yPos) {
		if (rank == 0) {
			return;
		}
		Client.instance.crown[rank].drawSprite(j2 - 16, yPos - 11);
	}

	/**
	 * X position of the lower part of the chat that shows my own name and the text i'm typing.
	 */
	public static int getMyChatX(int playerRights) {
		if (playerRights == 1 || playerRights == 2 || playerRights == 31 || playerRights == 33) {
			return 13;
		}
		else if (playerRights == 3 || playerRights == 22) {
			return 8;
		}
		else if (playerRights == 4) {
			return 8;
		}
		else if (playerRights == 5) {
			return 8;
		}
		else if (playerRights == 6) {
			return 8;
		}
		else if (playerRights == 23) {
			return 8;
		}
		else if (playerRights == 9 || playerRights == 26) //ironman, ulti, hardcore
		{
			return 10;
		}
		else if (playerRights == 25 || playerRights == 30 || playerRights == 32 || playerRights == 29 || playerRights == 17 || playerRights == 20 || playerRights == 11) {
			return 14;
		}
		else if (playerRights == 10) {
			return 13;
		}
		else if (playerRights == 7) {
			return 8;
		}
		switch (playerRights) {
			case 21 :
			case 24 :
			case 28 :
			case 34 :
			case 35 :
			case 36 :
				return 14;
		}
		return 0;
	}

	/**
	 * Draw the icons on the lower part of the chat that shows my own name and the text i'm typing.
	 */
	public static void drawMyChatIcon(int playerRights, int yPosOffset) {
		if (playerRights == 0) {
			return;
		}
		Client.instance.crown[playerRights].drawSprite(11, 122 + yPosOffset);
	}

}
