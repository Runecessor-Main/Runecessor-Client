package Runecessor;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;




// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Decompiler options: packimports(3) 
public class RSInterface {

	public static void unpack(StreamLoader streamLoader, TextDrawingArea textDrawingAreas[],
			StreamLoader streamLoader_1) {
		fonts = textDrawingAreas;
		RSFont = textDrawingAreas;
		aMRUNodes_238 = new ReferenceCache(50000);
		Stream stream = new Stream(streamLoader.getDataForName("data"));
		int i = -1;
		@SuppressWarnings("unused")
		int j = stream.readUnsignedWord();
		interfaceCache = new RSInterface[45000];
		Client.instance.drawLoadingText(598, Client.loadingGameString());
		while (stream.currentOffset < stream.buffer.length) {
			int k = stream.readUnsignedWord();
			if (k == 65535) {
				i = stream.readUnsignedWord();
				k = stream.readUnsignedWord();
			}
			RSInterface rsInterface = interfaceCache[k] = new RSInterface();
			rsInterface.id = k;
			rsInterface.parentId = i;
			rsInterface.setType(stream.readUnsignedByte());
			rsInterface.atActionType = stream.readUnsignedByte();
			rsInterface.actionType = stream.readUnsignedWord();
			rsInterface.width = stream.readUnsignedWord();
			rsInterface.height = stream.readUnsignedWord();
			rsInterface.opacity = (byte) stream.readUnsignedByte();
			rsInterface.isMouseoverTriggered = stream.readUnsignedByte();
			if (rsInterface.isMouseoverTriggered != 0) {
				rsInterface.isMouseoverTriggered = (rsInterface.isMouseoverTriggered - 1 << 8)
						+ stream.readUnsignedByte();
			} else {
				rsInterface.isMouseoverTriggered = -1;
			}
			int i1 = stream.readUnsignedByte();
			if (i1 > 0) {
				rsInterface.scriptCompareType = new int[i1];
				rsInterface.scriptCompareValue = new int[i1];
				for (int j1 = 0; j1 < i1; j1++) {
					rsInterface.scriptCompareType[j1] = stream.readUnsignedByte();
					rsInterface.scriptCompareValue[j1] = stream.readUnsignedWord();
				}

			}
			int k1 = stream.readUnsignedByte();
			if (k1 > 0) {
				rsInterface.valueIndexArray = new int[k1][];
				for (int l1 = 0; l1 < k1; l1++) {
					int i3 = stream.readUnsignedWord();
					rsInterface.valueIndexArray[l1] = new int[i3];
					for (int l4 = 0; l4 < i3; l4++) {
						rsInterface.valueIndexArray[l1][l4] = stream.readUnsignedWord();
					}
				}

			}
			if (rsInterface.getType() == 0) {
				rsInterface.drawsTransparent = false;
				rsInterface.scrollMax = stream.readUnsignedWord();
				rsInterface.invisible = stream.readUnsignedByte() == 1;
				int i2 = stream.readUnsignedWord();
				rsInterface.children = new int[i2];
				rsInterface.childX = new int[i2];
				rsInterface.childY = new int[i2];
				for (int j3 = 0; j3 < i2; j3++) {
					rsInterface.children[j3] = stream.readUnsignedWord();
					rsInterface.childX[j3] = stream.readSignedWord();
					rsInterface.childY[j3] = stream.readSignedWord();
				}
			}
			if (rsInterface.getType() == 1) {
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			}
			if (rsInterface.getType() == 2) {
				rsInterface.inv = new int[rsInterface.width * rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
				rsInterface.itemsAreDraggable = stream.readUnsignedByte() == 1;
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.usableItemInterface = stream.readUnsignedByte() == 1;
				rsInterface.itemsAreSwappable = stream.readUnsignedByte() == 1;
				rsInterface.invSpritePadX = stream.readUnsignedByte();
				rsInterface.invSpritePadY = stream.readUnsignedByte();
				rsInterface.spritesX = new int[20];
				rsInterface.spritesY = new int[20];
				rsInterface.sprites = new Sprite[20];
				for (int j2 = 0; j2 < 20; j2++) {
					int k3 = stream.readUnsignedByte();
					if (k3 == 1) {
						rsInterface.spritesX[j2] = stream.readSignedWord();
						rsInterface.spritesY[j2] = stream.readSignedWord();
						String s1 = stream.readString();
						if (streamLoader_1 != null && s1.length() > 0) {
							int i5 = s1.lastIndexOf(",");
							rsInterface.sprites[j2] = method207(Integer.parseInt(s1.substring(i5 + 1)), streamLoader_1,
									s1.substring(0, i5));
						}
					}
				}
				rsInterface.actions = new String[5];
				for (int l3 = 0; l3 < 5; l3++) {
					rsInterface.actions[l3] = stream.readString();
					if (rsInterface.actions[l3].length() == 0) {
						rsInterface.actions[l3] = null;
					}
					if (rsInterface.parentId == 3824) {
						rsInterface.actions[4] = "Buy X";
					}

					if (rsInterface.parentId == 3822) {
						rsInterface.actions[4] = "Sell X";
					}
				}
				if (rsInterface.parentId == 1644) {
					rsInterface.actions[2] = "Operate";
				}
			}

			if (rsInterface.getType() == 3) {
				rsInterface.isFilled = stream.readUnsignedByte() == 1;
			}
			if (rsInterface.getType() == 4 || rsInterface.getType() == 1) {
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int k2 = stream.readUnsignedByte();
				if (textDrawingAreas != null) {
					rsInterface.textDrawingAreas = textDrawingAreas[k2];
				}
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
			}
			if (rsInterface.getType() == 4) {
				rsInterface.message = stream.readString();
				rsInterface.messageEnabled = stream.readString();
			}
			if (rsInterface.getType() == 1 || rsInterface.getType() == 3 || rsInterface.getType() == 4) {
				rsInterface.textColour = stream.readDWord();
				Music.modifyMusicTextColour(rsInterface);
			}
			if (rsInterface.getType() == 3 || rsInterface.getType() == 4) {
				rsInterface.colourEnabled = stream.readDWord();
				rsInterface.hoverColorDisabled = stream.readDWord();
				rsInterface.hoverColorEnabled = stream.readDWord();
				Music.addHoverToMusicInterface(rsInterface);
				if (rsInterface.id == 15234) // Strange place on music tab.
				{
					rsInterface.colourEnabled = 65280;
				}
			}
			if (rsInterface.getType() == 5) {
				rsInterface.drawsTransparent = false;
				String s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int i4 = s.lastIndexOf(",");
					rsInterface.sprite1 = method207(Integer.parseInt(s.substring(i4 + 1)), streamLoader_1,
							s.substring(0, i4));
				}
				s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int j4 = s.lastIndexOf(",");
					rsInterface.sprite2 = method207(Integer.parseInt(s.substring(j4 + 1)), streamLoader_1,
							s.substring(0, j4));

				}
			}
			if (rsInterface.getType() == 6) {
				int l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.modelTypeDisabled = 1;
					rsInterface.mediaID = (l - 1 << 8) + stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.modelTypeEnabled = 1;
					rsInterface.modelEnabled = (l - 1 << 8) + stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.sequenceDisabled = (l - 1 << 8) + stream.readUnsignedByte();
				} else {
					rsInterface.sequenceDisabled = -1;
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.sequenceEnabled = (l - 1 << 8) + stream.readUnsignedByte();
				} else {
					rsInterface.sequenceEnabled = -1;
				}
				rsInterface.modelZoom = stream.readUnsignedWord();
				rsInterface.modelRotationY = stream.readUnsignedWord();
				rsInterface.modelRotationX = stream.readUnsignedWord();
			}
			if (rsInterface.getType() == 7) {
				rsInterface.inv = new int[rsInterface.width * rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int l2 = stream.readUnsignedByte();
				if (textDrawingAreas != null) {
					rsInterface.textDrawingAreas = textDrawingAreas[l2];
				}
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
				rsInterface.textColour = stream.readDWord();
				rsInterface.invSpritePadX = stream.readSignedWord();
				rsInterface.invSpritePadY = stream.readSignedWord();
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.actions = new String[5];
				for (int k4 = 0; k4 < 5; k4++) {
					rsInterface.actions[k4] = stream.readString();
					if (rsInterface.actions[k4].length() == 0) {
						rsInterface.actions[k4] = null;
					}
				}
			}
			if (rsInterface.atActionType == 2 || rsInterface.getType() == 2) {
				rsInterface.selectedActionName = stream.readString();
				rsInterface.spellName = stream.readString();
				rsInterface.spellUsableOn = stream.readUnsignedWord();
				String green = "@gre@" + rsInterface.spellName + "@whi@";
				rsInterface.spellName = green;
			}

			if (rsInterface.getType() == 8) {
				rsInterface.message = stream.readString();
				/*
				 * Only thing it prints out To view your messages:\n1) Logout
				 * and return to the frontpage of this website.\n2) Choose 'Read
				 * your messages from Jagex'. To start or cancel a
				 * subscription:\n1) Logout and return to the frontpage of this
				 * website.\n2) Choose the relevant option from the 'membership'
				 * section.\n\nNote: If you are a credit card subscriber a
				 * top-up payment will\nautomatically be taken when 3 days
				 * credit remain.\n(unless you cancel your subscription, which
				 * can be done \nat any time.) To change your recovery
				 * questions:\n1) Logout and return to the frontpage of this
				 * website.\n2) Choose 'Set new recovery questions'.
				 */
			}

			if (rsInterface.atActionType == 1 || rsInterface.atActionType == 4 || rsInterface.atActionType == 5
					|| rsInterface.atActionType == 6) {
				rsInterface.tooltip = stream.readString();
				if (rsInterface.tooltip.length() == 0) {
					if (rsInterface.atActionType == 1) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 4) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 5) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 6) {
						rsInterface.tooltip = "Continue";
					}
				}
			}
		}
		Client.instance.drawLoadingText(640, Client.loadingGameString());
		aClass44 = streamLoader;
		Interfaces.customInterfaces(textDrawingAreas);
		aMRUNodes_238 = null;
		if (ClientDebugConfiguration.DEBUG_INTERFACES) {
			Collections.sort(RSInterface.interfaceIds);
			for (int p = 0; p < RSInterface.interfaceIds.size(); p++) {
				Utility.print("" + RSInterface.interfaceIds.get(p));
			}
		}
		if (RSInterface.interfaceCache[ClientDebugConfiguration.INTERFACE_DEFINITION_TO_DEBUG] != null
				&& ClientDebugConfiguration.INTERFACE_DEFINITION_TO_DEBUG > 0) {
			RSInterface data = RSInterface.interfaceCache[ClientDebugConfiguration.INTERFACE_DEFINITION_TO_DEBUG];
			String random = "waster" + "baster";
			Utility.print("---------Interface id debug of: " + ClientDebugConfiguration.INTERFACE_DEFINITION_TO_DEBUG);
			Utility.print("RSInterface.interfaceCache[" + random + "] = new RSInterface();");
			// String arrays
			if (data.actions != null) {
				Utility.print("RSInterface.interfaceCache[" + random + "].actions = new String[" + data.actions.length
						+ "];");
				for (int index = 0; index < data.actions.length; index++) {
					Utility.print("RSInterface.interfaceCache[" + random + "].actions[" + index + "] = "
							+ data.actions[index] + ";");
				}
			}
			if (data.tooltips != null) {
				Utility.print("RSInterface.interfaceCache[" + random + "].tooltips = new String[" + data.tooltips.length
						+ "];");
				for (int index = 0; index < data.tooltips.length; index++) {
					Utility.print("RSInterface.interfaceCache[" + random + "].tooltips[" + index + "] = "
							+ data.tooltips[index] + ";");
				}
			}
			if (data.children != null) {
				Utility.print("RSInterface.interfaceCache[" + random + "].children = new int[" + data.children.length + "];");
				Utility.print("RSInterface.interfaceCache[" + random + "].childX = new int[" + data.children.length + "];");
				Utility.print("RSInterface.interfaceCache[" + random + "].childY = new int[" + data.children.length + "];");
				for (int index = 0; index < data.children.length; index++) {
					Utility.print("RSInterface.interfaceCache[" + random + "].children[" + index + "] = "
							+ data.children[index] + ";");
					Utility.print("RSInterface.interfaceCache[" + random + "].childX[" + index + "] = "
							+ data.childX[index] + ";");
					Utility.print("RSInterface.interfaceCache[" + random + "].childY[" + index + "] = "
							+ data.childY[index] + ";");
					Utility.print("");
				}
			}
			if (data.inv != null) {
				Utility.print("RSInterface.interfaceCache[" + random + "].inv = new int[" + data.inv.length + "];");
				for (int index = 0; index < data.inv.length; index++) {
					Utility.print(
							"RSInterface.interfaceCache[" + random + "].inv[" + index + "] = " + data.inv[index] + ";");
					Utility.print("RSInterface.interfaceCache[" + random + "].invStackSizes[" + index + "] = "
							+ data.invStackSizes[index] + ";");
					Utility.print("");
				}
			}
			if (data.scriptCompareType != null) {
				Utility.print("RSInterface.interfaceCache[" + random + "].scriptCompareType = new int["
						+ data.scriptCompareType.length + "];");
				for (int index = 0; index < data.scriptCompareType.length; index++) {
					Utility.print("RSInterface.interfaceCache[" + random + "].scriptCompareType[" + index + "] = "
							+ data.scriptCompareType[index] + ";");
					Utility.print("RSInterface.interfaceCache[" + random + "].scriptCompareValue[" + index + "] = "
							+ data.scriptCompareValue[index] + ";");
					Utility.print("");
				}
			}
			if (data.spritesX != null) {
				Utility.print("RSInterface.interfaceCache[" + random + "].spritesX = new int[" + data.spritesX.length + "];");
				Utility.print("RSInterface.interfaceCache[" + random + "].spritesY = new int[" + data.spritesY.length + "];");
				for (int index = 0; index < data.spritesX.length; index++) {
					Utility.print("RSInterface.interfaceCache[" + random + "].spritesX[" + index + "] = " + data.spritesX[index] + ";");
					Utility.print("RSInterface.interfaceCache[" + random + "].spritesY[" + index + "] = " + data.spritesY[index] + ";");
					Utility.print("");
				}
			}
			// Strings
			if (data.hoverText != null && !data.hoverText.isEmpty()) {
				Utility.print("RSInterface.interfaceCache[" + random + "].hoverText = \"" + data.hoverText + "\";");
			}
			if (data.message != null && !data.message.isEmpty()) {
				Utility.print("RSInterface.interfaceCache[" + random + "].message = \"" + data.message + "\";");
			}
			if (data.messageEnabled != null && !data.messageEnabled.isEmpty()) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].messageEnabled = \"" + data.messageEnabled + "\";");
			}
			if (data.tooltip != null && !data.tooltip.isEmpty()) {
				Utility.print("RSInterface.interfaceCache[" + random + "].tooltip = \"" + data.tooltip + "\";");
			}
			if (data.spellName != null && !data.spellName.isEmpty()) {
				Utility.print("RSInterface.interfaceCache[" + random + "].spellName = \"" + data.spellName + "\";");
			}
			if (data.selectedActionName != null && !data.selectedActionName.isEmpty()) {
				Utility.print("RSInterface.interfaceCache[" + random + "].selectedActionName = \""
						+ data.selectedActionName + "\";");
			}
			if (data.popupString != null && !data.popupString.isEmpty()) {
				Utility.print("RSInterface.interfaceCache[" + random + "].popupString = \"" + data.popupString + "\";");
			}

			// Booleans

			if (data.centerText) {
				Utility.print("RSInterface.interfaceCache[" + random + "].centerText = " + data.centerText + ";");
			}
			if (data.drawsTransparent) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].drawsTransparent = " + data.drawsTransparent + ";");
			}
			if (data.hasType9Hover) {
				Utility.print("RSInterface.interfaceCache[" + random + "].hasType9Hover = " + data.hasType9Hover + ";");
			}
			if (data.hoverHasText) {
				Utility.print("RSInterface.interfaceCache[" + random + "].hoverHasText = " + data.hoverHasText + ";");
			}
			if (data.hoverScrollBar) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].hoverScrollBar = " + data.hoverScrollBar + ";");
			}
			if (data.invisible) {
				Utility.print("RSInterface.interfaceCache[" + random + "].interfaceShown = " + data.invisible + ";");
			}
			if (data.isClicked) {
				Utility.print("RSInterface.interfaceCache[" + random + "].isClicked = " + data.isClicked + ";");
			}
			if (data.isFilled) {
				Utility.print("RSInterface.interfaceCache[" + random + "].isFilled = " + data.isFilled + ";");
			}
			if (data.isInventoryInterface) {
				Utility.print("RSInterface.interfaceCache[" + random + "].isInventoryInterface = "
						+ data.isInventoryInterface + ";");
			}
			if (data.isMouseoverTriggereds) {
				Utility.print("RSInterface.interfaceCache[" + random + "].isMouseoverTriggereds = "
						+ data.isMouseoverTriggereds + ";");
			}
			if (data.itemsAreDraggable) {
				Utility.print("RSInterface.interfaceCache[" + random + "].itemsAreDraggable = " + data.itemsAreDraggable
						+ ";");
			}
			if (data.itemsAreSwappable) {
				Utility.print("RSInterface.interfaceCache[" + random + "].itemsAreSwappable = " + data.itemsAreSwappable
						+ ";");
			}
			if (data.removeStackableNumber) {
				Utility.print("RSInterface.interfaceCache[" + random + "].removeStackableNumber = "
						+ data.removeStackableNumber + ";");
			}
			if (data.textIsClicked) {
				Utility.print("RSInterface.interfaceCache[" + random + "].textIsClicked = " + data.textIsClicked + ";");
			}
			if (data.textShadow) {
				Utility.print("RSInterface.interfaceCache[" + random + "].textShadow = " + data.textShadow + ";");
			}
			if (data.usableItemInterface) {
				Utility.print("RSInterface.interfaceCache[" + random + "].usableItemInterface = "
						+ data.usableItemInterface + ";");
			}

			// Integers.
			if (data.id != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].id = " + data.id + ";");
			}
			if (data.actionType != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].actionType = " + data.actionType + ";");
			}
			if (data.atActionType != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].atActionType = " + data.atActionType + ";");
			}
			if (data.colourEnabled != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].colourEnabled = " + data.colourEnabled + ";");
			}
			if (data.height != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].height = " + data.height + ";");
			}
			if (data.hoverColorDisabled != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].hoverColorDisabled = "
						+ data.hoverColorDisabled + ";");
			}
			if (data.hoverColorEnabled != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].hoverColorEnabled = " + data.hoverColorEnabled
						+ ";");
			}
			if (data.hoverType != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].hoverType = " + data.hoverType + ";");
			}
			if (data.interfaceEndX != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].interfaceEndX = " + data.interfaceEndX + ";");
			}
			if (data.interfaceEndY != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].interfaceEndY = " + data.interfaceEndY + ";");
			}
			if (data.interfaceStartX != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].interfaceStartX = " + data.interfaceStartX + ";");
			}
			if (data.interfaceStartY != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].interfaceStartY = " + data.interfaceStartY + ";");
			}
			if (data.invSpritePadX != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].invSpritePadX = " + data.invSpritePadX + ";");
			}
			if (data.invSpritePadY != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].invSpritePadY = " + data.invSpritePadY + ";");
			}
			if (data.invStartIndex != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].invStartIndex = " + data.invStartIndex + ";");
			}
			if (data.isMouseoverTriggered != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].isMouseoverTriggered = "
						+ data.isMouseoverTriggered + ";");
			}
			if (data.mediaID != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].mediaID = " + data.mediaID + ";");
			}
			if (data.mediaIdOffset1 != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].mediaIdOffset1 = " + data.mediaIdOffset1 + ";");
			}
			if (data.mediaIdOffset2 != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].mediaIdOffset2 = " + data.mediaIdOffset2 + ";");
			}
			if (data.modelEnabled != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].modelEnabled = " + data.modelEnabled + ";");
			}
			if (data.modelRotationX != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].modelRotationX = " + data.modelRotationX + ";");
			}
			if (data.modelRotationY != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].modelRotationY = " + data.modelRotationY + ";");
			}
			if (data.modelTypeDisabled != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].modelTypeDisabled = " + data.modelTypeDisabled
						+ ";");
			}
			if (data.modelTypeEnabled != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].modelTypeEnabled = " + data.modelTypeEnabled + ";");
			}
			if (data.modelZoom != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].modelZoom = " + data.modelZoom + ";");
			}
			if (data.offsetX != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].offsetX = " + data.offsetX + ";");
			}
			if (data.offsetY != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].offsetY = " + data.offsetY + ";");
			}
			if (data.opacity != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].opacity = " + data.opacity + ";");
			}
			if (data.parentId != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].parentId = " + data.parentId + ";");
			}
			if (data.scrollMax != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].scrollMax = " + data.scrollMax + ";");
			}
			if (data.scrollPosition != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].scrollPosition = " + data.scrollPosition + ";");
			}
			if (data.sequenceCycle != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].sequenceCycle = " + data.sequenceCycle + ";");
			}
			if (data.sequenceDisabled != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].sequenceDisabled = " + data.sequenceDisabled + ";");
			}
			if (data.sequenceEnabled != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].sequenceEnabled = " + data.sequenceEnabled + ";");
			}
			if (data.sequenceFrame != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].sequenceFrame = " + data.sequenceFrame + ";");
			}
			if (data.spellUsableOn != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].spellUsableOn = " + data.spellUsableOn + ";");
			}
			if (data.textClickedX != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].textClickedX = " + data.textClickedX + ";");
			}
			if (data.textClickedY != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].textClickedY = " + data.textClickedY + ";");
			}
			if (data.textColour != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].textColour = " + data.textColour + ";");
			}
			if (data.textSize != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].textSize = " + data.textSize + ";");
			}
			if (data.toolTipSpecialX != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].toolTipSpecialX = " + data.toolTipSpecialX + ";");
			}
			if (data.toolTipSpecialY != 0) {
				Utility.print(
						"RSInterface.interfaceCache[" + random + "].toolTipSpecialY = " + data.toolTipSpecialY + ";");
			}
			if (data.transparency != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].transparency = " + data.transparency + ";");
			}
			if (data.type != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].type = " + data.type + ";");
			}
			if (data.type9HoverXposition != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].type9HoverXposition = "
						+ data.type9HoverXposition + ";");
			}
			if (data.type9HoverYposition != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].type9HoverYposition = "
						+ data.type9HoverYposition + ";");
			}
			if (data.width != 0) {
				Utility.print("RSInterface.interfaceCache[" + random + "].width = " + data.width + ";");
			}
		}
	}

	public static void addSpriteComplete(int interfaceId, int child, int spriteId, int x, int y, RSInterface interfaces,
			boolean add) {
		if (add) {
			RSInterface.addSprite(interfaceId, spriteId);
		}
		RSInterface.setBounds(interfaceId, x, y, child, interfaces);
	}

	public static int getConfigID(int id) {
		RSInterface rsi = interfaceCache[id];
		if (rsi.valueIndexArray != null && rsi.valueIndexArray[0][1] > 0) {
			return rsi.valueIndexArray[0][1];
		}
		return 0;
	}

	public static void addHoverConfigButton(int id, int hoverOver, int disabledID, int enabledID, int width, int height,
			String tooltip, int[] anIntArray245, int[] anIntArray212, int[][] valueIndexArray) {
		RSInterface rsint = addTabInterface(id);
		rsint.parentId = id;
		rsint.interfaceId = id;
		rsint.type = 5;
		rsint.atActionType = 5;
		// rsint.contentType = 206;
		rsint.width = width;
		rsint.height = height;
		rsint.opacity = 0;
		rsint.hoverType = hoverOver;
		rsint.scriptCompareType = anIntArray245;
		rsint.scriptCompareValue = anIntArray212;
		rsint.valueIndexArray = valueIndexArray;
		rsint.sprite2 = imageLoaderNew(disabledID);
		rsint.sprite1 = imageLoaderNew(enabledID);
		rsint.tooltip = tooltip;
	}

	public static void addHoverButtonComplete(int interfaceId, int child, int x, int y, int normalSprite,
			int hoverSprite, int buttonWidth, int buttonHeight, String buttonHoverText, RSInterface interfaces,
			boolean add) {
		if (add) {
			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, normalSprite, hoverSprite,
					buttonWidth, buttonHeight, buttonHoverText);
		}
		RSInterface.setBounds(interfaceId, x, y, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, x, y, child + 1, interfaces);
	}

	public static void addHoverButtonLatest(int buttonId1, int buttonId2, int buttonId3, int spriteId1, int spriteId2,
			int buttonWidth, int buttonHeight, String buttonHoverText) {
		addHoverButton(buttonId1, spriteId1, buttonWidth, buttonHeight, buttonHoverText, -1, buttonId2, 1);
		addHoveredButton(buttonId2, spriteId2, buttonWidth, buttonHeight, buttonId3);
	}

	public int lastRowWithItem() {
		int lastIndexOfNonNegative = -1;

		for (int index = inv.length - 1; index > -1; index--) {
			if (inv[index] > 0) {
				lastIndexOfNonNegative = index;
				break;
			}
		}

		if (lastIndexOfNonNegative == -1) {
			return -1;
		}
		return (int) Math.ceil((double) (lastIndexOfNonNegative + 1) / (double) width);
	}

	// i = from slot
	// j = to slot
	public void swapInventoryItems(int i, int j) {
		int k = inv[i];
		inv[i] = inv[j];
		inv[j] = k;
		k = invStackSizes[i];
		invStackSizes[i] = invStackSizes[j];
		invStackSizes[j] = k;
	}

	public void populateContainer(int item, int amount) {
		for (int index = 0; index < inv.length; index++) {
			inv[index] = item;
			invStackSizes[index] = amount;
		}
	}

	public static void addBankItem(int index, Boolean hasOption) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.actions = new String[5];
		rsi.spritesX = new int[20];
		rsi.invStackSizes = new int[30];
		rsi.inv = new int[30];
		rsi.spritesY = new int[20];
		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];
		rsi.invSpritePadX = 24;
		rsi.invSpritePadY = 24;
		rsi.height = 1;
		rsi.removeStackableNumber = true;
		rsi.width = 1;
		rsi.parentId = 24494;
		rsi.id = index;
		rsi.setType(2);
	}

	public static void addBankHover(int interfaceID, int actionType, int hoverid, int spriteId1, int spriteId2,
			int Width, int Height, int configFrame, int configId, String Tooltip, int hoverId2, int hoverSpriteId,
			int hoverSpriteId2, String hoverSpriteName, int hoverId3, String hoverDisabledText, String hoverEnabledText,
			int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentId = interfaceID;
		hover.setType(5);
		hover.atActionType = actionType;
		hover.actionType = 0;
		hover.sprite1 = imageLoaderNew(spriteId1);
		hover.sprite2 = imageLoaderNew(spriteId2);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover.scriptCompareType = new int[1];
		hover.scriptCompareValue = new int[1];
		hover.scriptCompareType[0] = 1;
		hover.scriptCompareValue[0] = configId;
		hover.valueIndexArray = new int[1][3];
		hover.valueIndexArray[0][0] = 5;
		hover.valueIndexArray[0][1] = configFrame;
		hover.valueIndexArray[0][2] = 0;
		hover = addTabInterface(hoverid);
		hover.parentId = hoverid;
		hover.id = hoverid;
		hover.setType(0);
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.isMouseoverTriggereds = true;
		addSprites(hoverId2, spriteId1, spriteId2, configId, configFrame);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverEnabledText, configId, configFrame);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}

	public static void addActionButton(int id, int width, int height, String s) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = imageLoaderNew(419);
		rsi.sprite2 = imageLoader("");
		rsi.tooltip = s;
		rsi.actionType = 0;
		rsi.atActionType = 1;
		rsi.width = width;
		rsi.hoverType = 52;
		rsi.parentId = id;
		rsi.id = id;
		rsi.setType(5);
		rsi.height = height;
	}

	public static void setChildren(int total, RSInterface rsinterface) {
		rsinterface.children = new int[total];
		rsinterface.childX = new int[total];
		rsinterface.childY = new int[total];
	}

	public static void drawTooltip(int id, String text) {
		RSInterface rsinterface = addTabInterface(id);
		rsinterface.parentId = id;
		rsinterface.setType(0);
		rsinterface.invisible = true;
		rsinterface.isMouseoverTriggered = -1;
		addTooltipBox(id + 1, text);
		rsinterface.totalChildren(1);
		rsinterface.child(0, id + 1, 0, 0);
	}

	public static void addButton(int id, int spriteId, String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 1;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addButton(int id, String spriteName, String tooltip, int mOver, int atAction, int width,
			int height) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.atActionType = atAction;
		tab.actionType = 0;
		tab.opacity = 0;
		tab.isMouseoverTriggered = mOver;
		tab.sprite1 = imageLoader(spriteName);
		tab.sprite2 = imageLoader(spriteName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = tooltip;
	}

	public static void addHead(int id, int w, int h, int zoom) {
		RSInterface rsinterface = interfaceCache[id] = new RSInterface();
		rsinterface.type = 6;
		rsinterface.modelTypeDisabled = 2;
		rsinterface.mediaID = 4000;
		rsinterface.modelZoom = zoom;
		rsinterface.modelRotationX = 40;
		rsinterface.modelRotationY = 1900;
		rsinterface.height = h;
		rsinterface.width = w;
	}

	public static void addTooltipBox(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.parentId = id;
		rsi.setType(8);
		rsi.popupString = text;
	}

	public static void addTooltip(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.setType(0);
		rsi.invisible = true;
		rsi.isMouseoverTriggered = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
	}

	public static void addPriceChecker(int index) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.actions = new String[10];
		rsi.spritesX = new int[20];
		rsi.invStackSizes = new int[28];
		rsi.inv = new int[28];
		rsi.spritesY = new int[20];
		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];
		rsi.actions[0] = "Remove";
		rsi.actions[1] = "Remove-5";
		rsi.actions[2] = "Remove-10";
		rsi.actions[3] = "Remove-All";
		rsi.actions[4] = "Remove-X";
		rsi.centerText = true;
		rsi.isFilled = false;
		rsi.itemsAreSwappable = false;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.itemsAreDraggable = true;
		rsi.textShadow = false;
		rsi.invSpritePadX = 56;
		rsi.invSpritePadY = 35;
		rsi.height = 6;
		rsi.width = 5;
		rsi.parentId = 48542;
		rsi.id = 4393;
		rsi.type = 2;
	}

	public void children(int total) {
		children = new int[total];
		childX = new int[total];
		childY = new int[total];
	}

	public static void createSkillHover(int id, int type, int hoverAreaWidth, int hoverAreaHeight) {
		RSInterface hover = addInterface(id);
		hover.setType(type);
		hover.message = "Current EXP: 13,034,431";
		hover.width = hoverAreaWidth;
		hover.height = hoverAreaHeight;

		// Hunter hover position fix.
		if (id == 26375) {
			hover.hasType9Hover = true;
			hover.type9HoverXposition = 93;
			hover.type9HoverYposition = 250;
		}
	}

	public static void createTimedHoverBox(int id, String text, int hoverAreaWidth, int hoverAreaHeight,
			int hoverBoxXPosition, int hoverBoxYPosition) {
		RSInterface hover = addInterface(id);
		hover.setType(9);
		hover.message = text;
		hover.width = hoverAreaWidth;
		hover.height = hoverAreaHeight;
		hover.hasType9Hover = true;
		hover.type9HoverXposition = hoverBoxXPosition;
		hover.type9HoverYposition = hoverBoxYPosition;
	}

	public static void addImage(int id, int spriteId) {
		RSInterface image = addInterface(id);
		image.setType(5);
		image.atActionType = 0;
		image.actionType = 0;
		image.width = 100;
		image.height = 100;
		image.sprite1 = imageLoaderNew(spriteId);
	}

	public static void addSkillText(int id, boolean max, int skill) {
		RSInterface text = addInterface(id);
		text.id = id;
		text.parentId = id;
		text.setType(4);
		text.atActionType = 0;
		text.width = 15;
		text.height = 12;
		text.textDrawingAreas = fonts[0];
		text.textSize = 0;
		text.textShadow = true;
		text.centerText = true;
		text.textColour = 16776960;
		if (!max) {
			text.valueIndexArray = new int[1][];
			text.valueIndexArray[0] = new int[3];
			text.valueIndexArray[0][0] = 1;
			text.valueIndexArray[0][1] = skill;
			text.valueIndexArray[0][2] = 0;
		} else {
			text.valueIndexArray = new int[2][];
			text.valueIndexArray[0] = new int[3];
			text.valueIndexArray[0][0] = 1;
			text.valueIndexArray[0][1] = skill;
			text.valueIndexArray[0][2] = 0;
			text.valueIndexArray[1] = new int[1];
			text.valueIndexArray[1][0] = 0;
		}
		text.message = "%1";
	}

	public static void addSkillButton(int id) {
		RSInterface button = addInterface(id);
		button.setType(5);
		button.atActionType = 5;
		button.actionType = 0;
		button.width = 60;
		button.height = 27;
		button.sprite1 = imageLoaderNew(280);
		button.tooltip = "View";
	}

	public static void addSkillButton474(int id) {
		RSInterface button = addInterface(id);
		button.setType(5);
		button.atActionType = 5;
		button.actionType = 0;
		button.width = 62;
		button.height = 32;
		button.sprite1 = imageLoaderNew(650);
		button.tooltip = "View";
	}

	/**
	 * 
	 * @param i
	 * @param aT
	 *            4 to make it send server sided, 3 to be client sided button
	 *            only.
	 * @param cT
	 * @param hoverid
	 * @param W
	 * @param H
	 * @param tip
	 */
	public static void addHover(int i, int aT, int cT, int hoverid, int spriteId, int W, int H, String tip) {
		RSInterface rsinterfaceHover = addInterface(i);
		rsinterfaceHover.id = i;
		rsinterfaceHover.parentId = i;
		rsinterfaceHover.setType(5);
		rsinterfaceHover.atActionType = aT;
		rsinterfaceHover.actionType = cT;
		rsinterfaceHover.isMouseoverTriggered = hoverid;
		rsinterfaceHover.sprite1 = imageLoaderNew(spriteId);
		rsinterfaceHover.sprite2 = imageLoaderNew(spriteId);
		rsinterfaceHover.width = W;
		rsinterfaceHover.height = H;
		rsinterfaceHover.tooltip = tip;
	}

	public static void addHovered(int i, int spriteId, int w, int h, int IMAGEID) {
		RSInterface rsinterfaceHover = addInterface(i);
		rsinterfaceHover.parentId = i;
		rsinterfaceHover.id = i;
		rsinterfaceHover.setType(0);
		rsinterfaceHover.atActionType = 0;
		rsinterfaceHover.width = w;
		rsinterfaceHover.height = h;
		rsinterfaceHover.invisible = true;
		rsinterfaceHover.isMouseoverTriggered = -1;
		addSprite(IMAGEID, spriteId);
		setChildren(1, rsinterfaceHover);
		setBounds(IMAGEID, 0, 0, 0, rsinterfaceHover);
	}

	public static void addPrayer(final int i, final int configId,
			final int configFrame, final int scriptCompareValue,
			final int prayerSpriteID, final String PrayerName, final int Hover) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentId = 23377;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.actionType = 0;
		Interface.opacity = 0;
		Interface.isMouseoverTriggered = Hover;
		Interface.sprite1 = imageLoaderNew(284);
		Interface.sprite2 = imageLoader("");
		Interface.width = 34;
		Interface.height = 34;
		Interface.scriptCompareType = new int[1];
		Interface.scriptCompareValue = new int[1];
		Interface.scriptCompareType[0] = 1;
		Interface.scriptCompareValue[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@lre@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentId = 23377;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.actionType = 0;
		Interface.opacity = 0;
		Interface.sprite1 = imageLoaderNew(prayerSpriteID);
		Interface.sprite2 = imageLoaderNew(prayerSpriteID+1);
		Interface.width = 34;
		Interface.height = 34;
		Interface.scriptCompareType = new int[1];
		Interface.scriptCompareValue = new int[1];
		Interface.scriptCompareType[0] = 2;
		Interface.scriptCompareValue[0] = scriptCompareValue + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}
	
	public static void modelViewer(int interfaceId, int modelType, int entityId) {		
		RSInterface widget = RSInterface.addInterface(interfaceId);
		RSInterface rsi = RSInterface.addTabInterface(interfaceId + 1);		
		rsi.id = interfaceId;
		rsi.parentId = interfaceId;
		rsi.type = 6;
		rsi.atActionType = 0;
		rsi.actionType = 329;
		rsi.width = 136;
		rsi.height = 168;
		rsi.opacity = 0;
		rsi.isMouseoverTriggered = 0;
		rsi.modelZoom = 560;
		rsi.modelRotationY = 150;
		rsi.modelRotationX = 0;
		rsi.sequenceDisabled = -1;
		rsi.sequenceEnabled = -1;
		rsi.modelTypeEnabled = modelType;
		rsi.modelTypeDisabled = entityId;
		widget.totalChildren(1);
		widget.child(0, interfaceId + 1, 190, 150);
	}
	static void RandomTeleInt(TextDrawingArea[] tda) {
	     //Main Interface ID, and calling the addinterface method
	       RSInterface tab = RSInterface.addInterface(13400);

	        //Scroll bar Interface ID.
			RSInterface scrollTableft = RSInterface.addInterface(13430);
			int xOffset = 4;
			int yOffset = -8;
			
			//Scroll bar for drops
			RSInterface scrollTabright = RSInterface.addInterface(13498);
			
	        //Main Interface Sprites
	        RSInterface.addSprite(13401, 1314);
	        
	        //Interface Text
			 RSInterface.addText(13402, "Our Drops", tda, 2, 0xFF9900, true, true);
			 RSInterface.addText(13403, "Description", tda, 2, 0xFF9900, true, true);
			 RSInterface.addText(13404, "Drops", tda, 2, 0xFF9900, true, true);
			 RSInterface.addText(13405, "Boss Names", tda, 2, 0xFF9900, true, true);
			 
	        //Category Buttons
			 RSInterface.addButton(13406, 1315, "Select");
			 RSInterface.addButton(13407, 1315, "Select");
			 RSInterface.addButton(13408, 1315, "Select");
			 RSInterface.addButton(13409, 1315, "Select");
			 RSInterface.addButton(13410, 1315, "Select");
			 RSInterface.addButton(13411, 1315, "Select");

			 //Category Text
			 RSInterface.addText(13412, "Bosses", tda, 0, 0xFF9900, true, true);
			 RSInterface.addText(13413, "Monsters", tda, 0, 0xFF9900, true, true);
			 RSInterface.addText(13414, "Wilderness", tda, 0, 0xFF9900, true, true);
			 RSInterface.addText(13415, "Skilling", tda, 0, 0xFF9900, true, true);
			 RSInterface.addText(13416, "Minigames", tda, 0, 0xFF9900, true, true);
			 RSInterface.addText(13417, "Cities", tda, 0, 0xFF9900, true, true);
			 
		     //Description Text.
			 RSInterface.addText(13418, "Name:", tda, 1, 0xFF9900, true, true);
			 RSInterface.addText(13419, "Hitpoints:", tda, 1, 0xFF9900, true, true);
			 RSInterface.addText(13420, "Recom Team Size:", tda, 1, 0xFF9900, true, true);
			 RSInterface.addText(13421, "Attack Styles:", tda, 1, 0xFF9900, true, true);
			 RSInterface.addText(13422, "Difficulty:", tda, 1, 0xFF9900, true, true);

			 //Teleport Button
			 RSInterface.addButton(13423, 1317, "Teleport");
			 
		     //Description Text.
				 RSInterface.addText(13424, "1:", tda, 1, ClientConstants.YELLOW, true, true);
				 RSInterface.addText(13425, "2:", tda, 1, ClientConstants.YELLOW, true, true);
				 RSInterface.addText(13426, "3:", tda, 1, ClientConstants.YELLOW, true, true);
				 RSInterface.addText(13427, "4:", tda, 1, ClientConstants.YELLOW, true, true);
				 RSInterface.addText(13428, "5:", tda, 1, ClientConstants.YELLOW, true, true);

				 RSInterface.addText(13429, "Teleport", tda, 2, ClientConstants.YELLOW, true, true);
				
				 RSInterface.addToItemGroup(13499, 0, 8, 8, 5, 5, false, null, null, null, true, true);
				 
				 //Adds the NPC Onto the interface.
				RSInterface.modelViewer(13500, 1, 23889);

			 
			 //Positionining and Interface child
			RSInterface.setChildren(31, tab);
			tab.child(0, 13401, 7, 10);
			tab.child(1, 13402, 215, 68);
			tab.child(2, 13403, 405, 68);
			tab.child(3, 13404, 210, 244);
			tab.child(4, 13405, 85, 50);
			
			tab.child(5, 13406, 23, 17);
			tab.child(6, 13407, 102, 17);
			tab.child(7, 13408, 181, 17);
			tab.child(8, 13409, 260, 17);
			tab.child(9, 13410, 339, 17);
			tab.child(10, 13411, 419, 17);
			
			tab.child(11, 13412, 56, 23);
			tab.child(12, 13413, 134, 23);
			tab.child(13, 13414, 215, 23);
			tab.child(14, 13415, 295, 23);
			tab.child(15, 13416, 374, 23);
			tab.child(16, 13417, 454, 23);
			
			//Scrollbar positioning
			tab.child(17, 13430, 20 + xOffset, 82 + yOffset);
			
			//Description Text Positioning
			tab.child(18, 13418, 357, 90);
			tab.child(19, 13419, 366, 105);
			tab.child(20, 13420, 387, 120);
			tab.child(21, 13421, 378, 135);
			tab.child(22, 13422, 368, 150);
			
			//Teleport Button Positioning
			tab.child(23, 13423, 155, 208);
			
			
			//Text Input fields Positoning
			tab.child(24, 13424, 420, 90);
			tab.child(25, 13425, 410, 105);
			tab.child(26, 13426, 450, 120);
			tab.child(27, 13427, 441, 135);
			tab.child(28, 13428, 430, 150);
			tab.child(29, 13429, 220, 212);
			tab.child(30, 13498, 150, 265);


			
			//Scoll bar size, witdh and scrolling size.
			scrollTableft.width = 101;
			scrollTableft.height = 247;
			scrollTableft.scrollMax = 450;
			
			//Scroll bar size, width and scrolling size.
			scrollTabright.width = 334;
			scrollTabright.height = 60;
			scrollTabright.scrollMax = 200;
			
			int npcList = 50;
			int y = 1;

			for (int i = 0; i < npcList; i++) {
				RSInterface.addText(13431 + i, "Teleport Name", tda, 1, ClientConstants.ORANGE, false, false, ClientConstants.WHITE,
						"Select", 150);
			}

			RSInterface.setChildren(npcList, scrollTableft);

			for (int i = 0; i < npcList; i++) {
				scrollTableft.child(i, 13431 + i, 0, y);
				y += 15;
			}
			
			
			RSInterface.setChildren(1, scrollTabright);

			scrollTabright.child(0, 13499, 20, 10);

		}
	public static void addPrayer(int i, int configId, int configFrame, int scriptCompareValue, int spriteID, int spriteId2,
			String prayerName) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentId = 5608;
		tab.setType(5);
		tab.atActionType = 4;
		tab.actionType = 0;
		tab.opacity = 0;
		tab.isMouseoverTriggered = -1;
		tab.sprite1 = imageLoaderNew(284);
		tab.sprite2 = imageLoader("");
		tab.width = 34;
		tab.height = 34;
		tab.scriptCompareType = new int[1];
		tab.scriptCompareValue = new int[1];
		tab.scriptCompareType[0] = 1;
		tab.scriptCompareValue[0] = configId;
		tab.valueIndexArray = new int[1][3];
		tab.valueIndexArray[0][0] = 5;
		tab.valueIndexArray[0][1] = configFrame;
		tab.valueIndexArray[0][2] = 0;
		tab.tooltip = "Activate@or2@ " + prayerName;
		// tab.tooltip = "Select";
		RSInterface tab2 = addTabInterface(i + 1);
		tab2.id = i + 1;
		tab2.parentId = 5608;
		tab2.setType(5);
		tab2.atActionType = 0;
		tab2.actionType = 0;
		tab2.opacity = 0;
		tab2.isMouseoverTriggered = -1;
		tab2.sprite1 = imageLoaderNew(spriteID);
		tab2.sprite2 = imageLoaderNew(spriteId2);
		tab2.width = 34;
		tab2.height = 34;
		tab2.scriptCompareType = new int[1];
		tab2.scriptCompareValue = new int[1];
		tab2.scriptCompareType[0] = 2;
		tab2.scriptCompareValue[0] = scriptCompareValue + 1;
		tab2.valueIndexArray = new int[1][3];
		tab2.valueIndexArray[0][0] = 2;
		tab2.valueIndexArray[0][1] = 5;
		tab2.valueIndexArray[0][2] = 0;
	}

	public static RSInterface addInterface(int id) {

		if (ClientDebugConfiguration.DEBUG_INTERFACES) {
			
		}
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.id = id;
		rsi.parentId = id;
		rsi.width = 512;
		rsi.height = 334;

		return rsi;
	}

	public static RSInterface addInterface(int id, int xStart, int xEnd, int yStart, int yEnd) {

		if (ClientDebugConfiguration.DEBUG_INTERFACES) {
			interfaceIds.add(id);
		}
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.id = id;
		rsi.parentId = id;
		rsi.width = 512;
		rsi.height = 334;

		rsi.interfaceStartX = xStart;
		rsi.interfaceEndX = xEnd;
		rsi.interfaceStartY = yStart;
		rsi.interfaceEndY = yEnd;
		return rsi;
	}

	public static void addColorBox(int id, int color, int width, int height, boolean rounded) {
		RSInterface tab = addInterface(id);
		tab.width = width;
		tab.height = height;
		tab.textColour = color;
		tab.rounded = rounded;
		tab.type = 10;
		tab.id = id;
		tab.actionType = 0;
	}

	public static void addHDButton(int id, int sid, String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.type = 11;
		tab.atActionType = 1;
		tab.actionType = 0;
		tab.sprite1 = imageLoaderNew(sid);
		tab.sprite2 = imageLoaderNew(sid);
		tab.width = tab.sprite1.width;
		tab.height = tab.sprite2.height;
		tab.tooltip = tooltip;
	}

	public static void addText(int id, String text, TextDrawingArea tda[], int idx, int color, boolean centered) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		if (centered) {
			rsi.centerText = true;
		}
		rsi.textShadow = true;
		rsi.textDrawingAreas = tda[idx];
		rsi.textSize = idx;
		rsi.message = text;
		rsi.textColour = color;
		rsi.id = id;
		rsi.setType(4);
	}

	public static void textSize(int id, TextDrawingArea tda[], int idx) {
		RSInterface rsi = interfaceCache[id];
		rsi.textDrawingAreas = tda[idx];
		rsi.textSize = idx;
	}

	public static void addCacheSprite(int id, int sprite1, int sprite2, String sprites) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = method207(sprite1, aClass44, sprites);
		rsi.sprite2 = method207(sprite2, aClass44, sprites);
		rsi.parentId = id;
		rsi.id = id;
		rsi.setType(5);
	}

	public static void sprite1(int id, int sprite) {
		RSInterface class9 = interfaceCache[id];
		class9.sprite1 = imageLoaderNew(sprite);
	}

	public static void addToggleButton(int id, int sprite, int sprite2, int setconfig, int width, int height,
			String s) {
		RSInterface rsi = addInterface(id);
		rsi.sprite1 = imageLoaderNew(sprite);
		rsi.sprite2 = imageLoaderNew(sprite2);
		rsi.scriptCompareValue = new int[1];
		rsi.scriptCompareValue[0] = 1;
		rsi.scriptCompareType = new int[1];
		rsi.scriptCompareType[0] = 1;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = setconfig;
		rsi.valueIndexArray[0][2] = 0;
		rsi.atActionType = 4;
		rsi.width = width;
		rsi.isMouseoverTriggered = -1;
		rsi.parentId = id;
		rsi.id = id;
		rsi.setType(5);
		rsi.height = height;
		rsi.tooltip = s;
	}

	public void totalChildren(int id, int x, int y) {
		children = new int[id];
		childX = new int[x];
		childY = new int[y];
	}

	@SuppressWarnings("unused")
	public static void removeSomething(int id) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
	}

	public void specialBar(int id, boolean staff) {
		addActionButton(id - 12, 150, 26, "Use @gre@Special Attack");
		for (int i = id - 11; i < id; i++) {
			removeSomething(i);
		}

		RSInterface rsi = interfaceCache[id - 12];
		rsi.width = 150;
		rsi.height = 26;

		rsi = interfaceCache[id];
		rsi.width = 150;
		rsi.height = 26;

		rsi.child(0, id - 12, 0, 0);

		rsi.child(12, id + 1, 3, 7);

		rsi.child(23, id + 12, 16, 8);

		for (int i = 13; i < 23; i++) {
			rsi.childY[i] -= staff ? 0 : 1;
		}

		rsi = interfaceCache[id + 1];
		rsi.setType(5);
		rsi.sprite1 = imageLoaderNew(422);

		for (int i = id + 2; i < id + 12; i++) {
			rsi = interfaceCache[i];
			rsi.setType(5);
		}

		sprite1(id + 2, 135);
		sprite1(id + 3, 136);
		sprite1(id + 4, 137);
		sprite1(id + 5, 138);
		sprite1(id + 6, 139);
		sprite1(id + 7, 140);
		sprite1(id + 8, 141);
		sprite1(id + 9, 145);
		sprite1(id + 10, 146);
		sprite1(id + 11, 396);
	}

	public static void Sidebar0a(int id, int id2, int id3, String text1, String text2, String text3, String text4,
			int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y, int img1x,
			int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda) // 4button
																												// spec
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addText(id2 + 14, text4, tda, 0, 0xff981f, false); /* specialBar(ID); */
		rsi.specialBar(id3, false); // 7599
		rsi.width = 190;
		rsi.height = 261;

		int last = 15;
		int frame = 0;
		rsi.totalChildren(last, last, last);

		rsi.child(frame, id2 + 3, 21, 46);
		frame++; // 2429
		rsi.child(frame, id2 + 4, 104, 99);
		frame++; // 2430
		rsi.child(frame, id2 + 5, 21, 99);
		frame++; // 2431
		rsi.child(frame, id2 + 6, 105, 46);
		frame++; // 2432
		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++; // bottomright 2433
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++; // topleft 2434
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++; // bottomleft 2435
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++; // topright 2436
		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++; // chop 2437
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++; // slash 2438
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++; // lunge 2439
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++; // block 2440
		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon 2426
		rsi.child(frame, id3, 21, 205);
		frame++; // special attack 7599
		for (int i = id2 + 3; i < id2 + 7; i++) { // 2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = imageLoaderNew(420);
			rsi.sprite2 = imageLoaderNew(421);
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void createCombatIcons(int id, int parentId, int... sprites) {
		for (int index = 0; index < 8; index++) {
			int childId = id + 3 + index;

			RSInterface copy = RSInterface.copy(childId, parentId, interfaceCache[2430 + index]);

			copy.children = null;
			copy.childX = null;
			copy.childY = null;

			interfaceCache[childId] = copy;
		}
		for (int index = 0; index < sprites.length; index++) {
			int childId = id + 6 + index;

			interfaceCache[childId].sprite1 = imageLoaderNew(sprites[index]);
		}
	}

	public static void overlayListener(TextDrawingArea[] tda) {
		RSInterface.addText(26150, "", tda, 0, 0xff981f, true);
	}

	public static void Sidebar0b(int id, int id2, String text1, String text2, String text3, String text4, int str1x,
			int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y, int img1x, int img1y,
			int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda) // 4button
																										// nospec
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addText(id2 + 14, text4, tda, 0, 0xff981f, false);

		rsi.width = 190;
		rsi.height = 261;

		int last = 14;
		int frame = 0;
		rsi.totalChildren(last, last, last);

		rsi.child(frame, id2 + 3, 21, 46);
		frame++; // 2429
		rsi.child(frame, id2 + 4, 104, 99);
		frame++; // 2430
		rsi.child(frame, id2 + 5, 21, 99);
		frame++; // 2431
		rsi.child(frame, id2 + 6, 105, 46);
		frame++; // 2432
		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++; // bottomright 2433
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++; // topleft 2434
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++; // bottomleft 2435
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++; // topright 2436
		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++; // chop 2437
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++; // slash 2438
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++; // lunge 2439
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++; // block 2440
		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon 2426
		for (int i = id2 + 3; i < id2 + 7; i++) { // 2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = imageLoaderNew(420);
			rsi.sprite2 = imageLoaderNew(421);
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0c(int id, int id2, int id3, String text1, String text2, String text3, int str1x,
			int str1y, int str2x, int str2y, int str3x, int str3y, int img1x, int img1y, int img2x, int img2y,
			int img3x, int img3y, TextDrawingArea[] tda) // 3button
	// spec
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addText(id2 + 11, text3, tda, 0, 0xff981f, false); /* specialBar(ID); */
		rsi.specialBar(id3, false); // 7599
		rsi.width = 190;
		rsi.height = 261;

		int last = 12;
		int frame = 0;
		rsi.totalChildren(last, last, last);

		rsi.child(frame, id2 + 3, 21, 99);
		frame++;
		rsi.child(frame, id2 + 4, 105, 46);
		frame++;
		rsi.child(frame, id2 + 5, 21, 46);
		frame++;

		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++; // topleft
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++; // bottomleft
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++; // topright
		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++; // chop
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++; // slash
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++; // lunge
		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon
		rsi.child(frame, id3, 21, 205);
		frame++; // special attack 7599
		for (int i = id2 + 3; i < id2 + 6; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = imageLoaderNew(420);
			rsi.sprite2 = imageLoaderNew(421);
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0d(int id, int id2, String text1, String text2, String text3, int str1x, int str1y,
			int str2x, int str2y, int str3x, int str3y, int img1x, int img1y, int img2x, int img2y, int img3x,
			int img3y, TextDrawingArea[] tda) // 3button nospec
	// (magic intf)
	{
		RSInterface rsi = addInterface(id); // 2423
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addText(id2 + 11, text3, tda, 0, 0xff981f, false);

		removeSomething(353);
		addText(354, "Spell", tda, 0, 0xff981f, false); // This is used for the
														// autocast old
														// fashioned way on rs
		addCacheSprite(337, 19, 0, "combaticons");
		addCacheSprite(338, 13, 0, "combaticons2");
		addCacheSprite(339, 14, 0, "combaticons2");
		removeSomething(349);
		addToggleButton(350, 417, 418, 108, 68, 44, "Autocast Spell");

		rsi.specialBar(7599, true); // 7599
		rsi.width = 190;
		rsi.height = 261;

		int last = 16;
		int frame = 0;
		rsi.totalChildren(last, last, last);

		rsi.child(frame, id2 + 3, 20, 115);
		frame++;
		rsi.child(frame, id2 + 4, 20, 80);
		frame++;
		rsi.child(frame, id2 + 5, 20, 45);
		frame++;

		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++; // topleft
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++; // bottomleft
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++; // topright
		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++; // bash
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++; // pound
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++; // focus
		rsi.child(frame, 349, 105, 46);
		frame++; // spell1
		rsi.child(frame, 350, 104, 106);
		frame++; // spell2
		rsi.child(frame, 353, 125, 74);
		frame++; // spell
		rsi.child(frame, 354, 125, 134);
		frame++; // spell
		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon
		rsi.child(frame, 7599, 21, 205);
		frame++; // special attack 7599
	}

	public static RSInterface itemGroup(int id, int w, int h, int x, int y) {
		RSInterface rsi = addInterface(id);
		rsi.width = w;
		rsi.height = h;
		rsi.inv = new int[w * h];
		rsi.invStackSizes = new int[w * h];
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.invSpritePadX = x;
		rsi.invSpritePadY = y;
		rsi.spritesX = new int[20];
		rsi.spritesY = new int[20];
		rsi.sprites = new Sprite[20];
		rsi.type = 2;

		return rsi;
	}

	public static RSInterface addPixels(int id, int width, int height, int color, int transparency) {
		RSInterface component = addInterface(id);

		component.type = 10;
		component.width = width;
		component.height = height;
		component.colour = color;
		component.transparency = transparency;

		return component;
	}

	public static void addToItemGroup(int interfaceId, int itemId, int w, int h, int x, int y, boolean actions,
			String action1, String action2, String action3, boolean forceEmpty, boolean ignoreItemAmounts) {
		RSInterface rsi = addInterface(interfaceId);
		boolean stackable = (itemId == 13879 || itemId == 13883 || itemId == 9244) ? true : false;
		boolean showItem = itemId == 0 ? false : true;
		if (!showItem && !forceEmpty) {
			return;
		}

		itemId = itemId + 1;
		rsi.width = w;
		rsi.height = h;
		rsi.inv = new int[w * h];
		rsi.inv[0] = itemId;
		rsi.invStackSizes = new int[w * h];
		if (stackable) {
			rsi.removeStackableNumber = true;
		}
		rsi.invStackSizes[0] = 1;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.invSpritePadX = x;
		rsi.invSpritePadY = y;
		rsi.spritesX = new int[20];
		rsi.spritesY = new int[20];
		rsi.sprites = new Sprite[20];
		rsi.type = 2;
		rsi.ignoreItemAmounts = ignoreItemAmounts;
	}

	public static void addText(int interfaceId, String text, int colour, boolean center, boolean shadow,
			int isMouseoverTriggered, TextDrawingArea[] TDA, int textSize) {
		RSInterface RSInterface = addInterface(interfaceId);
		RSInterface.parentId = interfaceId;
		RSInterface.id = interfaceId;
		RSInterface.setType(4);
		RSInterface.atActionType = 0;
		RSInterface.width = 0;
		RSInterface.height = 0;
		RSInterface.actionType = 0;
		RSInterface.opacity = 0;
		RSInterface.isMouseoverTriggered = isMouseoverTriggered;
		RSInterface.centerText = center;
		RSInterface.textShadow = shadow;
		RSInterface.textDrawingAreas = TDA[textSize];
		RSInterface.textSize = textSize;
		RSInterface.message = text;
		RSInterface.messageEnabled = "";
		RSInterface.textColour = colour;
	}
	public static void addHoverClickText(int id, String text, String tooltip, TextDrawingArea tda[], int idx, int color,
			boolean center, boolean textShadow, int width) {
		RSInterface rsinterface = addInterface(id);
		rsinterface.id = id;
		rsinterface.parentId = id;
		rsinterface.type = 4;
		rsinterface.atActionType = 1;
		rsinterface.width = width;
		rsinterface.height = 11;
		rsinterface.actionType = 0;
		rsinterface.opacity = 0;
		rsinterface.hoverType = -1;
		rsinterface.centerText = center;
		rsinterface.textShadow = textShadow;
		rsinterface.textDrawingAreas = tda[idx];
		rsinterface.message = text;
		rsinterface.messageEnabled = "";
		rsinterface.tooltip = tooltip;
		rsinterface.textColour = color;
		rsinterface.colourEnabled = 0xFFFFFF;
		rsinterface.hoverColorDisabled = 0xFFFFFF;
		rsinterface.hoverColorEnabled = 0xFFFFFF;
	}
	public static void addClickableText(int id, String text, String tooltip, TextDrawingArea tda[], int idx, int colour,
			boolean center, boolean shadow, int width) {
		RSInterface tab = addTabInterface(id);
		tab.parentId = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 1;
		tab.width = width;
		tab.height = 11;
		tab.actionType = 0;
		tab.opacity = 0;
		tab.isMouseoverTriggered = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.messageEnabled = "";
		tab.textColour = colour;
		tab.colourEnabled = 0;
		tab.hoverColorDisabled = 0xffffff;
		tab.hoverColorEnabled = 0;
		tab.tooltip = tooltip;
	}

	public static void addHoverBox(int id, int ParentID, String text, String text2, int configId, int configFrame) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.parentId = ParentID;
		rsi.setType(8);
		rsi.messageEnabled = text;
		rsi.message = text2;
		rsi.scriptCompareType = new int[1];
		rsi.scriptCompareValue = new int[1];
		rsi.scriptCompareType[0] = 1;
		rsi.scriptCompareValue[0] = configId;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = configFrame;
		rsi.valueIndexArray[0][2] = 0;
	}

	public static void setSpriteClicked(int id, int spriteClickedId) {
		interfaceCache[id].spriteClicked = imageLoaderNew(spriteClickedId);
	}

	public static void hoverHasText(int id) {
		interfaceCache[id].hoverHasText = true;
	}

	public static void addText(int id, String text, TextDrawingArea tda[], int textSize, int color, boolean center,
			boolean shadow) {
		RSInterface tab = addTabInterface(id);
		tab.parentId = id;
		tab.id = id;
		tab.setType(4);
		tab.atActionType = 0;
		tab.width = 0;
		tab.height = 11;
		tab.actionType = 0;
		tab.opacity = 0;
		tab.isMouseoverTriggered = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[textSize];
		tab.textSize = textSize;
		tab.message = text;
		tab.messageEnabled = "";
		tab.textColour = color;
		tab.colourEnabled = 0;
		tab.hoverColorDisabled = 0;
		tab.hoverColorEnabled = 0;
	}

	public static void addText(int id, String text, TextDrawingArea tda[], int idx, int color, boolean center,
			boolean shadow, int hoverColour, String tooltip, int widthHover) {
		RSInterface tab = addTabInterface(id);
		tab.parentId = id;
		tab.id = id;
		tab.tooltip = tooltip;
		tab.setType(4);
		tab.atActionType = 4;
		tab.width = widthHover;
		tab.height = 15;
		tab.actionType = 0;
		tab.opacity = 0;
		tab.isMouseoverTriggered = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.textSize = idx;
		tab.message = text;
		tab.messageEnabled = "";
		tab.textColour = color;
		tab.colourEnabled = 0;
		tab.hoverColorDisabled = hoverColour;
		tab.hoverColorEnabled = 0;
	}

	public static void addButton(int id, int spriteId, String tooltip, int w, int h) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 1;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.width = w;
		tab.height = h;
		tab.tooltip = tooltip;
	}

	public static void addButtonMulti(int id, int spriteId, String[] tooltip, int w, int h) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 1;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.width = w;
		tab.height = h;
		tab.tooltips = tooltip;
	}

	public static void addButtonMultiWithHover(int id, int spriteId, String[] tooltip, int w, int h, int spriteHover) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 1;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.actionButtonMultiSpriteHover = imageLoaderNew(spriteHover);
		tab.width = w;
		tab.height = h;
		tab.tooltips = tooltip;
	}

	public void setConfigFrame(int frame) {
		valueIndexArray = new int[1][3];
		valueIndexArray[0][0] = 5;
		valueIndexArray[0][1] = frame;
		valueIndexArray[0][2] = 0;
	}

	public void setScriptCompare(int configId) {
		scriptCompareType = new int[1];
		scriptCompareValue = new int[1];
		scriptCompareType[0] = 1;
		scriptCompareValue[0] = configId;
	}

	public static void addConfigButton(int ID, int pID, int spriteId1, int spriteId2, int width, int height, String tT,
			int configID, int aT, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.parentId = pID;
		Tab.id = ID;
		Tab.setType(5);
		Tab.atActionType = aT;
		Tab.actionType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.opacity = 0;
		Tab.isMouseoverTriggered = -1;
		Tab.scriptCompareType = new int[1];
		Tab.scriptCompareValue = new int[1];
		Tab.scriptCompareType[0] = 1;
		Tab.scriptCompareValue[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoaderNew(spriteId1);
		Tab.sprite2 = imageLoaderNew(spriteId2);
		Tab.tooltip = tT;
	}

	public static void addSpriteOld(int id, String s) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoader(s);
		tab.sprite2 = imageLoader(s);
		tab.width = 512;
		tab.height = 334;
	}
	public static void addHDSprite(int id, int spriteId, String spriteName) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.id = id;
		rsi.parentId = id;
		rsi.type = 12;
		rsi.atActionType = 0;
		rsi.actionType = 0;
		rsi.opacity = (byte) 0;
		rsi.hoverType = 52;
		rsi.sprite1 = imageLoader(spriteId, spriteName);
		rsi.sprite2 = imageLoader(spriteId, spriteName);
	}

	public static void addHoverImage(int i, int j, int k, String name) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentId = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoader(j, name);
		tab.sprite2 = imageLoader(k, name);
	}
	public static void addHoveredButton(int i, String imageName, int j, int w,
			int h, int IMAGEID) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.parentId = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggereds = true;
		tab.opacity = 0;
		tab.isMouseoverTriggered = -1;
		tab.scrollMax = 0;
		addHoverImage(IMAGEID, j, j, imageName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}
	public static void addHoverButton(int i, String imageName, int j,
			int width, int height, String text, int contentType, int hoverOver,
			int aT) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentId = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.actionType = contentType;
		tab.opacity = 0;
		tab.isMouseoverTriggered = hoverOver;
		tab.sprite1 = imageLoader(j, imageName);
		tab.sprite2 = imageLoader(j, imageName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}
	public static void addSprite(int id, int spriteId, String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
	}

	public static void addSprite(int id, int spriteId) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.sprite1Number = spriteId;
		tab.sprite2Number = spriteId;
		tab.width = 1;
		tab.height = 1;
	}

	public static Sprite getSprite(int id, int spriteId) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.setType(5);
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.sprite1Number = spriteId;
		tab.sprite2Number = spriteId;
		tab.width = 1;
		tab.height = 1;
		return tab.sprite1;
	}
	public static void addSprites(int ID, int spriteId1, int spriteId2, int configId, int configFrame) {
		RSInterface tab = addTabInterface(ID);
		tab.id = ID;
		tab.parentId = ID;
		tab.setType(5);
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.width = 1;
		tab.height = 1;
		tab.scriptCompareType = new int[1];
		tab.scriptCompareValue = new int[1];
		tab.scriptCompareType[0] = 1;
		tab.scriptCompareValue[0] = configId;
		tab.valueIndexArray = new int[1][3];
		tab.valueIndexArray[0][0] = 5;
		tab.valueIndexArray[0][1] = configFrame;
		tab.valueIndexArray[0][2] = 0;
		tab.sprite1 = imageLoaderNew(spriteId1);
		tab.sprite2 = imageLoaderNew(spriteId2);
	}

	public static void addHoverButton(int i, int spriteId, int width, int height, String text, int contentType,
			int hoverOver, int aT) { // hoverable button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentId = i;
		tab.setType(5);
		tab.atActionType = aT;
		tab.actionType = contentType;
		tab.opacity = 0;
		tab.isMouseoverTriggered = hoverOver;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHoveredButton(int i, int spriteId, int w, int h, int IMAGEID) { // hoverable
																							// button
		RSInterface tab = addTabInterface(i);
		tab.parentId = i;
		tab.id = i;
		tab.setType(0);
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.invisible = true;
		tab.opacity = 0;
		tab.isMouseoverTriggered = -1;
		tab.scrollMax = 0;
		addHoverImage(IMAGEID, spriteId);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverImage(int i, int spriteId) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentId = i;
		tab.setType(5);
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.width = 512;
		tab.hoverScrollBar = true;
		tab.height = 334;
		tab.opacity = 0;
		tab.isMouseoverTriggered = 52;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
	}

	public static RSInterface addTabInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id; // 250
		tab.parentId = id; // 236
		tab.setType(0); // 262
		tab.atActionType = 0; // 217
		tab.actionType = 0;
		tab.width = 512; // 220
		tab.height = 700; // 267
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = -1; // Int 230
		return tab;
	}

	public static RSInterface addTabInterface(int id, int xStart, int xEnd, int yStart, int yEnd) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id; // 250
		tab.parentId = id; // 236
		tab.setType(0); // 262
		tab.atActionType = 0; // 217
		tab.actionType = 0;
		tab.width = 512; // 220
		tab.height = 700; // 267
		tab.opacity = (byte) 0;
		tab.isMouseoverTriggered = -1; // Int 230

		tab.interfaceStartX = xStart;
		tab.interfaceEndX = xEnd;
		tab.interfaceStartY = yStart;
		tab.interfaceEndY = yEnd;
		return tab;
	}

	private static Sprite imageLoader(String spriteName) {
		long l = (TextClass.method585(spriteName) << 8);
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite(spriteName);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return sprite;
	}

	public static void textClicked(int interfaceId, int spriteId, int xOffset, int yOffset) {
		interfaceCache[interfaceId].textSpriteClicked = imageLoaderNew(spriteId);
		interfaceCache[interfaceId].textClickedX = xOffset;
		interfaceCache[interfaceId].textClickedY = yOffset;

	}

	static Sprite imageLoaderNew(int spriteId) {
		Sprite sprite;

		try {
			if (spriteId == -1) {
				return null;
			}
			sprite = Client.cacheSprite[spriteId];
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return sprite;
	}

	/**
	 *
	 * @param childNumber
	 *            The number of child there is, in order, starting from 0, 1, 2
	 *            etc..
	 * @param interfaceID
	 *            Interface identity
	 * @param x
	 *            x-axis coord
	 * @param y
	 *            x-axis coord
	 */
	public void child(int childNumber, int interfaceID, int x, int y) {

		if (ClientDebugConfiguration.DEBUG_INTERFACES) {
			interfaceIds.add(interfaceID);
		}
		children[childNumber] = interfaceID;
		childX[childNumber] = x;
		childY[childNumber] = y;
	}

	/**
	 *
	 * @param t
	 *            The total amount of child there is. 1 is for 1 child.
	 */
	public void totalChildren(int t) {
		children = new int[t];
		childX = new int[t];
		childY = new int[t];
	}

	private Model method206(int i, int npcId) {
		Model model = (Model) aMRUNodes_264.insertFromCache((i << 16) + npcId);
		if (model != null)
			return model;

		if (i == 1)
			model = Model.getModel(npcId);
		if (i == 2) {
			model = EntityDefinition.forId(npcId).getHead();
		}
		if (i == 3)
			model = Client.myPlayer.method453();
		if (i == 4)
			model = ItemDefinition.forId(npcId).getInterfaceModel(50);
		if (i == 5)
			model = null;
		if (model != null)
			aMRUNodes_264.removeFromCache(model, (i << 16) + npcId);
		return model;
	}

	public static Sprite method207(int i, StreamLoader streamLoader, String s) {
		long l = (TextClass.method585(s) << 8) + (long) i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(streamLoader, s, i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception e) {
			if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
				e.printStackTrace();
			}
			return null;
		}
		return sprite;
	}

	public static void method208(boolean flag, Model model) {
		int i = 0; // was parameter
		int j = 5; // was parameter
		if (flag)
			return;
		aMRUNodes_264.unlinkAll();
		if (model != null && j != 4)
			aMRUNodes_264.removeFromCache(model, (j << 16) + i);
	}

	public Model method209(int j, int k, boolean flag) {
		Model model;
		if (flag) {
			model = method206(modelTypeEnabled, modelEnabled);
		} else {
			model = method206(modelTypeDisabled, mediaID);
		}
		if (model == null)
			return null;
		if (k == -1 && j == -1 && model.currentModelColors == null)
			return model;
		Model model_1 = new Model(true, Frames.isNegativeZero(k) & Frames.isNegativeZero(j), false, model);
		if (k != -1 || j != -1)
			model_1.method469();
		if (k != -1)
			model_1.method470(k);
		if (j != -1)
			model_1.method470(j);
		model_1.method479(64, 768, -50, -10, -50, true, true);

		return model_1;
	}

	public RSInterface() {
	}

	public static void addChar(int ID, int zoom) {
		RSInterface t = interfaceCache[ID] = new RSInterface();
		t.id = ID;
		t.parentId = ID;
		t.setType(6);
		t.atActionType = 0;
		t.actionType = 328;
		t.width = 180;
		t.height = 190;
		t.modelZoom = zoom;
		t.modelRotationY = 30;
		t.modelRotationX = 0;
		t.sequenceDisabled = -1;
		t.sequenceEnabled = -1;
	}

	public static void addChar(int ID, int zoom, int width, int height) {
		RSInterface t = interfaceCache[ID] = new RSInterface();
		t.id = ID;
		t.parentId = ID;
		t.setType(6);
		t.atActionType = 0;
		t.actionType = 328;
		// t.width = 180;
		// t.height = 190;
		t.width = width;
		t.height = height;
		t.modelZoom = zoom;
		t.modelRotationY = 30;
		t.modelRotationX = 0;
		t.sequenceDisabled = -1;
		t.sequenceEnabled = -1;
	}

	public static void add3dModel(int ID, int modelId) {
		RSInterface t = interfaceCache[ID] = new RSInterface();
		t.id = ID;
		t.parentId = ID;
		t.setType(6);
		t.atActionType = 0;
		t.actionType = 329;
		t.width = 180;
		t.height = 190;
		t.mediaID = modelId;
		t.modelZoom = 560;
		t.modelRotationY = 0;
		t.modelRotationX = 0;
		t.sequenceDisabled = -1;
		t.sequenceEnabled = -1;
	}

	private static Sprite LoadLunarSprite(String s) {
		Sprite sprite = imageLoader(s);
		return sprite;
	}

	public static void addLunarSprite(int i, String name) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentId = i;
		RSInterface.setType(5);
		RSInterface.atActionType = 5;
		RSInterface.actionType = 0;
		RSInterface.opacity = 0;
		RSInterface.isMouseoverTriggered = 52;
		RSInterface.sprite1 = LoadLunarSprite(name);
		RSInterface.width = 500;
		RSInterface.height = 500;
		RSInterface.tooltip = "";
	}

	public static void drawRune(int i, int spriteId, String runeName) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.setType(5);
		RSInterface.atActionType = 0;
		RSInterface.actionType = 0;
		RSInterface.opacity = 0;
		RSInterface.isMouseoverTriggered = 52;
		RSInterface.sprite1 = LoadLunarSprite("/Lunar/RUNE " + spriteId);
		RSInterface.width = 500;
		RSInterface.height = 500;
	}

	public static void addRuneText(int ID, int runeAmount, int RuneID, TextDrawingArea[] font) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentId = 1151;
		rsInterface.setType(4);
		rsInterface.atActionType = 0;
		rsInterface.actionType = 0;
		rsInterface.width = 0;
		rsInterface.height = 14;
		rsInterface.opacity = 0;
		rsInterface.isMouseoverTriggered = -1;
		rsInterface.scriptCompareType = new int[1];
		rsInterface.scriptCompareValue = new int[1];
		rsInterface.scriptCompareType[0] = 3;
		rsInterface.scriptCompareValue[0] = runeAmount;
		rsInterface.valueIndexArray = new int[1][4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = RuneID;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.centerText = true;
		rsInterface.textDrawingAreas = font[0];
		// rsInterface.textShadowed = true;
		rsInterface.message = "%1/" + runeAmount + "";
		rsInterface.popupString = "";
		// rsInterface.disabledColour = 12582912;
		// rsInterface.enabledColour = 49152;
	}

	public static void homeTeleport() {
		RSInterface RSInterface = addInterface(30000);
		RSInterface.tooltip = "Cast @gre@Lunar Home Teleport";
		RSInterface.id = 30000;
		RSInterface.parentId = 30000;
		RSInterface.setType(5);
		RSInterface.atActionType = 5;
		RSInterface.actionType = 0;
		RSInterface.opacity = 0;
		RSInterface.isMouseoverTriggered = 30001;
		RSInterface.sprite1 = imageLoaderNew(651);
		RSInterface.width = 20;
		RSInterface.height = 20;
		RSInterface Int = addInterface(30001);
		Int.invisible = true;
		Int.totalChildren(1);
		addLunarSprite(30002, "/Lunar/SPRITE 0");
		setBounds(30002, 0, 0, 0, Int);
	}

	public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1, int ra2, int rune1, int lvl, String name,
			String descr, TextDrawingArea[] TDA, int sid, int suo, int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentId = 1151;
		rsInterface.setType(5);
		rsInterface.atActionType = type;
		rsInterface.actionType = 0;
		rsInterface.isMouseoverTriggered = ID + 1;
		rsInterface.selectedActionName = "Cast On";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.scriptCompareType = new int[3];
		rsInterface.scriptCompareValue = new int[3];
		rsInterface.scriptCompareType[0] = 3;
		rsInterface.scriptCompareValue[0] = ra1;
		rsInterface.scriptCompareType[1] = 3;
		rsInterface.scriptCompareValue[1] = ra2;
		rsInterface.scriptCompareType[2] = 3;
		rsInterface.scriptCompareValue[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.sprite2 = LoadLunarSprite("/Lunar/LUNARON " + sid);
		rsInterface.sprite1 = LoadLunarSprite1(Config.PRE_EOC ? sid : (468 + sid + (186)));
		boolean isUsed = false;
		for (int index = 0; index < usedVengeanceInterfaceSprites.length; index++) {
			if (sid == usedVengeanceInterfaceSprites[index]) {
				isUsed = true;
				break;
			}
		}
		if (!isUsed) {
			rsInterface.sprite2 = rsInterface.sprite1;
		}
		RSInterface INT = addInterface(ID + 1);
		INT.invisible = true;
		INT.totalChildren(7);
		addLunarSprite(ID + 2, "/Lunar/BOX 0");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 19, 2, INT);
		setBounds(30016, 37, 35, 3, INT);
		setBounds(rune1, 112, 35, 4, INT);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 50, 66, 5, INT);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 123, 66, 6, INT);

	}

	private static Sprite LoadLunarSprite1(int spriteId) {
		Sprite sprite = imageLoaderNew(spriteId);
		return sprite;
	}

	private final static int[] usedVengeanceInterfaceSprites = { 35, 36 };

	public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3, int rune1,
			int rune2, int lvl, String name, String descr, TextDrawingArea[] TDA, int sid, int suo, int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentId = 1151;
		rsInterface.setType(5);
		rsInterface.atActionType = type;
		rsInterface.actionType = 0;
		rsInterface.isMouseoverTriggered = ID + 1;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.scriptCompareType = new int[4];
		rsInterface.scriptCompareValue = new int[4];
		rsInterface.scriptCompareType[0] = 3;
		rsInterface.scriptCompareValue[0] = ra1;
		rsInterface.scriptCompareType[1] = 3;
		rsInterface.scriptCompareValue[1] = ra2;
		rsInterface.scriptCompareType[2] = 3;
		rsInterface.scriptCompareValue[2] = ra3;
		rsInterface.scriptCompareType[3] = 3;
		rsInterface.scriptCompareValue[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = sid == 36 ? imageLoaderNew(694) : LoadLunarSprite("/Lunar/LUNARON " + sid);
		rsInterface.sprite1 = LoadLunarSprite1(Config.PRE_EOC ? sid : (468 + sid + (186)));
		boolean isUsed = false;
		for (int index = 0; index < usedVengeanceInterfaceSprites.length; index++) {
			if (sid == usedVengeanceInterfaceSprites[index]) {
				isUsed = true;
				break;
			}
		}
		if (!isUsed) {
			rsInterface.sprite2 = rsInterface.sprite1;
		}
		RSInterface INT = addInterface(ID + 1);
		INT.invisible = true;
		INT.totalChildren(9);
		addLunarSprite(ID + 2, "/Lunar/BOX 0");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 19, 2, INT);
		setBounds(30016, 14, 35, 3, INT);
		setBounds(rune1, 74, 35, 4, INT);
		setBounds(rune2, 130, 35, 5, INT);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 66, 6, INT);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 66, 7, INT);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 66, 8, INT);
	}

	public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3, int rune1,
			int rune2, int lvl, String name, String descr, TextDrawingArea[] TDA, int sid, int suo, int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentId = 1151;
		rsInterface.setType(5);
		rsInterface.atActionType = type;
		rsInterface.actionType = 0;
		rsInterface.isMouseoverTriggered = ID + 1;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.scriptCompareType = new int[4];
		rsInterface.scriptCompareValue = new int[4];
		rsInterface.scriptCompareType[0] = 3;
		rsInterface.scriptCompareValue[0] = ra1;
		rsInterface.scriptCompareType[1] = 3;
		rsInterface.scriptCompareValue[1] = ra2;
		rsInterface.scriptCompareType[2] = 3;
		rsInterface.scriptCompareValue[2] = ra3;
		rsInterface.scriptCompareType[3] = 3;
		rsInterface.scriptCompareValue[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = sid == 35 ? imageLoaderNew(693) : LoadLunarSprite("/Lunar/LUNARON " + sid);
		rsInterface.sprite1 = LoadLunarSprite1(Config.PRE_EOC ? sid : (468 + sid + (186)));
		boolean isUsed = false;
		for (int index = 0; index < usedVengeanceInterfaceSprites.length; index++) {
			if (sid == usedVengeanceInterfaceSprites[index]) {
				isUsed = true;
				break;
			}
		}
		if (!isUsed) {
			rsInterface.sprite2 = rsInterface.sprite1;
		}
		RSInterface INT = addInterface(ID + 1);
		INT.invisible = true;
		INT.totalChildren(9);
		addLunarSprite(ID + 2, "/Lunar/BOX 1");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 21, 2, INT);
		setBounds(30016, 14, 48, 3, INT);
		setBounds(rune1, 74, 48, 4, INT);
		setBounds(rune2, 130, 48, 5, INT);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 79, 6, INT);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 79, 7, INT);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 79, 8, INT);
	}

	public static void surgeSpell() {

		int id = 41_239;

		runesBox3(id + 1, "Air Surge", "A very high level air missile", 81, 556, 6, 565, 0, 562, 1);
		interfaceCache[id] = new RSInterface();
		interfaceCache[id].hoverType = id + 1;
		interfaceCache[id].id = id;
		interfaceCache[id].sprite1 = imageLoaderNew(1225);
		interfaceCache[id].sprite2 = imageLoaderNew(1226);

		interfaceCache[id].atActionType = 2;
		interfaceCache[id].width = interfaceCache[id].sprite1.myWidth;
		interfaceCache[id].height = interfaceCache[id].sprite1.myHeight;
		interfaceCache[id].spellName = "Air Surge";
		interfaceCache[id].spellUsableOn = 10;
		interfaceCache[id].selectedActionName = "Cast On";
		interfaceCache[id].type = 5;
		interfaceCache[id].scriptCompareType = new int[] {0, 0, 1, 1, 61};
		interfaceCache[id].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[id].valueIndexArray = new int[][] {{4, 3214, 557, 0}, {4, 3214, 566, 0},
				{4, 3214, 562, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941, 10, 1688, 13943, 0}, {1, 6, 0},};

		id += 3;

		runesBox3(id + 1, "Water Surge", "A very high level water missile", 81, 556, 6, 565, 0, 562,
				1);
		interfaceCache[id] = new RSInterface();
		interfaceCache[id].hoverType = id + 1;
		interfaceCache[id].id = id;
		interfaceCache[id].sprite1 = imageLoaderNew(1228);
		interfaceCache[id].sprite2 = imageLoaderNew(1227);

		interfaceCache[id].atActionType = 2;
		interfaceCache[id].width = interfaceCache[id].sprite1.myWidth;
		interfaceCache[id].height = interfaceCache[id].sprite1.myHeight;
		interfaceCache[id].spellName = "Water Surge";
		interfaceCache[id].spellUsableOn = 10;
		interfaceCache[id].selectedActionName = "Cast On";
		interfaceCache[id].type = 5;
		interfaceCache[id].scriptCompareType = new int[] {0, 0, 1, 1, 61};
		interfaceCache[id].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[id].valueIndexArray = new int[][] {{4, 3214, 557, 0}, {4, 3214, 566, 0},
				{4, 3214, 562, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941, 10, 1688, 13943, 0}, {1, 6, 0},};


		id += 3;

		runesBox3(id + 1, "Earth Surge", "A very high level earth missile", 81, 556, 6, 565, 0, 562,
				1);
		interfaceCache[id] = new RSInterface();
		interfaceCache[id].hoverType = id + 1;
		interfaceCache[id].id = id;
		interfaceCache[id].sprite1 = imageLoaderNew(1230);
		interfaceCache[id].sprite2 = imageLoaderNew(1229);

		interfaceCache[id].atActionType = 2;
		interfaceCache[id].width = interfaceCache[id].sprite1.myWidth;
		interfaceCache[id].height = interfaceCache[id].sprite1.myHeight;
		interfaceCache[id].spellName = "Earth Surge";
		interfaceCache[id].spellUsableOn = 10;
		interfaceCache[id].selectedActionName = "Cast On";
		interfaceCache[id].type = 5;
		interfaceCache[id].scriptCompareType = new int[] {0, 0, 1, 1, 61};
		interfaceCache[id].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[id].valueIndexArray = new int[][] {{4, 3214, 557, 0}, {4, 3214, 566, 0},
				{4, 3214, 562, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941, 10, 1688, 13943, 0}, {1, 6, 0},};

		id += 3;

		runesBox3(id + 1, "Fire Surge", "A very high level fire missile", 81, 556, 6, 565, 0, 562, 1);
		interfaceCache[id] = new RSInterface();
		interfaceCache[id].hoverType = id + 1;
		interfaceCache[id].id = id;
		interfaceCache[id].sprite1 = imageLoaderNew(1231);
		interfaceCache[id].sprite2 = imageLoaderNew(1230);

		interfaceCache[id].atActionType = 2;
		interfaceCache[id].width = interfaceCache[id].sprite1.myWidth;
		interfaceCache[id].height = interfaceCache[id].sprite1.myHeight;
		interfaceCache[id].spellName = "Fire Surge";
		interfaceCache[id].spellUsableOn = 10;
		interfaceCache[id].selectedActionName = "Cast On";
		interfaceCache[id].type = 5;
		interfaceCache[id].scriptCompareType = new int[] {0, 0, 1, 1, 61};
		interfaceCache[id].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[id].valueIndexArray = new int[][] {{4, 3214, 557, 0}, {4, 3214, 566, 0},
				{4, 3214, 562, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941, 10, 1688, 13943, 0}, {1, 6, 0},};

	}
	public static void miasmics()
	{
		surgeSpell();
		runesBox3(32601, "Miasmic Rush", "A single-target miasmic attack.", 61,
				557, 0, 566, 0, 562, 1);
		interfaceCache[32600] = new RSInterface();
		interfaceCache[32600].hoverType = 32601;
		interfaceCache[32600].id =32600;
		interfaceCache[32600].sprite1 = imageLoaderNew(1064);
		interfaceCache[32600].sprite2 = imageLoaderNew(1065);
		
		interfaceCache[32600].atActionType = 2;
		interfaceCache[32600].width = 20;
		interfaceCache[32600].height = 20;
		interfaceCache[32600].spellName = "Miasmic Rush";
		interfaceCache[32600].spellUsableOn = 10;
		interfaceCache[32600].selectedActionName = "Cast On";
		interfaceCache[32600].type = 5;
		interfaceCache[32600].scriptCompareType = new int[] {0, 0, 1, 1, 61};
		interfaceCache[32600].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[32600].valueIndexArray = new int[][] {
				{4, 3214, 557, 0},
				{4, 3214, 566, 0},
				{4, 3214, 562, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941
					, 10, 1688, 13943, 0},
				{1, 6, 0},
		};

		runesBox3(32621, "Miasmic Burst", "A multi-target miasmic attack.", 73,
				557, 1, 566, 1, 562, 3);
		interfaceCache[32620] = new RSInterface();
		interfaceCache[32620].hoverType = 32621;
		interfaceCache[32620].id =32620;
		interfaceCache[32620].sprite1 = imageLoaderNew(1066); // off
		interfaceCache[32620].sprite2 = imageLoaderNew(1067);
		interfaceCache[32620].atActionType = 2;
		interfaceCache[32620].width = 20;
		interfaceCache[32620].height = 20;
		interfaceCache[32620].spellName = "Miasmic Burst";
		interfaceCache[32620].spellUsableOn = 10;
		interfaceCache[32620].selectedActionName = "Cast On";
		interfaceCache[32620].type = 5;
		interfaceCache[32620].scriptCompareType = new int[] {1, 1, 3, 1, 73};
		interfaceCache[32620].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[32620].valueIndexArray = new int[][] {
				{4, 3214, 557, 0},
				{4, 3214, 566, 0},
				{4, 3214, 562, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941
					, 10, 1688, 13943, 0}, 
				{1, 6, 0},
		};
		runesBox3(32641, "Miasmic Blitz", "A strong single-target\\n miasmic attack.", 85,
				557, 2, 566, 2, 565, 1);
		interfaceCache[32640] = new RSInterface();
		interfaceCache[32640].hoverType = 32641;
		interfaceCache[32640].id =32640;
		interfaceCache[32640].sprite1 = imageLoaderNew(1068);
		interfaceCache[32640].sprite2 = imageLoaderNew(1069);
		interfaceCache[32640].atActionType = 2;
		interfaceCache[32640].width = 20;
		interfaceCache[32640].height = 20;
		interfaceCache[32640].spellName = "Miasmic Blitz";
		interfaceCache[32640].spellUsableOn = 10;
		interfaceCache[32640].selectedActionName = "Cast On";
		interfaceCache[32640].type = 5;
		interfaceCache[32640].scriptCompareType = new int[] {2, 2, 1, 1, 85};
		interfaceCache[32640].scriptCompareValue = new int[] {3, 3, 3, 3, 3};
		interfaceCache[32640].valueIndexArray = new int[][] {
				{4, 3214, 557, 0},
				{4, 3214, 566, 0},
				{4, 3214, 565, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941
					, 10, 1688, 13943, 0},
				{1, 6, 0},
		};

		runesBox3(32661, "Miasmic Barrage", "A strong multi-target \\nmiasmic attack.", 95,
				557, 3, 566, 3, 565, 3);
		interfaceCache[32660] = new RSInterface();
		interfaceCache[32660].hoverType = 32661;
		interfaceCache[32660].id =32660;
		interfaceCache[32660].sprite1 = imageLoaderNew(1070);
		interfaceCache[32660].sprite2 = imageLoaderNew(1071);
		interfaceCache[32660].atActionType = 2;
		interfaceCache[32660].width = 20;
		interfaceCache[32660].height = 20;
		interfaceCache[32660].spellName = "Miasmic Barrage";
		interfaceCache[32660].spellUsableOn = 10;
		interfaceCache[32660].selectedActionName = "Cast On";
		interfaceCache[32660].type = 5;
		interfaceCache[32660].scriptCompareType = new int[] {3, 3, 3,3, 95};
		interfaceCache[32660].scriptCompareValue = new int[] {3, 3, 3,3, 3};
		interfaceCache[32660].valueIndexArray = new int[][] {
				{4, 3214, 557, 0},
				{4, 3214, 566, 0},
				{4, 3214, 565, 0},
				{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941
					, 10, 1688, 13943, 0},
				{1, 6, 0},
		};
	}
	
	public static void runesBox3(int id, String spellName, String desc, int level, 
			int rune1, int rune1amt, int rune2, int rune2amt, int rune3, int rune3amt)
	{
		interfaceCache[id] = new RSInterface();
		interfaceCache[id].id = id;
		interfaceCache[id].height = 76;
		interfaceCache[id].width = 182;
		interfaceCache[id].atActionType = interfaceCache[id].actionType = 0;
		interfaceCache[id].hoverType = -1;
		interfaceCache[id].type = 0;
		interfaceCache[id].isMouseoverTriggereds = true;
		addText(id+1, "Level "+level+" "+spellName, fonts, 1, 0xFE981F, true, true);
		addText(id+2, desc, fonts, 0, 0xAF6A1A, true, true);
		
		//		addModel(id+3, ItemDefinition.forId(rune1).inventoryModel, 512, 1024, 900, 28, 28);
		//		addModel(id+4, ItemDefinition.forId(rune2).inventoryModel, 512, 1024, 900, 28, 28);
		//		addModel(id+5, ItemDefinition.forId(rune3).inventoryModel, 512, 1024, 900, 28, 28);
		//		addModel(id+9, ItemDefinition.forId(13867).inventoryModel, 512, 1024, 2200, 35, 35);
		
		addText(id+6, "%1/"+(rune1amt+1), fonts, 0, 0xC00000, true, true);
		interfaceCache[id+6].textColour = 0x00C000;
		interfaceCache[id+6].message = "%1/"+(rune1amt+1);
		interfaceCache[id+6].actionType = 0;
		interfaceCache[id+6].scriptCompareType = new int[] {rune1amt};
		interfaceCache[id+6].scriptCompareValue = new int[] {3};
		interfaceCache[id+6].valueIndexArray = new int[][] {{4, 3214, rune1, 0}};

		addText(id+7, "%1/"+(rune2amt+1), fonts, 0, 0xC00000, true, true);
		interfaceCache[id+7].textColour = 0x00C000;
		interfaceCache[id+7].message = "%1/"+(rune2amt+1);
		interfaceCache[id+7].actionType = 0;
		interfaceCache[id+7].scriptCompareType = new int[] {rune2amt};
		interfaceCache[id+7].scriptCompareValue = new int[] {3};
		interfaceCache[id+7].valueIndexArray = new int[][] {{4, 3214, rune2, 0}};

		addText(id+8, "%1/"+(rune3amt+1), fonts, 0, 0xC00000, true, true);
		interfaceCache[id+8].textColour = 0x00C000;
		interfaceCache[id+8].message = "%1/"+(rune3amt+1);
		interfaceCache[id+8].actionType = 0;
		interfaceCache[id+8].scriptCompareType = new int[] {rune3amt};
		interfaceCache[id+8].scriptCompareValue = new int[] {3};
		interfaceCache[id+8].valueIndexArray = new int[][] {{4, 3214, rune3, 0}};
		

		addText(id+10, "%1/1", fonts, 0, 0xC00000, true, true);
		interfaceCache[id+10].textColour = 0x00C000;
		interfaceCache[id+10].message = "%1/1";
		interfaceCache[id+10].actionType = 0;
		interfaceCache[id+10].scriptCompareType = new int[] {1};
		interfaceCache[id+10].scriptCompareValue = new int[] {3};
		interfaceCache[id+10].valueIndexArray = new int[][] {{10, 1688, 13867, 10, 1688, 13869, 10, 1688, 13941
			, 10, 1688, 13943, 0}};
		
		setChildren(11, interfaceCache[id]);
		setBounds(id, 0, 0, 0, interfaceCache[id]);
		setBounds(id+1, 182/2, 5, 1, interfaceCache[id]);
		setBounds(id+2, 182/2, 18, 2, interfaceCache[id]);
		setBounds(id+3, 29-20, 36, 3, interfaceCache[id]);
		setBounds(id+4, 79-30, 36, 4, interfaceCache[id]);
		setBounds(id+5, 128-40, 36, 5, interfaceCache[id]);
		setBounds(id+6, 44-20, 63, 6, interfaceCache[id]);
		setBounds(id+7, 94-30, 63, 7, interfaceCache[id]);
		setBounds(id+8, 105, 63, 8, interfaceCache[id]);
		setBounds(id+9, 130, 30, 9, interfaceCache[id]);
		setBounds(id+10, 145, 63, 10, interfaceCache[id]);
	}
	public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3, int rune1,
			int rune2, int lvl, String name, String descr, TextDrawingArea[] TDA, int sid, int suo, int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentId = 1151;
		rsInterface.setType(5);
		rsInterface.atActionType = type;
		rsInterface.actionType = 0;
		rsInterface.isMouseoverTriggered = ID + 1;
		// rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.scriptCompareType = new int[4];
		rsInterface.scriptCompareValue = new int[4];
		rsInterface.scriptCompareType[0] = 3;
		rsInterface.scriptCompareValue[0] = ra1;
		rsInterface.scriptCompareType[1] = 3;
		rsInterface.scriptCompareValue[1] = ra2;
		rsInterface.scriptCompareType[2] = 3;
		rsInterface.scriptCompareValue[2] = ra3;
		rsInterface.scriptCompareType[3] = 3;
		rsInterface.scriptCompareValue[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = LoadLunarSprite("/Lunar/LUNARON " + sid);
		rsInterface.sprite1 = LoadLunarSprite1(Config.PRE_EOC ? sid : (468 + sid + (186)));
		boolean isUsed = false;
		for (int index = 0; index < usedVengeanceInterfaceSprites.length; index++) {
			if (sid == usedVengeanceInterfaceSprites[index]) {
				isUsed = true;
				break;
			}
		}
		if (!isUsed) {
			rsInterface.sprite2 = rsInterface.sprite1;
		}
		RSInterface INT = addInterface(ID + 1);
		INT.invisible = true;
		INT.totalChildren(9);
		addLunarSprite(ID + 2, "/Lunar/BOX 2");
		setBounds(ID + 2, 0, 0, 0, INT);
		addText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID + 3, 90, 4, 1, INT);
		addText(ID + 4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		setBounds(ID + 4, 90, 34, 2, INT);
		setBounds(30016, 14, 61, 3, INT);
		setBounds(rune1, 74, 61, 4, INT);
		setBounds(rune2, 130, 61, 5, INT);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 92, 6, INT);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 92, 7, INT);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 92, 8, INT);
	}

	public static void constructLunar() {
		RSInterface Interface = addTabInterface(29999);
		setChildren(Config.PRE_EOC ? 81 : 80, Interface);
		setBounds(30000, 10, 15, 0, Interface);
		setBounds(30017, 39, 15, 1, Interface);
		setBounds(30025, 68, 17, 2, Interface);
		setBounds(30032, 97, 15, 3, Interface);
		setBounds(30040, 126, 17, 4, Interface);
		setBounds(30048, 155, 15, 5, Interface);
		setBounds(30056, 9, 44, 6, Interface);
		setBounds(30064, 39, 44, 7, Interface);
		setBounds(30075, 68, 44, 8, Interface);
		setBounds(30083, 97, 44, 9, Interface);
		setBounds(30091, 126, 44, 10, Interface);
		setBounds(30099, 157, 43, 11, Interface);
		setBounds(30106, 10, 73, 12, Interface);
		setBounds(30114, 39, 73, 13, Interface);
		setBounds(30122, 67, 72, 14, Interface);
		setBounds(30130, 97, 73, 15, Interface);
		setBounds(30138, 127, 73, 16, Interface);
		setBounds(30146, 158, 73, 17, Interface);
		setBounds(30154, 13, 101, 18, Interface);
		setBounds(30162, 39, 102, 19, Interface);
		setBounds(30170, 68, 102, 20, Interface);
		setBounds(30178, 96, 102, 21, Interface);
		setBounds(30186, 127, 102, 22, Interface);
		setBounds(30194, 161, 103, 23, Interface);
		setBounds(30202, 9, 131, 24, Interface);
		setBounds(30210, 40, 131, 25, Interface);
		setBounds(30218, 71, 132, 26, Interface);
		setBounds(30226, 97, 131, 27, Interface);
		setBounds(30234, 127, 131, 28, Interface);
		setBounds(30242, 157, 131, 29, Interface);
		setBounds(30250, 10, 160, 30, Interface);
		setBounds(30258, 39, 160, 31, Interface);
		setBounds(30266, 68, 160, 32, Interface);
		setBounds(30274, 97, 160, 33, Interface);
		setBounds(30282, 130, 160, 34, Interface);
		setBounds(30290, 155, 160, 35, Interface);
		setBounds(30298, 12, 189, 36, Interface);
		setBounds(30306, 41, 189, 37, Interface);
		setBounds(30314, 67, 187, 38, Interface);
		setBounds(30322, 97, 188, 39, Interface);
		setBounds(30001, 5, 184, 40, Interface); // hover
		setBounds(30018, 5, 176, 41, Interface); // hover
		setBounds(30026, 5, 176, 42, Interface); // hover
		setBounds(30033, 5, 163, 43, Interface); // hover
		setBounds(30041, 5, 176, 44, Interface); // hover
		setBounds(30049, 5, 176, 45, Interface); // hover
		setBounds(30057, 5, 176, 46, Interface); // hover
		setBounds(30065, 5, 176, 47, Interface); // hover
		setBounds(30076, 5, 163, 48, Interface); // hover
		setBounds(30084, 5, 176, 49, Interface); // hover
		setBounds(30092, 5, 176, 50, Interface); // hover
		setBounds(30100, 5, 176, 51, Interface); // hover
		setBounds(30107, 5, 176, 52, Interface); // hover
		setBounds(30115, 5, 163, 53, Interface); // hover
		setBounds(30123, 5, 176, 54, Interface); // hover
		setBounds(30131, 5, 163, 55, Interface); // hover
		setBounds(30139, 5, 163, 56, Interface); // hover
		setBounds(30147, 5, 163, 57, Interface); // hover
		setBounds(30155, 5, 176, 58, Interface); // hover
		setBounds(30163, 5, 176, 59, Interface); // hover
		setBounds(30171, 5, 176, 60, Interface); // hover
		setBounds(30179, 5, 163, 61, Interface); // hover
		setBounds(30187, 5, 176, 62, Interface); // hover
		setBounds(30195, 5, 149, 63, Interface); // hover
		setBounds(30203, 5, 176, 64, Interface); // hover
		setBounds(30211, 5, 163, 65, Interface); // hover
		setBounds(30219, 5, 163, 66, Interface); // hover
		setBounds(30227, 5, 176, 67, Interface); // hover
		setBounds(30235, 5, 149, 68, Interface); // hover
		setBounds(30243, 5, 176, 69, Interface); // hover
		setBounds(30251, 5, 5, 70, Interface); // hover
		setBounds(30259, 5, 5, 71, Interface); // hover
		setBounds(30267, 5, 5, 72, Interface); // hover
		setBounds(30275, 5, 5, 73, Interface); // hover
		setBounds(30283, 5, 5, 74, Interface); // hover
		setBounds(30291, 5, 5, 75, Interface); // hover
		setBounds(30299, 5, 5, 76, Interface); // hover
		setBounds(30307, 5, 5, 77, Interface); // hover
		setBounds(30323, 5, 5, 78, Interface); // hover
		setBounds(30315, 5, 5, 79, Interface); // hover
		if (Config.PRE_EOC) {
			setBounds(38_292, 0, 0, 80, Interface); // bottom filter
		}
	}

	public static ArrayList<Integer> interfaceIds = new ArrayList<Integer>();

	public static void setBounds(int id, int X, int Y, int frame, RSInterface RSinterface) {
		if (ClientDebugConfiguration.DEBUG_INTERFACES) {
			interfaceIds.add(id);
		}
		RSinterface.children[frame] = id;
		RSinterface.childX[frame] = X;
		RSinterface.childY[frame] = Y;
	}

	public static void addButton(int i, String name, int W, int H, String S, int AT) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentId = i;
		RSInterface.setType(5);
		RSInterface.atActionType = AT;
		RSInterface.actionType = 0;
		RSInterface.opacity = 0;
		RSInterface.isMouseoverTriggered = 52;
		RSInterface.sprite1 = imageLoader(name);
		RSInterface.sprite2 = imageLoader(name);
		RSInterface.width = W;
		RSInterface.height = H;
		RSInterface.tooltip = S;
	}

	public DropdownMenu dropDown;

	public boolean hovered = false;

	public RSInterface dropDownOpen;

	public int dropDownHover = -1;

	public static void addDropdownMenu(int identification, int width, int defaultOption, boolean split, boolean center,
			Dropdown dropdown, String... options) {
		addDropdownMenu(identification, width, defaultOption, 0xFD961E, split, center, dropdown, options);
	}

	public static void addDropdownMenu(int identification, int width, int defaultOption, int textColor, boolean split,
			boolean center, Dropdown dropdown, String... options) {
		RSInterface dropdownMenu = addInterface(identification);
		dropdownMenu.type = 69;
		dropdownMenu.atActionType = 69;
		dropdownMenu.centerText = center;
		dropdownMenu.textColour = textColor;
		dropdownMenu.message = "";
		dropdownMenu.dropDown = new DropdownMenu(width, defaultOption, dropdown, options);
	}

	public static void addTransparentSprite(int id, int spriteId, int i) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentId = id;
		tab.transparency = i;
		tab.setType(5);
		tab.atActionType = 0;
		tab.actionType = 0;
		tab.sprite1 = imageLoaderNew(spriteId);
		tab.sprite2 = imageLoaderNew(spriteId);
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static void reloadInterfaces(boolean once) {
		if (ClientDebugConfiguration.RELOAD_INTERFACE_DISABLED) {
			return;
		}
		if (!Client.interfacesReloadLoop) {
			return;
		}
		if (System.currentTimeMillis() - Client.InterfaceReloadTime < 2000 && !once) {
			return;
		}
		Client.InterfaceReloadTime = System.currentTimeMillis();
		Client.interfacesReloaded = true;
		loadDebugSprites();

		TextDrawingArea aTextDrawingArea_1273 = new TextDrawingArea(true, "q8_full", Client.instance.titleStreamLoader);
		TextDrawingArea aclass30_sub2_sub1_sub4s[] = { Client.instance.smallText, Client.instance.aTextDrawingArea_1271,
				Client.instance.chatTextDrawingArea, aTextDrawingArea_1273 };
		StreamLoader streamLoader_1 = Client.instance.streamLoaderForName(3, "interface", "interface",
				Client.instance.expectedCRCs[3], 35);
		StreamLoader streamLoader_2 = Client.instance.streamLoaderForName(4, "2d graphics", "media",
				Client.instance.expectedCRCs[4], 40);
		RSInterface.unpack(streamLoader_1, aclass30_sub2_sub1_sub4s, streamLoader_2);

		if (once) {
			Client.interfacesReloadLoop = false;
		}
	}

	public static StreamLoader aClass44;

	public boolean drawsTransparent;

	public Sprite sprite1;

	public int sprite1Number = -1;

	public int sprite2Number = -1;

	/**
	 * The clicked version sprite.
	 */
	public Sprite spriteClicked;

	/**
	 * True to set the id to be clicked.
	 */
	public boolean isClicked;

	/**
	 * The clicked version sprite.
	 */
	public Sprite textSpriteClicked;

	public Sprite actionButtonMultiSpriteHover;

	/**
	 * True to set the id to be clicked.
	 */
	public boolean textIsClicked;

	public int interfaceId;

	public int textClickedX;

	public int textClickedY;

	public int sequenceCycle;

	public Sprite sprites[];

	public static RSInterface interfaceCache[];

	public int scriptCompareValue[];

	public int actionType; // anInt214

	public int spritesX[];

	public int hoverColorDisabled;

	public int atActionType;

	public int interfaceStartX;

	public int interfaceStartY;

	public int interfaceEndX;

	public int interfaceEndY;

	public String spellName;

	public int colourEnabled;

	public int width;

	public int mysteryBoxX = -1;

	public String tooltip;

	public String[] tooltips;

	public String selectedActionName;

	public boolean centerText;

	public int scrollPosition;

	public String actions[];

	public int valueIndexArray[][];

	public boolean isFilled;

	public String messageEnabled;

	public int isMouseoverTriggered;

	public boolean isMouseoverTriggereds;

	public int invSpritePadX;

	public int textColour;

	public int modelTypeDisabled;

	public int mediaID;

	public boolean itemsAreSwappable;

	public int parentId;

	public int spellUsableOn;

	private static ReferenceCache aMRUNodes_238;

	public int hoverColorEnabled;

	public int children[];

	public int childX[];

	public boolean usableItemInterface;

	public TextDrawingArea textDrawingAreas;

	public int invSpritePadY;

	public int scriptCompareType[];

	public int sequenceFrame;

	public int spritesY[];

	public String message = "";

	public boolean isInventoryInterface;

	public int id;

	public int textSize;

	public int toolTipSpecialX;

	public int toolTipSpecialY;

	public int invStackSizes[];

	public boolean removeStackableNumber;

	public int inv[];

	public byte opacity;

	private int modelTypeEnabled;

	private int modelEnabled;

	public int sequenceDisabled;

	public boolean disableModel;

	public int sequenceEnabled;

	public boolean itemsAreDraggable;

	public Sprite sprite2;

	public int scrollMax;

	public int type;

	public boolean ignoreItemAmounts;

	public int hoverType;

	public int offsetX;

	private static final ReferenceCache aMRUNodes_264 = new ReferenceCache(30);

	public int offsetY;

	public boolean invisible;

	public int height;

	public boolean textShadow;

	public int modelZoom;

	public int modelRotationY;

	public int modelRotationX;

	public int childY[];

	public boolean hasType9Hover;

	public int type9HoverXposition;

	public int type9HoverYposition;

	public static TextDrawingArea[] fonts;

	public static TextDrawingArea[] RSFont;

	public boolean hoverHasText;

	public String hoverText;

	public boolean hoverScrollBar;

	public int transparency;

	public int mediaIdOffset2;

	public int mediaIdOffset1;

	public String popupString;

	public int invStartIndex;

	public boolean rounded;

	public int colour;

	public boolean childInvisibilitySupported;

	public boolean componentSupportsItemOpacity;

	/**
	 * True to draw a sprite that uses sprite.drawAdvancedSprite method, where
	 * rather than making purple parts invisible, it will make invisible parts
	 * in the image actually invisible.
	 */
	public boolean drawAdvancedSprite;

	/**
	 * The amount of seconds left on this text interface. This is used to set
	 * the amount of seconds this text will represent as a countdown timer.
	 * <p>
	 * Which is used on the Donator interface main tab to show a special offer
	 * that is on limited time. So it will show 24h 34m 43s for example.
	 */
	public int textCountDownSecondsLeft;

	/**
	 * The time of when {@link #textCountDownSecondsLeft} was reduced, so it
	 * only gets reduced every second.
	 */
	public long textCountDownTimeReduced;

	/**
	 * The percentage of the sprite to show. It will load from left to right.
	 * Used for loading bars.
	 */
	public int spriteLoadingBarPercentage = -1;

	private boolean debug;

	public static void setSpriteLoadingBarPercentage(int interfaceId, int percentage) {
		RSInterface.interfaceCache[interfaceId].spriteLoadingBarPercentage = percentage;
	}

	public static void loadDebugSprites() {
		String path = ClientConstants.getCacheLocation() + "sprites_debug/sprites";
		int amount = new File(path).listFiles().length;
		Client.cacheSprite = new Sprite[amount];

		for (int i = 0; i < amount; i++) {
			String location = path + "/" + i;
			if (!new File(location + ".png").exists())
			{
				Utility.print("MISSING SPRITE: " + location + ".png");
			}
			Client.cacheSprite[i] = new Sprite(location, "");
		}
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Handles the operation of an interfaceId that has a
	 * {@link RSInterface#textCountDownSecondsLeft}
	 *
	 * @author Lava, created on 27-03-2018.
	 */
	public static class TextCountDown {

		/**
		 * Store the {@link #TextCountDown} object in a list.
		 */
		public static ArrayList<TextCountDown> textCountDownList = new ArrayList<TextCountDown>();

		/**
		 * The Parent interface id which contains the text count down.
		 */
		private int textCountDownParentInterfaceId;

		/**
		 * The interface id which is the text count down itself.
		 */
		private int interfaceChildId;

		/**
		 * {@link #textCountDownParentInterfaceId}
		 */
		public int getTextCountDownParentInterfaceId() {
			return textCountDownParentInterfaceId;
		}

		/**
		 * {@link #textCountDownParentInterfaceId}
		 */
		public void setTextCountDownParentInterfaceId(int textCountDownParentInterfaceId) {
			this.textCountDownParentInterfaceId = textCountDownParentInterfaceId;
		}

		/**
		 * {@link #interfaceChildId}
		 */
		public int getInterfaceChildId() {
			return interfaceChildId;
		}

		/**
		 * {@link #interfaceChildId}
		 */
		public void setInterfaceChildId(int interfaceChildId) {
			this.interfaceChildId = interfaceChildId;
		}

		/**
		 * @param textCountDownParentInterfaceId
		 *            {@link #textCountDownParentInterfaceId}
		 * @param interfaceChildId
		 *            {@link #interfaceChildId}
		 */
		public TextCountDown(int textCountDownParentInterfaceId, int interfaceChildId) {
			this.setTextCountDownParentInterfaceId(textCountDownParentInterfaceId);
			this.setInterfaceChildId(interfaceChildId);
		}

		/**
		 * Called on the main game loop when logged in-game to find out if the
		 * parent interface id is opened and then to reduce the text count down.
		 */
		public static void handleTextCountDownReduction(int interfaceId) {
			if (interfaceId == 0) {
				return;
			}
			for (int index = 0; index < textCountDownList.size(); index++) {
				TextCountDown instance = textCountDownList.get(index);
				if (instance.getTextCountDownParentInterfaceId() == interfaceId) {
					textCountDownParentInterfaceFound(instance.getInterfaceChildId());
				}
			}

		}

		/**
		 * Reduce the text count down.
		 */
		private static void textCountDownParentInterfaceFound(int interfaceChildId) {
			RSInterface instance = RSInterface.interfaceCache[interfaceChildId];
			if (instance.textCountDownSecondsLeft > 0) {
				if (System.currentTimeMillis() - instance.textCountDownTimeReduced < 1000) {
					return;
				}
				instance.textCountDownTimeReduced = System.currentTimeMillis();
				instance.textCountDownSecondsLeft--;
				instance.message = Utility.getTimeLeft(instance.textCountDownSecondsLeft);

				// Xp bonus interface countdown id.
				if (instance.id == 21372 && instance.textCountDownSecondsLeft == 0) {
					Client.showXpBonusInterface = false;
				}
			}
		}

	}

	public static RSInterface copy(int id, int parentId, RSInterface from) {
		RSInterface copy = addInterface(id);

		copy.id = id;
		copy.parentId = parentId;
		copy.dropDown = from.dropDown;
		copy.hovered = from.hovered;
		copy.dropDownOpen = from.dropDownOpen;
		copy.dropDownHover = from.dropDownHover;
		copy.drawsTransparent = from.drawsTransparent;
		copy.sprite1 = from.sprite1;
		copy.sprite1Number = from.sprite1Number;
		copy.sprite2Number = from.sprite2Number;
		copy.spriteClicked = from.spriteClicked;
		copy.isClicked = from.isClicked;
		copy.textSpriteClicked = from.textSpriteClicked;
		copy.actionButtonMultiSpriteHover = from.actionButtonMultiSpriteHover;
		copy.textIsClicked = from.textIsClicked;
		copy.interfaceId = from.interfaceId;
		copy.textClickedX = from.textClickedX;
		copy.textClickedY = from.textClickedY;
		copy.sequenceCycle = from.sequenceCycle;
		copy.sprites = from.sprites;
		if (from.scriptCompareValue != null) {
			copy.scriptCompareValue = Arrays.copyOf(from.scriptCompareValue, from.scriptCompareValue.length);
		}
		copy.actionType = from.actionType;
		copy.spritesX = from.spritesX;
		copy.hoverColorDisabled = from.hoverColorDisabled;
		copy.atActionType = from.atActionType;
		copy.interfaceStartX = from.interfaceStartX;
		copy.interfaceStartY = from.interfaceStartY;
		copy.interfaceEndX = from.interfaceEndX;
		copy.interfaceEndY = from.interfaceEndY;
		copy.spellName = from.spellName;
		copy.colourEnabled = from.colourEnabled;
		copy.width = from.width;
		copy.mysteryBoxX = from.mysteryBoxX;
		copy.tooltip = from.tooltip;
		copy.tooltips = from.tooltips;
		copy.selectedActionName = from.selectedActionName;
		copy.centerText = from.centerText;
		copy.scrollPosition = from.scrollPosition;
		copy.actions = from.actions;
		if (from.valueIndexArray != null) {
			copy.valueIndexArray = Arrays.copyOf(from.valueIndexArray, from.valueIndexArray.length);
		}
		copy.isFilled = from.isFilled;
		copy.messageEnabled = from.messageEnabled;
		copy.isMouseoverTriggered = from.isMouseoverTriggered;
		copy.isMouseoverTriggereds = from.isMouseoverTriggereds;
		copy.invSpritePadX = from.invSpritePadX;
		copy.textColour = from.textColour;
		copy.modelTypeDisabled = from.modelTypeDisabled;
		copy.mediaID = from.mediaID;
		copy.itemsAreSwappable = from.itemsAreSwappable;
		copy.parentId = from.parentId;
		copy.spellUsableOn = from.spellUsableOn;
		copy.hoverColorEnabled = from.hoverColorEnabled;
		copy.children = from.children;
		copy.childX = from.childX;
		copy.usableItemInterface = from.usableItemInterface;
		copy.textDrawingAreas = from.textDrawingAreas;
		copy.invSpritePadY = from.invSpritePadY;
		if (from.scriptCompareType != null) {
			copy.scriptCompareType = Arrays.copyOf(from.scriptCompareType, from.scriptCompareType.length);
		}
		copy.sequenceFrame = from.sequenceFrame;
		copy.spritesY = from.spritesY;
		copy.message = from.message;
		copy.isInventoryInterface = from.isInventoryInterface;
		copy.textSize = from.textSize;
		copy.toolTipSpecialX = from.toolTipSpecialX;
		copy.toolTipSpecialY = from.toolTipSpecialY;
		copy.invStackSizes = from.invStackSizes;
		copy.removeStackableNumber = from.removeStackableNumber;
		copy.inv = from.inv;
		copy.opacity = from.opacity;
		copy.modelTypeEnabled = from.modelTypeEnabled;
		copy.modelEnabled = from.modelEnabled;
		copy.sequenceDisabled = from.sequenceDisabled;
		copy.disableModel = from.disableModel;
		copy.sequenceEnabled = from.sequenceEnabled;
		copy.itemsAreDraggable = from.itemsAreDraggable;
		copy.sprite2 = from.sprite2;
		copy.scrollMax = from.scrollMax;
		copy.type = from.type;
		copy.ignoreItemAmounts = from.ignoreItemAmounts;
		copy.hoverType = from.hoverType;
		copy.offsetX = from.offsetX;
		copy.offsetY = from.offsetY;
		copy.invisible = from.invisible;
		copy.height = from.height;
		copy.textShadow = from.textShadow;
		copy.modelZoom = from.modelZoom;
		copy.modelRotationY = from.modelRotationY;
		copy.modelRotationX = from.modelRotationX;
		copy.childY = from.childY;
		copy.hasType9Hover = from.hasType9Hover;
		copy.type9HoverXposition = from.type9HoverXposition;
		copy.type9HoverYposition = from.type9HoverYposition;
		copy.hoverHasText = from.hoverHasText;
		copy.hoverText = from.hoverText;
		copy.hoverScrollBar = from.hoverScrollBar;
		copy.transparency = from.transparency;
		copy.mediaIdOffset2 = from.mediaIdOffset2;
		copy.mediaIdOffset1 = from.mediaIdOffset1;
		copy.popupString = from.popupString;
		copy.invStartIndex = from.invStartIndex;
		copy.rounded = from.rounded;
		copy.colour = from.colour;
		copy.childInvisibilitySupported = from.childInvisibilitySupported;
		copy.componentSupportsItemOpacity = from.componentSupportsItemOpacity;
		copy.drawAdvancedSprite = from.drawAdvancedSprite;
		copy.textCountDownSecondsLeft = from.textCountDownSecondsLeft;
		copy.textCountDownTimeReduced = from.textCountDownTimeReduced;
		copy.spriteLoadingBarPercentage = from.spriteLoadingBarPercentage;
		copy.debug = from.debug;
		copy.menuItem = from.menuItem;
		copy.menuVisible = from.menuVisible;

		return copy;
	}

	@Override
	public String toString() {
		return "RSInterface{" + "dropDown=" + dropDown + ", hovered=" + hovered + ", dropDownOpen=" + dropDownOpen
				+ ", dropDownHover=" + dropDownHover + ", drawsTransparent=" + drawsTransparent + ", sprite1=" + (sprite1 == null
				? null : Client.getIndexOfSprite(sprite1))
				+ ", sprite1Number=" + sprite1Number + ", sprite2Number=" + sprite2Number + ", spriteClicked="
				+ spriteClicked + ", isClicked=" + isClicked + ", textSpriteClicked=" + textSpriteClicked
				+ ", actionButtonMultiSpriteHover=" + actionButtonMultiSpriteHover + ", textIsClicked=" + textIsClicked
				+ ", interfaceId=" + interfaceId + ", textClickedX=" + textClickedX + ", textClickedY=" + textClickedY
				+ ", sequenceCycle=" + sequenceCycle + ", sprites=" + Arrays.toString(sprites) + ", scriptCompareValue="
				+ Arrays.toString(scriptCompareValue) + ", actionType=" + actionType + ", spritesX="
				+ Arrays.toString(spritesX) + ", hoverColorDisabled=" + hoverColorDisabled + ", atActionType="
				+ atActionType + ", interfaceStartX=" + interfaceStartX + ", interfaceStartY=" + interfaceStartY
				+ ", interfaceEndX=" + interfaceEndX + ", interfaceEndY=" + interfaceEndY + ", spellName='" + spellName
				+ '\'' + ", colourEnabled=" + colourEnabled + ", width=" + width + ", mysteryBoxX=" + mysteryBoxX
				+ ", tooltip='" + tooltip + '\'' + ", tooltips=" + Arrays.toString(tooltips) + ", selectedActionName='"
				+ selectedActionName + '\'' + ", centerText=" + centerText + ", scrollPosition=" + scrollPosition
				+ ", actions=" + Arrays.toString(actions) + ", valueIndexArray=" + Arrays.toString(valueIndexArray)
				+ ", isFilled=" + isFilled + ", messageEnabled='" + messageEnabled + '\'' + ", isMouseoverTriggered="
				+ isMouseoverTriggered + ", isMouseoverTriggereds=" + isMouseoverTriggereds + ", invSpritePadX="
				+ invSpritePadX + ", textColour=" + textColour + ", modelTypeDisabled=" + modelTypeDisabled
				+ ", mediaID=" + mediaID + ", itemsAreSwappable=" + itemsAreSwappable + ", parentId=" + parentId
				+ ", spellUsableOn=" + spellUsableOn + ", hoverColorEnabled=" + hoverColorEnabled + ", children="
				+ Arrays.toString(children) + ", childX=" + Arrays.toString(childX) + ", usableItemInterface="
				+ usableItemInterface + ", textDrawingAreas=" + textDrawingAreas + ", invSpritePadY=" + invSpritePadY
				+ ", scriptCompareType=" + Arrays.toString(scriptCompareType) + ", sequenceFrame=" + sequenceFrame
				+ ", spritesY=" + Arrays.toString(spritesY) + ", message='" + message + '\'' + ", isInventoryInterface="
				+ isInventoryInterface + ", id=" + id + ", textSize=" + textSize + ", toolTipSpecialX="
				+ toolTipSpecialX + ", toolTipSpecialY=" + toolTipSpecialY + ", invStackSizes="
				+ Arrays.toString(invStackSizes) + ", removeStackableNumber=" + removeStackableNumber + ", inv="
				+ Arrays.toString(inv) + ", opacity=" + opacity + ", modelTypeEnabled=" + modelTypeEnabled
				+ ", modelEnabled=" + modelEnabled + ", sequenceDisabled=" + sequenceDisabled + ", disableModel="
				+ disableModel + ", sequenceEnabled=" + sequenceEnabled + ", itemsAreDraggable=" + itemsAreDraggable
				+ ", sprite2=" + sprite2 + ", scrollMax=" + scrollMax + ", type=" + type + ", ignoreItemAmounts="
				+ ignoreItemAmounts + ", hoverType=" + hoverType + ", offsetX=" + offsetX + ", offsetY=" + offsetY
				+ ", invisible=" + invisible + ", height=" + height + ", textShadow=" + textShadow + ", modelZoom="
				+ modelZoom + ", modelRotationY=" + modelRotationY + ", modelRotationX=" + modelRotationX + ", childY="
				+ Arrays.toString(childY) + ", hasType9Hover=" + hasType9Hover + ", type9HoverXposition="
				+ type9HoverXposition + ", type9HoverYposition=" + type9HoverYposition + ", hoverHasText="
				+ hoverHasText + ", hoverText='" + hoverText + '\'' + ", hoverScrollBar=" + hoverScrollBar
				+ ", transparency=" + transparency + ", mediaIdOffset2=" + mediaIdOffset2 + ", mediaIdOffset1="
				+ mediaIdOffset1 + ", popupString='" + popupString + '\'' + ", invStartIndex=" + invStartIndex
				+ ", rounded=" + rounded + ", colour=" + colour + ", childInvisibilitySupported="
				+ childInvisibilitySupported + ", componentSupportsItemOpacity=" + componentSupportsItemOpacity
				+ ", drawAdvancedSprite=" + drawAdvancedSprite + ", textCountDownSecondsLeft="
				+ textCountDownSecondsLeft + ", textCountDownTimeReduced=" + textCountDownTimeReduced
				+ ", spriteLoadingBarPercentage=" + spriteLoadingBarPercentage + ", debug=" + debug + '}';
	}

	/**
	 * Set up the specific interface for a text count down feature. Must have
	 * {@link RSInterface#message} working.
	 *
	 * @param textCountDownParentInterfaceId
	 *            The parent interface id.
	 * @param interfaceChildId
	 *            The interface id which has the {@link RSInterface#message}
	 *            working.
	 */
	public static void setTextCountdown(int textCountDownParentInterfaceId, int interfaceChildId) {
		TextCountDown.textCountDownList.add(new TextCountDown(textCountDownParentInterfaceId, interfaceChildId));
	}

	/**
	 * True to make an interface id use {@link #drawAdvancedSprite}
	 */
	public static void setInterfaceIdAdvancedSprite(int interfaceId) {
		RSInterface.interfaceCache[interfaceId].drawAdvancedSprite = true;
	}

	/**
	 * The menu item for this component
	 */
	private RSMenuItem menuItem;

	/**
	 * Retrieves the {@link RSMenuItem} object that is currently in focus by this component
	 * @return    the item in focus
	 */
	public RSMenuItem getMenuItem() {
		return menuItem;
	}

	/**
	 * Modifies the current {@link RSMenuItem} for this component
	 * @param menuItem    the new item that will be replacing the previous item
	 */
	public void setMenuItem(RSMenuItem menuItem) {
		this.menuItem = menuItem;
	}

	/**
	 * The visibility of the menu of items.
	 */
	private boolean menuVisible;

	/**
	 * Determines if the menu of items is visible.
	 * @return    will return true if the player has triggered the drop down button.
	 */
	public boolean isMenuVisible() {
		return menuVisible;
	}

	/**
	 * Sets the menu to either a visible or invisible state.
	 * @param menuVisible    true if the menu is to be visible, otherwise invisible.
	 */
	public void setMenuVisible(boolean menuVisible) {
		this.menuVisible = menuVisible;
	}

	static void addDropMenu(int id, int width, int height, String text, TextDrawingArea[] TDA, RSMenuItem... menuItems) {
		RSInterface component = addInterface(id);
		setChildren(1 + menuItems.length, component);
		setBounds(id + 1, 0, 0, 0, component);
		for (int i = 0; i < menuItems.length; i++) {
			setBounds(id + 2 + i, 0, height + (i * height), 1 + i, component);
		}

		RSInterface menu = addInterface(id + 1);
		menu.type = 20;
		menu.opacity = Byte.MAX_VALUE;
		menu.atActionType = 9;
		menu.width = width;
		menu.height = height;
		menu.tooltip = "View";
		menu.message = text;
		menu.tooltip = text;
		menu.textDrawingAreas = TDA[1];

		for (int i = 0; i < menuItems.length; i++) {
			RSInterface menuItem = addInterface(id + 2 + i);
			menuItem.type = 21;
			menuItem.width = width;
			menuItem.height = height;
			menuItem.opacity = Byte.MAX_VALUE;
			menuItem.atActionType = 10;
			menuItem.isMouseoverTriggered = id + 1;
			Sprite sprite = menuItems[i].getSprite();
			if (sprite != null) {
				if (menuItems[i].getSprite().myHeight > menuItem.height - 2) {
					sprite = menuItems[i].getSprite();
				}
			}
			menuItem.menuItem = menuItems[i];
			menuItem.textDrawingAreas = TDA[1];
		}
	}

	public static Sprite imageLoader(int i, String s) {
		long l = (TextClass.method585(s) << 8) + i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(s + " " + i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

}