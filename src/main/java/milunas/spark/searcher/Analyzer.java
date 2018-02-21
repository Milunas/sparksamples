package milunas.spark.searcher;

public interface Analyzer {

    boolean isLinesContainsWords(String words);

    long countBrackets(String bracket);

}
