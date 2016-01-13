package amidst.mojangapi.world.icon;

import java.awt.image.BufferedImage;

import amidst.documentation.Immutable;
import amidst.mojangapi.world.Dimension;
import amidst.mojangapi.world.coordinates.CoordinatesInWorld;
import amidst.mojangapi.world.coordinates.Resolution;

@Immutable
public class WorldIcon {
	private final CoordinatesInWorld coordinates;
	private final String name;
	private final BufferedImage image;
	private final Dimension dimension;
	private final boolean displayDimension;

	public WorldIcon(CoordinatesInWorld coordinates, String name,
			BufferedImage image, Dimension dimension, boolean displayDimension) {
		this.coordinates = coordinates;
		this.name = name;
		this.image = image;
		this.dimension = dimension;
		this.displayDimension = displayDimension;
	}

	public CoordinatesInWorld getCoordinates() {
		return coordinates;
	}

	public String getName() {
		return name;
	}

	public BufferedImage getImage() {
		return image;
	}

	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public String toString() {
		if (dimension.getResolution() != Resolution.WORLD) {
			return name + " in the " + dimension.getName() + " "
					+ coordinates.toString(dimension.getResolution()) + " -> "
					+ coordinates.toString() + " in the Overworld";
		} else if (displayDimension) {
			return name + " in the " + dimension.getName() + " "
					+ coordinates.toString();
		} else {
			return name + " " + coordinates.toString();
		}
	}
}
