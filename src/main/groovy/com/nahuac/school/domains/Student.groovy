package com.nahuac.school.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id

  String firstName
  String lastName
  String email
  String gender
  String locationTest
  String entitySchool
  String degree
  Boolean advisory

}