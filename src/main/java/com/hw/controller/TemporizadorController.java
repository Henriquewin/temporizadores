package com.hw.controller;

import com.hw.model.Temporizador;
import com.hw.service.TemporizadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//Página Principal onde é exibido os Temporizadores
@RequestMapping("/temporizadores")
public class TemporizadorController {

    @Autowired
    private TemporizadorService temporizadorService;

    @GetMapping("/")
public String listarTemporizadores(Model model) {
    List<Temporizador> temporizadores = temporizadorService.listarTemporizadoresComCronometro();
    model.addAttribute("temporizadores", temporizadores);
    return "temporizadores";
}
// Método GET para a Página onde se configura e adiciona os temporizadores
@GetMapping("/novo")
public String mostrarFormulario(Model model) {
    if (temporizadorService.contarTemporizadores() >= 4) {
        return "limite_excedido";
    }
    model.addAttribute("temporizador", new Temporizador());
    return "formulario_temporizador";
}
// Método POST para instanciar um novo temporizador
@PostMapping("/novo")
public String adicionarTemporizador(@ModelAttribute Temporizador temporizador) {
    temporizadorService.adicionarTemporizador(temporizador);
    return "redirect:/temporizadores/";
}
// Método para excluir um temporizador através do seu respectivo id
@GetMapping("/excluir/{id}")
public String excluirTemporizador(@PathVariable Long id) {
    temporizadorService.excluirTemporizador(id);
    return "redirect:/temporizadores/";
}

}


