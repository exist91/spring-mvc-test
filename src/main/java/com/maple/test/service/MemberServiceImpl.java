package com.maple.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maple.test.dao.MemberDAO;
import com.maple.test.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;

	@Override
	public boolean join(Member member) {

		String name = member.getName();
		name = "잘생긴 " + name;
		member.setName(name);

		try {
			memberDao.insertMember(member);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
