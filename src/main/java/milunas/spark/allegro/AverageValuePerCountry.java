package milunas.spark.allegro;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class AverageValuePerCountry {

    private final static String APP_NAME = "Calculator";
    private final static String MASTER = "local";

    private SparkSession getOrCreateSession(){
        return SparkSession
                .builder()
                .appName(APP_NAME)
                .master(MASTER)
                .getOrCreate();
    }

    private Dataset<Row> getData(String path){
        return getOrCreateSession()
                .read()
                .csv(path);
    }

}
