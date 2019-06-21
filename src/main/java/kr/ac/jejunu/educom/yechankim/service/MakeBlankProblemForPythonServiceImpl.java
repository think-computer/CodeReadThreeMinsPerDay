package kr.ac.jejunu.educom.yechankim.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MakeBlankProblemForPythonServiceImpl implements MakeBlankProblemForPythonService {
    SecureRandom random = new SecureRandom();
    int maxNo = 2;
    String source;
    String[] codes;
    char firstBlankSymbol = 'ⓐ';
    int[] randomlyChosenPatternListList;
    String[] answersList;

    public MakeBlankProblemForPythonServiceImpl() {
        process();
    }

    @Override
    public void setForThisService(String src) {
        setProblemSource(src);
        choosePatternRandomly();
        makeProblem();
    }

    @Override
    public void setProblemSource(String src) {
        source = src;
        codes = source.split("\n");
    }
    @Override
    public void process() {
        randomlyChosenPatternListList = new int[maxNo];
        //randomlyChosenPatternList = new int[maxNo];
        answersList = new String[maxNo];
    }
    @Override
    public void choosePatternRandomly() {
        int i;

        for (i = 0; i < maxNo; i += 1) {
            randomlyChosenPatternListList[i] = random.nextInt(patternList.length);
        }
    }
    @Override
    public void makeProblem() {
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
    @Override
    public String getProblem() {
        String temp = "";

        for (String code : codes)
            temp += (code + "\n");

        return temp;
    }
    @Override
    public String[] getAnswersList() {
        return answersList;
    }
}