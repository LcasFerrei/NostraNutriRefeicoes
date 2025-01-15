package com.nutri.nutricao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nutri.nutricao.services.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-curriculo")
    public String enviarCurriculo(
            @RequestParam String nome,
            @RequestParam String cpf,
            @RequestParam String idade,
            @RequestParam String nacionalidade,
            @RequestParam String telefone,
            @RequestParam String email,
            @RequestParam MultipartFile curriculo) {
        // Salvar os dados no MySQL (essa parte você já deve ter implementado)

        // Enviar o currículo por e-mail
        try {
            emailService.enviarEmailComCurriculo(
                nome,
                cpf,
                idade,
                nacionalidade,
                telefone,
                email,
                curriculo);
        } catch (Exception e) {
            return "Erro ao enviar o currículo: " + e.getMessage();
        }

        return "Currículo enviado com sucesso!";
    }
}
