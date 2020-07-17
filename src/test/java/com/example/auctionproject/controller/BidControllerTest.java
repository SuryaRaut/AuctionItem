package com.example.auctionproject.controller;

import com.example.auctionproject.dto.BidDTO;
import com.example.auctionproject.entity.AuctionModel;
import com.example.auctionproject.entity.BidModel;
import com.example.auctionproject.service.AuctionService;
import com.example.auctionproject.service.BidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class BidControllerTest {
    @InjectMocks
    private BidController controller;

    @Mock
    private BidService bidService;
    @Mock
    private BidDTO bidDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPost() throws Exception{
        BidModel bidModel = new BidModel();
        bidModel.setBidderName("bidder-name");
        bidModel.setMaxAutoBitAmount(30D);
        bidModel.setBidId(1);

        Mockito.when(bidService.postBid( Mockito.any(BidDTO.class) ) )
                .thenReturn( "some-response-value" );

        String response = controller.postBid( bidDTO );
        Assertions.assertEquals("some-response-value", response);

        Mockito.verify(bidService, Mockito.times( 1 ) ).postBid( Mockito.any(BidDTO.class));
    }
    @Test
    public void shouldGet() throws Exception {


        Mockito.when(bidService.getBid( Mockito.anyInt() ) ).thenReturn(new BidModel());

        BidModel bidReponse = controller.getBidDetails( 1 );
        Assertions.assertNotNull(bidReponse);

        Mockito.verify(bidService, Mockito.times( 1 ) ).getBid( Mockito.anyInt() );

    }
    
@Test
public void shouldGetAll() throws Exception {


    //Mockito.when(bidService.getAll() );
    Mockito.when(bidService.getAll()).thenReturn(Arrays.asList( new BidModel(), new BidModel(), new BidModel() ) );
    //List<BidModel> bidModels = bidService.getAll();
    List<BidModel> reponse = controller.getBidDetails();
    Assertions.assertNotNull(reponse);
    Mockito.verify(bidService, Mockito.times( 1 ) ).getAll( );

}
}
