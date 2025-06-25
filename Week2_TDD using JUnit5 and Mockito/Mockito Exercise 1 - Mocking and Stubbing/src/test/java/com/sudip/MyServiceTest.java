package com.sudip;

import com.external.ExternalApi;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.* ;

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
    public void testFetchDataSuccess() {
        when(mockApi.getData()).thenReturn("Mock Data");

        String result = service.fetchData();

        assertEquals("Mock Data", result, "Should return mocked data");

        // Verify: Ensure getData was called ONLY ONCE
        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testFetchDataNullResponse() {
        when(mockApi.getData()).thenReturn(null);

        String result = service.fetchData();

        assertEquals("No data available", result, "Should handle null response");

        verify(mockApi, times(1)).getData();
    }

    @Test
    void testFetchDataThrowsRuntimeException() {
        RuntimeException exception = new RuntimeException("API failure");
        when(mockApi.getData()).thenThrow(exception);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            service.fetchData();
        });

        assertSame(exception, thrown, "Should throw the same RuntimeException object");
        assertEquals("API failure", thrown.getMessage());
        verify(mockApi, times(1)).getData();
    }
}