package shiwu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shiwu.pojo.Role;
import shiwu.service.RoleListService;
import shiwu.service.RoleService;

import java.util.List;

@Service
public class RoleListServiceImpl implements RoleListService {
    @Autowired
    private RoleService roleService = null;

    @Override
    @Transactional(transactionManager = "transactionManager",
    propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int insertRoleList(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            count += roleService.insertRole(role);
        }
        return count;
    }
}
