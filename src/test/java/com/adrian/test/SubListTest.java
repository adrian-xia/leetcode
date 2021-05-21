package com.adrian.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 夏磊
 * @version Id: SubListTest, v 0.1 2021/4/19 2:15 下午 xl1048886 Exp $
 * @description
 */
public class SubListTest {

    @Test
    public void testSublist() {
        List<String> cachePrices = Lists.newArrayList("10", "8", "9", "6", "7", "3", "7", "8", "9", "10", "11");
        List<String> priceList = cachePrices.stream().filter(cachePrice -> new BigDecimal("3").compareTo(new BigDecimal(cachePrice)) != 0)
                .collect(Collectors.toList());


//        priceList = priceList.subList(priceList.size() - 10, priceList.size());
        System.out.println(priceList);
    }

}
