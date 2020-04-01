package com.nilesh.springboottestapp;

import com.nilesh.springboottestapp.LoadRequest.LoadRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class StatusServiceTest {

    StatusService statusService;
    Controller mockController;
    StatusServiceFields mockStFields;
    LoadRequest mockLoadRequest;
    @BeforeEach
    public void setUp()
    {
        mockController= Mockito.mock(Controller.class);
        mockStFields = Mockito.mock(StatusServiceFields.class);
        mockLoadRequest=Mockito.mock(LoadRequest.class);
        statusService = new StatusService(mockController,mockStFields);
    }

    @Test
    public void test_refresh_load_on_when_age_is_none_and_verify_if_controller_gets_called()
    {
        Mockito.when(mockStFields.getAge()).thenReturn(0);

        statusService.refreshLoad();

        Mockito.verifyZeroInteractions(mockController);
        Mockito.verifyZeroInteractions(mockLoadRequest);

        //        Mockito.verifyZeroInteractions(mockStFields);

    }

    @Test
    public void test_refresh_load_on_when_age_is_not_10_and_verify_if_controller_gets_called()
    {
        Mockito.when(mockStFields.getAge()).thenReturn(11);

        statusService.refreshLoad();

        Mockito.verifyZeroInteractions(mockController);
        Mockito.verifyZeroInteractions(mockLoadRequest);

        //Mockito.verifyZeroInteractions(mockStFields);
    }

    @Test
    public void test_refresh_load_on_when_age_is_ten_and_verify_if_controller_gets_called()
    {
        Mockito.when(mockStFields.getAge()).thenReturn(10);

        statusService.refreshLoad();

        Mockito.verifyZeroInteractions(mockController);
        //Mockito.verifyZeroInteractions(mockStFields);
    }

}