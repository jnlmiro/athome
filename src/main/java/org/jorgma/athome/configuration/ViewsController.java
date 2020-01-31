package org.jorgma.athome.configuration;

import org.jorgma.athome.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jorgma on 2019-05-31.
 */
@Controller
public class ViewsController {

    @Value("${spring.profiles.active}")
    private String activeProfile;


    private String indexPath() {
        if (activeProfile.equals(Constants.dev)) {
            System.out.println("is dev");
            System.out.println(Constants.devEntryPoint);
            return Constants.devEntryPoint;
        }
        return "/";
    }

    @RequestMapping(value = {
            "/",
            "/dashboard",
            "/entry-board",
            "/stations",
            "/weather",
            "/weather/**",
            "/rpi-backlight",
            "/rpi-backlight/**",
            "/zwave",
            "/zwave/**"
    }, method = RequestMethod.GET)
    public String index() {
        return "forward:" + indexPath() + "index.html";
    }

}
