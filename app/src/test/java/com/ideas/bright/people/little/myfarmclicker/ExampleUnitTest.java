package com.ideas.bright.people.little.myfarmclicker;

import com.ideas.bright.people.little.myfarmclicker.resource.Club;
import com.ideas.bright.people.little.myfarmclicker.resource.MoneyUtils;
import com.ideas.bright.people.little.myfarmclicker.resource.Queue;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testClub()
    {
        Club club = new Club(new GameMultipliers());
        assertEquals(2, club.addPeople(2));

        assertEquals(club.getCapacity() - 2, club.addPeople(500));
    }

    @Test
    public void testQueue()
    {
        Queue queue = new Queue(new GameMultipliers());
        assertEquals(1, queue.getPerson());
        assertEquals(19, queue.getPeople());
        assertEquals(1, queue.getPerson());
        assertEquals(18, queue.getPeople());
        queue.putPeople(1);
        assertEquals(19, queue.getPeople());
        queue.putPeople(5);
        assertEquals(20, queue.getPeople());

    }

    @Test
    public void testFormatter()
    {
        NumberFormat formatter = new DecimalFormat();
        formatter = new DecimalFormat("$0.00/min");
        System.out.println(formatter.format(123456.30));

        formatter = new DecimalFormat("$#,###/min");
        System.out.println(formatter.format(123456.30));
    }

    @Test
    public void testMoneyUtils()
    {
        assertEquals("1.234M", MoneyUtils.toString(1234567));
        assertEquals("12.345M", MoneyUtils.toString(12345678));
        assertEquals("123.456M", MoneyUtils.toString(123456789));
        assertEquals("1.234B", MoneyUtils.toString(1234567890));
        assertEquals("12.345B", MoneyUtils.toString(12345678900.00));
        assertEquals("123.456B", MoneyUtils.toString(123456789000.00));
        assertEquals("1.234T", MoneyUtils.toString(1234567890000.00));
        assertEquals("12.345T", MoneyUtils.toString(12345678900000.00));
        assertEquals("123.456T", MoneyUtils.toString(123456789000000.00));
        assertEquals("1.234q", MoneyUtils.toString(1234567890000000.00));
    }

    @Test
    public void testToDouble()
    {
        assertEquals(12345000, MoneyUtils.toDouble("12.345M"), 0.0000001);
        assertEquals(1234000000, MoneyUtils.toDouble("1.234B"), 0.0000001);
    }
}