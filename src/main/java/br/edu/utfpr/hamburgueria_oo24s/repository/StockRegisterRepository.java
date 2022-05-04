package br.edu.utfpr.hamburgueria_oo24s.repository;

import br.edu.utfpr.hamburgueria_oo24s.model.StockRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRegisterRepository extends JpaRepository<StockRegister, UUID> {
}
