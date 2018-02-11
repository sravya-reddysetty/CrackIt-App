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

/**
 * Created by sys1 on 9/29/2017.
 */

public class Medicines extends Fragment {
    View v;
    Spinner sp;
    TextView t;
   // String[] s={"select","cold","cough","fever"};
   String[] med={"SELECT MEDICINE","Amaxicilin","Combiflame","Ibuprofin","Paracetamol"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.medicines,container,false);
        sp=(Spinner) v.findViewById(R.id.spinner_list);
        t=(TextView)v.findViewById(R.id.text) ;
        ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,med);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        //Toast.makeText(getActivity(),"Amaxicilin",Toast.LENGTH_LONG).show();
                        t.setText("Antibiotic");
                        break;
                    case 2:
  //                      Toast.makeText(getActivity(),"Combiflame",Toast.LENGTH_LONG).show();
                        t.setText("Fever,BodyPains");
                        break;
                    case 3:
    //                    Toast.makeText(getActivity(),"Ibuprofin",Toast.LENGTH_LONG).show();
                        t.setText("Pain Killer");
                        break;
                    case 4:
      //                  Toast.makeText(getActivity(),"Paracetamol",Toast.LENGTH_LONG).show();
                        t.setText("Headache");
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

/*public class Medicines  extends Fragment{
    View v;
    Spinner sp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        sp = (Spinner) v.findViewById(R.id.spinner_list);
        String[] med={"SELECT MEDICINE","Amaxicilin","Combiflame","Ibuprofin","Paracetamol"};
        v=inflater.inflate(R.layout.medicines,container,false);
        ArrayAdapter ad=new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,med);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position)
                    {
                        case 1:
                            Toast.makeText(getActivity(),"Amaxicilin",Toast.LENGTH_LONG).show();
                        case 2:
                            Toast.makeText(getActivity(),"Combiflame",Toast.LENGTH_LONG).show();
                        case 3:
                            Toast.makeText(getActivity(),"Ibuprofin",Toast.LENGTH_LONG).show();
                        case 4:
                            Toast.makeText(getActivity(),"Paracetamol",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            return v;
        }
    }

*/






