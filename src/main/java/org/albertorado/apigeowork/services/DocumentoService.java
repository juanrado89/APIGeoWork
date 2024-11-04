package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.DocumentoDto;
import org.albertorado.apigeowork.entities.Documento;
import org.albertorado.apigeowork.mapper.DocumentoMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DocumentoRepository;

import java.util.Optional;
@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final DocumentoMapper documentoMapper;

    public DocumentoService(DocumentoRepository documentoRepository, DocumentoMapper documentoMapper) {
        this.documentoRepository = documentoRepository;
        this.documentoMapper = documentoMapper;
    }

    public DocumentoDto buscarPorId(int id) {
        Optional<Documento> resultado = documentoRepository.findByIdDocumento(id);
        if(resultado.isEmpty()){
            return null;
        }
        return documentoMapper.toDto(resultado.get());
    }

    public DocumentoDto crearDocumento(Documento documento) {

        Documento creado = documentoRepository.save(documento);
        return documentoMapper.toDto(creado);

    }

    public DocumentoDto actualizarDocumento(int id, Documento documento) {
        Optional<Documento> busqueda = documentoRepository.findByIdDocumento(id);

        if (busqueda.isPresent()) {
            Documento documentoExistente = busqueda.get();
            if (documento.getNombre() != null) {
                documentoExistente.setNombre(documento.getNombre());
            }
            if (documento.getTipoContenido() != null) {
                documentoExistente.setTipoContenido(documento.getTipoContenido());
            }
            if (documento.getContenido() != null) {
                documentoExistente.setContenido(documento.getContenido());
            }
            Documento actualizado = documentoRepository.save(documentoExistente);
            return documentoMapper.toDto(actualizado);
        } else {
            return null;
        }
    }


    public void borrarDocumento(int id) {

        documentoRepository.deleteDocumentoByIdDocumento(id);

    }
}
