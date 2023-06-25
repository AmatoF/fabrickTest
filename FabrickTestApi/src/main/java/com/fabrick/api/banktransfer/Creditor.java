package com.fabrick.api.banktransfer;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Creditor extends CommonObject {

    String name;
    Account account;
    Address address;





}
