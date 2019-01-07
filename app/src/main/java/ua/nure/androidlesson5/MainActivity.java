package ua.nure.androidlesson5;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private EditText pass;

    private Button btnEnter;
    private Button btnTwo;

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        textView = findViewById(R.id.tv_value);

        pass = findViewById(R.id.et_password);

        btnEnter = findViewById(R.id.btn_enter);
        btnTwo = findViewById(R.id.btn_two);

        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textView.setText("Значение: " + String.valueOf(rating));
                    }
                }
        );

        btnEnter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnEnter.setText("AntiHype");
                        Toast.makeText(MainActivity.this, pass.getText(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        btnTwo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("You want to close an application?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Close app");
                        alert.show();
                    }
                }
        );
    }
}
