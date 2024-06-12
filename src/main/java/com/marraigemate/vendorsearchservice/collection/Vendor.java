package com.marraigemate.vendorsearchservice.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vendor {
    @Id
    private String id;

    @Indexed
    private String name;

    private String description;

    private VendorType type;

    private MarraigeHall hallDetails;

    private Catering cateringDetails;

    private HallDecoration hallDecorationDetails;

    private Availability availability;

    private Contact contact;

    private Address address;
}
