package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void MallartDuckIsADuck()
    {
        Duck mallard = new MallardDuck();
        assertTrue( mallard instanceof Duck );
    }

    @Test
    public void MallartDuckIsATurley()
    {
        Duck mallard = new MallardDuck();
        assertTrue( mallard instanceof Turkey );
    }
}
