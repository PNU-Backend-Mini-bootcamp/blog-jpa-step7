package shop.mtcoding.blogv2.temp;

import org.springframework.stereotype.Controller;

@Controller
public class DogController {

    public DogController(Dog dog) {
        System.out.println("DogController component scan : Dog name : "+dog.name);
    }
}
