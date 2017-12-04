package cn.acseed.test;

import java.util.Optional;

/**
 * Created by caohongchen on 2017/12/3.
 */
public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
