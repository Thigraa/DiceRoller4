package com.example.diceroller4;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button rollButton,restartButton;
    ImageView diceImage, diceImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton = (Button) findViewById(R.id.roll_button);
        diceImage = (ImageView) findViewById(R.id.diceImage);
        diceImage2 = (ImageView) findViewById(R.id.diceImage2);
        restartButton = findViewById(R.id.buttonRestart);
        final Toast jackpot = Toast.makeText(this, "JACKPOT!", Toast.LENGTH_SHORT);
        diceImage.setImageResource(R.drawable.empty_dice);
        diceImage2.setImageResource(R.drawable.empty_dice);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollButton.setText("Dice Rolled");
                int dadoUno= (int)Math.floor(Math.random()*6);
                int dadoDos=(int)Math.floor(Math.random()*6);
                int [] array = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};
                diceImage.setImageResource(array[dadoUno]);
                diceImage2.setImageResource(array[dadoDos]);

            }
        });
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dadoUno= (int)Math.floor(Math.random()*6);
                if(dadoUno == 5){
                    jackpot.show();
                }
                int [] array = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};
                diceImage.setImageResource(array[dadoUno]);

            }
        });
        diceImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dadoDos= (int)Math.floor(Math.random()*6);
                int [] array = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};
                diceImage2.setImageResource(array[dadoDos]);
                if(dadoDos == 5){
                    jackpot.show();
                }
            }
        });
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceImage.setImageResource(R.drawable.empty_dice);
                diceImage2.setImageResource(R.drawable.empty_dice);
            }
        });
    }
}