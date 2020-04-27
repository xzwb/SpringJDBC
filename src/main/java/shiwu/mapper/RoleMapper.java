package shiwu.mapper;

import org.springframework.stereotype.Repository;
import shiwu.pojo.Role;

@Repository
public interface RoleMapper {
    int insertRole(Role role);
}
