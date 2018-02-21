package milunas.spark.searcher;

import java.util.Scanner;

public class SparkSearcherApplication {

    private static String setPath(){
        Scanner reader = new Scanner(System.in);
        String filePath = reader.nextLine();
        reader.close();
        return filePath;
    }

    public static void main(String[] args){
        ReportGenerate report = new ReportGenerate(setPath());
        System.out.println(report.generateNewReport());
    }

}
