package com.lifebank.lbfavoritessvc.process;

import com.lifebank.lbfavoritessvc.pojo.database.IProduct;
import com.lifebank.lbfavoritessvc.pojo.database.LbFavoritesPOJO;
import com.lifebank.lbfavoritessvc.pojo.request.AddFavorite;
import com.lifebank.lbfavoritessvc.repository.FavoriteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.Optional;

public class AddFavoriteProcess<T, P extends Integer> {
    private FavoriteRepository favoriteRepository;
    private JpaRepository<T,Object> productRepository;

    public AddFavoriteProcess(FavoriteRepository favoriteRepository, JpaRepository productRepository){
        this.favoriteRepository = favoriteRepository;
        this.productRepository = productRepository;
    }
    public ResponseEntity process(AddFavorite addFavorite, String clientId){
        Object productId = addFavorite.getProductId();
        if(!validateExistAndSameType(productId)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if(alreadyExists(addFavorite.getProductId())){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        LbFavoritesPOJO lbFavoritesPOJO = new LbFavoritesPOJO();
        lbFavoritesPOJO.setFavCliId(Integer.parseInt(clientId));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        lbFavoritesPOJO.setFavCreationDate(timestamp);
        lbFavoritesPOJO.setFavEmail(addFavorite.getEmail());
        lbFavoritesPOJO.setFavName(addFavorite.getPersonName());
        lbFavoritesPOJO.setFavProductCode(addFavorite.getProductId());
        lbFavoritesPOJO.setFavProductType(addFavorite.getProductType());
        lbFavoritesPOJO.setFavState("A");
        favoriteRepository.save(lbFavoritesPOJO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    private boolean validateExistAndSameType(Object id){
        Optional<T> oProduct =  productRepository.findById(id);
        return oProduct.isPresent();
    }
    private boolean alreadyExists(String favoriteId){
        Optional<LbFavoritesPOJO> oProduct =  favoriteRepository.findByFavProductCode(favoriteId.toString());
        return oProduct.isPresent();
    }
}
