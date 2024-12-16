package repositories;

import models.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {

	private List<Member> members;

	public MemberRepository() {
		this.members = new ArrayList<>();
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public void addMember(Member member) {
		members.add(member);
	}

	public void removeMember(Member member) {
		members.remove(member);
	}

	public Optional<Member> findMemberByName(String name) {
		return members.stream()
				.filter(p -> p.getName().equalsIgnoreCase(name))
				.findFirst();
	}

	public Optional<Member> findMemberByCPF(String cpf) {
		return members.stream()
				.filter(p -> p.getCPF().equalsIgnoreCase(cpf))
				.findFirst();
	}
}
