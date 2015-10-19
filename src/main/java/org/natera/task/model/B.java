package org.natera.task.model;

class B  extends A {

        public int a;

        public int m() {
                return super.m();
        }

        public static void main() {
                B b = new B();
                int a = (A)b.a;
        }

}