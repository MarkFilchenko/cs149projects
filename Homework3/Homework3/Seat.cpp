#include "Seat.hpp"

Seat::Seat() {
}

void Seat::isSold() {
    this->sold = true;
}

bool Seat::getSold() {
    return this->sold;
}

void Seat::setCustomer(Customer *customer) {
    this->customer = customer;
}

Customer* Seat::getCustomer() {
    return this->customer;
}

void Seat::setSeller(Seller *seller) {
    this->seller = seller;
}

Seller* Seat::getSeller() {
    return this->seller;
}
