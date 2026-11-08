package com.example.employeeskills;
import jakarta.validation.constraints.*;
public record EmployeeSkillRequest(
    @NotNull @Positive Long empId,
    @NotNull @Positive Long sId,
    @NotNull @Min(0) @Max(80) Integer yearsOfExp
) {}
