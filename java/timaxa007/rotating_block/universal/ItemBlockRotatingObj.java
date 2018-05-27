package timaxa007.rotating_block.universal;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBlockRotatingObj extends ItemBlock {

	public ItemBlockRotatingObj(Block block) {
		super(block);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z,
			int side, float hitX, float hitY, float hitZ) {
		if (super.onItemUse(itemStack, player, world, x, y, z, side, hitX, hitY, hitZ)) {

			switch(side) {
			case 0:--y;break;
			case 1:++y;break;
			case 2:--z;break;
			case 3:++z;break;
			case 4:--x;break;
			case 5:++x;break;
			default:break;
			}

			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TileEntityRotatingObj) {
				TileEntityRotatingObj tile = (TileEntityRotatingObj)te;
				float rot = 0;
				switch(side){
				case 0:
				case 1:
					rot = player.rotationYaw;
					break;
				case 2:
				case 3:
					rot = (float)(Math.atan2(0.5F - hitY, 0.5F - hitX) * (180D / Math.PI));
					break;
				case 4:
				case 5:
					rot = (float)(Math.atan2(0.5F - hitY, 0.5F - hitZ) * (180D / Math.PI));
					break;
				}
				int l = MathHelper.floor_float((rot * tile.getDirections() / 360.0F) + 0.5F) & (tile.getDirections() - 1);
				tile.rotate_side = (byte)(l << 3 | side);
			}
			return true;
		} else return false;
	}

}
