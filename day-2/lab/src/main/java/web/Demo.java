package web;

import java.util.ArrayList;
import org.springframework.boot.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Demo {

    @RequestMapping("/")
	String index() {
		return "index";
	}


    
}
