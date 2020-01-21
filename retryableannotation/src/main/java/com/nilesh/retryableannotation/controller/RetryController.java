package com.nilesh.retryableannotation.controller;

import com.nilesh.retryableannotation.services.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableRetry
@RequestMapping("api/retryable")
public class RetryController {

    @Autowired
    RetryService retryService;

    @GetMapping("retryanootation")
    public String tryRetryAnnotation()
    {
        retryService.tryRetryMethod();
        return "Successfully tested.";
    }

    @GetMapping("retryanootationforNFexception/{num}")
    @Retryable(value = {NumberFormatException.class, NullPointerException.class}, maxAttempts = 3)
    public String tryRetryAnnotationWithNFException(@PathVariable String num)
    {
        retryService.tryRetryMethodforNFE(num);
        return "Successfully tested.";
    }

    @GetMapping("retryanootationforNPexception/{str}")
    @Retryable(value = {NumberFormatException.class, NullPointerException.class}, maxAttempts = 3)
    public String tryRetryAnnotationWithNPException(@PathVariable String str)
    {
        retryService.tryRetryMethodforNPE(str);
        return "Successfully tested.";
    }

    @Recover
    public String recover(NumberFormatException ex){
        return retryService.recoverNFE(ex);
    }

    @Recover
    public String recover(NullPointerException ex){
        return retryService.recoverNPE(ex);
    }


}
