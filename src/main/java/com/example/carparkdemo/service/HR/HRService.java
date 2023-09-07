package com.example.carparkdemo.service.HR;

import com.example.carparkdemo.entities.Employee;
import com.example.carparkdemo.repository.HRStaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HRService implements IHRService {

    private final HRStaffRepository HRStaffRepository;

    public HRService(HRStaffRepository HRStaffRepository) {
        this.HRStaffRepository = HRStaffRepository;
    }

    public String getAllEmployee() {
        List<Employee> employees = HRStaffRepository.findAll();
        StringBuilder sb = new StringBuilder();
        employees.forEach(employee -> sb.append(employee.toString()).append("\n"));
        return sb.toString();
    }

    public List<Employee> getAllEmployeeByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("role").descending()
                .and(Sort.by("id")).ascending());
        return HRStaffRepository.findAll(pageable).getContent();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return HRStaffRepository.findById(id).orElse(null);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public void editEmployee(Long id) {
        Employee employee = HRStaffRepository.findById(id).orElseThrow(() -> new IllegalStateException("Employee with id " + id + " does not exist"));
        employee.setName("new name");
        employee.setAddress("new address");
        employee.setBirthDate(null);
        employee.setDepartment("new department");
        employee.setEmail("new email");
        HRStaffRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByAccount(String account) {
        return HRStaffRepository.findByAccount(account).orElse(null);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public String deleteEmployee(Long id) {
        boolean exists = HRStaffRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + id + " does not exist");
        }
        HRStaffRepository.deleteById(id);
        return "Employee removed: " + id;
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public void addEmployee(Employee employee) {
        HRStaffRepository.save(employee);
    }


}
