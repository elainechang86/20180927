package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameText;
    TextView enterView;
    RadioButton y;
    RadioButton o;
    RadioButton five;
    RadioGroup radioGroup;
    Button startButton;
    TextView nameView;
    TextView nameView2;
    TextView winnerView;
    TextView winnerView2;
    TextView cpuView;
    TextView cpuView2;
    TextView meView;
    TextView meView2;

    int gamer = -1;
    String[] MoraString = {"剪刀", "石頭", "布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText) findViewById(R.id.nameText);
        enterView = (TextView) findViewById(R.id.enterView);
        y = (RadioButton)findViewById(R.id.y);
        o = (RadioButton)findViewById(R.id.o);
        five = (RadioButton)findViewById(R.id.five);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        startButton = (Button) findViewById(R.id.startButton);
        nameView2 = (TextView) findViewById(R.id.nameView2);
        winnerView2 = (TextView)findViewById(R.id.winnerView2);
        meView2 = (TextView)findViewById(R.id.meView2);
        cpuView2 = (TextView)findViewById(R.id.cpuView2);

        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final TextView enterView = (TextView) findViewById(R.id.enterView);
        Button  play = (Button) findViewById(R.id.startButton);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.five:
                        gamer = 2;
                        break;
                    case  R.id.o:
                        gamer = 1;
                        break;
                    case R.id.y:
                        gamer = 0;
                        break;
                }
            }
        });
        Button button = (Button) findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameText.getText().toString().equals(""))
                    enterView.setText("請選擇玩家名稱");
                else if (gamer == -1)
                    enterView.setText("請選擇出拳的種類");
                else{
                    nameView2.setText(nameText.getText());
                    meView2.setText(MoraString[gamer]);
                    int mora_computer = (int)(Math.random()*3);
                    cpuView2.setText(MoraString[mora_computer]);
                    if ((gamer==0 && mora_computer==1)||(gamer==1 && mora_computer==2)||(gamer==2 && mora_computer==0)){
                        winnerView2.setText("電腦");
                        enterView.setText("可惜，電腦獲勝了");
                    } else if (mora_computer == gamer){
                        winnerView2.setText("平局");
                        enterView.setText("平局!再試一場看看");
                    } else {
                        winnerView2.setText(nameText.getText());
                        enterView.setText("恭喜你獲勝了");
                    }
                }
            }
        });

    }
}
