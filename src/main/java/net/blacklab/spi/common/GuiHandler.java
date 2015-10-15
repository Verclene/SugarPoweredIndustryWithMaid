package net.blacklab.spi.common;

import net.blacklab.spi.client.gui.GuiContainerSPBattery;
import net.blacklab.spi.client.gui.GuiContainerSPFurnace;
import net.blacklab.spi.client.gui.GuiContainerSPGenerator;
import net.blacklab.spi.container.ContainerSPBattery;
import net.blacklab.spi.container.ContainerSPFurnace;
import net.blacklab.spi.container.ContainerSPGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int GUI_ID_SPGENERATOR = 0;
	public static final int	GUI_ID_SPBATTERY   = 1;

	public static final int GUI_ID_SPFURNACE   = 2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Object object = null;
		switch (ID) {
		case GUI_ID_SPGENERATOR:
			object = new ContainerSPGenerator(player, player.inventory, (IInventory) world.getTileEntity(new BlockPos(x, y, z)));
			break;
		case GUI_ID_SPBATTERY:
			object = new ContainerSPBattery(player, player.inventory, (IInventory) world.getTileEntity(new BlockPos(x,y,z)));
			break;
		case GUI_ID_SPFURNACE:
			object = new ContainerSPFurnace(player, player.inventory, (IInventory) world.getTileEntity(new BlockPos(x,y,z)));
			break;
		default:
			break;
		}
		return object;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Object object = null;
		switch (ID) {
		case GUI_ID_SPGENERATOR:
			object = new GuiContainerSPGenerator(player, player.inventory, (IInventory) world.getTileEntity(new BlockPos(x, y, z)));
			break;
		case GUI_ID_SPBATTERY:
			object = new GuiContainerSPBattery(player, player.inventory, (IInventory) world.getTileEntity(new BlockPos(x, y, z)));
			break;
		case GUI_ID_SPFURNACE:
			object = new GuiContainerSPFurnace(player, player.inventory, (IInventory) world.getTileEntity(new BlockPos(x,y,z)));
			break;
		default:
			break;
		}
		return object;
	}

}
