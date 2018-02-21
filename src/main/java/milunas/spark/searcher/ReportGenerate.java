package milunas.spark.searcher;

public class ReportGenerate {


    private static final String MAIN_METHOD = "static void main(String[] args";
    private static final String SORT_METHOD = "public static int[][][] mySort(int[] dane)";
    private final Analyzer analyzer;

    public ReportGenerate(String filePath){
        analyzer = new AnalyzeTextFile(filePath);
    }

    private boolean isContainsMainMethod(){
       return analyzer.isLinesContainsWords(MAIN_METHOD);
    }

    private boolean isContainsSortMethod(){
        return analyzer.isLinesContainsWords(SORT_METHOD);
    }

    private boolean isBracketsMatched(){

        if (analyzer.countBrackets("{")!=analyzer.countBrackets("}"))
            return false;
        if (analyzer.countBrackets("(")!=analyzer.countBrackets(")"))
            return false;
        if (analyzer.countBrackets("[")!=analyzer.countBrackets("]"))
            return false;

        return true;
    }

    public String generateNewReport(){

        if(!isContainsMainMethod()) {
            return "Main method not exist";
        }
        if(!isContainsSortMethod()) {
            return "Sort method not exist";
        }
        if(!isBracketsMatched()) {
            return "Brackets don't matches";
        }
        return "Ok!";
    }

}
