/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.resource;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class LogicResource {

    public int solution(int[] A) {

        int N = A.length;
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                answer = i;
                return i;
            }
        }
        return answer;
    }

}
