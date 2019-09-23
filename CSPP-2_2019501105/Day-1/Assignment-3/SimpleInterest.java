/**
 * Given principle amount, rate of Interest and time period, Calculte Simple
 * Interest.
 * You can check for the test cases in the TestJUnit.java
 * 
 * @author Siva Sankar
 */

 public class SimpleInterest {

    /**
     * This method returns the interest calculated for the given principle amount
     * and rate of interest, number of years the interest should be calculated.
     * 
     * @param principle, the principle amount
     * @param numberOfYears, the time period in years.
     * @param rateOfInterest, the rate of interest
     * 
     * @return the interest calculated for the given values of principle,
     * rate of interest and time period (Number of years)
     */
    public static double simpleInterest(double principle, double numberOfYears, double rateOfInterest) {
        //  Your code goes here....
        return (principle*numberOfYears*rateOfInterest)/100;
    }
 }