package com.alianza.clientes.data.repository;

import com.alianza.clientes.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findBySharedKey(String sharedKey);
}
