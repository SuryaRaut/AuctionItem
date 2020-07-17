package com.example.auctionproject.service;

import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.repository.AuctionRepo;
import com.example.auctionproject.repository.BidRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyInt;

public class AuctionServiceTest {
    @InjectMocks
    private AuctionService auctionService;

    @Mock
    private AuctionRepo auctionRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void shouldGetAuction() {
        when(auctionRepo.existsById( anyInt() ) ).thenReturn(true);
        when(auctionRepo.findById( anyInt() ) ).thenReturn(new AuctionModel());

        AuctionModel auctionResponse = auctionService.getItem(1);
        Assertions.assertNotNull(auctionResponse);

        verify(auctionRepo, times(1)).existsById( anyInt() );
        verify(auctionRepo, times(1)).findById( anyInt() );
    }
    @Test
    public void shouldPostAuction() {
        when(auctionRepo.findById( anyInt() ) ).thenReturn(createAuctionModel());
        //AuctionModel auctionResponse = auctionService.postItem(new AuctionModel());
        String response = auctionService.postItem(createAuctionModel());
        Assertions.assertEquals("Successfull", response);

        verify(auctionRepo, times(1)).save(any(AuctionModel.class));
    }
    @Test
    public void shouldUpdateBid() {
        when(auctionRepo.existsById( anyInt() ) ).thenReturn(true);
        when(auctionRepo.findById( anyInt() ) ).thenReturn( new AuctionModel());

        String response = auctionService.updateItem(new AuctionModel());
        Assertions.assertEquals("Succefully Updated", response);
        verify(auctionRepo, times(1)).save(any(AuctionModel.class));
    }
    @Test
    public void shouldDeleteAuction() {
        when(auctionRepo.existsById( anyInt() ) ).thenReturn(true);
        when(auctionRepo.findById( anyInt() ) ).thenReturn( new AuctionModel());

        String response = auctionService.deleteItem(1);
        Assertions.assertEquals("Item Deleted", response);
        verify(auctionRepo, times(1)).existsById( anyInt() );
        verify(auctionRepo, times(1)).findById( anyInt() );
    }

    private AuctionModel createAuctionModel() {
        AuctionModel model = new AuctionModel();
        model.setCurrentBid("0");
        model.setAuctionId(12);
        model.setReservePrice("1200");
        return model;
    }

}
