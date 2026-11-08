package com.example.employeeskills;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class EmployeeSkillId implements Serializable {
    @Column(name = "emp_id", nullable = false)
    private Long empId;
    @Column(name = "s_id", nullable = false)
    private Long sId;
    protected EmployeeSkillId() {}
    public EmployeeSkillId(Long empId, Long sId) { this.empId = empId; this.sId = sId; }
    public Long getEmpId() { return empId; }
    public void setEmpId(Long value) { this.empId = value; }
    public Long getSId() { return sId; }
    public void setSId(Long value) { this.sId = value; }
    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof EmployeeSkillId id)) return false;
        return Objects.equals(empId, id.empId) && Objects.equals(sId, id.sId);
    }
    @Override public int hashCode() { return Objects.hash(empId, sId); }
}
