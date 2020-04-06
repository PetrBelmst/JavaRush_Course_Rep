package com.company;

public abstract class AbstractRobot implements Defensable, Attackable {

    private static int hitCount;


    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        double a = Math.random() * 4;
        hitCount = (int) a + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.CHEST;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            attackedBodyPart = BodyPart.ARM;

        } else hitCount = 0;
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        double a = Math.random() * 4;
        hitCount = (int) a + 1;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.CHEST;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 4) { // else if (hitCount >= 4)
            defendedBodyPart = BodyPart.HEAD;

        } else hitCount = 0;
        return defendedBodyPart;
    }

    public abstract String getName();
}