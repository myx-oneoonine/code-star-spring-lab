/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author myx
 */
@Controller
public class MyApp {

    @RequestMapping("/vat-result")
    String vat(double price, Model model) {
        model.addAttribute("result", price * 7 / 100);

        return "vat-result";
    }

    @RequestMapping("/circle-result")
    String circle(double radius, Model model) {
        model.addAttribute("area", Math.PI * Math.pow(radius, 2));
        model.addAttribute("circumference", 2 * Math.PI * radius);

        return "circle-result";
    }

    @RequestMapping("/rectangle-result")
    String rectangle(double width, double hight, Model model) {
        model.addAttribute("area", width * hight);

        return "rectangle-result";
    }

    @RequestMapping("zipcode-result")
    String zipcode(String district, Model model) {
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

        model.addAttribute("zipcode", result);

        zipcodeMap.clear();
        return "zipcode-result";
    }

    @RequestMapping("ip-result")
    String ip(String domainName, Model model) {

        String result = "not found";
        try {
            result = InetAddress.getByName(domainName).toString();
        } catch (Exception e) {
            System.out.println("ERROR\n");
            e.printStackTrace();
        }

        model.addAttribute("ip", result);
        return "ip-result";
    }
}
