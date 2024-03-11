public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++) { 
			String currentLine = in.readLine();
			dictionary[i] = currentLine;
			}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
	for (int i = 0; i < dictionary.length - 1; i++) {
		if ( word.equals(dictionary[i])) {
			return true;
			}	
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
        if (hashtag.isEmpty()) {
            return ;
        }
		String words= "";
		hashtag = hashtag.toLowerCase();
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
			words += hashtag.charAt(i - 1);
			if(existInDictionary(words, dictionary)==true){
				System.out.println(words);
				breakHashTag( hashtag.substring(i), dictionary);
				break;
			}
		
        }
    }

}
