package puzzles.twostacks.tc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=2913&rd=5849
 * 
 * @author krzysztofbarczynski
 * 
 */
public class UserName {
	Set<String> set = new HashSet<>();

	public String newMember(String[] existingNames, String userName) {
		set.addAll(Arrays.asList(existingNames));
		int counter = 1;
		if (!set.contains(userName)) {
			return userName;
		}
		while (set.contains(userName + counter)) {
			counter++;
		}
		return userName + counter;
	}
}
