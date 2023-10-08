package com.coppel.abcc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coppel.abcc.modelo.Articulo;
import com.coppel.abcc.repositorio.ArticuloRepository;

import java.util.List;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloController(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }


    @GetMapping("/")
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloRepository.findAll();
        model.addAttribute("articulos", articulos);
        return "listar-articulos";
    }

 
    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("articulo", new Articulo());
        return "formulario-articulo";
    }

    @PostMapping("/crear")
    public String crearArticulo(@ModelAttribute Articulo articulo) {
        articuloRepository.save(articulo);
        return "redirect:/articulos/";
    }

    

}
