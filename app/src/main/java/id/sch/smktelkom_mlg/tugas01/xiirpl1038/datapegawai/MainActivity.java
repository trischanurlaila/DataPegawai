package id.sch.smktelkom_mlg.tugas01.xiirpl1038.datapegawai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkom_mlg.tugas01.xiirpl1038.datapegawai.adapter.BagianAdapter;

public class MainActivity extends AppCompatActivity
    {
        EditText etNama;
        EditText etPengalaman;
        RadioGroup rgStatus;
        CheckBox cbP, cbI, cbT;
        Spinner spJabatan, spBagian;
        Button bOK;
        TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;
        String[][] arBagian = {{" "},{"Utama","Keuangan","Personalia"},
                {"Kepegawaian","Pemasaran","Produksi"},
                {"Pemasaran","Produksi","Perlengkapan"}};
        ArrayList<String> listBagian = new ArrayList<>();
        BagianAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etNama = (EditText) findViewById(R.id.editTextNama);
            etPengalaman = (EditText) findViewById(R.id.editTextPengalaman);
            rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);

            cbP = (CheckBox) findViewById(R.id.checkBoxP);
            cbI = (CheckBox) findViewById(R.id.checkBoxI);
            cbT = (CheckBox) findViewById(R.id.checkBoxT);

            spJabatan = (Spinner) findViewById(R.id.spinnerJabatan);
            spBagian = (Spinner) findViewById(R.id.spinnerBagian);

            bOK = (Button) findViewById(R.id.buttonOK);
            tvHasil = (TextView) findViewById(R.id.textViewHasil);
            tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
            tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
            tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        }
    }
