package com.lld.employee.hierarchy.service;

import com.lld.employee.hierarchy.dto.EmployeeNode;
import com.lld.employee.hierarchy.dto.ManagerNode;
import com.lld.employee.hierarchy.model.Employee;
import com.lld.employee.hierarchy.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTraversalService {
    private final EmployeeRepo repo;

    public EmployeeTraversalService(EmployeeRepo repo) {
        this.repo = repo;
    }

    // Upward chain: employee -> manager -> manager’s manager -> ... CEO
    public ManagerNode getManagerHierarchy(String id) {
        Employee emp = repo.findById(id).orElseThrow();
        ManagerNode root = null;
        ManagerNode prev  = null;
        Employee current = emp.getManager();

        while (current!=null){
            ManagerNode node  = new ManagerNode(current.getId(),current.getName(),current.getTitle());
            if (prev == null){
                root  = node;
            }else {
                prev.setManager(node);
            }
            prev = node;  // keep track of the last created node
            current  = current.getManager();
        }
        return root;
    }

    // Downward subordinates: direct reports only
    public EmployeeNode getSubordinatesHierarchy(String id) {
        Employee emp = repo.findById(id).orElseThrow();
        return buildHierarchy(emp);
    }

    private EmployeeNode buildHierarchy(Employee emp) {
        EmployeeNode node = new EmployeeNode(emp.getId(), emp.getName(), emp.getTitle());
        for (Employee sub: emp.getSubordinates()){
            node.addSubordinate(buildHierarchy(sub));
        }
        return node;
    }
}
