package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woodmancup.members.Member;
import com.woodmancup.members.MemberRepository;

@Repository
public class SessionRepository implements InitializingBean {

	private static final Comparator<Session> ORDER_SORT = new Comparator<Session>() {
		@Override
		public int compare(Session o1, Session o2) {
			return o1.getSessionNumber().compareTo(o2.getSessionNumber());
		}
	};

	private List<Session> sessions = new ArrayList<Session>();

	private MemberRepository memberRepository;

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		create2005();
		create2006();
		create2007();
		create2008();
		create2009();
		create2010();
		create2011();
		create2012();
	}


	private Group createGroup(String teamId, String... members) {
		List<Member> list = new ArrayList<Member>();
		for (String memberId : members) {
			Member member = memberRepository.findById(memberId);
			list.add(member);
		}
		return Group.newInstance(teamId, list.toArray(new Member[0]));
	}


	public List<Session> findSessionsByTournamentId(String tournamentId) {
		List<Session> list = new ArrayList<Session>();
		for (Session session : sessions) {
			if (session.getTournamentId().equals(tournamentId)) {
				list.add(session);
			}
		}
		Collections.sort(list, ORDER_SORT);
		return list;
	}

}
