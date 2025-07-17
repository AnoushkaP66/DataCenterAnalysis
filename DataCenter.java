package Projects.AnalyzingDataCenters;

public class DataCenter {
    //Private variables
    private String constructionFirm;
    private double constructionCost;
    private double ITLoad;
    private double operatingCost;

    /**
     * This is a default constructor for a DataCenter object. It assigns the numeric values to 0 and an empty String value.
     */
    public DataCenter() {
        this.constructionFirm = "";
        this.constructionCost = 0.0;
        this.ITLoad = 0.0;
        this.operatingCost = 0.0;
    }

    /**
     * This is a parameterized constructor for a DataCenter object. It assigns the attributes to the values specified
     * in the parameters.
     * @param constructionFirm
     * @param constructionCost
     * @param ITLoad
     * @param operatingCost
     */
    public DataCenter(String constructionFirm, double constructionCost, double ITLoad, double operatingCost) {
        this.constructionFirm = constructionFirm;
        this.constructionCost = constructionCost;
        this.ITLoad = ITLoad;
        this.operatingCost = operatingCost;
    }

    /**
     * This method returns a constructionFirm
     * @return constructionFirm
     */
    public String getConstructionFirm() {
        return constructionFirm;
    }

    /**
     * This method sets a constructionFirm
     * @param constructionFirm
     */
    public void setConstructionFirm(String constructionFirm) {
        this.constructionFirm = constructionFirm;
    }

    /**
     * This method returns the cost of construction
     * @return constructionCost
     */
    public double getConstructionCost() {
        return constructionCost;
    }

    /**
     * This method sets a construction cost
     * @param constructionCost
     */
    public void setConstructionCost(double constructionCost) {
        this.constructionCost = constructionCost;
    }

    /**
     * This method returns the IT load
     * @return ITLoad
     */
    public double getITLoad() {
        return ITLoad;
    }

    /**
     * This method sets an IT load
     * @param ITLoad
     */
    public void setITLoad(double ITLoad) {
        this.ITLoad = ITLoad;
    }

    /**
     * This method returns an operating cost
     * @return operatingCost
     */
    public double getOperatingCost() {
        return operatingCost;
    }

    /**
     * This method sets an operating cost
     * @param operatingCost
     */
    public void setOperatingCost(double operatingCost) {
        this.operatingCost = operatingCost;
    }

    ///@Override
    /// This method returns the DataCenter object in String format
    public String toString() {
        return constructionFirm + " " +
                String.format("%.2f", constructionCost) + " " +
                String.format("%.2f", ITLoad) + " " +
                String.format("%.2f", operatingCost);
    }
}
