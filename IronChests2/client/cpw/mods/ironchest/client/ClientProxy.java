/*******************************************************************************
 * Copyright (c) 2012 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 *     cpw - initial API and implementation
 ******************************************************************************/
package cpw.mods.ironchest.client;

import net.minecraft.src.ChestItemRenderHelper;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.ironchest.CommonProxy;
import cpw.mods.ironchest.IronChestType;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderInformation() {
		ChestItemRenderHelper.instance = new IronChestRenderHelper();
		MinecraftForgeClient.preloadTexture("/cpw/mods/ironchest/sprites/block_textures.png");
		MinecraftForgeClient.preloadTexture("/cpw/mods/ironchest/sprites/item_textures.png");
	}

	@Override
	public void registerTileEntitySpecialRenderer(IronChestType typ) {
		ClientRegistry.bindTileEntitySpecialRenderer(typ.clazz, new TileEntityIronChestRenderer());
	}

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
