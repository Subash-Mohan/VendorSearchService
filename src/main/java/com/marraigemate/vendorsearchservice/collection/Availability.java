package com.marraigemate.vendorsearchservice.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Availability {
    private List<String> days;

    private String startTime;

    private String endTime;
}
