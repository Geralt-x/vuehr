package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.DepartmentMapper;
import org.javaboy.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    /**
     * @Description: 查询所有部门
     *
     * @param:
     * @return:
     * @auther: root
     * @date: 2021/1/5 17:06
     */
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }
    /**
     * @Description: 增加部门
     *
     * @param:
     * @return:
     * @auther: root
     * @date: 2021/1/5 17:06
     */
    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }
    /**
     * @Description: 删除部门
     *
     * @param:
     * @return:
     * @auther: root
     * @date: 2021/1/5 17:06
     */
    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }

    /**
     *
     * @return
     */
    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }
}
