package com.nahuac.school.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class StudentController {

  @ResponseBody
	@RequestMapping("/student")
  ModelAndView student() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("content", "student");
		model.addObject("title", "Baeldung");
		model.addObject("any", "Hola mundo");
		return model
  }

	@PostMapping("/student/save")
  @ResponseBody
  Map save(Map params) {
		println params?.dump()
		[response: "Save"]
  }
}