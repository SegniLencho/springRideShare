package com.ride.springframework.repositories;

import com.ride.springframework.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by OD on 6/20/2017.
 */
@Transactional(Transactional.TxType.MANDATORY)

public interface RoleRepository extends JpaRepository<Role, Long> {
}
