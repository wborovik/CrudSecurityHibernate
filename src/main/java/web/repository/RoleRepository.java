package web.repository;

import web.model.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByName(String role);
}
