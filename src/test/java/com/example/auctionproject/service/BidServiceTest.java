package com.example.auctionproject.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyInt;

import com.example.auctionproject.dto.BidDTO;
import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.exceptions.ReservePriceNotMetException;
import com.example.auctionproject.repository.AuctionRepo;
import com.example.auctionproject.repository.BidRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BidServiceTest {

    @InjectMocks
    private BidService bidService;

    @Mock
    private BidRepo bidRepo;

    @Mock
    private AuctionRepo auctionRepo;

    @Mock
    private AuditLogService logService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPostBid() throws ReservePriceNotMetException {
        when(auctionRepo.findById( anyInt() ) ).thenReturn(createAuctionModel());
        doNothing().when(logService).log( any(BidModel.class), any(AuctionModel.class), anyString());

        String response = bidService.postBid(createBidDTO());
        Assertions.assertEquals("Successfull", response);
        verify(auctionRepo, times(1)).findById( anyInt() );
        verify(bidRepo, times(1)).save(any(BidModel.class));
        verify(auctionRepo, times(1)).save(any(AuctionModel.class));
        verify(logService, times(1)).log( any(BidModel.class), any(AuctionModel.class), anyString());

    }

    @Test
    public void shouldGetBid() {
        when(bidRepo.existsById( anyInt() ) ).thenReturn(true);
        when(bidRepo.findById( anyInt() ) ).thenReturn(Optional.ofNullable( new BidModel() ) );

        BidModel bidResponse = bidService.getBid(1);
        Assertions.assertNotNull(bidResponse);

        verify(bidRepo, times(1)).existsById( anyInt() );
        verify(bidRepo, times(1)).findById( anyInt() );
    }

    @Test
    public void shouldNotGetBid() {
        when(bidRepo.existsById( anyInt() ) ).thenReturn( false );

        BidModel bidResponse = bidService.getBid(1);
        Assertions.assertNull(bidResponse);

        verify(bidRepo, times(1)).existsById( anyInt() );
    }

    @Test
    public void shouldGetAll() {
        when(bidRepo.findAll()).thenReturn(Arrays.asList( new BidModel(), new BidModel(), new BidModel() ) );

        List<BidModel> bidModels = bidService.getAll();
        Assertions.assertNotNull( bidModels );
        Assertions.assertEquals( 3, bidModels.size() );

        verify(bidRepo, times(1)).findAll();
    }


    private BidDTO createBidDTO() {
        BidDTO bid = new BidDTO();
        bid.setBidderName("bidder-name");
        bid.setMaxAutoBidAmount( 30.0D );
        return bid;
    }

    private AuctionModel createAuctionModel() {
        AuctionModel model = new AuctionModel();
        model.setReservePrice("25");
        return model;
    }

}
