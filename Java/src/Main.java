public class Main {
    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int init_time_in_secs = h1 * 3600 + m1 * 60 + s1;
        int dest_time_in_secs = h2 * 3600 + m2 * 60 + s2;

        int count = 0;

        double hr_degree = (h1 % 12 + m1 / 60.0 + s1 / 3600.0) * 30.0;
        double min_degree = (m1 + s1 / 60.0) * 6.0;
        double sec_degree = s1 * 6.0;

        boolean is_sec_degree_higher_than_hour = sec_degree > hr_degree;
        boolean is_sec_degree_higher_than_min = sec_degree > min_degree;

        boolean temp_sec_degree_higher_than_hour = is_sec_degree_higher_than_hour;
        boolean temp_sec_degree_higher_than_min = is_sec_degree_higher_than_min;

        while (init_time_in_secs <= dest_time_in_secs) {
            if (hr_degree >= 360) hr_degree -= 360;
            if (min_degree >= 360) min_degree -= 360;
            if (sec_degree >= 360) sec_degree -= 360;

            is_sec_degree_higher_than_hour = sec_degree > hr_degree;
            is_sec_degree_higher_than_min = sec_degree > min_degree;

            int tempCount = count;

            if (!temp_sec_degree_higher_than_hour && is_sec_degree_higher_than_hour) count++;
            if (!temp_sec_degree_higher_than_min && is_sec_degree_higher_than_min) count++;

            if (count - tempCount == 2) count--;

            temp_sec_degree_higher_than_hour = is_sec_degree_higher_than_hour;
            temp_sec_degree_higher_than_min = is_sec_degree_higher_than_min;

            hr_degree += 30.0 / 3600;
            min_degree += 6.0 / 60;
            sec_degree += 6.0;

            init_time_in_secs++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(0, 5, 30, 0, 7, 0)); // → 2
    }
}
