package timaxa007.rotating_block.r4upside;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderTileEntityRotatingObj extends TileEntitySpecialRenderer {

	public static final IModelCustom model = 
			AdvancedModelLoader.loadModel(new ResourceLocation(ModBlockRotatingObj.DOMIN, "obj/test.obj"));
	public static final ResourceLocation texture = new ResourceLocation(ModBlockRotatingObj.DOMIN, "textures/blocks/test.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityRotatingObj)tile, x, y, z, f);
	}

	private void render(TileEntityRotatingObj tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 0.0F, 0.5F);
		if (tile != null) {
			switch(tile.getBlockMetadata() % 4) {
			case 0:GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);break;
			case 1:GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);break;
			case 2:GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);break;
			case 3:GL11.glRotatef(180F + 90F, 0.0F, 1.0F, 0.0F);break;
			}
			if (tile.getBlockMetadata() > 3) {
				GL11.glTranslatef(0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
			}
		}
		bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}

}
