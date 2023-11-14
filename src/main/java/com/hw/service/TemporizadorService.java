package com.hw.service;

import com.hw.model.Temporizador;
import com.hw.repository.TemporizadorRepository;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemporizadorService {

    @Autowired
    private TemporizadorRepository temporizadorRepository;

    public List<Temporizador> listarTemporizadores() {
        return temporizadorRepository.findAll();
    }

    public void adicionarTemporizador(String titulo, LocalDateTime data) {
        Temporizador temporizador = new Temporizador();
        temporizador.setTitulo(titulo);
        temporizador.setData(data);
    
        temporizadorRepository.save(temporizador);
    }

    public List<Temporizador> listarTemporizadoresComCronometro() {
    List<Temporizador> temporizadores = temporizadorRepository.findAll();
    List<Temporizador> temporizadoresComCronometro = new ArrayList<>();

    for (Temporizador temporizador : temporizadores) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime data = temporizador.getData();

        if (agora.isBefore(data)) {
            Duration duracao = Duration.between(agora, data);
            temporizador.setCronometro(duracao);
            temporizadoresComCronometro.add(temporizador);
        } else {
            temporizador.setCronometro(Duration.ZERO);
            temporizadoresComCronometro.add(temporizador);
        }
    }
    return temporizadoresComCronometro;
}

public void adicionarTemporizador(Temporizador temporizador) {
    if (contarTemporizadores() < 4) {
        temporizadorRepository.save(temporizador);
    }
}
public void excluirTemporizador(Long id) {
    temporizadorRepository.deleteById(id);
}

public long contarTemporizadores() {
    return temporizadorRepository.count();
}
}

