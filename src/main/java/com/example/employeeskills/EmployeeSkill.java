package com.example.employeeskills;
import jakarta.persistence.*;
@Entity
@Table(name = "employee_skill")
public class EmployeeSkill {
    @EmbeddedId
    private EmployeeSkillId id;
    @Column(name = "years_of_exp", nullable = false)
    private Integer yearsOfExp;
    public EmployeeSkillId getId() { return id; }
    public void setId(EmployeeSkillId value) { id = value; }
    public Integer getYearsOfExp() { return yearsOfExp; }
    public void setYearsOfExp(Integer value) { yearsOfExp = value; }
}
