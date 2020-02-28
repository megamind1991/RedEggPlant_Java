package com.rep.interfaces;

/**
 * Interface with a Nested Class and a Constant Field
 */
interface WithNestedClassAndInnerConstantFieldWalkable {

    // An abstract method
    void walk();

    // A nested class 接口里面的内嵌类
    class Dog implements WithNestedClassAndInnerConstantFieldWalkable {
        private Dog() {
            // Do not allow outside to create its object 把构造方法变成私有的 不被外面创建
        }// w w w .ja v a 2 s .c o m

        public void walk() {
            System.out.println("Nothing serious to run...");
        }
    }

    // 接口内部生成一个实现类 给外层访问
    WithNestedClassAndInnerConstantFieldWalkable Default = new Dog();

}

public class WithNestedClassAndInnerConstantFieldMain {
    public static void main(String[] args) {
        // 获取接口内定义的 内部变量 然后调用 本类的方法
        my(WithNestedClassAndInnerConstantFieldWalkable.Default);
    }

    public static void my(WithNestedClassAndInnerConstantFieldWalkable a) {
        a.walk();
    }
}