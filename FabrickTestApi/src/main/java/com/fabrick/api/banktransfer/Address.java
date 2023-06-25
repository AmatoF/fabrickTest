package com.fabrick.api.banktransfer;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address extends CommonObject {

    String address;
    String city;
    String countryCode;

}
