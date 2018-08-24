@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {



    }

    public void init(FMLInitializationEvent e) {



    }

    public void postInit(FMLPostInitializationEvent e) {



    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new EkuFBlock());
		event.getRegistry().register(new EkuPotBlock());
        GameRegistry.registerTileEntity(EkuPotTileEntity.class, EkuTest.MODID + "_ekupotblock");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.ekuFBlock).setRegistryName(ModBlocks.ekuFBlock.getRegistryName()));
		event.getRegistry().register(new EkuFItem());
		event.getRegistry().register(new ItemBlock(ModBlocks.ekuPotBlock).setRegistryName(ModBlocks.ekuPot.getRegistryName()));
    }

}

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        super.preInit(e);

    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {



    }

}

public class ServerProxy extends CommonProxy {



}