//
//  HighLevelSeller.hpp
//  Homework3
//
//  Created by Josh on 10/16/17.
//  Copyright © 2017 Josh. All rights reserved.
//

#ifndef HighLevelSeller_hpp
#define HighLevelSeller_hpp

#include <stdio.h>
#include "Seller.hpp"
class HighLevelSeller: public Seller{
public:
    HighLevelSeller(){
        
    }
    HighLevelSeller(string n):Seller(n){
        
    }
    
};

#endif /* HighLevelSeller_hpp */
