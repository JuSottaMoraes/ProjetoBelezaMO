package com.beleza1.beleza1.Controller;


import com.beleza1.beleza1.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BelezaController {

    @GetMapping("/loguin")
    public String mostraLoguin() {
        return "loguin";
    }

    @GetMapping("/cliente")
    public String mostraCliente(Model model, String nome, @RequestParam(defaultValue = "0") int idade) {
        Cliente c = new Cliente();
        if (nome != null && !nome.isBlank()) {
            //extrair sobrenome 
            int indiceEspaco = nome.indexOf(" ");
            if (indiceEspaco < 0) //não encontrou caractere de espaço 
            {

            }
            indiceEspaco = nome.length();// assume então a posição do último caractere 

            c.setNome(nome.substring(0, indiceEspaco));
            c.setSobrenome(nome.substring(indiceEspaco, nome.length()));
        }

        c.setIdade(idade);
        model.addAttribute("cliente", c);
        return "cliente";
    }

    @GetMapping("/cadastro-cliente")
    public String mostraCadastroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro-cliente";
    }

    @PostMapping("/cadastro-cliente")
    public String recebeCadastroCliente(Model model, @ModelAttribute Cliente cliente) {
        model.addAttribute("cliente", cliente);
        return "cliente";
    }

}
