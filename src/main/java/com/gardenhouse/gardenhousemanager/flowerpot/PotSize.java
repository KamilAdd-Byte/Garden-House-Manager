package com.gardenhouse.gardenhousemanager.flowerpot;

public enum PotSize {
    EXTRA_SMALL(10,10, 10),
    SMALL(15,15, 20),
    MEDIUM(20,20, 30),
    LARGE(30,30, 40),
    EXTRA_LARGE(40,40, 50);

    private int diameter;
    private int depth;
    private double ml;

    /**
     * @param diameter 'średnica doniczki' - it's diameter of flowerpot.
     * @param depth 'głębokość/wysokość doniczki' - it's depth of flowerpot.
     * @param ml
     */
    PotSize(int diameter, int depth, double ml) {
        this.diameter = diameter;
        this.depth = depth;
        this.ml = ml;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getMl() {
        return ml;
    }

    public void setMl(double ml) {
        this.ml = ml;
    }
}
