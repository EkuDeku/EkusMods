public class EkuPotBlock extends Block implements ITileEntityProvider{

	public static final int GUI_ID = 1;

	public EkuPotBlock(){
	
		super(material.ROCK);
		setUnlocalizedName(EkusMods.MODID + ".ekupotblock");
		setRegistryName("ekupotblock");
	
	}

	@SideOnly(Side.CLIENT)
	public void initModel(){
	
		ModelLoader.setCustomResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));

	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
	
		return new EkuPotTileEntity();

	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
	
		if(world.isRemote){
		
			return true;
		
		}
	
		TileEntity te = world.getTileEntity(pos);
		if(!(te instanceof EkuPotTileEntity)){
		
			return false;
		
		}

		player.openGui(EkuTest.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
		return true;

	}

}