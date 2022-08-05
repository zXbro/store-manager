package org.zxbro.store.keeper.api;

import java.util.List;

import com.google.common.collect.Lists;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello!";
    }

    @GetMapping(value = "/hello/list/{length}")
    public List<Integer> testList(@PathVariable("length") int length) {
        if (length < 1) {
            length = 10;
        } else {
            length = length + 10;
        }
        List<Integer> result = Lists.newArrayList();
        for (int i = 1; i <= length; i++) {
            result.add(i);
        }
        return result;
    }
}