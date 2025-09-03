package com.lld.employee.hierarchy.controller;

import com.lld.employee.hierarchy.dto.EmployeeNode;
import com.lld.employee.hierarchy.dto.ManagerNode;
import com.lld.employee.hierarchy.service.EmployeeTraversalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController{
    private final EmployeeTraversalService service;

    public EmployeeController(EmployeeTraversalService service) {
        this.service = service;
    }

    @GetMapping("/{id}/managers")
    public ManagerNode getManagers(@PathVariable String id) {
        return service.getManagerHierarchy(id);
    }

    @GetMapping("/{id}/subordinates")
    public EmployeeNode getSubordinates(@PathVariable String id) {
        return service.getSubordinatesHierarchy(id);
    }
}

