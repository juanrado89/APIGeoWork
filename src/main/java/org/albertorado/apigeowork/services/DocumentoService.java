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
        Optional<DocumentoDto> resultado = documentoRepository.findByIdDocumento(id);
        return resultado.orElseGet(null);
    }

    public DocumentoDto crearDocumento(Documento documento) {

        Documento creado = documentoRepository.save(documento);
        return documentoMapper.toDto(creado);

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
