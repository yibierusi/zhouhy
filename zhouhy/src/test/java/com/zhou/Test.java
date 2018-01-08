package com.zhou;

import java.util.Objects;

/**
 * Created by zhouhy on 2017/12/28.
 */
public class Test {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        String str = "abc";
        System.out.println(Objects.equals("abc","abc"));
        System.out.println(Objects.equals("abc",sb));
        System.out.println(Objects.equals("abc",str));
        System.out.println(Objects.equals("abc",sb.toString()));
    }
}
