package com.company.test;

import com.company.Shortener;
import com.company.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String s1, s2, s3;
        s1 = "same";
        s2 = "not same";
        s3 = "same";

        long idForS1 = shortener.getId(s1);
        long idForS2 = shortener.getId(s2);
        long idForS3 = shortener.getId(s3);

        Assert.assertNotEquals(idForS2, idForS1);
        Assert.assertNotEquals(idForS2, idForS3);
        Assert.assertEquals(s1, s3);

        String s1ByShortener = shortener.getString(idForS1);
        String s2ByShortener = shortener.getString(idForS2);
        String s3ByShortener = shortener.getString(idForS3);

        Assert.assertEquals(s1ByShortener, s1);
        Assert.assertEquals(s2ByShortener, s2);
        Assert.assertEquals(s3ByShortener, s3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
