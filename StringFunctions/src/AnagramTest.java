

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnagramTest {
	
	Set sampleA = new HashSet();
	Set sampleB = new HashSet();
	
	public boolean isAnagram(String a, String b, boolean isCaseSensitive) {
		
		sampleA.clear();
		sampleB.clear();
		
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		
		for (char ch : arr1) {
			
			if (!isCaseSensitive) {
				ch = Character.toLowerCase(ch);
			}
			
			sampleA.add(ch);
		}
		
		for (char ch : arr2) {
			if (!isCaseSensitive) {
				ch = Character.toLowerCase(ch);
			}
			sampleB.add(ch);
		}
		
		
		return compareSets(sampleA, sampleB);
	}
	
	private boolean compareSets(Set a, Set b) {
		
		if (a.size() != b.size()) {
			return false;
		}
		
		Iterator i = a.iterator();
		Iterator i2 = b.iterator();
		while (i.hasNext() && i2.hasNext()) {
			
			if (!(i.next().equals(i2.next()))) {
				return false;
			}
					
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		
		AnagramTest test = new AnagramTest();
		
		System.out.println(" Test A " + test.isAnagram("Mahesh", "Ramesh", false));
		
		System.out.println(" Test B " + test.isAnagram("LISTEN", "SILENt", false));
		
		System.out.println(" Test B " + test.isAnagram("LISTEN", "SILENt", true));
		
		System.out.println(" Test C " + test.isAnagram("triangle", "integral", false));
	}
	

}
