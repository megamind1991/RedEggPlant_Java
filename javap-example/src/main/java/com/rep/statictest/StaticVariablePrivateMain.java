package com.rep.statictest;

public class StaticVariablePrivateMain {
    private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }/* w ww .j a v a 2 s .com */

    private static void addInstance() {
        numInstances++;
    }

    /**
     * @Description : 功能说明
     * @Author : 大刘
     * @Param null
     * @Return : A
     */
    StaticVariablePrivateMain() {
        StaticVariablePrivateMain.addInstance();
    }

    /**
     * @Description : 功能说明
     * @Author : 大刘
     * @Param null
     * @Return : A
     */
    public static void main(String[] arguments) {
        System.out.println("Starting with " + StaticVariablePrivateMain.getCount() + " objects");
        for (int i = 0; i < 500; ++i)
            new StaticVariablePrivateMain();
        System.out.println("Created " + StaticVariablePrivateMain.getCount() + " objects");
    }
}