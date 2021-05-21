package com.adrian.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @version Id: ToMapTest, v 0.1 2021/4/21 7:35 下午 xialei Exp $
 */
public class ToMapTest {

    @Test
    public void testToMap() {
        List<User> userList = Lists.newArrayList(
                new User().setId("B").setName("张三"),
                new User().setId("B").setName("李四"),
                new User().setId("B").setName("李四"),
                new User().setId("C").setName("王五")
        );
        Map<String, String> map = userList.stream().collect(
                Collectors.toMap(User::getId, User::getName, (n1, n2) -> n1)
        );
        System.out.println(map);
    }

}
