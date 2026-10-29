package com.vpsmith.addressbook.user;

public record UserDTO(Long id, String userName, String firstName, String lastName, String email) {

    public static UserDTO from(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }           

    public User toEntity() {
        return new User(
                this.id(),
                this.userName(),
                this.firstName(),
                this.lastName(),
                this.email()
        );
    }   

}
