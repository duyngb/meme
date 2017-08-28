package tykp.fed.knowyourmeme;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDone = (Button) findViewById(R.id.btn_done);
        heightInput = (EditText) findViewById(R.id.input_height);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnAnswer(heightInput.getText().toString(), v);
            }
        });
    }

    private void returnAnswer(String height, View v) {
        // create dialog context
        Context context = new android.view.ContextThemeWrapper(this, R.style.MyDialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(getString(R.string.resultsWoW, height))
                .setTitle("WoW")
                .setCancelable(true);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                heightInput.setText("", TextView.BufferType.NORMAL);
                dialog.cancel();
            }
        });

        AlertDialog alert11 = builder.create();
        alert11.show();
    }
}
