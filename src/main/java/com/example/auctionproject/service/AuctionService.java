package com.example.auctionproject.service;

import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.repository.AuctionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepo auctionRepo;
    //private AuctionModel auctionModel;


    public String postItem(AuctionModel auctionModel){
        auctionRepo.save(auctionModel);
        return "Successfully added";
    }
    public AuctionModel getItem(int id){
        return auctionRepo.findById(id);

//        if(auctionRepo.existsById(id)){
//            auctionRepo.findById(id);
//            return "Success";
//        }
//        return "Item Doesn't exist";
    }
    public String updateItem( AuctionModel updateAuctionModel){
        // AuctionModel auctionModel = auctionRepo.findById(id);
//        String currentBid = updateAuctionModel.getCurrentBid();
//        String reservePrice = updateAuctionModel.getReservePrice();
//        String itemId = updateAuctionModel.getItemId();
//        String description = updateAuctionModel.getDescription();
//        if(currentBid != null){
//            auctionModel.setCurrentBid(currentBid);
//        }
//        if(reservePrice != null){
//            auctionModel.setReservePrice(reservePrice);
//        }
////        if(itemId != null){
////            auctionModel.setItemId(itemId);
////        }
////        if(description != null){
////            auctionModel.setDescription(description);
////        }
        auctionRepo.save(updateAuctionModel);
        return "Item Updated";
    }

    public String deleteItem(int id){
        if(auctionRepo.existsById(id)){
            auctionRepo.deleteById(id);
            return "Item Deleted";
        }
        return "Item Doesn't Exist";
    }
//    public List<AuctionModel> getAll(){
//        return (List<AuctionModel>) auctionRepo.findAll();
//    }

}
