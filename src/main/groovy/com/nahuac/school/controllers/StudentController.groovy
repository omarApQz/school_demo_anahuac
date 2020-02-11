package com.nahuac.school.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class StudentController {

  @RequestMapping("/student")
  @ResponseBody
  ModelAndView student() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("content", "student");
		model.addObject("title", "Baeldung");
		model.addObject("any", "Hola mundo");
		return model
  }
}