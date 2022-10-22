public class Converter {
    double lengthStep=75;
    double caloriesInStep = 50;
    public double distance(int sumOfSteps) {
        return sumOfSteps * lengthStep/100/1000;
    }
    public double burnCals(int sumOfSteps) {
        return sumOfSteps * caloriesInStep / 1000;
    }
}