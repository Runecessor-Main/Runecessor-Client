package Runecessor;

public class PlayerTitle {
	public static String getTitleSpacing(String title) {
		if (title == null) {
			return "";
		}
		if (title.isEmpty()) {
			return "";
		}
		else {
			return " ";
		}
	}

	public static String reduceTextWidth(String string) {
		for (int b = 0; b < PlayerTitle.titleColours.length; b++) {
			if (string.contains(PlayerTitle.titleColours[b])) {
				string = string.replaceAll(PlayerTitle.titleColours[b], "");
			}
		}
		return string;
	}

	/**
	 * List of title colours, to also scan for title colours of other players, which is why we cannot use the player variable of titleColour.
	 */
	public final static String[] titleColours =
	{
		"<col=ED700E>", // Orange.
		"<col=ebebeb>", // Pale white.
		"<col=bb44aa>", // Purple.
		"<col=cb4ab9>",};

	public static String getLessStrikingColour(String titleColour) {
		switch (titleColour) {
			case "<col=ED700E>":
				return "<col=ED700E>";
			case "<col=bb44aa>":
				return "<col=cb4ab9>";
		}
		return "";
	}

	public static String rightClickPlayerString(Player player) {
		String title = player.playerTitle;
		if (Client.instance.atPlayerActions.length >= 3) {
			if (Client.instance.atPlayerActions[2] != null) {
				title = !Client.titlesInWild && Client.instance.atPlayerActions[2].equals("Attack") ? "" : player.playerTitle;
			}
		}
		if (player.titleSwap == 1) {
			return "<col=ebebeb>" + player.getName() + getTitleSpacing(title) + getLessStrikingColour(player.titleColour) + title;
		}
		else {
			return getLessStrikingColour(player.titleColour) + title + getTitleSpacing(title) + "<col=ebebeb>" + getIronManCrownText(player.privelage) + player.getName();
		}
	}

	private static String getIronManCrownText(int playerRights) {
		switch (playerRights) {
			case 9:
			case 25:
			case 26:
				return "<img=" + playerRights + ">";
		}
		return "";
	}

	public static String myNameInTextTypingArea(Player player) {
		String title = player.playerTitle;
		if (Client.instance.atPlayerActions.length >= 3) {
			if (Client.instance.atPlayerActions[2] != null) {
				title = !Client.titlesInWild && Client.instance.atPlayerActions[2].equals("Attack") ? "" : player.playerTitle;
			}
		}
		if (player.titleSwap == 1) {
			return "<col=00000>" + player.getName() + PlayerTitle.getTitleSpacing(title) + player.titleColour + title + "<col=00000>";
		}
		else {
			return player.titleColour + title + PlayerTitle.getTitleSpacing(title) + "<col=00000>" + player.getName();
		}
	}

	public static String myMessagesInMyChat(Player myPlayer) {
		String title = Client.myPlayer.playerTitle;
		if (Client.instance.atPlayerActions.length >= 3) {
			if (Client.instance.atPlayerActions[2] != null) {
				title = !Client.titlesInWild && Client.instance.atPlayerActions[2].equals("Attack") ? "" : Client.myPlayer.playerTitle;
			}
		}
		if (myPlayer.titleSwap == 1) {
			return "<col=0>" + Client.myPlayer.getName() + PlayerTitle.getTitleSpacing(title) + Client.myPlayer.titleColour + title + "<col=0>";
		}
		else {
			return Client.myPlayer.titleColour + title + PlayerTitle.getTitleSpacing(title) + "<col=0>" + Client.myPlayer.getName();
		}
	}

	public static String quickChatString(Player myPlayer) {
		String title = Client.myPlayer.playerTitle;
		if (Client.instance.atPlayerActions.length >= 3) {
			if (Client.instance.atPlayerActions[2] != null) {
				title = !Client.titlesInWild && Client.instance.atPlayerActions[2].equals("Attack") ? "" : Client.myPlayer.playerTitle;
			}
		}
		if (myPlayer.titleSwap == 1) {

			return "<col=0>" + Client.myPlayer.getName() + Client.myPlayer.titleColour + PlayerTitle.getTitleSpacing(title) + title + "<col=0>";
		}
		else {
			return Client.myPlayer.titleColour + title + PlayerTitle.getTitleSpacing(title) + "<col=0>" + Client.myPlayer.getName();
		}
	}

	public static String messagesOfOtherPlayers(Player player) {

		String title = player.playerTitle;
		if (Client.instance.atPlayerActions.length >= 3) {
			if (Client.instance.atPlayerActions[2] != null) {
				title = !Client.titlesInWild && Client.instance.atPlayerActions[2].equals("Attack") ? "" : player.playerTitle;
			}
		}
		if (player.titleSwap == 1) {
			return "<col=0>" + player.getName() + PlayerTitle.getTitleSpacing(title) + player.titleColour + title + "<col=0>";
		}
		else {
			return player.titleColour + title + PlayerTitle.getTitleSpacing(title) + "<col=0>" + player.getName();
		}

	}
}
