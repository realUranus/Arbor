package com.realuranus.arbor;

public class APP_DATA {
    //url
    private final static String BASE_URL = "https://www.nowcoder.com/ta/leetcode";
    private final static String PROBLEM_URL = BASE_URL + "problem";

    //selector
    private final static String PROBLEM_SELECTOR = ".nk-content table a";

    public static String getBASE_URL() {
        return BASE_URL;
    }

    public static String getProblemUrl() {
        return PROBLEM_URL;
    }

    public static String getProblemSelector() {
        return PROBLEM_SELECTOR;
    }
}
