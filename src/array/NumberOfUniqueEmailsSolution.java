package array;

import java.util.Set;
import java.util.HashSet;

public class NumberOfUniqueEmailsSolution {
	public int numUniqueEmails(String[] emails) {
		Set<String> uniqueNormalizedEmails = new HashSet<String>();

		for (int i = 0; i < emails.length; ++i) {
			String unnormalizedEmail = emails[i];

			String[] elements = unnormalizedEmail.split("@");

			String localName = elements[0];
			String domainName = elements[1];

			String normalizedLocalName = getNormalizedLocalName(localName);
			String str = normalizedLocalName + "@" + domainName;

			uniqueNormalizedEmails.add(str);
		}

		return uniqueNormalizedEmails.size();
	}

	public String getNormalizedLocalName(String localName) {
		StringBuilder strBldr = new StringBuilder();

		for (int i = 0; i < localName.length(); ++i) {
			char c = localName.charAt(i);

			if (c == '+') {
				break;
			}

			if (c == '.') {
				continue;
			}

			strBldr.append(c);
		}
		return strBldr.toString();
	}
}

