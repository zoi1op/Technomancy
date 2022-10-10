package dev.Cosmos616.technomancy.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.ItemEntry;
import dev.Cosmos616.technomancy.Technomancy;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.simibubi.create.AllTags.forgeItemTag;

public class TMItems {
    private static final CreateRegistrate REGISTRATE = Technomancy.getRegistrate()
            ;

    public static final ItemEntry<Item> RAW_ZIRCONIUM =
    taggedIngredient("raw_zirconium",forgeItemTag("raw_materials/zirconium"), forgeItemTag("raw_materials"));

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }

    public static void register() {}
}
