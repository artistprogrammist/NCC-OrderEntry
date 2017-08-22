package com.netcracker.courses.oe.processor.service.util;

import com.netcracker.courses.oe.processor.dto.catalog.OfferDTO;
import com.netcracker.courses.oe.processor.dto.processor.ItemDTO;

public interface Converter {
    ItemDTO toItemDTO(OfferDTO offerDTO);
}
