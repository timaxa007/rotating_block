package timaxa007.rotating_block.r4;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@Mod (modid = ModBlockRotatingObj.MODID, name = ModBlockRotatingObj.MODNAME, version = ModBlockRotatingObj.VERSION)

public class ModBlockRotatingObj {

	public static final String
	MODID = "block_rotating_4_obj",
	DOMIN = "block_rotating_obj",
	MODNAME = "Rotating the block",
	VERSION = "0.1";

	@Instance(MODID) public static ModBlockRotatingObj instance;
	@SidedProxy(modId = MODID,
			clientSide = "timaxa007.rotating_block.r4.ProxyClient",
			serverSide = "timaxa007.rotating_block.r4.ProxyCommon")
	public static ProxyCommon proxy;

	public static Block block_rotating_obj;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		block_rotating_obj = new BlockRotatingObj();
		GameRegistry.registerBlock(block_rotating_obj, "block_rotating_4_obj");

		GameRegistry.registerTileEntity(TileEntityRotatingObj.class, "TileEntityRotating4Obj");

		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
