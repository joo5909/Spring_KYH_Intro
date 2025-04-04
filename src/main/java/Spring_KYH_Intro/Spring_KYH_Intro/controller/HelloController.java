package Spring_KYH_Intro.Spring_KYH_Intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model ){
        model.addAttribute("data", name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = false) String name){
        return "name : " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Object helloApi(@RequestParam(value = "name", required = false) String name){

        class Hello {
            private String name;

            public void setName(String name) {
                this.name = name;
            }
        }

        Hello hello = new Hello();

        hello.setName(name);

        return hello;
    }
}
