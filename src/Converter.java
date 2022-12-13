public class Converter {
    double getCalories(int totalSteps) {
        double calories = 0.05;
        return totalSteps * calories; //возращаем значение потраченных калорий
    }
    double getDistance(int totalSteps) {
        double distance = 0.00075;
        return totalSteps * distance; //возращаем значение пройденной дистанции
    }
}
