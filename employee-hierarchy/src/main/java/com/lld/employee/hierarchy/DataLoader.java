package com.lld.employee.hierarchy;
import com.lld.employee.hierarchy.model.Employee;
import com.lld.employee.hierarchy.repository.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepo repo;

    public DataLoader(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        Employee ceo = new Employee("E1", "Asha Rao", "CEO");
        Employee vpEng = new Employee("E2", "Bilal Khan", "VP Engineering");
        Employee vpSales = new Employee("E3", "Chirag Mehta", "VP Sales");
        Employee dirPlatform = new Employee("E4", "Deepa Jain", "Director Platform");
        Employee dev = new Employee("E5", "Farhan Ali", "Senior Engineer");

        // link hierarchy
        vpEng.setManager(ceo);
        vpSales.setManager(ceo);
        dirPlatform.setManager(vpEng);
        dev.setManager(dirPlatform);

        repo.save(ceo);
        repo.save(vpEng);
        repo.save(vpSales);
        repo.save(dirPlatform);
        repo.save(dev);
    }
}

