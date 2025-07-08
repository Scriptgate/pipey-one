package net.scriptgate.pi.p1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestForwardingController {

    private static final Logger LOG = LoggerFactory.getLogger(RequestForwardingController.class);

    @RequestMapping(value = {
            "/pip1",
            "/pip1/",
            "/pip1/{path:[^\\.]*}"
    })
    public String redirect() {
        LOG.debug("Forwarding to /pip1/");
        // Forward to home page so that angular routing is preserved
        return "forward:/";
    }
}
