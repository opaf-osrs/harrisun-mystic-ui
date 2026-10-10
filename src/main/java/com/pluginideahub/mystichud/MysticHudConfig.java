package com.pluginideahub.mystichud;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

// key names are kept wherever the meaning did not change, so players keep their values through
// the 1.3 regroup. enum constants are stored by name, so those stay too and only toString moves.
@ConfigGroup(MysticHudConfig.GROUP)
public interface MysticHudConfig extends Config
{
	String GROUP = "mystichud";

	@ConfigSection(
		name = "Map position",
		description = "Where the block sits when it is not attached to the inventory",
		position = 10,
		closedByDefault = true
	)
	String POSITION = "position";

	@ConfigSection(
		name = "Minimap",
		description = "The map and what sits around it",
		position = 20
	)
	String MINIMAP = "minimap";

	@ConfigSection(
		name = "Orb blocks",
		description = "The four blocks under the map",
		position = 30
	)
	String ORB_BLOCKS = "orbBlocks";

	@ConfigSection(
		name = "Developer",
		description = "Testing tools. They only work in developer mode",
		position = 40,
		closedByDefault = true
	)
	String DEVELOPER = "developer";

	// ---- top ----

	@ConfigItem(
		keyName = "attachInventory",
		name = "Attach to inventory",
		description = "Join the block onto the top of the inventory. Resizable modern only",
		position = 1
	)
	default boolean attachInventory()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hideWhenClosed",
		name = "Hide when inventory closed",
		description = "Hide the block while no side panel is open",
		position = 2
	)
	default boolean hideWhenClosed()
	{
		return false;
	}

	@ConfigItem(
		keyName = "orbOrder",
		name = "Orb order",
		description = "Left to right order of the blocks",
		position = 3
	)
	default OrbOrder orbOrder()
	{
		return OrbOrder.SPEC_PRAYER_RUN_HP;
	}

	@ConfigItem(
		keyName = "squareMinimap",
		name = "Square minimap",
		description = "Draw the minimap as a rectangle instead of a circle",
		position = 4
	)
	default boolean squareMinimap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "drawBlocks",
		name = "Square orb blocks",
		description = "Draw the orbs as flat blocks instead of the round orbs",
		position = 5
	)
	default boolean drawBlocks()
	{
		return true;
	}

	// ---- position ----

	@Range(min = -400, max = 200)
	@ConfigItem(
		keyName = "posX",
		name = "Position X",
		description = "Move the block left or right. Shift+drag does the same",
		section = POSITION,
		position = 1
	)
	default int posX()
	{
		return 0;
	}

	@Range(min = -600, max = 600)
	@ConfigItem(
		keyName = "posY",
		name = "Position Y",
		description = "Move the block down from the top. It stops at the inventory",
		section = POSITION,
		position = 2
	)
	default int posY()
	{
		return 0;
	}

	// ---- minimap ----

	// keyName deliberately NOT "nativeMapWidth": that key already has a stored false in
	// the profile from trying the toggle, and a stored value beats a changed default
	@ConfigItem(
		keyName = "trueMapWidth",
		name = "True map width",
		description = "Draw the map at the game's own 152px width, centred in the frame",
		section = MINIMAP,
		position = 1
	)
	default boolean nativeMapWidth()
	{
		return false;
	}

	@Range(min = 80, max = 152)
	@ConfigItem(
		keyName = "mapHeight",
		name = "Map height",
		description = "Tallest the map is drawn. It gets shorter when there is no room above the inventory",
		section = MINIMAP,
		position = 2
	)
	default int mapHeight()
	{
		return 152;
	}

	@ConfigItem(
		keyName = "mapOutline",
		name = "Map frame",
		description = "Draw a frame around the map and blocks",
		section = MINIMAP,
		position = 3
	)
	default boolean mapOutline()
	{
		return true;
	}

	@ConfigItem(
		keyName = "originalFrameArt",
		name = "Original frame art",
		description = "Use the game's own frame art instead of your resource pack's",
		section = MINIMAP,
		position = 4
	)
	default boolean originalFrameArt()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showCompass",
		name = "Compass",
		description = "Small compass in the map's top left corner. Click it to face north",
		section = MINIMAP,
		position = 5
	)
	default boolean showCompass()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWorldMap",
		name = "World map orb",
		description = "Show the world map orb beside the map. Ctrl+M works either way",
		section = MINIMAP,
		position = 6
	)
	default boolean showWorldMap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showExtraOrbs",
		name = "XP orb",
		description = "Show the xp orb beside the map",
		section = MINIMAP,
		position = 7
	)
	default boolean showExtraOrbs()
	{
		return false;
	}

	// ---- orb blocks ----

	@Range(min = 24, max = 120)
	@ConfigItem(
		keyName = "orbRowHeight",
		name = "Row height",
		description = "Height of the blocks. It stops growing when it would reach the inventory",
		section = ORB_BLOCKS,
		position = 1
	)
	default int orbRowHeight()
	{
		return 40;
	}

	// a new key, not orbIconSize: that one's 0 meant "leave the art alone", and this is a
	// real size, so old values would mean the wrong thing here
	@Range(min = 8, max = 64)
	@ConfigItem(
		keyName = "iconSize",
		name = "Icon size",
		description = "Icon size in pixels. It shrinks if the value would not fit beside it",
		section = ORB_BLOCKS,
		position = 2
	)
	default int iconSize()
	{
		return 20;
	}

	@Range(min = 6, max = 40)
	@ConfigItem(
		keyName = "orbFontSize",
		name = "Value size",
		description = "Size of the number. 16 is the sharpest",
		section = ORB_BLOCKS,
		position = 3
	)
	default int orbFontSize()
	{
		return 16;
	}

	@ConfigItem(
		keyName = "orbTextAlign",
		name = "Value position",
		description = "Where the number sits in the block",
		section = ORB_BLOCKS,
		position = 4
	)
	default TextAlign orbTextAlign()
	{
		return TextAlign.AFTER_ICON;
	}

	@Range(max = 24)
	@ConfigItem(
		keyName = "orbIconPadX",
		name = "Edge padding",
		description = "Space between the block's edge and the icon. Shrinks first when space is tight",
		section = ORB_BLOCKS,
		position = 5
	)
	default int orbIconPadX()
	{
		return 3;
	}

	@Range(max = 24)
	@ConfigItem(
		keyName = "orbTextGap",
		name = "Gap",
		description = "Space between the icon and the number. Shrinks first when space is tight",
		section = ORB_BLOCKS,
		position = 6
	)
	default int orbTextGap()
	{
		return 3;
	}

	@Range(min = -24, max = 24)
	@ConfigItem(
		keyName = "orbIconNudgeY",
		name = "Icon Y",
		description = "Move the icon up or down",
		section = ORB_BLOCKS,
		position = 7
	)
	default int orbIconNudgeY()
	{
		return 0;
	}

	@Range(min = -24, max = 24)
	@ConfigItem(
		keyName = "orbTextNudgeY",
		name = "Value Y",
		description = "Move the number up or down",
		section = ORB_BLOCKS,
		position = 8
	)
	default int orbTextNudgeY()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "specArmedFill",
		name = "Spec queued fill",
		description = "How the spec block changes while a special attack is queued",
		section = ORB_BLOCKS,
		position = 9
	)
	default SpecArmedFill specArmedFill()
	{
		return SpecArmedFill.BRIGHTER;
	}

	@ConfigItem(
		keyName = "specArmedBorder",
		name = "Spec queued border",
		description = "Light up the spec block's border while a special attack is queued",
		section = ORB_BLOCKS,
		position = 10
	)
	default boolean specArmedBorder()
	{
		return false;
	}

	// ---- developer: every one of these is a no-op outside developer mode ----

	@ConfigItem(
		keyName = "orbDebug",
		name = "Debug readout",
		description = "Show the build tag and layout numbers over the map",
		section = DEVELOPER,
		position = 1
	)
	default boolean orbDebug()
	{
		return false;
	}

	@ConfigItem(
		keyName = "simulateSoulreaper",
		name = "Simulate soulreaper axe",
		description = "Draw the spec block as if the soulreaper axe were equipped",
		section = DEVELOPER,
		position = 2
	)
	default boolean simulateSoulreaper()
	{
		return false;
	}

	@Range(max = 5)
	@ConfigItem(
		keyName = "simulatedSoulStacks",
		name = "Simulated soul stacks",
		description = "Stack count shown while simulating the axe",
		section = DEVELOPER,
		position = 3
	)
	default int simulatedSoulStacks()
	{
		return 3;
	}

	@ConfigItem(
		keyName = "simulateThreeDigits",
		name = "Simulate 3-digit values",
		description = "Show a three digit number in every block",
		section = DEVELOPER,
		position = 4
	)
	default boolean simulateThreeDigits()
	{
		return false;
	}

	@ConfigItem(
		keyName = "layoutVersion",
		name = "",
		description = "",
		hidden = true
	)
	default int layoutVersion()
	{
		return 0;
	}

	enum OrbOrder
	{
		SPEC_PRAYER_RUN_HP("Spec, Prayer, Run, HP"),
		HP_PRAYER_RUN_SPEC("HP, Prayer, Run, Spec"),
		HP_PRAYER_SPEC_RUN("HP, Prayer, Spec, Run");

		private final String label;

		OrbOrder(String label)
		{
			this.label = label;
		}

		@Override
		public String toString()
		{
			return label;
		}
	}

	enum SpecArmedFill
	{
		NONE("No change"),
		BRIGHTER("Brighter"),
		GAME_COLOUR("Game colour");

		private final String label;

		SpecArmedFill(String label)
		{
			this.label = label;
		}

		@Override
		public String toString()
		{
			return label;
		}
	}

	enum TextAlign
	{
		AFTER_ICON("Beside icon"),
		RIGHT_EDGE("Right edge"),
		CENTRED("Centred"),
		STACKED("Under icon"),
		OVER_ICON("On icon");

		private final String label;

		TextAlign(String label)
		{
			this.label = label;
		}

		@Override
		public String toString()
		{
			return label;
		}
	}
}
