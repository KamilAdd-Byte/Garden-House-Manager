package com.gardenhouse.gardenhousemanager.flowerpot;

public enum PotSize {
    EXTRA_SMALL(10,10),
    SMALL(15,15),
    MEDIUM(20,20),
    LARGE(30,30),
    EXTRA_LARGE(40,40);

    private int diameter;
    private int depth;

    /**
     * @param diameter 'średnica doniczki' - it's diameter of flowerpot.
     * @param depth 'głębokość doniczki' - it's depth of flowerpot.
     */
    PotSize(int diameter, int depth) {
        this.diameter = diameter;
        this.depth = depth;
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
}
