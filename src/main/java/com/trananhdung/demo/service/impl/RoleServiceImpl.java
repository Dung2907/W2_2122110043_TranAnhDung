package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.Role;
import com.trananhdung.demo.repository.RoleRepository;
import com.trananhdung.demo.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Integer roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        return optionalRole.orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Integer roleId, Role updatedRole) {
        Role existingRole = roleRepository.findById(roleId).orElse(null);

        if (existingRole != null) {
            existingRole.setRoleName(updatedRole.getRoleName());
            existingRole.setPrivacy(updatedRole.getPrivacy());
            // You may need to handle other relationships here
            return roleRepository.save(existingRole);
        }

        return null;
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
}
