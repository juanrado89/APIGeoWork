package org.albertorado.apigeowork.dtos;

public class EmpresaDto {

    private int idEmpresa;
    private DatosEmpresaDto datosEmpresa;


    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public DatosEmpresaDto getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(DatosEmpresaDto datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }
}
