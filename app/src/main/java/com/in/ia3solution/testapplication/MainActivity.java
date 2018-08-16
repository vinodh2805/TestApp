package com.in.ia3solution.testapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    final long period = 5000;
    int silver_bar_rtgs_min = 38670;
    int silver_bar_rtgs_max = 38680;

    int silver_bar_retail_max = 38780;
    int silver_bar_retail_min = 38770;

    int GOLD_BID_INR_MAX = 29900;
    int GOLD_BID_INR_MIN = 29700;

    int GOLD_ASK_INR_MAX = 29900;
    int GOLD_ASK_INR_MIN = 29750;

    int SILVER_ASK_INR_MAX = 37900;
    int SILVER_ASK_INR_MIN = 37800;

    float gold_bid_max = 1195.50f;
    float gold_bid_min = 1193.50f;

    float gold_ask_max = 1195.50f;
    float gold_ask_min = 1192.50f;

    float silver_bid_max = 17.50f;
    float silver_bid_min = 15.50f;

    float silver_ask_max = 17.50f;
    float silver_ask_min = 15.50f;

    float bid_dollar_max = 70.50f;
    float bid_dollar_min = 68.50f;

    float ask_dollar_max = 71.50f;
    float ask_dollar_min = 69.50f;

    TextView row2_col3,row3_col3,table2data_row1_col2,table2data_row1_col3,table2data_row2_col2,table2data_row2_col3,table2data3_row3_col2,table2data3_row3_col3;
    TextView table3data_row1_col2,table3data_row1_col3,table3data_row2_col2,table3data_row2_col3;
    Handler handler;
    int delay = 5000; //milliseconds

    int preNumder =Constants.SILVER_BAR_RTGS;
    int preNumder_SILVER_RETAIL =Constants.SILVER_BAR_RETAIL;
    int preNumder_GOLD_BID_INR =Constants.Gold_Bid_INR;
    int preNumder_GOLD_ASK_INR =Constants.Gold_ASK_INR;
    int preNumder_SILVER_ASK_INR =Constants.SILVER_ASK_INR;
    int preNumder_SILVER_BID_INR =Constants.SILVER_BID_INR;
    float preNumder_gold_bid=Constants.bid_gold;
    float preNumder_gold_ask=Constants.ask_gold;
    float preNumder_silver_bid=Constants.bid_silver;
    float preNumder_silver_ask=Constants.ask_silver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        row2_col3 = (TextView) findViewById(R.id.row2_col3);
        row3_col3 = (TextView) findViewById(R.id.row3_col3);
        table2data_row1_col2 = (TextView) findViewById(R.id.table2data_row1_col2);
        table2data_row1_col3 = (TextView) findViewById(R.id.table2data_row1_col3);
        table2data_row2_col2 = (TextView) findViewById(R.id.table2data_row2_col2);
        table2data_row2_col3 = (TextView) findViewById(R.id.table2data_row2_col3);
        table2data3_row3_col2 = (TextView) findViewById(R.id.table2data3_row3_col2);
        table2data3_row3_col3 = (TextView) findViewById(R.id.table2data3_row3_col3);
        table3data_row1_col2 = (TextView) findViewById(R.id.table3data_row1_col2);
        table3data_row1_col3 = (TextView) findViewById(R.id.table3data_row1_col3);
        table3data_row2_col2 = (TextView) findViewById(R.id.table3data_row2_col2);
        table3data_row2_col3 = (TextView) findViewById(R.id.table3data_row2_col3);



        handler = new Handler(){
            @Override
            public void handleMessage(Message msg)
            {
                super.handleMessage(msg);
                Random rsilver_bar = new Random();
                int silver_bar_rtgs = rsilver_bar.nextInt(silver_bar_rtgs_max - silver_bar_rtgs_min  + 1) + silver_bar_rtgs_min;
                Log.d("hello world","hello world"+silver_bar_rtgs);
                if(preNumder<silver_bar_rtgs)
                {
                    row2_col3.setText(""+silver_bar_rtgs);
                    row2_col3.setTextColor(getResources().getColor(R.color.green));
                    preNumder=silver_bar_rtgs;
                }
                else
                {
                    row2_col3.setText(""+silver_bar_rtgs);
                    row2_col3.setTextColor(getResources().getColor(R.color.red));
                    preNumder=silver_bar_rtgs;

                }
                Random r = new Random();
                int silver_bar_retail = r.nextInt(silver_bar_retail_max - silver_bar_retail_min  + 2) + silver_bar_retail_min;
                Log.d("hello world_bar","hello world_bar"+silver_bar_retail);
                if(preNumder_SILVER_RETAIL<silver_bar_retail)
                {
                    row3_col3.setText(""+silver_bar_retail);
                    row3_col3.setTextColor(getResources().getColor(R.color.green));
                    preNumder_SILVER_RETAIL=silver_bar_retail;
                }
                else
                {
                    row3_col3.setText(""+silver_bar_retail);
                    row3_col3.setTextColor(getResources().getColor(R.color.red));
                    preNumder_SILVER_RETAIL=silver_bar_retail;

                }

                Random bid_gold = new Random();
                float gold_bid_random = gold_bid_min + bid_gold.nextFloat() * (gold_bid_max - gold_bid_min);
                if(preNumder_gold_bid<gold_bid_random)
                {
                    table2data_row1_col2.setText(""+String.format("%.2f", gold_bid_random));
                    table2data_row1_col2.setTextColor(getResources().getColor(R.color.green));
                    preNumder_gold_bid=gold_bid_random;
                }
                else
                {
                    table2data_row1_col2.setText(""+String.format("%.2f", gold_bid_random));
                    table2data_row1_col2.setTextColor(getResources().getColor(R.color.red));
                    preNumder_gold_bid=gold_bid_random;

                }
                Random ask_gold = new Random();
                float gold_ask_random = gold_ask_min + ask_gold.nextFloat() * (gold_ask_max - gold_ask_min);
                if(preNumder_gold_ask<gold_ask_random)
                {
                    table2data_row1_col3.setText(""+String.format("%.2f", gold_ask_random));
                    table2data_row1_col3.setTextColor(getResources().getColor(R.color.green));
                    preNumder_gold_ask=gold_ask_random;
                }
                else
                {
                    table2data_row1_col3.setText(""+String.format("%.2f", gold_ask_random));
                    table2data_row1_col3.setTextColor(getResources().getColor(R.color.red));
                    preNumder_gold_ask=gold_ask_random;

                }

                Random bid_silver = new Random();
                float bid_silver_random = silver_bid_min + bid_silver.nextFloat() * (silver_bid_max - silver_bid_min);
                if(preNumder_silver_bid<bid_silver_random)
                {
                    table2data_row2_col2.setText(""+String.format("%.2f", bid_silver_random));
                    table2data_row2_col2.setTextColor(getResources().getColor(R.color.green));
                    preNumder_silver_bid=bid_silver_random;
                }
                else
                {
                    table2data_row2_col2.setText(""+String.format("%.2f", bid_silver_random));
                    table2data_row2_col2.setTextColor(getResources().getColor(R.color.red));
                    preNumder_silver_bid=bid_silver_random;

                }

                Random ask_silver = new Random();
                float ask_silver_random = silver_ask_min + ask_silver.nextFloat() * (silver_ask_max - silver_ask_min);
                if(preNumder_silver_ask<ask_silver_random)
                {
                    table2data_row2_col3.setText(""+String.format("%.2f", ask_silver_random));
                    table2data_row2_col3.setTextColor(getResources().getColor(R.color.green));
                    preNumder_silver_ask=ask_silver_random;
                }
                else
                {
                    table2data_row2_col3.setText(""+String.format("%.2f", ask_silver_random));
                    table2data_row2_col3.setTextColor(getResources().getColor(R.color.red));
                    preNumder_silver_ask=ask_silver_random;

                }

                Random bid_dollar = new Random();
                float bid_dollar_random = bid_dollar_min + bid_dollar.nextFloat() * (bid_dollar_max - bid_dollar_min);

                table2data3_row3_col2.setText(""+String.format("%.2f", bid_dollar_random));

                Random ask_dollar = new Random();
                float ask_dollar_random = ask_dollar_min + ask_dollar.nextFloat() * (ask_dollar_max - ask_dollar_min);

                table2data3_row3_col3.setText(""+String.format("%.2f", ask_dollar_random));

                Random gold_bid_inr_ran = new Random();
                int gold_bid_inr = gold_bid_inr_ran.nextInt(GOLD_BID_INR_MAX - GOLD_BID_INR_MIN  + 2) + GOLD_BID_INR_MIN;

                if(preNumder_GOLD_BID_INR<gold_bid_inr)
                {
                    table3data_row1_col2.setText(""+gold_bid_inr);
                    table3data_row1_col2.setTextColor(getResources().getColor(R.color.green));
                    preNumder_GOLD_BID_INR=gold_bid_inr;
                }
                else
                {
                    table3data_row1_col2.setText(""+gold_bid_inr);
                    table3data_row1_col2.setTextColor(getResources().getColor(R.color.red));
                    preNumder_GOLD_BID_INR=gold_bid_inr;

                }

                Random gold_ask_inr_ran = new Random();
                int gold_ask_inr = gold_ask_inr_ran.nextInt(GOLD_ASK_INR_MAX - GOLD_ASK_INR_MIN  + 2) + GOLD_ASK_INR_MIN;

                if(preNumder_GOLD_ASK_INR<gold_ask_inr)
                {
                    table3data_row1_col3.setText(""+gold_ask_inr);
                    table3data_row1_col3.setTextColor(getResources().getColor(R.color.green));
                    preNumder_GOLD_ASK_INR=gold_ask_inr;
                }
                else
                {
                    table3data_row1_col3.setText(""+gold_ask_inr);
                    table3data_row1_col3.setTextColor(getResources().getColor(R.color.red));
                    preNumder_GOLD_ASK_INR=gold_ask_inr;

                }

                Random silver_ask_inr_ran = new Random();
                int silver_ask_inr = silver_ask_inr_ran.nextInt(SILVER_ASK_INR_MAX - SILVER_ASK_INR_MIN  + 2) + SILVER_ASK_INR_MIN;

                if(preNumder_SILVER_ASK_INR<silver_ask_inr)
                {
                    table3data_row2_col2.setText(""+silver_ask_inr);
                    table3data_row2_col2.setTextColor(getResources().getColor(R.color.green));
                    preNumder_SILVER_ASK_INR=silver_ask_inr;
                }
                else
                {
                    table3data_row2_col2.setText(""+silver_ask_inr);
                    table3data_row2_col2.setTextColor(getResources().getColor(R.color.red));
                    preNumder_SILVER_ASK_INR=silver_ask_inr;

                }

                Random silver_bid_inr_ran = new Random();
                int silver_bid_inr = silver_bid_inr_ran.nextInt(SILVER_ASK_INR_MAX - SILVER_ASK_INR_MIN  + 2) + SILVER_ASK_INR_MIN;

                if(preNumder_SILVER_BID_INR<silver_ask_inr)
                {
                    table3data_row2_col3.setText(""+silver_bid_inr);
                    table3data_row2_col3.setTextColor(getResources().getColor(R.color.green));
                    preNumder_SILVER_BID_INR=silver_ask_inr;
                }
                else
                {
                    table3data_row2_col3.setText(""+silver_bid_inr);
                    table3data_row2_col3.setTextColor(getResources().getColor(R.color.red));
                    preNumder_SILVER_BID_INR=silver_ask_inr;

                }


            }
        };


        handler.postDelayed(new Runnable(){
            public void run(){
                //do something

                handler.postDelayed(this, delay);
                handler.sendMessage(new Message());
            }
        }, delay);
    }
}
