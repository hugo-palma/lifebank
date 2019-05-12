package com.lifebank.lbfavoritessvc.process;

import com.lifebank.lbfavoritessvc.pojo.database.LbClientPOJO;
import com.lifebank.lbfavoritessvc.pojo.database.LbFavoritesPOJO;
import com.lifebank.lbfavoritessvc.pojo.request.UpdateFavoriteEmailOnly;
import com.lifebank.lbfavoritessvc.repository.ClientRepository;
import com.lifebank.lbfavoritessvc.repository.FavoriteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UpdateFavoriteProcess {
    private FavoriteRepository favoriteRepository;
    private ClientRepository clientRepository;

    public UpdateFavoriteProcess(FavoriteRepository favoriteRepository, ClientRepository clientRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public ResponseEntity process(UpdateFavoriteEmailOnly updateFavoriteEmailOnly, String clientId){
        if(!validateFavoriteIdFormat(updateFavoriteEmailOnly.getId())){
            //El formato de id del beneficiario no es valido
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        List<LbFavoritesPOJO> lbFavoritesPOJOList = favoriteRepository.findAllByFavCliId(clientId);
        Integer favId = Integer.parseInt(updateFavoriteEmailOnly.getId());
        for (LbFavoritesPOJO favorite: lbFavoritesPOJOList) {
            if(favId == favorite.getFavId()){
                favorite.setFavEmail(updateFavoriteEmailOnly.getEmail());
                favoriteRepository.save(favorite);
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
        }catch (Exception e){
            return false;
        }

    }
}
