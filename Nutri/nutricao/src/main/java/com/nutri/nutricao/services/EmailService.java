package com.nutri.nutricao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailComCurriculo(String nome, String cpf, String idade, String nacionalidade, String telefone,
            String emailUsuario, MultipartFile arquivo) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // true para multipart

        try {
            // Email onde quer que o curriculo chegue coloco entre as aspas
            String emailDaEmpresa = "deployteste2024@gmail.com";
            String assunto = "Novo Currículo de " + nome;
            String corpo = "Nome: " + nome + "\nCPF: " + cpf + "\nIdade: " + idade +
                    "\nNacionalidade: " + nacionalidade + "\nTelefone: " + telefone +
                    "\nE-mail: " + emailUsuario;

            helper.setTo(emailDaEmpresa); // Enviando para o e-mail da empresa
            helper.setSubject(assunto);
            helper.setText(corpo);

            // Anexar o arquivo
            if (arquivo != null && !arquivo.isEmpty()) {
                helper.addAttachment(arquivo.getOriginalFilename(), arquivo);
            }

            mailSender.send(message);
        } catch (MailException e) {
            // Tratar exceção de envio de e-mail, se necessário
            throw new RuntimeException("Falha ao enviar o e-mail", e);
        }
    }
}
