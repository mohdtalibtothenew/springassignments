package com.ttn.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentMultipleController extends MultiActionController {

    public ModelAndView dummy(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("dummy");
        return modelAndView;
    }


    public void dummy2(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<b>HELLO World</b>");
    }

}