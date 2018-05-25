package timaxa007.rotating_block.r4side_a;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
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


			if (side == 0 || side == 1) {
				int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
				if (side == 0) {
					l += 4;
				}
				/* Если сторона верхняя, изменяем метудату от 0 по 3 зависимо от положения entity.
				 * Если сторона блока нижня, на которую мы ставин наш блок, то метадата будет от 4 по 7.
				 * Будет использоваться для поворота нашей модели.*/
				world.setBlockMetadataWithNotify(x, y, z, l, 2);
			} else {
				System.out.println("onItemUse " + (8 + (side - 2)));
				world.setBlockMetadataWithNotify(x, y, z, 8 + (side - 2), 2);
			}
			return true;
		} else {
			return false;
		}
	}

}
