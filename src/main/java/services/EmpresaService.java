package services;

import dtos.EmpresaDto;
import entities.Empresa;
import repositories.EmpresaRepository;

import java.util.Optional;

public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaDto crearEmpresa(Empresa empresa) {
        EmpresaDto busqueda = buscarEmpresaPorId(empresa.getIdEmpresa());
        if(busqueda != null){
            return busqueda;
        }else{
            empresaRepository.save(empresa);
            Optional<EmpresaDto> resultado = empresaRepository.findByDatosEmpresa_IdDatosEmpresa(empresa.getDatosEmpresa().getIdDatosEmpresa());
            return resultado.orElseGet(null);
        }
    }

    public EmpresaDto buscarEmpresaPorId(int id) {
        Optional<EmpresaDto> resultado = empresaRepository.findByIdEmpresa(id);
        return resultado.orElseGet(null);
    }

    public EmpresaDto actualizarEmpresa(int id, Empresa empresa) {
        Optional<EmpresaDto> resultado = empresaRepository.findByIdEmpresa(id);
        if(resultado.isPresent()){
            empresaRepository.save(empresa);
            Optional<EmpresaDto> actualizado = empresaRepository.findByIdEmpresa(id);
            return actualizado.orElseGet(null);
        }
        return null;
    }

    public void borrarEmpresa(int id) {
        empresaRepository.deleteByIdEmpresa(id);
    }

}
