package timaxa007.rotating_block.universal;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRotatingObj extends TileEntity {

	public byte rotate_side = 0;//byte, short, int

	public TileEntityRotatingObj() {}//Empty

	/**Rotate in float.**/
	public float getRotate() {
		return (rotate_side >> 3) * (360F / getDirections());
	}

	/**Which side.**/
	public int getSide() {
		return rotate_side & 0x7;//2 byte - max 3, 3 byte - max 7, sides 6 (0 - 5) - max 5
	}

	/**Not "Direction", number of directions**/
	public int getDirections() {
		return 4;//8, 16
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("rotate_side")) rotate_side = nbt.getByte("rotate_side");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (rotate_side != 0) nbt.setByte("rotate_side", rotate_side);
	}

	//Syns for Client
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
