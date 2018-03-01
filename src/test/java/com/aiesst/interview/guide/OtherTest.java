package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class OtherTest {
    @Test
    public void primerSumTest() {
        Assert.assertEquals(2, getPrimerPairs(10));
    }

    static int getPrimerPairs(int sum) {
        int pairs = 0;
        var primers = new ArrayList<Integer>();
        for (int i = 2; i <= sum; i++) {
            if (isPrimer(i)) {
                primers.add(i);
            }
        }
        for (int i = 0; i < primers.size(); i++) {
            for (int j = i; j < primers.size(); j++) {
                if (primers.get(i) + primers.get(j) == sum) {
                    ++pairs;
                }
            }
        }
        return pairs;
    }

    /**
     * 检查一个数是否为素数
     *
     * @param num
     * @return
     */
    static boolean isPrimer(int num) {
        if (num < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void isPrimersTest() {
        Assert.assertTrue(isPrimer(7));
        Assert.assertTrue(!isPrimer(4));

    }

    @Test
    public void geohashTest() {
        Assert.assertEquals(geohash(80, -90, 90, 6), "111100");
    }

    /**
     * 腾讯面试题，geohash
     *
     * @param pivot    基准
     * @param low      下限
     * @param upper    上限
     * @param accurate 精度
     * @return
     */
    static String geohash(int pivot, int low, int upper, int accurate) {
        StringBuilder resBuilder = new StringBuilder();
        while (resBuilder.length() < accurate) {
            int half = (upper + low) / 2;
            if (half > pivot) {
                upper = half;
                resBuilder.append(0);
            } else {
                low = half + 1;
                resBuilder.append(1);
            }
            if (upper <= low) {
                break;
            }
        }
        return resBuilder.toString();
    }
}
