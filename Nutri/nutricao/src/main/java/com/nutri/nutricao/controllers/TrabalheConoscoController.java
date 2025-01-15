package com.nutri.nutricao.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nutri.nutricao.services.EmailService;

@Controller
public class TrabalheConoscoController {

    private static final Logger logger = LoggerFactory.getLogger(TrabalheConoscoController.class);

    @Autowired
    private EmailService emailService;

    @GetMapping("/trabalheconosco")
    public String formularioCurriculo(Model model) {
        return "trabalheconosco";
    }

    @PostMapping("/trabalheconosco")
    public String cadastrarCurriculo(
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("idade") int idade,
            @RequestParam("nacionalidade") String nacionalidade,
            @RequestParam("telefone") String telefone,
            @RequestParam("email") String email,
            @RequestParam("experiencia") String experiencia,
            @RequestParam(value = "curriculo", required = false) MultipartFile arquivo, // Campo opcional
            Model model) {

        // Envie o currículo por e-mail, se o arquivo não estiver vazio
        if (arquivo != null && !arquivo.isEmpty()) {
            try {
                emailService.enviarEmailComCurriculo(
                        nome,
                        cpf,
                        String.valueOf(idade), // Convertendo para String
                        nacionalidade,
                        telefone,
                        email,
                        arquivo);
            } catch (Exception e) {
                model.addAttribute("message", "Erro ao enviar o currículo: " + e.getMessage());
                logger.error("Erro ao enviar o currículo: ", e);
                return "trabalheconosco";
            }
        }

        // Adiciona uma mensagem para o modelo
        model.addAttribute("message", "Currículo enviado com sucesso!");
        return "trabalheconosco";
    }
}
