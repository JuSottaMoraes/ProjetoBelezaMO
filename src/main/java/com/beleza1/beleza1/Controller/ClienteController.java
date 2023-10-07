package com.beleza1.beleza1.Controller;

import com.beleza1.beleza1.model.Entity.ClienteEntity;
import com.beleza1.beleza1.model.ListaCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ClienteController {

    @GetMapping("/")
    public String loguin() {
        return "loguin";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("clientes", ListaCliente.getLista());

        return "lista";
    }

    @GetMapping("/cadastro-cliente")
    public String exibirFormulario(Model model) {
        model.addAttribute("cliente", new ClienteEntity());
        return "cadastro-cliente";

    }

    @PostMapping("/cadastro-cliente")
    public String processarFormulario(@ModelAttribute ClienteEntity cliente, Model model) {
        cliente.setId(ListaCliente.getLista().size() + 1);
        ListaCliente.adicionar(cliente);
        model.addAttribute("cliente", cliente);
        return "cadastro-sucesso";
    }

    @DeleteMapping("/cadastro-cliente")
    public String deletarClientee(@ModelAttribute ClienteEntity cliente, Model model) {
        cliente.setId(ListaCliente.getLista().size() - 1);
        ListaCliente.excluir(cliente);
        model.addAttribute("cliente", cliente);
        return "lista-cliente";
    }

    @PutMapping("/cadastro-cliente")
    public String atualizarFormulario(@ModelAttribute ClienteEntity cliente, Model model) {
        cliente.setId(ListaCliente.getLista().size() + 1);
        ListaCliente.atualizar(cliente);
        model.addAttribute("cliente", cliente);
        return "atualizar";
    }

}
