//
//  Seller.hpp
//  Homework3
//
//  Created by Josh on 10/16/17.
//  Copyright © 2017 Josh. All rights reserved.
//

#ifndef Seller_hpp
#define Seller_hpp

#include <stdio.h>
#include <iostream>
#include <queue>

#include "Customer.hpp"
using namespace std;
class Seller{
    
protected:
    //All sellers have a name, queue of customers
    string name;
    priority_queue<customer> customers;
    
public:
    Seller();
    Seller(string n);
    void queueCustomer(customer c);
    void dequeueCustomer();
    void processTicket();
    priority_queue<customer> getCustomers();
    
    
    
};


#endif /* Seller_hpp */
