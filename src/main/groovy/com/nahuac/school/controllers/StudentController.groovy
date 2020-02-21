package com.nahuac.school.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.servlet.view.RedirectView
import com.nahuac.school.domain.Student
import com.nahuac.school.repository.StudentRepository
import com.nahuac.school.component.NotificationComponent

@Controller
class StudentController {

	@Autowired
	StudentRepository studentRepository
	@Autowired
	NotificationComponent notificationComponent

	@GetMapping("/")
  @ResponseBody
  RedirectView index() {
		return new RedirectView("/student/show");
  }

  @ResponseBody
	@RequestMapping("/student")
  ModelAndView student() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("content", "student");
		model.addObject("title", "Baeldung");
		model.addObject("any", "Hola mundo");
		return model
  }

  @ResponseBody
	@RequestMapping("/student/show")
  ModelAndView show() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("content", "show");
		model.addObject("students", studentRepository.findAll());
		return model
  }

	@PostMapping("/student/save")
  @ResponseBody
  Map save(@RequestBody Student params) {
		println params?.dump()
		studentRepository.save(params)
		notificationComponent.sendNotification(params.email)
		[response: "Save"]
  }

	@GetMapping("/students")
	@ResponseBody
	List<Student> list(){
		return studentRepository.findAll()
	}
}