package committee.nova.nbtreader;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Goulixiaoji
 */
@Mod(NBTReader.MOD_ID)
public class NBTReader {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "nbtreader";

    public NBTReader() {
        MinecraftForge.EVENT_BUS.register(this);
    }


}
