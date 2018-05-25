package timaxa007.rotating_block.r4;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
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

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		/* Изменяем метудату от 0 по 3 зависимо от положения entity.
		 * Будет использоваться для поворота нашей модели.*/
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

}
