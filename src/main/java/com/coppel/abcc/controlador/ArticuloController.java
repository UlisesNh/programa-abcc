package com.coppel.abcc.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.coppel.abcc.modelo.Articulo;
import com.coppel.abcc.servicios.ArticuloService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloService articuloService;

  
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/")
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloService.obtenerTodos();
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
        articuloService.guardarArticulo(articulo);
        return "redirect:/articulos/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Articulo> optionalArticulo = articuloService.buscarPorId(id);
        if (optionalArticulo.isPresent()) {
            model.addAttribute("articulo", optionalArticulo.get());
            return "formulario-articulo";
        } else {
            return "redirect:/articulos/";
        }
    }

    @PostMapping("/editar/{id}")
    public String editarArticulo(@PathVariable Long id, @ModelAttribute Articulo articulo) {
        articulo.setId(id);
        articuloService.actualizarArticulo(articulo);
        return "redirect:/articulos/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
        return "redirect:/articulos/";
    }

    @GetMapping("/consultar/{id}")
    public String consultarArticulo(@PathVariable Long id, Model model) {
        Optional<Articulo> optionalArticulo = articuloService.buscarPorId(id);
        if (optionalArticulo.isPresent()) {
            model.addAttribute("articulo", optionalArticulo.get());
            return "detalle-articulo";
        } else {
            return "redirect:/articulos/";
        }
    }
}

