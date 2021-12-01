package entity;

import enums.CardinalPoints;
import enums.PenPosition;
import com.sages.exception.TurtleException;

public class Turtle {
    private Pen pen;
    private int yCoordinate;
    private int xCoordinate;
    private String name;
    private CardinalPoints direction;

    public Turtle() {
        pen = new Pen();
        pen.setPenPosition(PenPosition.UP);
        direction = CardinalPoints.EAST;
    }

    public Turtle(String name) {
        pen = new Pen();
        pen.setPenPosition(PenPosition.UP);
        direction = CardinalPoints.EAST;
        this.name = name;
    }

    public Turtle(int xCoordinate, int yCoordinate, String name) {
        pen = new Pen();
        pen.setPenPosition(PenPosition.UP);
        direction = CardinalPoints.EAST;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.name = name;

    }


    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoints direction) {
        this.direction = direction;
    }

    public void changePenPosition(PenPosition penPosition) {
        this.getPen().setPenPosition(penPosition);
    }

    public void turnRight() {
        switch (direction) {
            case EAST -> setDirection(CardinalPoints.SOUTH);
            case SOUTH -> setDirection(CardinalPoints.WEST);
            case WEST -> setDirection(CardinalPoints.NORTH);
            case NORTH -> setDirection(CardinalPoints.EAST);
        }
    }

    public void turnLeft() {
        switch (direction) {
            case EAST -> setDirection(CardinalPoints.NORTH);
            case SOUTH -> setDirection(CardinalPoints.EAST);
            case WEST -> setDirection(CardinalPoints.SOUTH);
            case NORTH -> setDirection(CardinalPoints.WEST);
        }
    }

    public void moveForward(int numberOfSteps) throws TurtleException {
        if (direction.equals(CardinalPoints.EAST))
            xCoordinate += numberOfSteps - 1;
        else if (direction.equals(CardinalPoints.SOUTH)) {
            yCoordinate += numberOfSteps - 1;
        } else if (direction.equals(CardinalPoints.WEST)) {
            xCoordinate -= numberOfSteps - 1;
        } else if (direction.equals(CardinalPoints.NORTH)) {
            yCoordinate -= numberOfSteps - 1;
        }
    }

    public void moveForward(int numberOfSteps, SketchPad pad) throws TurtleException {
        validatingStepsToMoveForward(numberOfSteps, pad);

        if (direction.equals(CardinalPoints.EAST)) {

            if (pen.getPenPosition().equals(PenPosition.DOWN)) {
                for (int i = 0; i < numberOfSteps; i++) {
                    pad.getFloor()[yCoordinate][xCoordinate] = 1;
                    xCoordinate++;
                }
            } else {
                moveForward(numberOfSteps);
            }
        } else if (direction.equals(CardinalPoints.WEST)) {
            if (pen.getPenPosition().equals(PenPosition.DOWN)) {
                for (int i = xCoordinate; i < numberOfSteps; i++) {
                    pad.getFloor()[yCoordinate][xCoordinate] = 1;
                    xCoordinate--;
                }
            }
            else {
                moveForward(numberOfSteps);
            }
        } else if(direction.equals(CardinalPoints.SOUTH)){
            if(pen.getPenPosition().equals(PenPosition.DOWN)){
                for (int i = yCoordinate; i < numberOfSteps; i++) {
                    pad.getFloor()[yCoordinate][xCoordinate] = 1;
                    yCoordinate++;
                }
            }
            else {
                moveForward(numberOfSteps);
            }
        }

//        if(pen.getPenPosition().equals(PenPosition.DOWN) && direction.equals(CardinalPoints.SOUTH)){
//            for (int i = yCoordinate; i < numberOfSteps; i++) {
//                pad.getFloor()[yCoordinate][xCoordinate] = 1;
//                xCoordinate++;
//            }
//        }
        if(pen.getPenPosition().equals(PenPosition.DOWN) && direction.equals(CardinalPoints.NORTH)){
            for (int i = yCoordinate; i < numberOfSteps; i++) {
                pad.getFloor()[yCoordinate][xCoordinate] = 1;
            }
        }

    }



    private void validatingStepsToMoveForward(int numberOfSteps, SketchPad pad) throws TurtleException {
        if(numberOfSteps > pad.getFloor().length-1){
            throw new TurtleException("Number of steps too high");
        }
        int destination = -1;
        if(direction.equals(CardinalPoints.EAST)){
            destination = xCoordinate +numberOfSteps-1;
            if(destination > pad.getFloor().length-1){
                throw new TurtleException("Number of steps too high");
            }
        }

        if(direction.equals(CardinalPoints.SOUTH)){
            destination = yCoordinate +numberOfSteps-1;
            if(destination > pad.getFloor().length){
                throw new TurtleException("Number of steps too high");
            }
        } else if(direction.equals(CardinalPoints.WEST)){
            destination = xCoordinate - numberOfSteps-1;
            if(destination < pad.getFloor().length){
                throw new TurtleException("Number of steps too high");
            }
        } else if(direction.equals(CardinalPoints.NORTH)){
            destination = yCoordinate - numberOfSteps-1;
            if(destination < 1){
                throw new TurtleException("Number of steps too high");
            }
        }
    }


}
