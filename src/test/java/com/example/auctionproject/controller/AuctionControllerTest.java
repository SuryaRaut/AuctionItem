package com.example.auctionproject.controller;

import com.example.auctionproject.dto.AuctionDTO;
import com.example.auctionproject.dto.BidDTO;
import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.service.AuctionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AuctionControllerTest {

    @InjectMocks
    private AuctionController controller;

    @Mock
    private AuctionService auctionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPost() throws Exception {

        AuctionModel auctionModel = new AuctionModel();
        auctionModel.setAuctionId(12);
        auctionModel.setCurrentBid("0");
        auctionModel.setReservePrice("1200");

        Mockito.when(auctionService.postItem( Mockito.any( AuctionModel.class ) ) )
                .thenReturn( "some-response-value" );

        String response = controller.addAuction( auctionModel );
        Assertions.assertEquals("some-response-value", response);

        Mockito.verify(auctionService, Mockito.times( 1 ) ).postItem( Mockito.any( AuctionModel.class ) );
    }

    @Test
    public void shouldGet() throws Exception {


        Mockito.when(auctionService.getItem( Mockito.anyInt() ) ).thenReturn(new AuctionModel());

        AuctionModel auctionReponse = controller.getAuction( 1 );
        Assertions.assertNotNull(auctionReponse);

        Mockito.verify(auctionService, Mockito.times( 1 ) ).getItem( Mockito.anyInt() );

    }


    @Test
    public void shouldUpdate() throws Exception {

        Mockito.when(auctionService.updateItem( Mockito.any(AuctionModel.class) ) )
                .thenReturn( "some-response-value" );

        String response = controller.updateAuction( new AuctionModel() );
        Assertions.assertEquals("some-response-value", response);

        Mockito.verify(auctionService, Mockito.times( 1 ) ).updateItem( Mockito.any(AuctionModel.class) );

    }

    @Test
    public void shouldDelete() {

        Mockito.when(auctionService.deleteItem( Mockito.anyInt() ) )
                .thenReturn( "some-response-value" );

        String response = controller.deleteAuction( 1 );
        Assertions.assertEquals("some-response-value", response);

        Mockito.verify(auctionService, Mockito.times( 1 ) )
                .deleteItem(  Mockito.anyInt() );
    }
}
