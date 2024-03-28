public class Calculations {
    public Calculations() {
    }

    public float calculate_income_no_cap(float deposit, float percent, float time, int m) {
        if (m == 1) {
            time /= 12;
        }
        float income = deposit * (percent / 100) * time;
        return deposit + income;
    }

    public float calculate_income_cap(float deposit, float percent, float time, int m) {
        if (m == 1) {
            time /= 12;
        }
        float income = (float) (deposit * (Math.pow(1 + percent / 100, time)));
        return income;
    }
}
