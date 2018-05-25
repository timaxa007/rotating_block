package timaxa007.rotating_block.r4side_a;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRotatingObj extends Block implements ITileEntityProvider {

	public BlockRotatingObj() {
		super(Material.circuits);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(0.25F);
		setStepSound(soundTypeMetal);
		setBlockTextureName(ModBlockRotatingObj.DOMIN + ":test");
		setBlockName("block_rotating_obj");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityRotatingObj();
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}
