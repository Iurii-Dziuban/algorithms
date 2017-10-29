package iurii.job.interview.facebook;

/**
 *
 * https://github.com/fuwutu/CodeForces/blob/master/268B%20-%20Buttons.cpp
 *
 * http://codeforces.com/contest/268/problem/B
 *
 * https://glider.ai
 *
 * Created by IuriiDziuban on 10/22/17.
 */
public class Buttons {

    // 1*(n-1)+1 + 2*(n-2)+1 + 3*(n-3)+1 + ... + n*(n-n)+1
    public int calculate(int n){
        return countPressingIthButton(n, n);
    }

    private int countPressingIthButton(int totalButtons, int i) {
        if (i == 0) {
            return totalButtons;
        }
        int count = i * (totalButtons - i) + 1;
        return count + countPressingIthButton(totalButtons, i - 1);
    }
}
