 public class Converter {
    double rateStep;
    double rateCalorie;

        Converter(double step, double calorie) {
            rateStep = step;
            rateCalorie = calorie;
        }

        double convert(int steps, int var) {
            if (var == 1) {
                return steps * rateStep;
            } else {
                return steps * rateCalorie;
            }
        }
}
