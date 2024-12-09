package repositories;

import models.Membro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Data Access Object Pattern
public class MemberRepository {

	private List<Member> members;

	public MemberRepository() {
		this.members = new ArrayList<>();
	}

	public List<Membro> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public void addMember(Membro member) {
		members.add(member);
	}

	public void removeMember(Membro member) {
		members.remove(member);
	}

	public Optional<Membro> findMember(String name) {
		return members.stream()
			.filter(p -> p.getNome().equalsIgnoreCase(name))
			.findFirst();
	}
}
