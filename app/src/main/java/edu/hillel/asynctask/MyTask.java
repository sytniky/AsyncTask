package edu.hillel.asynctask;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * Created by yuriy on 24.07.16.
 */
public class MyTask extends AsyncTask<Integer, Integer, Integer> {

    private Activity mParent;

    public MyTask(Activity parent) {
        this.mParent = parent;
    }

    @Override
//    protected Integer doInBackground(Void... objects) {
    protected Integer doInBackground(Integer... params) {

        // separate thread
        int lostMoney = 1;
        int n = params[0];

        try {
            for (int i = 0; i < n; i++) {
                Thread.sleep(1000);
                lostMoney = (int) Math.pow(2, i + 1);
                publishProgress(lostMoney);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lostMoney;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer result) {
        showResult(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        showResult(values[0]);
    }

    private void showResult(int result) {
        if (mParent instanceof MainActivity) {
            ((MainActivity) mParent).setResultText("You lost " + result);
        }
    }
}
