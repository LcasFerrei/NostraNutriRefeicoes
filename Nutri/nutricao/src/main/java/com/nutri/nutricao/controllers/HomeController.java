package com.nutri.nutricao.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.nutri.nutricao.models.Home;

@Controller
public class HomeController {

    // Endpoint para a página Home
    @GetMapping("/home")
    public String home(Model model) {
        Home homeData = new Home();

        // Configurando os dados da home
        homeData.setTitle("NostraNutri");
        homeData.setSubtitle("Nutrição e sabor para seu ambiente de trabalho.");
        homeData.setDescription("Qualidade e sabor que sua empresa merece.");

        homeData.setContactInfo(List.of("(85) 99154-1634", "contato@nostranutri.com"));
        homeData.setSocialMediaLinks(
                List.of("https://www.instagram.com/nostranutri/", "https://www.linkedin.com/company/nostranutri/"));

        Home.ServicePlan basicPlan = new Home.ServicePlan();
        basicPlan.setTitle("Basic");
        basicPlan.setDetails(List.of("Entrega de segunda a sexta", "Café da Manhã",
                "Opções de pratos vegetarianos e não-vegetarianos", "Até 20 refeições por semana", "Suporte via e-mail"));

        Home.ServicePlan goldPlan = new Home.ServicePlan();
        goldPlan.setTitle("Gold");
        goldPlan.setDetails(List.of("Entrega de segunda a sábado",
                "Variedade de pratos vegetarianos, veganos e não-vegetarianos", "Até 40 refeições por semana"));

        homeData.setServicePlans(List.of(basicPlan, goldPlan));

        Home.Image img1 = new Home.Image();
        img1.setSrc("img/nostranutri.png");
        img1.setAlt("NostraNutri");

        homeData.setImageGallery(List.of(img1));

        model.addAttribute("homeData", homeData);

        return "home"; // Nome da página home.html
    }
}
