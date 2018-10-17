package com.ttn.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
//Question Implement AbstractController in StudentController. create a mapping index.html for it and render index.jsp view from it which displays messages "Hello from index.gsp"
//Question Use annotation in StudentController to define a default action index which renders a jsp page.
/* Question Create one more annotation based action hello inside the StudentController
        which and use @ResponseBody annotation from it to display Hello world.*/
@Controller("/")
public class StudentController extends AbstractController {
    public StudentController() {

    }
    @ModelAttribute
    public  void addCommonHeading(Model model){
        model.addAttribute("commonHeading","Spring MVC Demo");
    }
    @Override
    @RequestMapping("/a")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("/hello")
    String hello(){
        return "dummy";
    }
   //Question Create one more action which sends Model HelloWorld to the jsp file.
    @ResponseBody
    @RequestMapping("/index")
    ModelAndView index() {
        ModelAndView model =  new ModelAndView("index");
        model.addObject("msg", "Hello World");
        return model;
    }
    /* Question Use @PathVariable annotation to access firstname and lastname in an action inside
    StudentController place both the parameters in different arguments and access them.*/

    @RequestMapping("/firstname/{firstName}")
    @ResponseBody
    ModelAndView returnFirsName(@PathVariable("firstName") String firstName) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg1",firstName);
        return model;
    }
    @RequestMapping("/lastname/{lastName}")
    @ResponseBody
    ModelAndView returnLastName(@PathVariable("lastName") String lastName) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg2",lastName);
        return modelAndView;

    }
    // Question Now place both the arguments inside a Map and access the Map instead

    @RequestMapping("/countryAndState/{countryName}/{stateName}")
    @ResponseBody
    ModelAndView returnCountryAndState(@PathVariable Map<String, String> requestMap) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView.addObject("msg",requestMap.get("countryName")+ " "+requestMap.get("stateName"));
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("form");
        return modelAndView;
    }
   //Question Use @RequestParam annotation to access the firstname and lastname in formData action of StudentController.
  //Question Create a StudentCO and bind firstname and lastname with instance variable of StudentCO.
    //Question Use @ModelAttribute annotation to add Heading "Spring MVC Demo" in every model.
    @RequestMapping(value = "/submitForm.html", method = RequestMethod.POST)
    @ResponseBody
    String submitForm(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        return "Username " + username + " Password " + password;
    }
    @RequestMapping(value = "/coform", method = RequestMethod.GET)
    ModelAndView coForm() {
        ModelAndView modelAndView = new ModelAndView("coform");
        return modelAndView;
    }
    @RequestMapping(value = "/submitcoForm.html", method = RequestMethod.POST)
    @ResponseBody
    ModelAndView submitForm(@ModelAttribute("student") StudentCO student) {
        ModelAndView modelAndView = new ModelAndView("SuccessCoForm");
        return modelAndView;
    }
@ModelAttribute
    public Model commonHeader(Model model){
        model.addAttribute("commonHeading","Spring MVC Demo");
return model;
    }

}
