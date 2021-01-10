package ro.fasttrackit.gymproject.services;

import org.springframework.stereotype.Service;
import ro.fasttrackit.gymproject.domain.Membership;
import ro.fasttrackit.gymproject.exceptions.NotFoundException;
import ro.fasttrackit.gymproject.repositories.MembershipRepository;

import java.util.List;

@Service
public class MembershipService {
    private final MembershipRepository repository;

    public MembershipService(MembershipRepository repository) {
        this.repository = repository;
    }

    public List<Membership> getAll() {
        return repository.findAll();
    }

    public Membership getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Membership with this ID: " + id));
    }

    public Membership addMembership(Membership membership) {
        return repository.save(membership);
    }

    public Membership removeMembership(Integer id) {
        Membership membershipToRemove = getById(id);
        repository.delete(membershipToRemove);
        return membershipToRemove;
    }

    public Membership editMembership(Integer id, Membership membership) {
        Membership membershipToEdit = getById(id);
        membershipToEdit.setType(membership.getType());
        membershipToEdit.setValidFrom(membership.getValidFrom());
        membershipToEdit.setValidTo(membership.getType(), membership.getValidFrom());
        return repository.save(membershipToEdit);
    }
}
