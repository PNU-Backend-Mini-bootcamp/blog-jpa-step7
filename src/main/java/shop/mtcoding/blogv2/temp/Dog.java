package shop.mtcoding.blogv2.temp;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    public String name = "토토";

    public Dog() {
        System.out.println("Dog Component scan ----------------------");
    }
}
