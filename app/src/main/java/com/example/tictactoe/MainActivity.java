package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    // -1 for empty 0 for cross and 1 for zero
    int[] gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fadeIN(View view) {
        ImageView counter = (ImageView) view;

        int pos = Integer.parseInt(counter.getTag().toString());

        if(gameState[pos]==-1 && gameActive) {
            gameState[pos] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.cross);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.zero);
                activePlayer = 0;
            }
            counter.animate().alpha(1).scaleY(1f).scaleX(1f).setDuration(700);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != -1) {

                    // Someone has won!
                    String winner;
                    gameActive = false;
                    if (activePlayer == 0)
                        winner = "Zero";
                    else
                        winner = "Cross";
                    Toast.makeText(getApplicationContext(), winner + " has won!!", Toast.LENGTH_SHORT).show();
                }

            }
        }

     }
}
