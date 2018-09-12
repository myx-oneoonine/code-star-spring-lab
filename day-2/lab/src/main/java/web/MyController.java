/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Stations;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author myx
 */
@Controller
public class MyController {

    SessionFactory factory = new Configuration()
            .addPackage("entity")
            .addAnnotatedClass(Stations.class)
            .buildSessionFactory();

    //http://localhost:8080/suburb?name=GERALDTON
    @RequestMapping("/suburb")
    @ResponseBody
    List suburb(String name) {
        Session database = factory.openSession();
        Query query = database.createQuery("from Stations where suburb = :suburb");
        query.setParameter("suburb", name);
        List list = query.list();
        database.close();
        return list;
    }

    //http://localhost:8080/postcode/6530
    @RequestMapping("/postcode/{code}")
    @ResponseBody
    List postcode(@PathVariable String code) {
        Session database = factory.openSession();
        Query query = database.createQuery("from Stations where postcode = :postcode");
        query.setParameter("postcode", code);
        List list = query.list();
        return list;
    }

    //http://localhost:8080/search?query=syd
    @RequestMapping("/search")
    @ResponseBody
    List search(String query) {
        Session database = factory.openSession();
        Query qry = database.createQuery("from Stations where postcode like :query or address like :query");
        qry.setParameter("query", "%" + query.toUpperCase() + "%");
        List list = qry.list();
        return list;
    }

    //http://localhost:8080/station-list?top=-40.0&bottom=-50.0&left=140&right=150
    @RequestMapping("/station-list")
    @ResponseBody
    List position(double top, double bottom, double left, double right) {
        Session database = factory.openSession();
        Query qry = database.createQuery(""
                + "from Stations "
                + "where "
                    + "(latitude BETWEEN :bottom and :top) "
                    + "and (longitude BETWEEN :left and :right)");
        qry.setParameter("top", top);
        qry.setParameter("bottom", bottom);
        qry.setParameter("left", left);
        qry.setParameter("right", right);
        List list = qry.list();
        return list;

//select * from stations 
//where (latitude BETWEEN -30 and -20) and (longitude BETWEEN 100 and 150) ;
    }
}
