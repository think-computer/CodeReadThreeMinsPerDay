package kr.ac.jejunu.educom.yechankim.service;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeBlankProblemForPythonProgramSource {
    private static SecureRandom random = new SecureRandom();
    private static int maxNo = 2;
    private static String source;
    private static String[] codes;
    private static char firstBlankSymbol = 'ⓐ';
    private static int[] randomlyChosenPatternListList;
    //private static int[] randomlyChosenPatternList;
    public static String[] answersList;
    private static MakeBlankProblemForPythonProgramSource instance;
    private static String[] keywordPatternList = {
            "\\s*(while)\\s+.+\\s*:\\s*",
            "\\s*(for)\\s+.+\\s+in\\s+.+\\s*:\\s*",
            "\\s*(if)\\s+(\\(.+\\)|.+)\\s*:\\s*",
            "\\s*(elif)\\s+(\\(.+\\)|.+)\\s*:\\s*",
            "\\s*(else)\\s*:\\s*",
            "\\s*(def)\\s+.+\\(.*\\)\\s*:\\s*"
    };
    private static String[] conditionPatternList = {
            "\\s*.+\\s*(>=)\\s*.+\\s*",
            "\\s*.+\\s*(<=)\\s*.+\\s*",
            "\\s*.+\\s*(>)\\s*.+\\s*",
            "\\s*.+\\s*(<)\\s*.+\\s*",
            "\\s*.+\\s*(==)\\s*.+\\s*"
    };
    private static String[] operatorPatternList = {
            "\\s*.+\\s*(\\+)\\s*.+\\s*",
            "\\s*.+\\s*(-)\\s*.+\\s*",
            "\\s*.+\\s*(\\*)\\s*.+\\s*",
            "\\s*.+\\s*(/)\\s*.+\\s*",
            "\\s*.+\\s*(%)\\s*.+\\s*",
            "\\s*.+\\s*(=)\\s*.+\\s*"
    };
    private static String[] indexPatternList = {
            "\\s*.+\\s*\\[\\s*(.+)\\s*\\]\\s*.+"
    };
    private static String[][] patternList = {
            keywordPatternList, conditionPatternList, operatorPatternList, indexPatternList
    };
    public static MakeBlankProblemForPythonProgramSource getInstance() {
        if (instance == null) {
            instance = new MakeBlankProblemForPythonProgramSource();
        }

        process();

        return instance;
    }
    public static void setProblemSource(String src) {
        source = src;
        codes = source.split("\n");
    }
    private static void process() {
        randomlyChosenPatternListList = new int[maxNo];
        //randomlyChosenPatternList = new int[maxNo];
        answersList = new String[maxNo];
    }
    public static void choosePatternRandomly() {
        int i;

        for (i = 0 ; i < maxNo ; i += 1) {
            randomlyChosenPatternListList[i] = random.nextInt(patternList.length);
            //System.out.println(randomlyChosenPatternListList[i]);
        }
//        for (i = 0 ; i < maxNo ; i += 1) {
//            randomlyChosenPatternList[i] = random.nextInt(patternList[randomlyChosenPatternListList[i]].length);
//            System.out.println(randomlyChosenPatternList[i]);
//        }
    }
    public static void makeProblem() {
        String copy = source;
        boolean flag = true;
        int ctr = 0;
        Pattern pattern;
        Matcher matcher;

        for (int i = 0 ; i < codes.length ; i += 1) { //String code : codes) {
            for (int j = 0 ; j < maxNo ; j += 1) {
                int r = randomlyChosenPatternListList[j];
                //int c = randomlyChosenPatternList[i];

                for (int c = 0 ; c < patternList[randomlyChosenPatternListList[j]].length ; c += 1) {
                    if (ctr == maxNo) {
                        flag = false;
                        break;
                    }

                    if (Pattern.matches(patternList[r][c], codes[i])) {
                        pattern = Pattern.compile(patternList[r][c]);
                        matcher = pattern.matcher(codes[i]);

                        if (matcher.find()) {
                            String changedCode = "";
                            answersList[ctr] = matcher.group(1);
                            int index = codes[i].indexOf(answersList[ctr]);
                            changedCode = codes[i].substring(0, index) + String.format("( 빈칸 %c )", (char)(firstBlankSymbol + ctr)) + codes[i].substring(index + answersList[ctr].length());
                            codes[i] = changedCode;
                            ctr += 1;
                        }
                    }
                }
            }
        }

        if (flag) {
            System.out.println("(warning) not enough blanks created");
        }
    }
    //public String getSource() {
    //    return source;
    //}
    public String getProblem() {
        String temp = "";

        for (String code : codes)
            temp += (code + "\n");

        return temp;
    }
}

/* 테스트 예제 클래스 소스
    import java.util.regex.Pattern;

    public class MakeBlankProblemForPythonProgramSourceTest {
        public static void main(String[] args) {
            String src =    "def fib(n):\n" +
                            "     arr[10] = 3;\n"+
                            "     a, b = 0, 1\n" +
                            "     while a < n:\n" +
                            "         print(a, end=' ')\n" +
                            "         a, b = b, a+b\n" +
                            "     print()";

            MakeBlankProblemForPythonProgramSource instance =
                    MakeBlankProblemForPythonProgramSource.getInstance();
            instance.setProblemSource(src);
            instance.choosePatternRandomly();
            instance.makeProblem();

            System.out.println(instance.getProblem());

            int cnt = 0;
            for (String ans : instance.answersList) {
                if (ans == null)
                    break;

                System.out.println(ans);
                cnt += 1;
            }

            System.out.println("형성된 빈칸 개수: " + cnt + "개");
        }
    }
*/