package cn.acseed.controller;

import cn.acseed.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by caohongchen on 16-12-25.
 */
@RestController
public class UserController {
    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping(value = "/orderDetail/{category}/4/{src}", method = RequestMethod.GET)
    public User greeting(OrderDetailParam param) {
        return new User(counter.getAndIncrement(), String.format(template, param.getName()));
    }
}
