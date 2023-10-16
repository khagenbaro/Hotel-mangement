package com.HotelManagement.dto;

import com.HotelManagement.modal.LunchCategory;
import lombok.Data;
import java.util.List;

@Data
public class LunchMenuDTO {

        private String name;
        private String description;
        private List<LunchCategory> lunchCategoryList;

}
