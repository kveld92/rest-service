package Resource;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kevin Veld on 2-4-2017.
 */
public class BerekenCentrummatenTest {

    @Test
    public void geefGemiddeldeTest1() throws Exception {
        List<Double> nummers = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0);
        BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(nummers);
        assertEquals("5.5",berekenCentrummaten.geefGemiddelde());
    }

    @Test
    public void geefGemiddeldeTest2() throws Exception {
        List<Double> nummers = Arrays.asList(1.0,3.5,3.0);
        BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(nummers);
        assertEquals("2.5",berekenCentrummaten.geefGemiddelde());
    }

    @Test
    public void geefMediaanTest1() throws Exception {
        List<Double> nummers = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0);
        BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(nummers);
        assertEquals("5.5",berekenCentrummaten.geefMediaan());
    }

    @Test
    public void geefMediaanTest2() throws Exception {
        List<Double> nummers = Arrays.asList(1.0,3.5,3.0);
        BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(nummers);
        assertEquals("3.0",berekenCentrummaten.geefMediaan());
    }

    @Test
    public void geefModaalTest1() throws Exception {
        List<Double> nummers = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0);
        List<Double> uitkomstModaal = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0);
        BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(nummers);
        assertEquals(uitkomstModaal, berekenCentrummaten.geefModaal());
    }

    @Test
    public void geefModaalTest2() throws Exception {
        List<Double> nummers = Arrays.asList(1.0,2.0,2.0);
        List<Double> uitkomstModaal = Arrays.asList(2.0);
        BerekenCentrummaten berekenCentrummaten = new BerekenCentrummaten(nummers);
        assertEquals(uitkomstModaal, berekenCentrummaten.geefModaal());
    }

}