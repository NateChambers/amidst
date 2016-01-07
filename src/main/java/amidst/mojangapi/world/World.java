package amidst.mojangapi.world;

import java.util.List;

import amidst.documentation.CalledByAny;
import amidst.documentation.ThreadSafe;
import amidst.mojangapi.world.icon.WorldIcon;
import amidst.mojangapi.world.icon.producer.CachedWorldIconProducer;
import amidst.mojangapi.world.icon.producer.WorldIconProducer;
import amidst.mojangapi.world.oracle.BiomeDataOracle;
import amidst.mojangapi.world.oracle.SlimeChunkOracle;
import amidst.mojangapi.world.player.MovablePlayerList;

@ThreadSafe
public class World {
	private final WorldSeed seed;
	private final WorldType worldType;
	private final String generatorOptions;
	private final MovablePlayerList movablePlayerList;

	private final BiomeDataOracle biomeDataOracle;
	private final SlimeChunkOracle slimeChunkOracle;
	private final CachedWorldIconProducer spawnProducer;
	private final CachedWorldIconProducer strongholdProducer;
	private final CachedWorldIconProducer playerProducer;
	private final WorldIconProducer villageProducer;
	private final WorldIconProducer templeProducer;
	private final WorldIconProducer mineshaftProducer;
	private final WorldIconProducer netherFortressProducer;
	private final WorldIconProducer oceanMonumentProducer;

	World(WorldSeed seed, WorldType worldType, String generatorOptions,
			MovablePlayerList movablePlayerList,
			BiomeDataOracle biomeDataOracle, SlimeChunkOracle slimeChunkOracle,
			CachedWorldIconProducer spawnProducer,
			CachedWorldIconProducer strongholdProducer,
			CachedWorldIconProducer playerProducer,
			WorldIconProducer villageProducer,
			WorldIconProducer templeProducer,
			WorldIconProducer mineshaftProducer,
			WorldIconProducer netherFortressProducer,
			WorldIconProducer oceanMonumentProducer) {
		this.seed = seed;
		this.worldType = worldType;
		this.generatorOptions = generatorOptions;
		this.movablePlayerList = movablePlayerList;
		this.biomeDataOracle = biomeDataOracle;
		this.slimeChunkOracle = slimeChunkOracle;
		this.spawnProducer = spawnProducer;
		this.strongholdProducer = strongholdProducer;
		this.playerProducer = playerProducer;
		this.villageProducer = villageProducer;
		this.templeProducer = templeProducer;
		this.mineshaftProducer = mineshaftProducer;
		this.netherFortressProducer = netherFortressProducer;
		this.oceanMonumentProducer = oceanMonumentProducer;
	}

	@CalledByAny
	public WorldSeed getWorldSeed() {
		return seed;
	}

	@CalledByAny
	public WorldType getWorldType() {
		return worldType;
	}

	@CalledByAny
	public String getGeneratorOptions() {
		return generatorOptions;
	}

	public MovablePlayerList getMovablePlayerList() {
		return movablePlayerList;
	}

	public BiomeDataOracle getBiomeDataOracle() {
		return biomeDataOracle;
	}

	public SlimeChunkOracle getSlimeChunkOracle() {
		return slimeChunkOracle;
	}

	public WorldIconProducer getSpawnProducer() {
		return spawnProducer;
	}

	public WorldIconProducer getStrongholdProducer() {
		return strongholdProducer;
	}

	public WorldIconProducer getPlayerProducer() {
		return playerProducer;
	}

	public WorldIconProducer getVillageProducer() {
		return villageProducer;
	}

	public WorldIconProducer getTempleProducer() {
		return templeProducer;
	}

	public WorldIconProducer getMineshaftProducer() {
		return mineshaftProducer;
	}

	public WorldIconProducer getNetherFortressProducer() {
		return netherFortressProducer;
	}

	public WorldIconProducer getOceanMonumentProducer() {
		return oceanMonumentProducer;
	}

	public WorldIcon getSpawnWorldIcon() {
		return spawnProducer.getFirstWorldIcon();
	}

	public List<WorldIcon> getStrongholdWorldIcons() {
		return strongholdProducer.getWorldIcons();
	}

	public List<WorldIcon> getPlayerWorldIcons() {
		return playerProducer.getWorldIcons();
	}

	public void reloadPlayerWorldIcons() {
		playerProducer.resetCache();
	}
}