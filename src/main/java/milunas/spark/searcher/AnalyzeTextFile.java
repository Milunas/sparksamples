package milunas.spark.searcher;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class AnalyzeTextFile implements Analyzer {

    private final static String MASTER = "local";
    private String filePath;
    private String applicationName;

    public AnalyzeTextFile(String filePath){
        this.filePath = filePath;
        applicationName = "analyze"+filePath;
    }

    private SparkSession getOrCreateSparkSession(){
            return SparkSession
                    .builder()
                    .appName(applicationName)
                    .master(MASTER)
                    .getOrCreate();
    }

    private Dataset<String> getLinesFromText(){
        return getOrCreateSparkSession()
                .read()
                .textFile(filePath)
                .cache();
    }

   public boolean isLinesContainsWords(String words){
        Dataset<String> lines = getLinesFromText();
        return lines.filter(s->s.contains(words)) != null;
    }

   public long countBrackets(String bracket){
        Dataset<String> lines = getLinesFromText();
        return lines.filter(s->s.contains(bracket)).count();
    }

}
