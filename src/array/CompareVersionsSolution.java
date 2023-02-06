package array;

import java.util.List;
import java.util.ArrayList;

public class CompareVersionsSolution {
    public int compareVersion(String version1, String version2) {
		String[] version1RevisionStrs = version1.split("\\.");
		String[] version2RevisionStrs = version2.split("\\.");
		List<Integer> version1Revisions = new ArrayList<Integer>();
		List<Integer> version2Revisions = new ArrayList<Integer>();
		int normalizedLength = Math.max(version1RevisionStrs.length, version2RevisionStrs.length);

		for (int i = 0; i < normalizedLength; ++i) {
			if (i >= version1RevisionStrs.length) {
				version1Revisions.add(0);
			} else {
				version1Revisions.add(revisionStrToRevisionInt(version1RevisionStrs[i]));
			}

			if (i >= version2RevisionStrs.length) {
				version2Revisions.add(0);
			} else {
				version2Revisions.add(revisionStrToRevisionInt(version2RevisionStrs[i]));
			}
		}
		
		for (int i = 0; i < normalizedLength; ++i) {
			int res = version1Revisions.get(i) - version2Revisions.get(i);
			if (res == 0) {
				continue;
			} else if (res < 0) {
				return -1;
			} else {
				return 1;
			}
		}

		return 0;
	}

	public int revisionStrToRevisionInt(String revisionStr) {
		int revision = 0;
		int ptr = 0;

		while (ptr < revisionStr.length() && revisionStr.charAt(ptr) == '0') {
			ptr++;
		}

		while (ptr < revisionStr.length()) {
			revision = revision * 10 + (revisionStr.charAt(ptr) - '0');
            ptr++;
		}

		return revision;
	}
}
