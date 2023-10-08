package com.coppel.abcc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.coppel.abcc.modelo.Articulo;
import com.coppel.abcc.repositorio.ArticuloRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloController(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
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

 
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Articulo> optionalArticulo = articuloRepository.findById(id);
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
        articuloRepository.save(articulo);
        return "redirect:/articulos/";
    }

   
    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable Long id) {
        articuloRepository.deleteById(id);
        return "redirect:/articulos/";
    }

  
    @GetMapping("/consultar/{id}")
    public String consultarArticulo(@PathVariable Long id, Model model) {
        Optional<Articulo> optionalArticulo = articuloRepository.findById(id);
        if (optionalArticulo.isPresent()) {
            model.addAttribute("articulo", optionalArticulo.get());
            return "detalle-articulo";
        } else {
            return "redirect:/articulos/";
        }
    }
}
