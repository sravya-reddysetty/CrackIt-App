package com.example.sys1.prescriptor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sys1 on 9/29/2017.
 */

public class Diseases extends Fragment{
    View v;
    Spinner sp;
    TextView tv1,tv2,tv3;
    String[] s={"SELECT DISEASE","cold","cough","fever"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.disease,container,false);
        sp=(Spinner) v.findViewById(R.id.sp);
        tv1=(TextView)v.findViewById(R.id.t1);
        tv2=(TextView)v.findViewById(R.id.t2);
        tv3=(TextView)v.findViewById(R.id.t3);
        ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,s);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                       // Toast.makeText(getActivity(),"Cold",Toast.LENGTH_LONG).show();
                        tv1.setText("FORMULA   : Levacetrizine Hydrochloride");
                        tv2.setText("Medicines  : Cetrizen");
                        tv3.setText("             FebrexPlus");
                        break;
                    case 2:
                        //Toast.makeText(getActivity(),"Cough",Toast.LENGTH_LONG).show();
                        tv1.setText("FORMULA   : Bromohexyne HCL");
                        tv2.setText("Medicines  : Kufril");
                        tv3.setText("             Ascoril");
                        break;
                    case 3:
                        //Toast.makeText(getActivity(),"Fever",Toast.LENGTH_LONG).show();
                        tv1.setText("FORMULA   :Paracetemol");
                        tv2.setText("Medicines  :Crocin  ");
                        tv3.setText("            Calpol ");
                        break;
                    default:
                        Toast.makeText(getActivity(),"NO SUCH DISEASE", Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }
}
