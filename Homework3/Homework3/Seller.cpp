//
//  Seller.cpp
//  Homework3
//
//  Created by Josh on 10/16/17.
//  Copyright © 2017 Josh. All rights reserved.
//

#include "Seller.hpp"
Seller::Seller(){
    
}
Seller::Seller(string n){
    name = n;
    customers = priority_queue<customer>();
}
void Seller::queueCustomer(customer c){
    customers.push(c);
}
void Seller::dequeueCustomer(){
    customers.pop();
}

priority_queue<customer> Seller::getCustomers(){
    return customers;
}
