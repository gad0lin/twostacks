package puzzles.twostacks;

public class RandomizedSelectorTest extends SelectorTest {

	@Override
	public Selector createSelector(int[] arr) {
		return new RandomizedSelect(arr);
	}

}
