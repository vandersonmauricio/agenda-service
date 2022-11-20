package pdev.com.agenda.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdev.com.agenda.domain.entity.Agenda;
import pdev.com.agenda.domain.repository.AgendaRepository;
import pdev.com.agenda.exception.BusinessException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Test {

    private final AgendaRepository repository;

    public Agenda save(Agenda agenda){

        Optional<Agenda> isPersistClient = repository.findById(agenda.getPaciente().getId());

        if (isPersistClient.isEmpty()){
            throw  new BusinessException("não foi encontrado nenhum paciente na agenda");
        }

        return repository.save(agenda);
    }

}
