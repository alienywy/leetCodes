package com.leetcode3;

public class Substitutaion {
    public String substitution (String a, String b, String c) {
        if (c == null) {
            return a;
        }
        StringBuilder stra = new StringBuilder(a);
        StringBuilder strb = new StringBuilder(b);
        int s1 = 0, s2 = 0; // pointer in a and b
        int rp1 = 0; // replace indicator in a
        for (s1 = 0; s1 < a.length(); s1++, rp1++) {
            if (stra.charAt(s1) == strb.charAt(s2)) {
                while (s2 < strb.length()) {
                    if (stra.charAt(s1) == strb.charAt(s2)) {
                        s1++;
                        s2++;
                    } else {
                        s2 = 0;
                        break;
                    }
                }
            }
            if (s2 == strb.length()) {
                // replace to c;
                stra.replace(rp1, s1, c);
                rp1 = s1;
                s2 = 0;
                
            }
        }
        return stra.toString();
    }


    public static void main(String[] args) {
        Substitutaion so = new Substitutaion();
        
        System.out.println(so.substitution("helloel23", "el", "ck"));
    }

}
