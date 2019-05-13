package com.lifebank.transaction.process;

import com.lifebank.transaction.collector.ITransactionCollector;
import com.lifebank.transaction.factory.IFactory;
import com.lifebank.transaction.factory.response.IResponseFactory;
import com.lifebank.transaction.filter.IFilter;
import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class DetailsProcess <T extends TransactionBlueprint> {
    private JpaRepository productoRepository;
    private ITransactionCollector iTransactionCollector;
    private IFactory factory;
    IFilter iFilter;
    private IResponseFactory responseFactory;

    public DetailsProcess(JpaRepository productoRepository, ITransactionCollector iTransactionCollector, IFactory factory, IResponseFactory responseFactory, IFilter iFilter){
        this.productoRepository = productoRepository;
        this.iTransactionCollector = iTransactionCollector;
        this.factory = factory;
        this.responseFactory = responseFactory;
        this.iFilter = iFilter;
    }
    public <R extends ITransaction> ResponseEntity process(String productId, String startDate, String endDate){
        List<ITransaction> listaTransacciones;
        listaTransacciones = iTransactionCollector.getTransactions(productId);
        if(listaTransacciones.isEmpty())
        {
            Optional oCuenta  = productoRepository.findById(productId);
            if(!oCuenta.isPresent())
            {
                return new ResponseEntity<>("No existe", HttpStatus.BAD_REQUEST);
            }
            else{
                //TODO:Verificar que hacer en caso de vacio
                return null;
            }
        }
        //Obteniendo detalle de transacciones
        List<Transaction> transactionList = factory.getTransactionsDetails(listaTransacciones);
        transactionList = iFilter.filter(listaTransacciones, transactionList, productId);
        responseFactory.setData(productoRepository, productId, startDate, endDate, transactionList);
        return new ResponseEntity<>(responseFactory.getResponse(), HttpStatus.OK);
    }
}
