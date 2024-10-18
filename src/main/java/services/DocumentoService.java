package services;

import dtos.DocumentoDto;
import entities.Documento;
import org.springframework.stereotype.Service;
import repositories.DocumentoRepository;

import java.util.Optional;
@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public DocumentoDto buscarPorId(int id) {
        Optional<DocumentoDto> resultado = documentoRepository.findByIdDocumento(id);
        return resultado.orElseGet(null);
    }

    public DocumentoDto crearDocumento(Documento documento) {

        Optional<DocumentoDto> busqueda = documentoRepository.findByNombreLikeIgnoreCaseAndContenidoContainingIgnoreCase(documento.getNombre(),documento.getContenido());
        if(busqueda.isPresent()){
            return null;
        }else{
            documentoRepository.save(documento);
            Optional<DocumentoDto> resultado = documentoRepository.findByNombreLikeIgnoreCaseAndContenidoContainingIgnoreCase(documento.getNombre(),documento.getContenido());
            return resultado.orElseGet(null);
        }

    }

    public DocumentoDto actualizarDocumento(int id,Documento documento) {

        Optional<DocumentoDto> busqueda = documentoRepository.findByIdDocumento(id);
        if(busqueda.isPresent()){
            documentoRepository.save(documento);
            Optional<DocumentoDto> resultado = documentoRepository.findByIdDocumento(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }

    }

    public void borrarDocumento(int id) {

        documentoRepository.deleteDocumentoByIdDocumento(id);

    }
}
