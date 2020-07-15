# AuctionItem
AuctionItem TakeHome Project

High level overview of this application is to Post Items for Auction and intrested individual shoud be able to post bid for that specific item based on AuctionId. 
Auction poster should be able to edit, update and delete their post, and if the Bid amount is equal or less that reserve price then bidder should get 
response message that they have not met the reserve price. And, maxBidAmount should be reflected as current bid amount. 

In order to test this application one needs postman or similar application since I have not implemented front end.
For the Auction Post method data shoud be in this format. 

{
	"auctionId":3,
	"currentBid": "0",
	"reservePrice": "3000",
	"item": {
		"itemId": "honda",
		"description": "desc"
	}
}

In order to post bit for the auction item, Bid post data should be in this format

{
"auctionID": 1,//auctionItem Id that one trying to bid the amount on
"maxAutoBidAmount": 1500.0,
"bidderName":"Bidder name"

}
