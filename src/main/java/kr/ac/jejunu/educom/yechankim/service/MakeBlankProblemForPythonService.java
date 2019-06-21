package kr.ac.jejunu.educom.yechankim.service;

import java.security.SecureRandom;

public interface MakeBlankProblemForPythonService {
    String[] keywordPatternList = {
            "\\s*(while)\\s+.+\\s*:\\s*",
            "\\s*(for)\\s+.+\\s+in\\s+.+\\s*:\\s*",
            "\\s*(if)\\s+(\\(.+\\)|.+)\\s*:\\s*",
            "\\s*(elif)\\s+(\\(.+\\)|.+)\\s*:\\s*",
            "\\s*(else)\\s*:\\s*",
            "\\s*(def)\\s+.+\\(.*\\)\\s*:\\s*"
    };
    String[] conditionPatternList = {
            "\\s*.+\\s*(>=)\\s*.+\\s*",
            "\\s*.+\\s*(<=)\\s*.+\\s*",
            "\\s*.+\\s*(>)\\s*.+\\s*",
            "\\s*.+\\s*(<)\\s*.+\\s*",
            "\\s*.+\\s*(==)\\s*.+\\s*"
    };
    String[] operatorPatternList = {
            "\\s*.+\\s*(\\+)\\s*.+\\s*",
            "\\s*.+\\s*(-)\\s*.+\\s*",
            "\\s*.+\\s*(\\*)\\s*.+\\s*",
            "\\s*.+\\s*(/)\\s*.+\\s*",
            "\\s*.+\\s*(%)\\s*.+\\s*",
            "\\s*.+\\s*(=)\\s*.+\\s*"
    };
    String[] indexPatternList = {
            "\\s*.+\\s*\\[\\s*(.+)\\s*\\]\\s*.+"
    };
    String[][] patternList = {
            keywordPatternList, conditionPatternList, operatorPatternList, indexPatternList
    };

    void setForThisService(String src);
    void setProblemSource(String src);
    void process();
    void choosePatternRandomly();
    void makeProblem();
    String getProblem();
    String[] getAnswersList();
}
