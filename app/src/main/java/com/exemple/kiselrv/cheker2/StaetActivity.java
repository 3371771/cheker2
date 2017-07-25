package com.exemple.kiselrv.cheker2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class StaetActivity extends AppCompatActivity implements View.OnClickListener {

//    private static final String url = "jdbc:mysql://localhost:3360/cheker";
//    private static final String user = "root";
//    private static final String pass = "root";

    TextView fio;
    Button exit, exit1, enter, enter2;
    final String LOG_TAG = "myLogs";
    // ConnectMySql task;


//127.0.0.1
       // 195.128.137.28

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staet);

        fio = (TextView) findViewById(R.id.fio);
        enter = (Button) findViewById(R.id.enter);
        enter2 = (Button) findViewById(R.id.enter2);
        exit = (Button) findViewById(R.id.exit);
        exit1 = (Button) findViewById(R.id.exit1);
        enter.setOnClickListener(this);
        enter2.setOnClickListener(this);
        exit.setOnClickListener(this);
        exit1.setOnClickListener(this);
        new MyTask2().execute();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enter:
                Intent intent_enter = new Intent(this, EnterActivity.class);
                intent_enter.putExtra("fio", fio.getText().toString());
                startActivity(intent_enter);
                break;
            case R.id.exit:
                Intent intent_exit = new Intent(this, ExitActivity.class);
                intent_exit.putExtra("fio", fio.getText().toString());
                startActivity(intent_exit);
                break;
            case R.id.exit1:
                new MyTask().execute();
                break;
           case R.id.enter2:
                new MyTask2().execute();
               break;
            default:
                break;


        }

    }

    private class MyTask extends AsyncTask <Void,Void,String> {

        String fName;

        @Override
        protected String doInBackground(Void... voids) {
//            try {
//            Class.forName("com.mysql.jdbc.Driver");
//                Log.d(LOG_TAG, "--- Driver is conected!!! ---");
//            } catch (ClassNotFoundException e) {
//                Log.d(LOG_TAG, "--- Driver is NOT conected!!! ---");
//                Log.d(LOG_TAG,e.toString());
//                e.printStackTrace();
//                return null;
//            }
            Connection con;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://192.168.0.2:3306/cheker", "user", "user");

                Log.d(LOG_TAG,"есть подключение к БД");
            } catch (java.sql.SQLException e) {
                Log.d(LOG_TAG,"ошибка подключения к БД");
                Log.d(LOG_TAG,e.toString());

//                Statement st = con.createStatement();
//                final ResultSet rs = st.executeQuery( "SELECT * FROM users");
//                rs.next();
//               fName = rs.getString("fio");

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
            }


        @Override
        protected void onPostExecute (String result) {
            super.onPostExecute(result);
            fio.setText(fName);
        }
    }

//    public void Connect()
//    {
//        task = new ConnectMySql();
//        task.execute();
//    }
//
//    private class ConnectMySql extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... urls)
//        {
//            String response = "";
//            try
//            {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection(url, user, pass);
//                String result = "Database connection success\n";
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery("INSERT INTO  `cheker`.`users` (`id`, `fio` ,`enter` ,`exit`)VALUES (NULL ,  'ivanov',  `2017-07-14 00:00:00` ,  '2017-07-14 00:00:00')");
//
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//            return response;
//        }
//
//    }


    private class MyTask2 extends AsyncTask <Void,Void,Void> {

            String fName;

            @Override
            protected Void doInBackground(Void... voids) {
//
                Connection con;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://192.168.0.2:3306/cheker", "user", "user");
                    Statement st = con.createStatement();
                    String sql = "INSERT INTO users " + "VALUES (null, 'Zara', curdate(), curtime(),'vhod')";
                    st.executeUpdate(sql);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }
//    @Override
//    protected void onPostExecute (String result) {
//        super.onPostExecute(result);
//        fio.setText(fName);
//    }
}


}


