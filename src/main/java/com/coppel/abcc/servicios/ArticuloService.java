package com.coppel.abcc.servicios;

import org.springframework.stereotype.Service;
import com.coppel.abcc.modelo.Articulo;
import com.coppel.abcc.repositorio.ArticuloRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;
    
    public boolean validarCantidadMenorOIgualAlStock(Articulo articulo) {
        return articulo.getCantidad() <= articulo.getStock();
    }

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    public void guardarArticulo(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }

    public void actualizarArticulo(Articulo articulo) {
        articuloRepository.save(articulo);
    }


	public Optional<Articulo> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
