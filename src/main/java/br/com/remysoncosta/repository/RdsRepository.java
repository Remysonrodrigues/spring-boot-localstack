package br.com.remysoncosta.repository;

import br.com.remysoncosta.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdsRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAlunoByNomeContainingIgnoreCase(String nome);

}
