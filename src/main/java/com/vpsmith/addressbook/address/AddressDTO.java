package com.vpsmith.addressbook.address;

public record AddressDTO(Long id, String addressLine1, String addressLine2  , String city, String state, String zipCode) {

    public static AddressDTO from(Address address) {
        return new AddressDTO(
                address.getId(),
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getCity(),
                address.getState(),
                address.getZipCode()
        );
    }           

    public Address toEntity() {
        return new Address(
                this.id(),
                this.addressLine1(),
                this.addressLine2(),
                this.city(),
                this.state(),
                this.zipCode()
        );
    }   
}
