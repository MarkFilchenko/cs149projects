//
//  LowLevelSeller.hpp
//  Homework3
//
//  Created by Josh on 10/16/17.
//  Copyright © 2017 Josh. All rights reserved.
//

#ifndef LowLevelSeller_hpp
#define LowLevelSeller_hpp

#include <stdio.h>
#include "Seller.hpp"


class LowLevelSeller : public Seller{
public:
    LowLevelSeller(string n): Seller(n){
        
    }
    LowLevelSeller(){

    };
};

#endif /* LowLevelSeller_hpp */
