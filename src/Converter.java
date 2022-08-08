 public class Converter {
    double rateStep;
    double rateCalorie;

    Converter(double step, double calorie) {
        rateStep = step;
        rateCalorie = calorie;
    }

    double convertKm(int steps) {
        return steps * rateStep;
    }

     double convertCalories(int steps) {
             return steps * rateCalorie;
     }
}
