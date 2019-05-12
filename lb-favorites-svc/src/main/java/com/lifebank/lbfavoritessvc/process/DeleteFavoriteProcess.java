package com.lifebank.lbfavoritessvc.process;

import com.lifebank.lbfavoritessvc.pojo.database.LbFavoritesPOJO;
import com.lifebank.lbfavoritessvc.repository.FavoriteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DeleteFavoriteProcess {
    private FavoriteRepository favoriteRepository;

    public DeleteFavoriteProcess(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public ResponseEntity process(String clientId, String favoriteId){
        if(!validateFavoriteIdFormat(clientId)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<LbFavoritesPOJO> lbFavoritesPOJOList = favoriteRepository.findAllByFavCliId(clientId);
        Integer favId = Integer.parseInt(favoriteId);
        for (LbFavoritesPOJO favorite: lbFavoritesPOJOList) {
            if(favId.equals(favorite.getFavId())){
                favoriteRepository.delete(favorite);
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }
        //No se encontro el id de favorito en los favoritos del cliente
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    private boolean validateFavoriteIdFormat(String sId){
        try{
            int id = Integer.parseInt(sId);
            if(id > 0){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
