package id.sch.smktelkom_mlg.tugas01.xiirpl1038.datapegawai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.tugas01.xiirpl1038.datapegawai.R;

/**
 * Created by TrischaNL on 9/8/2016.
 */
public class BagianAdapter extends ArrayAdapter<String>
{
    String mJabatan = "";
    public BagianAdapter(Context context, ArrayList<String> listBagian)
    {
        super(context, R.layout.row_spinner_bagian, listBagian);
    }

    public void setJabatan(String Jabatan) {
        this.mJabatan = Jabatan;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent)
    {
        if(view==null)
            view= LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_bagian, parent, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0,1));
        TextView tvBagian = (TextView) view.findViewById(R.id.textViewBagian);
        tvBagian.setText(getItem(position));
        TextView tvJabatan = (TextView) view.findViewById(R.id.textViewJabatan);
        tvJabatan.setText(mJabatan);

        return view;

    }


}
