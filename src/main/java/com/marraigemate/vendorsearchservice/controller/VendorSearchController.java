package com.marraigemate.vendorsearchservice.controller;


import com.marraigemate.vendorsearchservice.DTO.VendorDTO;
import com.marraigemate.vendorsearchservice.collection.SearchResult;
import com.marraigemate.vendorsearchservice.service.VendorSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vendor")
public class VendorSearchController {

    @Autowired
    private VendorSearchService vendorSearchService;

    @GetMapping("/")
    public ResponseEntity<List<VendorDTO>> getVendorByIds(@RequestBody List<String> vendorIds) {
        return ResponseEntity.ok(vendorSearchService.getVendorByIds(vendorIds));
    }

    @GetMapping("/fuzzy/{search}")
    public ResponseEntity<List<SearchResult>> findFuzzyMatches(@PathVariable String search) {
        return ResponseEntity.ok(vendorSearchService.findFuzzyMatches(search));
    }
}
