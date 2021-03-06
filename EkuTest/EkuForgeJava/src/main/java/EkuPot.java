public class EkuPot extends Container {

	private EkuPotTileEntity te;

	public EkuPot(IInventory playerInventory, EkuPotTileEntity te){
	
		this.te = te
		addOwnslots();
		addPlayerSlots(playerInventory);
	
	}

	private void addPlayerSlots(IInventory playerInventory) {
        
        for (int row = 0; row < 3; ++row) {

            for (int col = 0; col < 9; ++col) {

                int x = 9 + col * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));

            }

        }

		for (int row = 0; row < 9; ++row) {

            int x = 9 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));

        }

    }

	private void addOwnSlots() {

		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 9;
        int y = 6;

        int slotIndex = 0;
        for (int i = 0; i < itemHandler.getSlots(); i++) {

            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 18;

        }
    }

	@Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {

            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < TestContainerTileEntity.SIZE) {

                if (!this.mergeItemStack(itemstack1, EkuPotTileEntity.SIZE, this.inventorySlots.size(), true)) {

                    return null;

                }

            } else if (!this.mergeItemStack(itemstack1, 0, EkuPotTileEntity.SIZE, false)) {

                return null;

            }

            if (itemstack1.isEmpty()) {

                slot.putStack(ItemStack.EMPTY);

            } else {

                slot.onSlotChanged();

            }

        }

        return itemstack;

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {

        return te.canInteractWith(playerIn);

    }

}