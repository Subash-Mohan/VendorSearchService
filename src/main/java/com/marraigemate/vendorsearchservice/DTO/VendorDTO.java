package com.marraigemate.vendorsearchservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.marraigemate.vendorsearchservice.collection.VendorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendorDTO {

    private String id;

    private String name;

    private String description;

    private VendorType type;

    private MarraigeHallDTO hallDetails;

    private CateringDTO cateringDTODetails;

    private HallDecorationDTO hallDecorationDetails;

    private AvailabilityDTO availability;

    private ContactDTO contact;

    private AddressDTO address;
}

