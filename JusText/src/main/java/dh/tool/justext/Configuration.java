package dh.tool.justext;

import java.io.Serializable;

/**
 * Created by hiep on 24/06/2014.
 */
public class Configuration implements Serializable, Cloneable {
	public static final Configuration DEFAULT = new Configuration();

	private boolean noHeadings = false;
	private int maxHeadingDistance = 200;
	private int lengthLow = 70;
	private int lengthHigh = 200;
	private double stopwordsLow = 0.3;
	private double stopwordsHigh = 0.32;
	private double maxLinkDensity = 0.2;
	private String language;

	public boolean isNoHeadings() {
		return noHeadings;
	}

	private void setNoHeadings(boolean noHeadings) {
		this.noHeadings = noHeadings;
	}

	public int getMaxHeadingDistance() {
		return maxHeadingDistance;
	}

	private void setMaxHeadingDistance(int maxHeadingDistance) {
		this.maxHeadingDistance = maxHeadingDistance;
	}

	public int getLengthLow() {
		return lengthLow;
	}

	private void setLengthLow(int lengthLow) {
		this.lengthLow = lengthLow;
	}

	public int getLengthHigh() {
		return lengthHigh;
	}

	private void setLengthHigh(int lengthHigh) {
		this.lengthHigh = lengthHigh;
	}

	public double getStopwordsLow() {
		if (language==null) {
			return 0;
		}
		return stopwordsLow;
	}

	private void setStopwordsLow(double stopwordsLow) {
		this.stopwordsLow = stopwordsLow;
	}

	public double getStopwordsHigh() {
		if (language==null) {
			return 0;
		}
		return stopwordsHigh;
	}

	private void setStopwordsHigh(double stopwordsHigh) {
		this.stopwordsHigh = stopwordsHigh;
	}

	public double getMaxLinkDensity() {
		return maxLinkDensity;
	}

	private void setMaxLinkDensity(double maxLinkDensity) {
		this.maxLinkDensity = maxLinkDensity;
	}

	public String getLanguage() {
		return language;
	}

	private void setLanguage(String language) {
		this.language = language;
	}

	@Override
	protected Configuration clone() throws CloneNotSupportedException {
		Configuration resu = new Configuration();
		resu.setNoHeadings(noHeadings);
		resu.setMaxHeadingDistance(maxHeadingDistance);
		resu.setLengthLow(lengthLow);
		resu.setLengthHigh(lengthHigh);
		resu.setStopwordsLow(stopwordsLow);
		resu.setStopwordsHigh(stopwordsHigh);
		resu.setMaxLinkDensity(maxLinkDensity);
		resu.setLanguage(language);
		return resu;
	}

	static public class Builder {
		Configuration configuration;

		public Builder() {
			configuration = new Configuration();
		}

		public Builder(Configuration configuration) throws CloneNotSupportedException {
			this.configuration = configuration.clone();
		}

		Configuration getConfiguration() {
			return configuration;
		}

		private Builder setNoHeadings(boolean noHeadings) {
			configuration.setNoHeadings(noHeadings);
			return this;
		}

		public Builder setMaxHeadingDistance(int maxHeadingDistance) {
			configuration.setMaxHeadingDistance(maxHeadingDistance);
			return this;
		}

		public Builder setLengthLow(int lengthLow) {
			configuration.setLengthLow(lengthLow);
			return this;
		}

		public Builder setLengthHigh(int lengthHigh) {
			configuration.setLengthHigh(lengthHigh);
			return this;
		}

		public Builder setStopwordsLow(double stopwordsLow) {
			configuration.setStopwordsLow(stopwordsLow);
			return this;
		}

		public Builder setStopwordsHigh(double stopwordsHigh) {
			configuration.setStopwordsHigh(stopwordsHigh);
			return this;
		}

		public Builder setMaxLinkDensity(double maxLinkDensity) {
			configuration.setMaxLinkDensity(maxLinkDensity);
			return this;
		}

		public Builder setLanguage(String language) {
			configuration.setLanguage(language);
			return this;
		}
	}
}