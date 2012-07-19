package puzzles.twostacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

interface ICutRod {
	int getMaxPrice(int length);
}

public class CutRod implements ICutRod {

	private java.util.List<CutPreis> prices;

	public CutRod(java.util.List<CutPreis> prices) {
		this.prices = new ArrayList<>(prices);
	}

	public int getMaxPrice(int lenght) {
		int[] r = new int[lenght + 1];
		int max = 0;
		r[0] = 0;
		for (int i = 1; i <= lenght; i++) {
			for (CutPreis cp : prices) {
				if (i - cp.getSize() >= 0) {
					max = Math.max(max, cp.getCost() + r[i - cp.getSize()]);
				}
			}
			r[i] = max;
		}
		return max;
	}

	public static class CutPreis {
		int size;
		int cost;

		public CutPreis(int size, int cost) {
			this.size = size;
			this.cost = cost;
		}

		public int getSize() {
			return size;
		}

		public int getCost() {
			return cost;
		}

	}

}
