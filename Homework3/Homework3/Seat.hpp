#ifndef HW_3_SEAT_H
#define HW_3_SEAT_H

#include <stdio.h>
#include <string>

#include "Customer.hpp"
#include "Seller.hpp"

class Seat{

private:
    bool sold;
    Customer* customer;
    Seller* seller;

public:
    Seat();

    void isSold();
    bool getSold();

    void setCustomer(Customer* customer);
    Customer* getCustomer();

    void setSeller(Seller* seller);
    Seller* getSeller();

    void setPriceLevel(int priceLevel);
    int  getPriceLevel();
};

#endif //HW_3_SEAT_H
