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

            adapter = new BagianAdapter(this, listBagian);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spBagian.setAdapter(adapter);

            spJabatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                    listBagian.clear();
                    listBagian.addAll(Arrays.asList(arBagian[pos]));
                    adapter.setJabatan((String)spJabatan.getItemAtPosition(pos));
                    adapter.notifyDataSetChanged();
                    spBagian.setSelection(0);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            bOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doProcess();
                    doClick();
                    doCheck();
                    doSelect();

                }
            });

            rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int i) {
                    if(i == R.id.radioButtonBM)
                    {
                        findViewById(R.id.tilJA).setVisibility(View.GONE);
                    }
                    else
                    {
                        findViewById(R.id.tilJA).setVisibility(View.VISIBLE);
                    }
                }
            });
        }


        private void doSelect() {
            tvHasil4.setText("Jabatan : " + spJabatan.getSelectedItem().toString()
                    +" bagian "+spBagian.getSelectedItem().toString());
        }

        private void doCheck() {
            String ahli = "Bidang Keahlian: ";
            int startlen = ahli.length();
            if(cbP.isChecked()) ahli+=cbP.getText()+" ";
            if(cbI.isChecked()) ahli+=cbI.getText()+" ";
            if(cbT.isChecked()) ahli+=cbT.getText()+" ";

            if(ahli.length()==startlen) ahli+="Tidak ada pada pilihan";
            tvHasil3.setText(ahli);
        }

        private void doClick() {
            String status = null;
            if (rgStatus.getCheckedRadioButtonId()!=-1)
            {
                RadioButton rb = (RadioButton) findViewById(rgStatus.getCheckedRadioButtonId());
                status = rb.getText().toString();

                if(rgStatus.getCheckedRadioButtonId()!=R.id.radioButtonBM)
                {
                    EditText etJA = (EditText) findViewById(R.id.editTextJA);
                    status += " dengan anak berjumlah : " + etJA.getText();
                }
            }

            if (status == null)
            {tvHasil2.setText("Belum memiih Status");}
            else
            {tvHasil2.setText("Status Anda : " +status);}
        }

        private void doProcess() {
            if(isValid())
            {
                String nama = etNama.getText().toString();
                String pengalaman = etPengalaman.getText().toString();
                tvHasil.setText("\nNama : " + nama + "\nPengalaman Kerja : " + pengalaman + " tahun");
            }
        }

        private boolean isValid() {
            boolean valid = true;

            String nama = etNama.getText().toString();
            String pengalaman = etPengalaman.getText().toString();

            if(nama.isEmpty())
            {
                etNama.setError("Nama belum diisi");
                valid = false;
            }
            else if(nama.length()<3)
            {
                etNama.setError("Nama minimal 3 karakter");
                valid = false;
            }
            else
            {
                etNama.setError(null);
            }

            if(pengalaman.isEmpty())
            {
                etPengalaman.setError("Tahun pengalaman belum diisi");
                valid = false;
            }
            else
            {
                etPengalaman.setError(null);
            }

            return valid;
        }

    }

