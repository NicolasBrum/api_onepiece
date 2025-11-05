package brum.nicolas.api.onepiece.repositories;

import brum.nicolas.api.onepiece.entities.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Long> {
    List<Missao> findAllByClassificacao(Missao.Classificacao classificacao);
    List<Missao> findAllByStatusMissao(Missao.StatusMissao statusMissao);
}
