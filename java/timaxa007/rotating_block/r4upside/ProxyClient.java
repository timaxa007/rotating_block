package timaxa007.rotating_block.r4upside;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();
	}

	public void init() {
		super.init();

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRotatingObj.class, new RenderTileEntityRotatingObj());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlockRotatingObj.block_rotating_obj), new RenderItemBlockRotatingObj());

	}

}
