/*
 * @(#)JoinController.java $version 2015. 2. 7.
 *
 * Copyright 2015 NHN Ent. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.maple.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maple.test.model.Member;
import com.maple.test.service.MemberService;

/**
 * @author Kanghoon Choi
 */
@Controller
public class JoinController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/join/form")
	public String getForm() {

		System.out.println("Hello world");

		return "join";// join이라는 jsp를 찾아줘!
	}

	@RequestMapping("/join")
	public String join(Model model, Member member) {

		boolean result = memberService.join(member);		
		
		if (result) {
			return "joinSuccess";
		} else {
			model.addAttribute("failMsg", "회원가입이 실패했어요");
			model.addAttribute("member", member);
			return "join";
		}
	}
}
