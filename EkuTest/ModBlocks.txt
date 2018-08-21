public class ModBlocks {

    @GameRegistry.ObjectHolder("ekutest:EkuFBlock")
    public static EkuFBlock ekuFBlock;

	@GameRegistry.ObjectHolder("ekutest:EkuPotBlock")
	public static EkuPot ekuPotBlock;

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        ekuPot.initModel();

    }

}