package blusunrize.immersiveengineering.common.util.compat.jei.alloysmelter;

import blusunrize.immersiveengineering.api.crafting.AlloyRecipe;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.stone.BlockTypes_StoneDevices;
import blusunrize.immersiveengineering.common.util.compat.jei.IERecipeCategory;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class AlloySmelterRecipeCategory extends IERecipeCategory<AlloyRecipe, AlloySmelterRecipeWrapper>
{
	public static ResourceLocation background = new ResourceLocation("immersiveengineering:textures/gui/alloy_smelter.png");

	public AlloySmelterRecipeCategory(IGuiHelper helper)
	{
		super("alloysmelter","tile.immersiveengineering.stone_device.alloy_smelter.name", helper.createDrawable(background, 8,13, 142, 60), AlloyRecipe.class, new ItemStack(IEContent.blockStoneDevice,1,BlockTypes_StoneDevices.ALLOY_SMELTER.getMeta()));
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, AlloySmelterRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 29, 3);
		guiItemStacks.init(1, false, 57, 3);
		guiItemStacks.init(2, false, 111, 21);
		guiItemStacks.set(0, ingredients.getInputs(ItemStack.class).get(0));
		guiItemStacks.set(1, ingredients.getInputs(ItemStack.class).get(1));
		if(ingredients.getOutputs(ItemStack.class).size()>0)
			guiItemStacks.set(2, ingredients.getOutputs(ItemStack.class).get(0));
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(AlloyRecipe recipe)
	{
		return new AlloySmelterRecipeWrapper(recipe);
	}
}