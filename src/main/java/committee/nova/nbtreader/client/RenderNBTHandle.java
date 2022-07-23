package committee.nova.nbtreader.client;

import committee.nova.nbtreader.NBTReader;
import committee.nova.nbtreader.input.KeyInputHandle;
import committee.nova.nbtreader.math.SolveNBT;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderNBTHandle {
    protected static final String COLON = ": ";

    @SubscribeEvent
    public static void onRenderTooltip(ItemTooltipEvent event) {
        List<ITextComponent> tooltip = event.getToolTip();
        ItemStack stack = event.getItemStack();

        if (KeyInputHandle.IS_SHIFT_KEY_DOWN){
            doAfterShiftKeyDown(stack.serializeNBT(), tooltip);
        } else {
            tooltip.add(new TranslationTextComponent("nbtreader.tip"));
        }
    }

    protected static void doAfterShiftKeyDown(CompoundNBT nbt, List<ITextComponent> tooltip){
        if (!nbt.isEmpty()) {
            Map<String, String> map = SolveNBT.solveNBT(nbt.toString());

            for (Map.Entry<String, String> entry : map.entrySet()){
                String output = entry.getKey() + COLON + entry.getValue();
                StringTextComponent textComponent = new StringTextComponent(output);
                tooltip.add(textComponent);
            }
        }
    }

}
