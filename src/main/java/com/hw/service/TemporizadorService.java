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
    //lista com temporizadores ativos
    public List<Temporizador> listarTemporizadores() {
        return temporizadorRepository.findAll();
    }
    //Método para estar adicionado temporizador, seta titulo e data
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
//caso haja menos de 4 temporizadores ativos ai defato se adiciona o novo temporizador
public void adicionarTemporizador(Temporizador temporizador) {
    if (contarTemporizadores() < 4) {
        temporizadorRepository.save(temporizador);
    }
}
// Método para excluir um temporizador
public void excluirTemporizador(Long id) {
    temporizadorRepository.deleteById(id);
}

//metodo que conta quantos tempos estão em execucao
public long contarTemporizadores() {
    return temporizadorRepository.count();
}
}

