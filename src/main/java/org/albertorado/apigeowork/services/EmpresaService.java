package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.EmpresaDto;
import org.albertorado.apigeowork.entities.Empresa;
import org.albertorado.apigeowork.mapper.EmpresaMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.EmpresaRepository;

import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    public EmpresaDto crearEmpresa(Empresa empresa) {
        Empresa creada = empresaRepository.save(empresa);
        return empresaMapper.toDto(creada);
    }

    public EmpresaDto buscarEmpresaPorId(int id) {
        Optional<Empresa> resultado = empresaRepository.findByIdEmpresa(id);
        if(resultado.isEmpty()){
            return null;
        }
        return empresaMapper.toDto(resultado.get());
    }

    public EmpresaDto actualizarEmpresa(int id, Empresa empresa) {
        Optional<Empresa> resultado = empresaRepository.findByIdEmpresa(id);

        if (resultado.isPresent()) {
            Empresa empresaExistente = resultado.get();
            if (empresa.getDatosEmpresa() != null) {
                empresaExistente.setDatosEmpresa(empresa.getDatosEmpresa());
            }
            Empresa actualizada = empresaRepository.save(empresaExistente);
            return empresaMapper.toDto(actualizada);
        } else {
            return null;
        }
    }

    public void borrarEmpresa(int id) {
        empresaRepository.deleteByIdEmpresa(id);
    }

}
