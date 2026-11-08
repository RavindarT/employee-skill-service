package com.example.employeeskills;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeSkillService {
    private final EmployeeSkillRepository repository;
    public EmployeeSkillService(EmployeeSkillRepository repository) { this.repository = repository; }
    @Transactional(readOnly = true)
    public List<EmployeeSkill> list() { return repository.findAll(); }
    @Transactional(readOnly = true)
    public EmployeeSkill get(Long empId, Long sId) { return repository.findById(new EmployeeSkillId(empId, sId)).orElseThrow(() -> new ResourceNotFoundException("EmployeeSkill not found")); }
    @Transactional
    public EmployeeSkill create(EmployeeSkillRequest request) {
        if (repository.existsById(new EmployeeSkillId(request.empId(), request.sId()))) throw new DuplicateResourceException("EmployeeSkill already exists");
        EmployeeSkill record = new EmployeeSkill();
        record.setId(new EmployeeSkillId(request.empId(), request.sId()));
        record.setYearsOfExp(request.yearsOfExp());
        return repository.save(record);
    }
    @Transactional
    public EmployeeSkill update(Long empId, Long sId, EmployeeSkillRequest request) {
        EmployeeSkill record = get(empId, sId);
        record.setYearsOfExp(request.yearsOfExp());
        return repository.save(record);
    }
    @Transactional
    public void delete(Long empId, Long sId) { repository.delete(get(empId, sId)); }
}
