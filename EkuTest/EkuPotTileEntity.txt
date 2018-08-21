public class EkuPotTileEntity extends TileEntity{

	public static final int SIZE = 9;

	private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE){
	
		@Override
		protected void onContentsChanged(int slot){
		
			EkuPotTileEntity.this.markDirty();
		
		}
	
	};

	@Override
	public void readFromNBT(NBTTagCompound compound) {

        super.readFromNBT(compound);
        if (compound.hasKey("items")) {

            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));

        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);
        compound.setTag("items", itemStackHandler.serializeNBT());
        return compound;

    }

	public boolean canInteractWith(EntityPlayer playerIn) {

        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;

    }

	 @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {

            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);

        }

        return super.getCapability(capability, facing);

    }

}