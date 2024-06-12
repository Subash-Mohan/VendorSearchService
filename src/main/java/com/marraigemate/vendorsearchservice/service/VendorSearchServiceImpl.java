package com.marraigemate.vendorsearchservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marraigemate.vendorsearchservice.DTO.AddressDTO;
import com.marraigemate.vendorsearchservice.DTO.GeoPointDTO;
import com.marraigemate.vendorsearchservice.DTO.VendorDTO;
import com.marraigemate.vendorsearchservice.collection.SearchResult;
import com.marraigemate.vendorsearchservice.collection.Vendor;
import com.marraigemate.vendorsearchservice.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorSearchServiceImpl implements VendorSearchService {

    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<VendorDTO> getVendorByIds(List<String> vendorIds) {
        List<VendorDTO> vendorDTOList = new ArrayList<>();
        List<Vendor> vendors = vendorRepository.findAllById(vendorIds);
        for(Vendor vendor : vendors) {
            VendorDTO vendorDTO = new VendorDTO();
            vendorDTO.setId(vendor.getId());
            vendorDTO.setName(vendor.getName());
            AddressDTO addressDTO = getAddressDTO(vendor);
            vendorDTO.setAddress(addressDTO);
            vendorDTOList.add(vendorDTO);
        }
        return vendorDTOList;
    }

    private AddressDTO getAddressDTO(Vendor vendor) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(vendor.getAddress().getCity());
        addressDTO.setCountry(vendor.getAddress().getCountry());
        addressDTO.setCity(vendor.getAddress().getCity());
        addressDTO.setState(vendor.getAddress().getState());
        addressDTO.setZip(vendor.getAddress().getZip());
        GeoPointDTO geoPointDTO = new GeoPointDTO();
        geoPointDTO.setLatitude(vendor.getAddress().getLocation().getLatitude());
        geoPointDTO.setLongitude(vendor.getAddress().getLocation().getLongitude());
        addressDTO.setLocation(geoPointDTO);
        return addressDTO;
    }

    @Override
    public List<SearchResult> findFuzzyMatches(String search) {
        return vendorRepository.findFuzzyMatches(search);
    }


}

