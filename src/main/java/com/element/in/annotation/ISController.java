package com.element.in.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Controller
@RequestMapping("/element.in/insurance")
public @interface ISController {}