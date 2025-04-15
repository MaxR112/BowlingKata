package MR.BowlingKata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;

class bowlingTest {
    public Game g;

    @BeforeEach
    public void setUpGame(){
        g = new Game();
    }
    
    @Test
    public void testGutterGame(){
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes(){
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare(){
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16,g.score());
    }

    @Test
    public void testOneStrike(){
        g.roll(10); //Strike
        g.roll(3);
        g.roll(6);
        rollMany(16, 0);
        assertEquals(28,g.score());
    }

    private void rollMany(int n, int pins){
        for (int i = 0; i < n; i++){
            g.roll(pins);
        }
    }

    private void rollSpare(){
        g.roll(5);
        g.roll(5);
    }
}