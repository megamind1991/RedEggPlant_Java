package com.rep.finalize;

public class FinalizeMain {
    public static void main(String[] args) {
        // Create many objects, say 20000 objects.
        for (int i = 0; i < 20000; i++) {
            new Finalize(i);
        }  /*  ww w  .j  a va2  s.  co  m*/
    }
}

class Finalize {
    private int x;

    public Finalize(int x) {
        this.x = x;
    }

    public void finalize() {
      // 当虚拟机认为需要回收并且销毁的这个对象的时候 调用finalize方法
        System.out.println("Finalizing " + this.x);

        /* Perform any cleanup work here... */
    }
}