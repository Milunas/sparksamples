package milunas.spark;

import milunas.spark.searcher.ReportGenerate;

import static spark.Spark.*;

public class JavaSparkApplication {

    private static final String PATH = "my-class.java";

    public static void main(String[] args) {

        ReportGenerate generator = new ReportGenerate(PATH);
        port(8080);
        get("/report", (req, resp) -> generator.generateNewReport());
    }
}
