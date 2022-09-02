package ru.stqa.oft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrimes() {

        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimesLong() {
        long n = Integer.MAX_VALUE;

        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test
    public void testNonPrimes() {

        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    }
}
