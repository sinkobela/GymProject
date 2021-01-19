package ro.fasttrackit.gymproject.controllers;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.gymproject.domain.Membership;
import ro.fasttrackit.gymproject.services.MembershipService;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {
    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAll();
    }

    @GetMapping("/{id}")
    public Membership getMembershipById(@PathVariable Integer id) {
        return membershipService.getById(id);
    }

    @PostMapping
    public Membership addMembership(@RequestBody Membership membership) {
        return membershipService.addMembership(membership);
    }

    @PutMapping("/{id}")
    public Membership editMembership(@PathVariable Integer id, @RequestBody Membership membership) {
        return membershipService.editMembership(id, membership);
    }

    @DeleteMapping("/{id}")
    public Membership removeMembership(@PathVariable Integer id) {
        return membershipService.removeMembership(id);
    }
}
