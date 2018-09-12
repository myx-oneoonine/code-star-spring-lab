package web;

import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/jsp")
    String jsp() {
        return "index-jsp";
    }

    @RequestMapping("/vat")
    String vat() {
        return "vat";
    }

    @RequestMapping("/circle")
    String circle() {
        return "circle";
    }

    @RequestMapping("/rectangle")
    String rectangle() {
        return "rectangle";
    }

    @RequestMapping("/zipcode")
    String zipcode() {
        return "zipcode";
    }
    
    @RequestMapping("/ip")
    String ip()
    {
        return "ip";
    }
}
