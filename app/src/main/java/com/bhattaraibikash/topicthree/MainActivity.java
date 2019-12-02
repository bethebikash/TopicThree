package com.bhattaraibikash.topicthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Spinner sCountry;
    AutoCompleteTextView acBatch;
    Button btnSave;
    TextView tvShow;

    public String[] batch = {"22A", "22B", "22C", "24A", "24B", "25A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        sCountry = (Spinner) findViewById(R.id.sCountry);

        String countries[] = {"Nepal", "India", "China","UK","USA"};
        ArrayAdapter adapterCountry = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                countries
        );
        sCountry.setAdapter(adapterCountry);


        acBatch = (AutoCompleteTextView) findViewById(R.id.acBatch);

        ArrayAdapter adapterBatch = new ArrayAdapter(
                this, android.R.layout.select_dialog_item,
                batch
        );

        acBatch.setAdapter(adapterBatch);
        acBatch.setThreshold(1);


        btnSave = (Button) findViewById(R.id.btnSave);
        tvShow = (TextView) findViewById(R.id.tvShow);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, country, batch, str;

                name = etName.getText().toString();
                country = sCountry.getSelectedItem().toString();
                batch = acBatch.getText().toString();
                str = "Your name is " + name + ". You are from " + country + ". Your Batch is " + batch +"\n";
                tvShow.append(str);
            }
        });
    }
}
