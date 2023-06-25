package com.fabrick.api.banktransfer;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account extends CommonObject {

    String accountCode;
    String bicCode;

}
