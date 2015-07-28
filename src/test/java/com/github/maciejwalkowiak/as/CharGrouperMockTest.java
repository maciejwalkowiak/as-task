package com.github.maciejwalkowiak.as;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CharGrouperMockTest {
    private static final String DEFAULT_RESULT = "";
    private static final String SPECIAL_RESULT = "SUCCESS";
    private static final String SPECIAL_INPUT = "abcdef";

    @InjectMocks
    private CharGrouper charGrouper;

    @Mock
    private ArraySorter arraySorter;

    @Mock
    private StringCompressor stringCompressor;

    @Before
    public void initMocks() {
        when(arraySorter.sort(anyObject()))
            .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);

        doReturn(DEFAULT_RESULT).when(stringCompressor).compress(anyString());
        doReturn(SPECIAL_RESULT).when(stringCompressor).compress(eq(SPECIAL_INPUT));
    }

    @Test
    public void shouldReturnSpecialResultForSpecialInput() {
        // when
        String result = charGrouper.group(SPECIAL_INPUT);

        // then
        assertThat(result).isEqualTo(SPECIAL_RESULT);
        verify(stringCompressor, times(1)).compress(anyString());
    }

    @Test
    public void shouldReturnDefaultResult() {
        // when
        String result = charGrouper.group("foobar");

        // then
        assertThat(result).isEqualTo(DEFAULT_RESULT);
        verify(stringCompressor, times(1)).compress(anyString());
    }
}
