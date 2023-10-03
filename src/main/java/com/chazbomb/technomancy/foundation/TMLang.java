package com.chazbomb.technomancy.foundation;

import com.chazbomb.technomancy.Technomancy;
import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.foundation.utility.LangBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;

public class TMLang {
	public static LangBuilder lang() { return Lang.builder(Technomancy.MOD_ID); }
	public static LangBuilder translate(String key, Object... args) { return lang().translate(key, args); }
	
	public static Component.Serializer translateText(String key) { return new Component.Serializer(Technomancy.MOD_ID + key); }
}
