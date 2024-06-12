package com.marraigemate.vendorsearchservice.service;



import com.marraigemate.vendorsearchservice.DTO.VendorDTO;
import com.marraigemate.vendorsearchservice.collection.SearchResult;

import java.util.List;

public interface VendorSearchService {
    public List<VendorDTO> getVendorByIds(List<String> vendorIds);
    public List<SearchResult> findFuzzyMatches(String search);
}
