package br.com.remysoncosta.service;

import br.com.remysoncosta.dto.AlunoRequest;
import br.com.remysoncosta.dto.AlunoResponse;
import br.com.remysoncosta.entity.Aluno;
import br.com.remysoncosta.exception.AlunoException;
import br.com.remysoncosta.repository.RdsRepository;
import br.com.remysoncosta.utils.AlunoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RdsService {

    private static final String ALUNO_NAO_ENCONTRADO = "Aluno não encontrado";

    @Autowired
    private RdsRepository rdsRepository;

    public AlunoResponse criarAluno(AlunoRequest alunoRequest) {
        Aluno novoAluno = AlunoConverter.toAluno(alunoRequest);
        return AlunoConverter.toAlunoResponse(rdsRepository.save(novoAluno));
    }

    public AlunoResponse atualizarAluno(AlunoRequest alunoRequest) {
        if (rdsRepository.findById(alunoRequest.getIdAluno()).isEmpty())
            throw new AlunoException(ALUNO_NAO_ENCONTRADO);

        Aluno novoAluno = AlunoConverter.toAluno(alunoRequest);
        return AlunoConverter.toAlunoResponse(rdsRepository.save(novoAluno));
    }

    public List<AlunoResponse> buscarAluno(String nome) {
        return rdsRepository.findAlunoByNomeContainingIgnoreCase(nome)
                .stream().map(c -> AlunoConverter.toAlunoResponse(rdsRepository.save(c))).collect(Collectors.toList());
    }

    public AlunoResponse excluirAluno(Integer idAluno) {
        if (rdsRepository.findById(idAluno).isEmpty())
            throw new AlunoException(ALUNO_NAO_ENCONTRADO);

        AlunoResponse alunoResponse = new AlunoResponse();
        alunoResponse.setIdAluno(idAluno);

        rdsRepository.deleteById(idAluno);
        return alunoResponse;
    }

}
