/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.DragonAPI.ModRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import Reika.DragonAPI.DragonAPIInit;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.Exception.MisuseException;
import Reika.DragonAPI.Instantiable.Data.Maps.ItemHashMap;
import Reika.DragonAPI.Interfaces.OreType;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;
import Reika.DragonAPI.Libraries.MathSci.ReikaMathLibrary;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
import Reika.DragonAPI.Libraries.World.ReikaBlockHelper;
import Reika.DragonAPI.ModInteract.MekanismHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;

public enum ModOreList implements OreType {

	TIN("Tin", 0xB2D5E9, OreRarity.COMMON, "ingotTin", 1, "oreTin", "oreCassiterite"),
	COPPER("Copper", 0xBC6C01, OreRarity.EVERYWHERE, "ingotCopper", 1, "oreCopper", "oreTetrahedrite"),
	LEAD("Lead", 0x697597, OreRarity.AVERAGE, "ingotLead", 1, "oreLead"),
	NICKEL("Nickel", 0xD0CCAD, OreRarity.SCATTERED, "ingotNickel", 1, "oreNickel", "orePentlandite"),
	SILVER("Silver", 0xA4D0DA, OreRarity.AVERAGE, "ingotSilver", 1, "oreSilver"),
	GALENA("Galena", 0x7F6E95, OreRarity.SCATTERED, "dustGalena", 1, "oreGalena"),
	ALUMINUM("Aluminum", 0xF1F1F1, OreRarity.COMMON, getAluminumName(), 1, "oreAluminum", "oreAluminium", "oreNaturalAluminum"), //...Why??
	IRIDIUM("Iridium", 0xC1E2D3, OreRarity.RARE, "ingotIridium", 1, "oreIridium"),
	FIRESTONE("Firestone", 0xE19636, OreRarity.RARE, "shardFirestone", 1, "oreFirestone"),
	CERTUSQUARTZ("Certus Quartz", 0xC4CEFF, OreRarity.AVERAGE, "crystalCertusQuartz", 3, "oreCertusQuartz"),
	URANIUM("Uranium", 0x4CFF00, OreRarity.SCATTERED, "ingotUranium", 1, "oreUranium", "oreYellorite"),
	CINNABAR("Mercury", 0x811A1A, OreRarity.SCATTERED, "itemQuicksilver", 1, "oreCinnabar"),
	AMBER("Amber", 0xB17F17, OreRarity.SCATTERED, "gemAmber", 1, "oreAmber"),
	INFUSEDAIR("Air Infused", 0xA88C32, OreRarity.SCATTERED, "shardAir", 2, "oreInfusedAir"),
	INFUSEDFIRE("Fire Infused", 0xB52100, OreRarity.SCATTERED, "shardFire", 2, "oreInfusedFire"),
	INFUSEDWATER("Water Infused", 0x007C99, OreRarity.AVERAGE, "shardWater", 2, "oreInfusedWater"),
	INFUSEDEARTH("Earth Infused", 0x008200, OreRarity.SCATTERED, "shardEarth", 2, "oreInfusedEarth"),
	INFUSEDENTROPY("Entropy Infused", 0x555576, OreRarity.SCARCE, "shardEntropy", 2, "oreInfusedEntropy"),
	INFUSEDORDER("Order Infused", 0xDCDCFF, OreRarity.SCARCE, "shardOrder", 2, "oreInfusedOrder"),
	APATITE("Apatite", 0x3296C5, OreRarity.COMMON, "gemApatite", 3, "oreApatite"),
	SALTPETER("Saltpeter", 0xFFFFFF, OreRarity.AVERAGE, "dustSaltpeter", 2, "oreSaltpeter"),
	TUNGSTEN("Tungsten", 0x1E1E1E, OreRarity.COMMON, "dustTungsten", 1, "oreTungsten", "oreTungstate"),
	NIKOLITE("Nikolite", 0x2DABB8, OreRarity.COMMON, "dustNikolite", 5, "oreNikolite"),
	PERIDOT("Peridot", 0x00C416, OreRarity.SCARCE, "gemPeridot", 1, "orePeridot"),
	RUBY("Ruby", 0xBC0000, OreRarity.SCARCE, "gemRuby", 1, "oreRuby"),
	SAPPHIRE("Sapphire", 0x0019AA, OreRarity.SCARCE, "gemSapphire", 1, "oreSapphire"),
	MONAZIT("Monazit", 0x3C6E3C, OreRarity.AVERAGE, "ForciciumItem", 4, "MonazitOre"),
	FORCE("Force", 0xFFC700, OreRarity.AVERAGE, "gemForce", 3, "oreForce"),
	NETHERCOAL("Nether Coal", 0x262626, OreRarity.EVERYWHERE, "itemCoal", 1, "oreNetherCoal"),
	NETHERIRON("Nether Iron", 0xD8AD91, OreRarity.COMMON, "ingotIron", 1, "oreNetherIron"),
	NETHERGOLD("Nether Gold", 0xD6A400, OreRarity.AVERAGE, "ingotGold", 1, "oreNetherGold"),
	NETHERREDSTONE("Nether Redstone", 0xBC0000, OreRarity.COMMON, "dustRedstone", 4, "oreNetherRedstone"),
	NETHERLAPIS("Nether Lapis", 0x2B4BFF, OreRarity.AVERAGE, "dyeBlue", 6, "oreNetherLapis"),
	NETHERDIAMOND("Nether Diamond", 0x68FFE3, OreRarity.SCARCE, "gemDiamond", 1, "oreNetherDiamond"),
	NETHEREMERALD("Nether Emerald", 0x12DB00, OreRarity.SCARCE, "gemEmerald", 1, "oreNetherEmerald"),
	NETHERTIN("Nether Tin", 0xA9CCE2, OreRarity.COMMON, "ingotTin", 1, "oreNetherTin"),
	NETHERCOPPER("Nether Copper", 0xC8850C, OreRarity.COMMON, "ingotCopper", 1, "oreNetherCopper"),
	NETHERLEAD("Nether Lead", 0x6F7DA3, OreRarity.AVERAGE, "ingotLead", 1, "oreNetherLead"),
	NETHERNICKEL("Nether Nickel", 0xB6AE85, OreRarity.AVERAGE, "ingotNickel", 1, "oreNetherNickel"),
	NETHERSILVER("Nether Silver", 0xA7E4EC, OreRarity.AVERAGE, "ingotSilver", 1, "oreNetherSilver"),
	NETHERNIKOLITE("Nether Nikolite", 0xA7E4EC, OreRarity.AVERAGE, "dustNikolite", 5, "oreNetherNikolite"),
	COBALT("Cobalt", 0x1C30A5, OreRarity.SCARCE, "ingotCobalt", 1, "oreCobalt"),
	ARDITE("Ardite", 0xF48A00, OreRarity.SCARCE, "ingotArdite", 1, "oreArdite"),
	PLATINUM("Platinum", 0x00A0DB, OreRarity.RARE, "ingotPlatinum", 1, "orePlatinum", "oreCooperite"), //WTF Greg..."Cooper" == "Sheldon"??
	NETHERPLATINUM("Nether Platinum", 0x0892DE, OreRarity.RARE, "ingotPlatinum", 1, "oreNetherPlatinum"),
	ZINC("Zinc", 0x9B9B9B, OreRarity.COMMON, "ingotZinc", 1, "oreZinc", "oreSphalerite"),
	OSMIUM("Osmium", 0xA8B0E7, OreRarity.COMMON, "ingotOsmium", 1, "oreOsmium"),
	NETHERPIGIRON("Pig Iron", 0xC5B3AA, OreRarity.SCATTERED, "ingotSteel", 1, "oreNetherSteel"), //...
	SULFUR("Sulfur", 0xFFFF00, OreRarity.COMMON, "dustSulfur", 3, "oreSulfur"),
	PITCHBLENDE("Pitchblende", 0x4E4E7B, OreRarity.AVERAGE, "ingotUranium", 1, "orePitchblende"),
	CADMIUM("Cadmium", 0x87A6E8, OreRarity.AVERAGE, "ingotCadmium", 1, "oreCadmium"),
	INDIUM("Indium", 0xB3BFD8, OreRarity.SCATTERED, "ingotIndium", 1, "oreIndium"),
	FLUORITE("Fluorite", 0xDFD4AA, OreRarity.EVERYWHERE, "gemFluorite", 6, "oreFluorite"),
	BAUXITE("Bauxite", 0x72332B, OreRarity.AVERAGE, "dustBauxite", 1, "oreBauxite"),
	SODALITE("Sodalite", 0x133CAD, OreRarity.EVERYWHERE, "dyeBlue", 1, "oreSodalite"),
	PYRITE("Pyrite", 0xE1B531, OreRarity.COMMON, "dustPyrite", 1, "orePyrite"),
	AMMONIUM("Ammonium Chloride", 0xFFF9E0, OreRarity.SCATTERED, "dustAmmonium", 1, "oreAmmonium"),
	CALCITE("Calcite", 0xFF6A00, OreRarity.SCATTERED, "gemCalcite", 1, "oreCalcite"),
	CHIMERITE("Chimerite", 0xCBE5F5, OreRarity.SCATTERED, "gemChimerite", 2, "oreChimerite"),
	VINTEUM("Vinteum", 0x507BBC, OreRarity.SCATTERED, "dustVinteum", 1, "oreVinteum"),
	BLUETOPAZ("Blue Topaz", 0x92B1F0, OreRarity.SCATTERED, "gemBlueTopaz", 1, "oreBlueTopaz"),
	MOONSTONE("Moonstone", 0x6592CD, OreRarity.RARE, "gemMoonstone", 1, "oreMoonstone"),
	SUNSTONE("Sunstone", 0xD15106, OreRarity.RARE, "gemSunstone", 1, "oreSunstone"),
	TITANIUM("Titanium", 0x809797, OreRarity.SCARCE, "ingotTitanium", 1, "oreTitanium"),
	MAGMANITE("Magmanite", 0xF95D00, OreRarity.SCATTERED, "dropMagma", 1, "oreMagmanite"),
	MAGNETITE("Magnetite", 0x44442D, OreRarity.AVERAGE, "gemMagnetite", 1, "oreMagnetite"),
	ESSENCE("Essence", 0x158215, OreRarity.AVERAGE, "itemEssence", 4, "oreEssence", "oreNetherEssence"),
	MIMICHITE("Mimichite", 0x8900FF, OreRarity.SCATTERED, "gemMimichite", 1, "oreMimichite"),
	NETHERURANIUM("Nether Uranium", 0x00aa00, OreRarity.SCARCE, "ingotUranium", 1, "oreNetherUranium"),
	QUANTUM("Quantum", 0x5BA642, OreRarity.SCATTERED, "dustQuantum", 2, "oreQuantum"),
	NETHERIRIDIUM("Nether Iridium", 0xb6f6c7, OreRarity.RARE, "ingotIridium", 1, "oreNetherIridium"),
	DARKIRON("Dark Iron", 0x4F00D1, OreRarity.AVERAGE, "ingotFzDarkIron", 1, "oreFzDarkIron"),
	CHROMITE("Chromite", 0x94E0F5, OreRarity.AVERAGE, "ingotChrome", 1, "oreChromite"),
	NETHERSAPPHIRE("Nether Sapphire", 0x00977, OreRarity.SCARCE, "gemSapphire", 1, "oreNetherSapphire"),
	NETHERPERIDOT("Nether Peridot", 0x0a408, OreRarity.SCARCE, "gemPeridot", 1, "oreNetherGreenSapphire", "oreNetherPeridot"),
	NETHERTITANIUM("Nether Titanium", 0x0a408, OreRarity.SCATTERED, "ingotTitanium", 1, "oreNetherTitanium"),
	NETHERSULFUR("Nether Sulfur", 0x0a408, OreRarity.COMMON, "dustSulfur", 3, "oreNetherSulfur"),
	NETHEROSMIUM("Nether Osmium", 0x98A0D7, OreRarity.AVERAGE, "ingotOsmium", 1, "oreNetherOsmium"),
	SILICON("Silicon", 0x777777, OreRarity.AVERAGE, "itemSilicon", 1, "oreSilicon"),
	RUTILE("Rutile", 0x615E57, OreRarity.SCATTERED, "ingotRutile", 1, "oreRutile"),
	AMETHYST("Amethyst", 0xff00ff, OreRarity.RARE, "gemAmethyst", 1, "oreAmethyst"),
	TESLATITE("Teslatite", 0x2F81F1, OreRarity.COMMON, "dustTeslatite", 3, "oreTeslatite"),
	MANA("Mana", 0x70DAFC, OreRarity.SCARCE, "ingotMana", 1, "oreMana");

	private ArrayList<ItemStack> ores = new ArrayList();
	public final String displayName;
	private String[] oreLabel;
	public final int dropCount;
	public final int oreColor;
	private String product;
	private boolean init;
	public final OreRarity rarity;
	private HashMap<String, ArrayList<ItemStack>> perName = new HashMap();

	//private static final ArrayList<ItemStack> blocks = new ArrayList<ItemStack>();

	public static final ModOreList[] oreList = values();

	private static final ItemHashMap<ModOreList> oreMappings = new ItemHashMap();

	private ModOreList(String n, int color, OreRarity r, String prod, int count, String... ore) {
		//if (!DragonAPIInit.canLoadHandlers())
		//	throw new MisuseException("Accessed registry enum too early! Wait until postInit!");
		dropCount = count;
		oreColor = color;
		displayName = n;
		product = prod;
		oreLabel = new String[ore.length];
		for (int i = 0; i < ore.length; i++) {
			oreLabel[i] = ore[i];
		}
		rarity = r;

		ReikaJavaLibrary.pConsole("DRAGONAPI: Adding ore entries for "+this.toString()+" (Ore Names: "+Arrays.toString(ore)+")");
	}

	private static String getAluminumName() {
		return ModList.GREGTECH.isLoaded() ? "dustAluminum" : "ingotAluminum";
	}

	public static void initializeAll() {
		if (!DragonAPIInit.canLoadHandlers())
			throw new MisuseException("Initialized registry enum too early! Wait until postInit!");
		for (int i = 0; i < oreList.length; i++) {
			oreList[i].initialize();
		}
	}

	private void initialize() {
		if (init) {
			ReikaJavaLibrary.pConsole(this+" is already initialized!");
			return;
		}
		init = true;
		for (int i = 0; i < oreLabel.length; i++) {
			ArrayList<ItemStack> toadd = OreDictionary.getOres(oreLabel[i]);
			if (!toadd.isEmpty()) {
				Iterator<ItemStack> it = toadd.iterator();
				while (it.hasNext()) {
					ItemStack is = it.next();
					if (is.getItem() == null)
						it.remove();
				}
				ReikaJavaLibrary.pConsole("\tDetected the following blocks for "+this+" from OreDict \""+oreLabel[i]+"\": "+toadd.toString());
				for (int k = 0; k < toadd.size(); k++) {
					ItemStack is = toadd.get(k);
					if (ReikaItemHelper.isBlock(is)) {
						if (!ReikaItemHelper.listContainsItemStack(ores, is))
							ores.add(is);
						ArrayList li = perName.get(oreLabel[i]);
						if (li == null)
							perName.put(oreLabel[i], new ArrayList());
						perName.get(oreLabel[i]).add(is);
					}
					else {
						ReikaJavaLibrary.pConsole("\t"+is+" is not an ore block, but was OreDict fetched by \""+oreLabel[i]+"\"!");
					}
				}
			}
			else
				ReikaJavaLibrary.pConsole("\tNo ore blocks detected for \""+oreLabel[i]+"\"");
		}
		if (!this.existsInGame())
			ReikaJavaLibrary.pConsole("\tDRAGONAPI: No ore blocks detected for "+this);

		this.loadCache();
	}

	private final void loadCache() {
		for (int i = 0; i < ores.size(); i++) {
			ItemStack is = ores.get(i);
			oreMappings.put(is, this);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(displayName);
		//sb.append(" (Ore Names: ");
		//for (int i = 0; i < oreLabel.length; i++) {
		//	sb.append(oreLabel[i]);
		//	if (i < oreLabel.length-1)
		//		sb.append(" ");
		//}
		//sb.append(")");
		//sb.append(" ("+this.getRarity().name().toLowerCase()+")");
		return sb.toString();
	}

	public boolean isThaumcraft() {
		return this.name().contains("INFUSED") || this.name().equals("CINNABAR") || this.name().equals("AMBER");
	}

	public boolean isNetherOres() {
		return this.name().startsWith("NETHER");
	}

	public boolean isGregtech() {
		switch(this) {
		case BAUXITE:
		case GALENA:
		case PYRITE:
		case SODALITE:
		case TUNGSTEN:
		case ZINC:
			return true;
		default:
			return false;
		}
	}

	public void reloadOreList() {
		ores = new ArrayList<ItemStack>();
		for (int i = 0; i < oreLabel.length; i++) {
			ArrayList<ItemStack> li = OreDictionary.getOres(oreLabel[i]);
			boolean flag = false;
			Iterator<ItemStack> it = li.iterator();
			while (it.hasNext()) {
				ItemStack is = it.next();
				if (is.getItem() == null) {
					ReikaJavaLibrary.pConsole("DRAGONAPI: Invalid item (ID = "+is.getItem()+") registered as "+this);
					it.remove();
				}
				else {
					if (!ReikaItemHelper.listContainsItemStack(ores, is)) {
						ores.add(is);
						flag = true;
					}
				}
			}
			if (flag) {
				ReikaJavaLibrary.pConsole("DRAGONAPI: Reloading ore listings for "+this);
				ReikaJavaLibrary.pConsole("DRAGONAPI: Found "+li);
			}
			ores.addAll(li);
		}
		//Thread.dumpStack();
	}

	public static boolean isModOre(ItemStack is) {
		return getModOreFromOre(is) != null;
	}

	public static ModOreList getModOreFromOre(ItemStack is) {
		if (is == null || is.getItem() == null)
			return null;
		if (ReikaItemHelper.matchStackWithBlock(is, MekanismHandler.getInstance().oreID))
			return MekanismHandler.getInstance().getModOre(is.getItem(), is.getItemDamage());
		return oreMappings.get(is);
	}

	public static ModOreList getEntryFromDamage(int dmg) {
		if (ReikaMathLibrary.isValueInsideBoundsIncl(0, oreList.length-1, dmg))
			return oreList[dmg];
		return null;
	}

	public String[] getOreDictNames() {
		String[] arr = new String[oreLabel.length];
		System.arraycopy(oreLabel, 0, arr, 0, oreLabel.length);
		return arr;
	}

	public String getProductOreDictName() {
		return product;
	}

	public int getDropCount() {
		return dropCount;
	}

	public boolean isIngotType() {
		return product.contains("ingot");
	}

	public boolean isDustType() {
		return product.contains("dust");
	}

	public boolean isGemType() {
		return product.contains("gem") || product.contains("crystal");
	}

	public String getTypeName() {
		if (this.isIngotType())
			return "Ingot";
		if (this.isDustType())
			return "Dust";
		if (this.isGemType())
			return "Gem";
		return "Item";
	}

	public static ArrayList<ItemStack> getAllRegisteredOreBlocks() {
		ArrayList<ItemStack> li = new ArrayList<ItemStack>();
		for (int i = 0; i < oreList.length; i++) {
			li.addAll(oreList[i].ores);
		}
		return li;
	}

	public ItemStack getFirstOreBlock() {
		if (!this.existsInGame())
			return null;
		return ores.get(0);
	}

	public ItemStack getRandomOreBlock() {
		if (!this.existsInGame())
			return null;
		int s = ores.size();
		int index = new Random().nextInt(s);
		return ores.get(index);
	}

	public Collection<ItemStack> getAllOreBlocks() {
		return Collections.unmodifiableCollection(ores);
	}

	public boolean existsInGame() {
		return !ores.isEmpty();
	}
	/*
	public boolean isRare() {
		return this == PLATINUM || this == NETHERPLATINUM || this == IRIDIUM ||	this == MOONSTONE || this == NETHERIRIDIUM;
	}*/

	public OreRarity getRarity() {
		return rarity;
	}

	public boolean isNether() {
		if (this.isNetherOres())
			return true;
		if (this == ARDITE || this == COBALT)
			return true;
		if (this == SUNSTONE)
			return true;
		if (this == FIRESTONE)
			return true;
		if (this == PYRITE)
			return true;
		if (this == AMMONIUM)
			return true;
		return false;
	}

	public boolean isEnd() {
		if (this == SODALITE)
			return true;
		return false;
	}

	public boolean isArsMagica() {
		switch(this) {
		case CHIMERITE:
		case VINTEUM:
		case BLUETOPAZ:
		case MOONSTONE:
		case SUNSTONE:
			return true;
		default:
			return false;
		}
	}

	public boolean isMetallurgy() {
		switch(this) {
		default:
			return false;
		}
	}

	public boolean canGenerateIn(Block b) {
		if (this.isNether())
			return b == Blocks.netherrack;
		if (this.isEnd())
			return b == Blocks.end_stone;
		return b == Blocks.stone;
	}

	public ItemStack getGennableIn(Block b) {
		for (int i = 0; i < ores.size(); i++) {
			ItemStack is = ores.get(i);
			Block ore = Block.getBlockFromItem(is.getItem());
			//Not done
		}
		return null;
	}

	public Map<String, ArrayList<ItemStack>> getOresByName() {
		return Collections.unmodifiableMap(perName);
	}

	public static ModList getOreModFromItemStack(ItemStack is) {
		if (ReikaBlockHelper.isOre(is)) {
			if (ReikaItemHelper.isBlock(is)) {
				Block b = Block.getBlockFromItem(is.getItem());
				UniqueIdentifier dat = GameRegistry.findUniqueIdentifierFor(b);
				if (dat != null) {
					String modName = dat.name;
					String id = dat.modId;
					ModList mod = ModList.getModFromID(id);
					return mod;
				}
			}
			else {
				ReikaJavaLibrary.pConsole("\t"+is+" is not an ore block, but was registered as an ore block! This is a bug in its parent mod!");
			}
		}
		return null;
	}
}
