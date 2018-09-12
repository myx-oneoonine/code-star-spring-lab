package web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @RequestMapping("/")
    String index() {
        return "Hello World!";
    }

    /**
     * 1*
     */
    @RequestMapping("/area")
    double area(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * 2*
     */
    @RequestMapping("/vat/{price}")
    double vat(@PathVariable double price) {
        return price * 7 / 100;
    }

    /**
     * 3*
     */
    @RequestMapping("/zipcode/{district}")
    String zipcode(@PathVariable String district) {
        String result = "Not Found";
        Map<String, String> zipcodeMap = new HashMap<String, String>();
        zipcodeMap.put("เมืองนนทบุรี", "11000");
        zipcodeMap.put("บางบัวทอง", "11110");
        zipcodeMap.put("ปากเกร็ด", "11120");
        zipcodeMap.put("บางกรวย", "11130");
        zipcodeMap.put("บางใหญ่", "11140");
        zipcodeMap.put("ไทรน้อย", "11150");

        if (zipcodeMap.containsKey(district)) {
            result = zipcodeMap.get(district);
        }

        zipcodeMap.clear();

        return result;
    }

    /**
     * 4*
     */
    @RequestMapping("/car-tax/{cc}/{seat}")
    double calculate(@PathVariable int cc, @PathVariable int seat) {
        return cc * 0.75 + seat * 70;
    }

    /**
     * 5*
     */
    @RequestMapping("/soul-mate/{name1}/{name2}")
    boolean soulMate(@PathVariable String name1, @PathVariable String name2) {
        return name1.length() == name2.length();
    }

}
