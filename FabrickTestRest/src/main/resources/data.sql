CREATE TABLE transaction_history(
    transactionId   INTEGER  NOT NULL PRIMARY KEY
    ,operationId     INTEGER  NOT NULL
    ,accountingDate  DATE  NOT NULL
    ,valueDate       DATE  NOT NULL
    ,type_enumeration VARCHAR(20) NOT NULL
    ,type_value       VARCHAR(25) NOT NULL
    ,amount          INTEGER  NOT NULL
    ,currency        VARCHAR(3) NOT NULL
    ,description     VARCHAR(22) NOT NULL
);