package com.bookstore.repository;

import com.bookstore.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by DG on 7/26/17.
 */
public interface RoleRepository extends CrudRepository<Role,Long> {


}
