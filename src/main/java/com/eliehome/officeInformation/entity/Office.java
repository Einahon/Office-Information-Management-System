package com.eliehome.officeInformation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/*
 * Indicates that this class is a JPA entity.
 * Lombok's annotation to generate getters, setters, toString, equals, and hashCode methods.
 * Lombok's annotation to generate a no-argument constructor.
 * Lombok's annotation to generate an all-arguments constructor.
 * Lombok's annotation to implement the Builder pattern for this class.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Office {

    /*
     * The following field is the primary key for the Office entity.
     * It is automatically generated with a unique value.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long office_id;

    /*
     * The address field is validated to ensure it is between 5 and 50 characters long.
     * If the length is not within this range, the provided message will be displayed.
     */
    @Length(max=50, min = 5, message = "Address must be at least of 5 - 50 characters " )
    private String address;

    /*
     * The city field is validated to ensure it is between 2 and 50 characters long.
     * If the length is not within this range, the provided message will be displayed.
     */
    @Length(max=50, min = 2, message = "City must be at least of 2 - 50 characters ")
    private String city;

    /*
     * The state field is validated to ensure it is between 2 and 50 characters long.
     * If the length is not within this range, the provided message will be displayed.
     */
    @Length(max=50, min = 2, message = "State must be at least of 2 - 50 characters ")
    private String state;

    /*
     * The manager field is validated to ensure it is not blank, and it is  between 2 and 50 characters long.
     * If it is blank or the length is not within this range, the provided messages will be displayed.
     */
    @NotBlank(message = "Add manager Name")
    @Length(max = 50, min = 2, message = "Manager Name must be at least of 2 - 50 characters ")
    private String manager;

}
