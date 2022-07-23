package committee.nova.nbtreader.input;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
public class KeyInputHandle {
    public static boolean IS_SHIFT_KEY_DOWN = false;

    @SubscribeEvent
    public static void onShiftKeyDown(InputEvent.KeyInputEvent event){
        int action = event.getAction();;
        int key = event.getKey();
        boolean isShiftKeyDown = (GLFW.GLFW_KEY_LEFT_SHIFT == key || GLFW.GLFW_KEY_RIGHT_SHIFT == key);
        if (isShiftKeyDown && GLFW.GLFW_PRESS == action){
            IS_SHIFT_KEY_DOWN  = true;
        }
        else if (isShiftKeyDown && GLFW.GLFW_RELEASE == action){
            IS_SHIFT_KEY_DOWN = false;
        }
    }


}
