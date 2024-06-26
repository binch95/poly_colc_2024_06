package com.koreait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Calc {
    static int miner = 0;
    public static int run(String exp) {
        // (20 + 20) + 20
        // 괄호 제거
        exp = exp.trim();
        exp = stripOuterBrackets(exp);

        // 단일항이 들어오면 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains(" * ");
        boolean needToPlus = exp.contains(" + ") || exp.contains(" - ");

        boolean needToSplit = exp.contains("(") || exp.contains(")");
        boolean needToCompound = needToMulti && needToPlus;


        if (needToSplit) {

            int splitPointIndex = findSplitPointIndex(exp);

            String firstExp = exp.substring(0, splitPointIndex);
            String secondExp = exp.substring(splitPointIndex + 1);


            char operator = exp.charAt(splitPointIndex);

            exp = Calc.run(firstExp) + " " + operator + " " + Calc.run(secondExp);

            return Calc.run(exp);

            } else if (needToCompound) {
                String[] bits = exp.split(" \\+ ");

                String newExp = Arrays.stream(bits)
                        .mapToInt(Calc::run)
                        .mapToObj(e -> e + "")
                        .collect(Collectors.joining(" + "));
                return run(newExp);
            }
            if (needToPlus) {
                exp = exp.replaceAll("- ", "+ -");
                String[] bits = exp.split(" \\+ ");
                int sum = 0;
                for (int i = 0; i < bits.length; i++) {
                    if (miner == 0) {
                        sum += Integer.parseInt(bits[i]);
                    }else{sum += Integer.parseInt(bits[i]) * -1;}
                }
                miner = 0;
                return sum;
            } else if (needToMulti) {
                String[] bits = exp.split(" \\* ");
                int sum = 1;
                for (int i = 0; i < bits.length; i++) {
                    sum *= Integer.parseInt(bits[i]);
                }
                return sum;
            }
            throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
        }


    private static String stripOuterBrackets(String exp) {
        int outerBracketsCount = 0;
        int round = 0;
        if(exp.charAt(0) == '-' && exp.charAt(1) == '('){miner = 1;exp = exp.substring(1,exp.length());}

        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }
        if (outerBracketsCount == 0) return exp;

        for (int i = outerBracketsCount - 1; i < exp.length(); i++) {
            if(exp.charAt(i) == '('){round++;}
            if(exp.charAt(i) == ')'){round--;}
            if (round == 0 && exp.length() - exp.replace("(","").length() >= 2) {return exp;}
            if(round >= 2 ){break;}
        }

        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }

    private static int findSplitPointIndex(String exp) {
        int index = findSplitPointIndexBy(exp, '+');
        if (index == -1){index = findSplitPointIndexBy(exp, '-');}
        if (index >= 0) return index;

        return findSplitPointIndexBy(exp, '*');
    }

    private static int findSplitPointIndexBy(String exp, char findChar) {
        int brackesCount = 0;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(') {
                brackesCount++;
            } else if (c == ')') {
                brackesCount--;
            } else if (c == findChar && exp.charAt(i + 1) != '(') {
                if (brackesCount == 0) return i;
            }
        }
        return -1;
    }
}
