package entity;

import com.sages.exception.TurtleException;
import enums.CardinalPoints;
import enums.PenPosition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {

    private Turtle ijapa;
    private SketchPad drawingBoard;
    @BeforeEach
    void setUp() {
        ijapa = new Turtle("ijapa");
        drawingBoard = new SketchPad();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void changePenPositionFromUpToDown(){
        assertEquals(PenPosition.UP, ijapa.getPen().getPenPosition());
        ijapa.changePenPosition(PenPosition.DOWN);
        assertEquals(PenPosition.DOWN, ijapa.getPen().getPenPosition());
    }

    @Test
    void changePenPositionFromDownToUp(){
        assertEquals(PenPosition.UP, ijapa.getPen().getPenPosition());
        ijapa.changePenPosition(PenPosition.DOWN);
        assertEquals(PenPosition.DOWN, ijapa.getPen().getPenPosition());
        ijapa.changePenPosition(PenPosition.UP);
        assertEquals(PenPosition.UP, ijapa.getPen().getPenPosition());
    }

    @Test
    void turnRightFromEast(){
        assertEquals(CardinalPoints.EAST ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.SOUTH ,ijapa.getDirection());
    }

    @Test
    void turnRightFromSouth(){
        assertEquals(CardinalPoints.EAST ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.SOUTH ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.WEST,ijapa.getDirection());
    }

    @Test
    void turnRightFromWest(){
        assertEquals(CardinalPoints.EAST ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.SOUTH ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.WEST,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.NORTH,ijapa.getDirection());
    }

    @Test
    void turnRightFromNorth(){
        assertEquals(CardinalPoints.EAST ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.SOUTH ,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.WEST,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.NORTH,ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalPoints.EAST,ijapa.getDirection());
    }

    @Test
    void turnLeftFromEast(){
        assertEquals(CardinalPoints.EAST ,ijapa.getDirection());
        ijapa.turnLeft();
        assertEquals(CardinalPoints.NORTH ,ijapa.getDirection());
    }

    @Test
    void turnLeftFromSouth(){
       ijapa.setDirection(CardinalPoints.SOUTH);
       ijapa.turnLeft();
       assertEquals(CardinalPoints.EAST, ijapa.getDirection());
    }

    @Test
    void turnLeftFromNorth(){
        ijapa.setDirection(CardinalPoints.NORTH);
        ijapa.turnLeft();
        assertEquals(CardinalPoints.WEST, ijapa.getDirection());
    }
    @Test
        void turnLeftFromWest(){
            ijapa.setDirection(CardinalPoints.WEST);
            ijapa.turnLeft();
            assertEquals(CardinalPoints.SOUTH, ijapa.getDirection());
    }

    @Test
    void moveForwardFromEast(){
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getyCoordinate());
        try {
            ijapa.moveForward(12);
        } catch (TurtleException e) {
            e.printStackTrace();
        }
        assertEquals(11, ijapa.getxCoordinate());
        assertEquals(0, ijapa.getyCoordinate());
    }

    @Test
    void  moveForwardFromSouth(){
        ijapa.setDirection(CardinalPoints.SOUTH);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getyCoordinate());
        try {
            ijapa.moveForward(12);
        } catch (TurtleException e) {
            e.printStackTrace();
        }
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(11, ijapa.getyCoordinate());
    }

     @Test
    void  moveForwardFromWest(){
        ijapa.setDirection(CardinalPoints.WEST);
        ijapa.setxCoordinate(11);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getyCoordinate());
         try {
             ijapa.moveForward(12);
         } catch (TurtleException e) {
             e.printStackTrace();
         }
         assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(0, ijapa.getyCoordinate());
    }

     @Test
    void  moveForwardFromNorth(){
        ijapa.setDirection(CardinalPoints.NORTH);
        ijapa.setyCoordinate(11);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
         try {
             ijapa.moveForward(12);
         } catch (TurtleException e) {
             e.printStackTrace();
         }
         assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(0, ijapa.getyCoordinate());
    }

    @Test
    void moveForwardFromEastWithExcessSteps(){
        assertEquals(CardinalPoints.EAST, ijapa.getDirection());
        ijapa.setxCoordinate(10);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getyCoordinate());

        assertThrows(TurtleException.class, ()->
                ijapa.moveForward(12, drawingBoard));

        assertEquals(BigDecimal.TEN.intValue(), ijapa.getxCoordinate());
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getyCoordinate());
    }

    @Test
    void moveForwardFromSouthWithExcessSteps(){
        ijapa.setDirection(CardinalPoints.SOUTH);
        ijapa.setyCoordinate(10);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());

        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertThrows(TurtleException.class, ()->
                ijapa.moveForward(12, drawingBoard));

        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(BigDecimal.TEN.intValue(), ijapa.getyCoordinate());
    }

    @Test
    void moveForwardFromWestWithExcessSteps(){
        ijapa.setDirection(CardinalPoints.WEST);
        ijapa.setyCoordinate(10);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());

        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertThrows(TurtleException.class, ()->
                ijapa.moveForward(12, drawingBoard));

        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(BigDecimal.TEN.intValue(), ijapa.getyCoordinate());
    }

     @Test
    void moveForwardFromNorthWithExcessSteps(){
        ijapa.setDirection(CardinalPoints.NORTH);
        ijapa.setyCoordinate(10);
        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());

        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertThrows(TurtleException.class, ()->
                ijapa.moveForward(12, drawingBoard));

        assertEquals(BigDecimal.ZERO.intValue(), ijapa.getxCoordinate());
        assertEquals(BigDecimal.TEN.intValue(), ijapa.getyCoordinate());
    }

    @Test
    void printSquare () throws TurtleException {
        ijapa.changePenPosition(PenPosition.DOWN);
        ijapa.setDirection(CardinalPoints.EAST);
        ijapa.moveForward(6, drawingBoard);

        ijapa.turnRight();
        ijapa.moveForward(6, drawingBoard);

//        display drawing

//        ijapa.turnRight();
//        ijapa.moveForward(2, drawingBoard);
        drawingBoard.display();
    }


}