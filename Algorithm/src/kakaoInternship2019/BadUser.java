package kakaoInternship2019;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @FileName : BadUser.java
 * @Project : Algorithm
 * @Date : 2020. 9. 8.
 * @Author : Kim DongJin
 * @Comment : 2019 카카오 겨울 인턴십 불량사용자 문제 풀이 완료
 */
public class BadUser {

	private Set<Set<String>> result;

	public int solution(String[] user_id, String[] banned_id) {
		result = new HashSet<>();
		dfs(user_id, banned_id, new LinkedHashSet<>());
		return result.size();
	}

	private void dfs(String[] user_id, String[] banned_id, Set<String> set) {
		if (set.size() == banned_id.length) {
			if (isBannedUsers(set, banned_id)) {
				result.add(new HashSet<>(set));
			}

			return;
		}

		for (String userId : user_id) {
			if (!set.contains(userId)) {
				set.add(userId);
				dfs(user_id, banned_id, set);
				set.remove(userId);
			}
		}
	}

	private boolean isBannedUsers(Set<String> set, String[] banned_id) {
		int i = 0;

		for (String user : set) {
			if (!isSameString(user, banned_id[i++])) {
				return false;
			}
		}

		return true;
	}

	private boolean isSameString(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		for (int i = 0; i < a.length(); i++) {
			if (b.charAt(i) == '*')
				continue;

			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}
