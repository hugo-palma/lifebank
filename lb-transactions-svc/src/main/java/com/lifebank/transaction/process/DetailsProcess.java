package com.lifebank.transaction.process;

import com.lifebank.transaction.repository.TransaccionesRepository;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetailsProcess <T> {
    private Environment env;
    JpaRepository productosRepository;
    JpaRepository detallesRepository;
    TransaccionesRepository transaccionesRepository;
    public DetailsProcess(Environment env, JpaRepository productosRepository, JpaRepository detallesRepository, TransaccionesRepository transaccionesRepository){
        this.env = env;
        this.productosRepository = productosRepository;
        this.detallesRepository = detallesRepository;
        this.transaccionesRepository = transaccionesRepository;
    }
    public ResponseEntity process(String accountID){
        List<T> listaTransacciones = new ArrayList<>();
        listaTransacciones = transaccionesRepository.findTransaccionesOfProduct(accountID);
        if(listaTransacciones.size() > 0)
        {
            //TODO: Obtener info de cada transaccion

        }
        else{
            Optional oCuenta  = productosRepository.findById(accountID);
            if(!oCuenta.isPresent())
            {
                return new ResponseEntity("No existe", HttpStatus.BAD_REQUEST);
            }
            else{
                //TODO:Verificar que hacer en caso de vacio
                return null;
            }
        }

        return null;
    }
}
