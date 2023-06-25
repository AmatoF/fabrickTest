package com.fabrick.rest.balance;

import com.fabrick.api.banktransfer.BankTransferRequest;
import com.fabrick.api.banktransfer.BankTransferResponse;
import com.fabrick.api.exception.*;
import com.fabrick.api.transaction.TransactionResponse;
import com.fabrick.business.balance.BalanceService;
import com.fabrick.business.banktransfer.BankTransferService;
import com.fabrick.business.transaction.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabrick")
public class FabrickController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private BankTransferService bankTransferService;


    @GetMapping(value = "/getBalance")
    public ResponseEntity<String> getBalance(@RequestParam Long accountId) throws GetBalanceException {
        return ResponseEntity.ok().body(balanceService.getBalance(accountId));
    }

    @GetMapping(value = "/getTransactionList")
    public ResponseEntity<TransactionResponse> getTransactionList(@RequestParam Long accountId, @RequestParam String fromAccountingDate, @RequestParam String toAccountingDate) throws GetTransactionException, SaveTransactionException {
        return ResponseEntity.ok().body(transactionService.getTransactionList(accountId, fromAccountingDate, toAccountingDate));
    }

    @PostMapping(value = "/createBankTransfer")
    public ResponseEntity<BankTransferResponse> createBankTransfer(@RequestParam Long accountId, @RequestBody BankTransferRequest bankTransferRequest) throws BankTransferException {
        return ResponseEntity.ok().body(bankTransferService.createBankTransfer(accountId, bankTransferRequest));
    }

    /********** EXCEPTION HANDLER ************/

    @ExceptionHandler(GetBalanceException.class)
    public ResponseEntity<GenericErrorDescriptor> handlerException(HttpServletRequest req, GetBalanceException e) {
        GenericErrorDescriptor error = new GenericErrorDescriptor(e.getMessage(), req.getRequestURI(), GetBalanceException.class);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GetTransactionException.class)
    public ResponseEntity<GenericErrorDescriptor> handlerException(HttpServletRequest req, GetTransactionException e) {
        GenericErrorDescriptor error = new GenericErrorDescriptor(e.getMessage(), req.getRequestURI(), GetTransactionException.class);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BankTransferException.class)
    public ResponseEntity<GenericErrorDescriptor> handlerException(HttpServletRequest req, BankTransferException e) {
        GenericErrorDescriptor error = new GenericErrorDescriptor(e.getMessage(), req.getRequestURI(), BankTransferException.class);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SaveTransactionException.class)
    public ResponseEntity<GenericErrorDescriptor> handlerException(HttpServletRequest req, SaveTransactionException e) {
        GenericErrorDescriptor error = new GenericErrorDescriptor(e.getMessage(), req.getRequestURI(), SaveTransactionException.class);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
