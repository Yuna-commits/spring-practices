package com.bit2025.locale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LocaleController {

	@Autowired
	private LocaleResolver localeResolver;

	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		// 현재 요청의 Locale 객체의 언어 코드 얻기
		String lang = localeResolver.resolveLocale(request).getLanguage();
		model.addAttribute("lang", lang);
		
		return "index";
	}
}
