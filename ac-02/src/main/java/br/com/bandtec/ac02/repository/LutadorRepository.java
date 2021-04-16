package br.com.bandtec.ac02.repository;

import br.com.bandtec.ac02.entity.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository  extends JpaRepository<Lutador,Integer> {

    List<Lutador> findByOrderByForcaGolpeDesc();

    @Query("select Count(*) from Lutador l where l.vida > 0")
    Long findAllVivos();

    List<Lutador> findByVidaEquals(Double vida);





}
