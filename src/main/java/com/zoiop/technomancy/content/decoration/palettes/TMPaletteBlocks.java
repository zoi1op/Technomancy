package com.zoiop.technomancy.content.decoration.palettes;

import com.zoiop.technomancy.registry.TMItemGroups;

import static com.zoiop.technomancy.Technomancy.REGISTRATE;

public class TMPaletteBlocks {

	public static void register() {
		REGISTRATE.creativeModeTab(() -> TMItemGroups.PALETTES_TAB);
		TMPaletteStoneTypes.register(REGISTRATE);
	}
}
