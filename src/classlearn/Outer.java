package classlearn;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/09 17:19
 **/

class Outer {
    private String name;
    private static int age = 20;

    public Outer(String name) {
        this.name = name;
        getInnerInstance().sayHello();
    }

    /**
     * 静态内部类 只能引用外部类的静态成员变量
     *
     * @author hbj
     */
    static class StaticClass {
        public void sayHello() {
            System.out.println("ZhuZhu`s static inner class age is " + age);
        }
    }

    /**
     * 内部类
     *
     * @author hbj
     */
    class Inner {
        private String name = "zhuzhu 2";

        public void sayHello() {
            System.out.println("Hello , my name is " + name + " , outer name is " + Outer.this.name + " , my age is " + age);
        }
    }

    public void zhu() {
        System.out.println("===begin===");
        /**
         * 局部内部类  只能在该方法里面使用
         * @author hbj
         */
        class ZhuZhu {
            public void zhuZhuMethod() {
                System.out.println("ZhuZhu`s Anonymity Class , zhu zhu`s name is " + name);
            }
        }
        ZhuZhu zhuZhu = new ZhuZhu();
        zhuZhu.zhuZhuMethod();
        System.out.println("===end===");
    }

    private Inner getInnerInstance() {
        return new Inner();
    }

}
