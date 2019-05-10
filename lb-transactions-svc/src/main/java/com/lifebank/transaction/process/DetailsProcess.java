package com.lifebank.transaction.process;

import com.lifebank.transaction.factory.IFactory;
import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.response.transactions.ProductDetailsResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import com.lifebank.transaction.repository.TransaccionesRepository;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetailsProcess <T extends ITransaction> {
    private Environment env;
    JpaRepository productosRepository;
    JpaRepository detallesRepository;
    TransaccionesRepository transaccionesRepository;
    IFactory factory;

    public DetailsProcess(Environment env, JpaRepository productosRepository, JpaRepository detallesRepository, TransaccionesRepository transaccionesRepository, IFactory factory){
        this.env = env;
        this.productosRepository = productosRepository;
        this.detallesRepository = detallesRepository;
        this.transaccionesRepository = transaccionesRepository;
        this.factory = factory;
    }
    public <R extends ITransaction> ResponseEntity process(String accountID){
        List<ITransaction> listaTransacciones;
        listaTransacciones = transaccionesRepository.findTransaccionesOfProduct(accountID);
        if(listaTransacciones.isEmpty())
        {
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
        List<ITransaction> lista = listaTransacciones;
        //Obteniendo detalle de transacciones
        List<Transaction> transactionList = factory.getTransactionsDetails(listaTransacciones);
        ProductDetailsResponse productDetailsResponse = new ProductDetailsResponse();
        productDetailsResponse.setTransactions(transactionList);
        return new ResponseEntity(productDetailsResponse, HttpStatus.OK);
    }
}
