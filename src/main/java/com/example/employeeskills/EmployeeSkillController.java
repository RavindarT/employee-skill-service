package com.example.employeeskills;
import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {
    private final EmployeeSkillService service;
    public EmployeeSkillController(EmployeeSkillService service) { this.service = service; }
    @GetMapping public List<EmployeeSkill> list() { return service.list(); }
    @GetMapping("/{empId}/{sId}") public EmployeeSkill get(@PathVariable Long empId, @PathVariable Long sId) { return service.get(empId, sId); }
    @PostMapping public ResponseEntity<EmployeeSkill> create(@Valid @RequestBody EmployeeSkillRequest request) {
        EmployeeSkill created = service.create(request);
        return ResponseEntity.created(URI.create("/api/employee-skills/" + created.getId().getEmpId() + "/" + created.getId().getSId())).body(created);
    }
    @PutMapping("/{empId}/{sId}") public EmployeeSkill update(@PathVariable Long empId, @PathVariable Long sId, @Valid @RequestBody EmployeeSkillRequest request) { return service.update(empId, sId, request); }
    @DeleteMapping("/{empId}/{sId}") public ResponseEntity<Void> delete(@PathVariable Long empId, @PathVariable Long sId) {
        service.delete(empId, sId);
        return ResponseEntity.noContent().build();
    }
}
