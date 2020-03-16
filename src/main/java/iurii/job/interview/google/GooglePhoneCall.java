package iurii.job.interview.google;

public class GooglePhoneCall {

    /*
    Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

lower case latin (a-z)

abca a->d
dbcd c->e
dbed b->c
dced

abca
dcga  = false

aaaa
aaab

all same letter occurences on the same positions.
legths of two strings should be the same.

Collect all the indexes of occured letter

Map<Charater, Set<Integer>>
a -> 0, 3
b -> 1
c -> 2

Then go through the keySet of Map and for each value in set

Time complexity : O(N)
Memory Complexity : O(N)

/// a = “” b = ”a”

boolean canTransform(String a, String b) {
    if (a.length() != b.length()) {
    	return false;
    }
    Map<Character, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < a.length(); i++) {
    	char character = a.charAt(i);
      if (map.get(character) == null) {
          Set<Integer> indexes = new HashSet<>();
          indexes.add(i);
          map.put(character, indexes);
      } else {
          map.get(character).add(i);
      }
    }
    for (Set<Integer> indexesSet : map.valueSet()) {
         Character firstChar = null;
         for (int index : indexesSet) {
            if (firstChar == null) {
                firstChar = b.charAt(index);
            } else {
                if (firstChar != b.charAt(index)) {
                    return false;
                }
            }
         }
    }
    return true;
}


///
Map<Character, Character> map = new HashMap<>();
for (int i = 0; i < a.length(); i++) {
     char aChar = a.charAt(i);
     if (map.get(aChar) == null) {
         map.put(aChar, b.charAt(i));
     } else {
         char bChar = map.get(aChar);
         if (bChar != b.charAt(i)) {
            return false;
         }
     }
}
return true;

Space Complexity - 26 * O(1)


ab
ab -> bb
xb
xa
ba

abc
xbc
...
bca

a -> b ,

ab
bc

a -> b -> c

abc
bca

a -> b -> c -> a

boolean isIntermediateNeeded(String a, String, Map<Character, Character> map) {

}

     */
}
