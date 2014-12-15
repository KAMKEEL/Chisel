package com.cricketcraft.chisel.block;

import com.cricketcraft.chisel.Chisel;
import com.cricketcraft.chisel.api.ICarvable;
import com.cricketcraft.chisel.carving.CarvableHelper;
import com.cricketcraft.chisel.carving.CarvableVariation;
import com.cricketcraft.chisel.init.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockVoidstonePillar extends Block implements ICarvable{

    public static IIcon topBottom, pillarSide;
    public CarvableHelper carvableHelper;
    private boolean isAnimated;

    public BlockVoidstonePillar(boolean isAnimated) {
        super(Material.rock);
        carvableHelper = new CarvableHelper();
        setHardness(5.0F);
        setResistance(10.0F);
        setCreativeTab(ModTabs.tabChiselBlocks);
        this.isAnimated = isAnimated;
    }

    @Override
    public IIcon getIcon(int side, int meta){
        if(side == 0 || side == 1){
            return topBottom;
        } else {
            return pillarSide;
        }
    }


    @Override
    public void registerBlockIcons(IIconRegister icon){
        if(this.isAnimated)
            topBottom = icon.registerIcon(Chisel.MOD_ID + ":voidstone/animated/pillar-top");
        else
            topBottom = icon.registerIcon(Chisel.MOD_ID + ":voidstone/pillar-top");

        pillarSide = icon.registerIcon(Chisel.MOD_ID + ":voidstone/pillar-side");
    }

    @Override
    public CarvableVariation getVariation(int metadata) {
        return carvableHelper.getVariation(metadata);
    }
}