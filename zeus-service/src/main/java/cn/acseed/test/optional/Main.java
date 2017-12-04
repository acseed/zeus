package cn.acseed.test.optional;

import cn.acseed.test.Car;
import cn.acseed.test.Insurance;
import cn.acseed.test.Person;

import java.util.Optional;

/**
 * Created by caohongchen on 2017/12/3.
 */
public class Main {

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
    public static void main(String[] args) {
        Person person = new Person();
        person.setCar(Optional.empty());
        System.out.println(getCarInsuranceName(Optional.of(person)));
    }
}
