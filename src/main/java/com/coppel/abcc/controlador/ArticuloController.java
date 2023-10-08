package com.coppel.abcc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coppel.abcc.modelo.Articulo;
import com.coppel.abcc.repositorio.ArticuloRepository;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloController(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioAlta(Model model) {
        model.addAttribute("articulo", new Articulo());
        return "formulario-alta";
    }

    @PostMapping("/nuevo")
    public String guardarArticulo(@ModelAttribute Articulo articulo) {
        // Validar si el SKU existe y realizar la lógica de alta
        // (Fecha de Alta, Fecha Baja)
        articuloRepository.save(articulo);
        return "redirect:/articulos/consulta";
    }

    @GetMapping("/eliminar/{sku}")
    public String mostrarConfirmacionBaja(@PathVariable String sku, Model model) {
        // Validar si el SKU existe y mostrar confirmación
        return "confirmacion-baja";
    }

    @PostMapping("/eliminar/{sku}")
    public String eliminarArticulo(@PathVariable String sku) {
        // Validar si el SKU existe y realizar la baja
        return "redirect:/articulos/consulta";
    }

    @GetMapping("/editar/{sku}")
    public String mostrarFormularioCambio(@PathVariable String sku, Model model) {
        // Validar si el SKU existe y mostrar formulario de cambio
        // (Actualizar los datos necesarios)
        return "formulario-cambio";
    }

    @PostMapping("/editar/{sku}")
    public String actualizarArticulo(@PathVariable String sku, @ModelAttribute Articulo articulo) {
        // Validar si el SKU existe y realizar la actualización
        return "redirect:/articulos/consulta";
    }

    @GetMapping("/consulta")
    public String consultarArticulo() {
        return "consulta";
    }
}
