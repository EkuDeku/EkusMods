@Mod(modid = EkuTest.MODID, name = EkuTest.MODNAME, version = EkuTest.MODVERSION, dependencies = "required-after:Forge@[11.16.0.1865,)", useMetadata = true)
public class EkuTest {

    public static final String MODID = "ekutest";
    public static final String MODNAME = "Mod tutorials";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "mcjty.ekutest.proxy.ClientProxy", serverSide = "mcjty.ekutest.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static EkuTest instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}