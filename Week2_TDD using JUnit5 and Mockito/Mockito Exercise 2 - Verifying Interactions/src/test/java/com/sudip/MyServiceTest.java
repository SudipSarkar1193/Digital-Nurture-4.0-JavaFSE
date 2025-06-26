package com.sudip;

import com.external.ExternalApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    private MyService service;

    @BeforeEach
    public void setUp() {
        service = new MyService(mockApi);
    }

    @Test
    public void testVerifyInteraction() {
        service.fetchData();

        // HERE we VERIFY: was mockApi.getData called with these arguments?
        verify(mockApi, times(1)).getData("Sudip", 5);
    }
}