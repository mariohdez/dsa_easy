package array;

public class CompareVersionsSolution {
    public int compareVersion(String version1, String version2) {
    	int ptr1 = 0;
    	int ptr2 = 0;
    	int revision1 = 0;
    	int revision2 = 0;
    	
    	while (ptr1 < version1.length() || ptr2 < version2.length()) {
    		int ptr1Start = ptr1;
    		int ptr2Start = ptr2;

    		while (ptr1 < version1.length() && version1.charAt(ptr1) != '.') {
    			++ptr1;
    		}

    		while (ptr2 < version2.length() && version2.charAt(ptr2) != '.') {
    			++ptr2;
    		}
    		
    		if (ptr1Start != ptr1) {
    			revision1 = revisionStrToRevisionInt(version1.substring(ptr1Start, ptr1));
    		}
    		
    		if (ptr2Start != ptr2) {
    			revision2 = revisionStrToRevisionInt(version2.substring(ptr2Start, ptr2));
    		}

    		int diff = revision1 - revision2;
    		
    		if (diff!=0) {
    			return diff;
    		}

    		++ptr1;
    		++ptr2;
    		revision1=0;
    		revision2=0;
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
