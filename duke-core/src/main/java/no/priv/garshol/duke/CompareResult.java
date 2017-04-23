package no.priv.garshol.duke;

import java.util.HashMap;

/**
 * The CompareResult object represent the detail result of duke matching.
 *
 * Created by Eric on 09/02/16.
 */
public class CompareResult {

    protected double prob;
    protected HashMap<String, Double> probDetail;

    /**
     * Creates a new CompareResult object
     *
     * @param defaultProb the default overal probability
     */
    public CompareResult(double defaultProb) {
        this.prob = defaultProb;
        this.probDetail = new HashMap<String, Double>();
    }

    /**
     * Returns the overal matching probability.
     *
     * @return the overal matching probability
     */
    public double getProb() {
        return prob;
    }

    /**
     * Sets the overal matching probability
     * @param prob the overal matching probability
     */
    public void setProb(double prob) {
        this.prob = prob;
    }

    /**
     * Returns the detailed matching probability map for each property
     * @return the detailed matching probability map
     */
    public HashMap<String, Double> getProbDetail() {
        return probDetail;
    }

    /**
     * Adds a new detail and updates the overal probability
     *
     * @param prop the compared property
     * @param propProb the result of the property comparison
     * @param prob the overal probability
     */
    public void addResult(String prop, double propProb, double prob) {
        setProb(prob);
        probDetail.put(prop, propProb);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Result: ");
        sb.append(getProb());
        sb.append("\n");

        for (String key: getProbDetail().keySet()) {
            sb.append("field: ");
            sb.append(key);
            sb.append(" (").append(getProbDetail().get(key)).append(")\n");
        }

        return sb.toString();
    }
}
