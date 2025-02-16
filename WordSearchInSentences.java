public class WordSearchInSentences {
    public static void main(String[] args) {
        String[] sentences = {
            "Java is a powerful language.",
            "I love programming in Python.",
            "Data structures and algorithms are important.",
            "Machine learning is fascinating."
        };
        String word = "programming";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing '" + word + "': " + result);
    }

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
