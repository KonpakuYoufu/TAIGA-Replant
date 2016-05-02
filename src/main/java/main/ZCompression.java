package main;

import blocks.BlockAardiumOre;
import blocks.BlockAdamantiteOre;
import blocks.BlockArcaniteOre;
import blocks.BlockAxiidianOre;
import blocks.BlockBasalt;
import blocks.BlockBismuthOre;
import blocks.BlockEterniteOre;
import blocks.BlockIgnititeOre;
import blocks.BlockKarmesineOre;
import blocks.BlockLigniteOre;
import blocks.BlockMeteoriteOre;
import blocks.BlockMindoriteOre;
import blocks.BlockMythrilOre;
import blocks.BlockPalladiumOre;
import blocks.BlockPrometheumOre;
import blocks.BlockRottenGround;
import blocks.BlockSlaggoldOre;
import blocks.BlockSlagironOre;
import blocks.BlockTiberiumOre;
import blocks.BlockVibraniumre;
import blocks.BlockYrdeanOre;
import blocks.category.BasicBlockOre;
import blocks.category.BasicBlockOreGlow;
import items.ItemSlagiron;
import main.world.ZWorldGen;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import proxy.ServerProxy;

@Mod(modid = ZCompression.MODID, version = ZCompression.VERSION)
public class ZCompression {

    static final String MODID = "zcompression";
    static final String VERSION = "1.0";

    @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
    private static ServerProxy proxy;

    // Items
    public static ItemSlagiron slagiron = new ItemSlagiron();


    //Blocks, esp. for tconstruct
    public static BlockAardiumOre aardiumOre = new BlockAardiumOre();
    public static BlockAdamantiteOre adamantiteOre = new BlockAdamantiteOre();
    public static BlockArcaniteOre arcaniteOre = new BlockArcaniteOre();
    public static BlockAxiidianOre axiidianOre = new BlockAxiidianOre();
    public static BlockBasalt basalt = new BlockBasalt();
    public static BlockBismuthOre bismuthOre = new BlockBismuthOre();
    public static BlockEterniteOre eterniteOre = new BlockEterniteOre();
    public static BlockIgnititeOre ignititeOre = new BlockIgnititeOre();
    public static BlockKarmesineOre karmesineOre = new BlockKarmesineOre();
    public static BlockLigniteOre ligniteOre = new BlockLigniteOre();
    public static BlockMeteoriteOre meteoriteOre = new BlockMeteoriteOre();
    public static BlockMindoriteOre mindoriteOre = new BlockMindoriteOre();
    public static BlockMythrilOre mythrilOre = new BlockMythrilOre();
    public static BlockPalladiumOre palladiumOre = new BlockPalladiumOre();
    public static BlockPrometheumOre prometheumOre = new BlockPrometheumOre();
    public static BlockRottenGround rottenGround = new BlockRottenGround();
    public static BlockSlagironOre slagironOre = new BlockSlagironOre();
    public static BlockSlaggoldOre slaggoldOre = new BlockSlaggoldOre();
    public static BlockTiberiumOre tiberiumOre = new BlockTiberiumOre();
    public static BlockVibraniumre vibraniumOre = new BlockVibraniumre();
    public static BlockYrdeanOre yrdeanOre = new BlockYrdeanOre();


    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        GameRegistry.register(slagiron);
        registerBlock(aardiumOre);
        registerBlock(adamantiteOre);
        registerBlock(arcaniteOre);
        registerBlock(axiidianOre);
        registerBlock(basalt);
        registerBlock(bismuthOre);
        registerBlock(eterniteOre);
        registerBlock(ignititeOre);
        registerBlock(karmesineOre);
        registerBlock(ligniteOre);
        registerBlock(meteoriteOre);
        registerBlock(mindoriteOre);
        registerBlock(mythrilOre);
        registerBlock(palladiumOre);
        registerBlock(prometheumOre);
        registerBlock(rottenGround);
        registerBlock(slagironOre);
        registerBlock(slaggoldOre);
        registerBlock(tiberiumOre);
        registerBlock(vibraniumOre);
        registerBlock(yrdeanOre);

    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerClientStuff();
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }

    private static void registerBlock(BasicBlockOre block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
    
    private static void registerBlock(BasicBlockOreGlow block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }


}