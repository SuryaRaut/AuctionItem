package com.example.auctionproject.controller;
import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")

public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    @PostMapping
    public String  addAuction(@RequestBody AuctionModel auctionModel){
        return auctionService.postItem(auctionModel);

    }
    @GetMapping("/{auctionId}")
    public AuctionModel getAuction(@PathVariable int auctionId){

        return auctionService.getItem(auctionId);
    }

    @PutMapping
    public String updateAuction(@RequestBody AuctionModel updateAuctionModel){
        return auctionService.updateItem( updateAuctionModel);
    }
    @DeleteMapping("/{auctionId}")
    public String deleteAuction(@PathVariable int auctionId){
        return auctionService.deleteItem(auctionId);
    }
//    @GetMapping("/getAll")
//    public List<AuctionModel> getAllItem(){
//      return auctionService.getAll();
//    }

}
