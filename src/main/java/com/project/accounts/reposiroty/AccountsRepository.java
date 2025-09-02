package com.project.accounts.reposiroty;

import com.project.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

    // Since we are making changes in the data so we have to provide below 2 annotations
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
