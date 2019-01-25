START GUIDE
  - script is written for ubuntu 16.04
  - open file run.sh and skip maven build if no maven in server
  - run run.sh which launch docker compose
  - check apis localhost:8080

API DETAIL
1. http://localhost:8080/element.in/insurance/modules
api list all modules and predefined isurance packages for user can select what they want to buy 
this is sample format 1 of 4 modules
module Bike has 3 packages ,user can select package they like and see price which is calculated for them
all insurance modules and packages should have a code, it make query easier and safer instead of using table id
[  
   {  
      "name":"Bike",
      "code":"BIKE",
      "max":3000.0,
      "min":0.0,
      "risk":0.3,
      "packages":[  
         {  
            "code":"BIKE-500",
            "couverage":500.0,
            "price":150.0
         },
         {  
            "code":"BIKE-1000",
            "couverage":1000.0,
            "price":300.0
         },
         {  
            "code":"BIKE-2000",
            "couverage":2000.0,
            "price":600.0
         },
         {  
            "code":"BIKE-3000",
            "couverage":3000.0,
            "price":900.0
         }
      ]
   }
]


2. http://localhost:8080/element.in/insurance/package/JEWELRY-1000
if user already know the isurance package code  , they can use this api
its clear to see exaclty package they like
{  
   "code":"JEWELRY-1000",
   "couverage":1000.0,
   "price":50.0
}

if user send a wrong pacakge code, a error message will be reponsed 
http://localhost:8080/element.in/insurance/package/JEWELRY-1000-WRONG
{  
   "error":"Insurance code is not found.",
   "errorCode":"0"
}
