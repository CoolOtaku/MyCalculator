package com.example.mycalculator.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.mycalculator.R;
import com.example.mycalculator.databinding.FragmentHomeBinding;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    static double res = 0;
    static int i1 = 0;
    static int i2 = 0;
    static ArrayList<Double> num = new ArrayList<Double>();
    static ArrayList<String> diya = new ArrayList<String>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        num.add(0, (double) 0);
        final EditText et = (EditText) root.findViewById(R.id.et);
        Button b1 = (Button) root.findViewById(R.id.b1);
        Button b2 = (Button) root.findViewById(R.id.b2);
        Button b3 = (Button) root.findViewById(R.id.b3);
        Button b4 = (Button) root.findViewById(R.id.b4);
        Button b5 = (Button) root.findViewById(R.id.b5);
        Button b6 = (Button) root.findViewById(R.id.b6);
        Button b7 = (Button) root.findViewById(R.id.b7);
        Button b8 = (Button) root.findViewById(R.id.b8);
        Button b9 = (Button) root.findViewById(R.id.b9);
        Button b0 = (Button) root.findViewById(R.id.b0);
        Button bPlus = (Button) root.findViewById(R.id.bPlus);
        Button bMinus = (Button) root.findViewById(R.id.bMinus);
        Button bMnojenya = (Button) root.findViewById(R.id.bMnojenya);
        Button bDilenya = (Button) root.findViewById(R.id.bDilenya);
        Button bRes = (Button) root.findViewById(R.id.bRes);
        Button bClear = (Button) root.findViewById(R.id.bClear);
        Button bc = (Button) root.findViewById(R.id.bc);
        final TextView nr = (TextView) root.findViewById(R.id.nr);
        final TextView textView7 = (TextView) root.findViewById(R.id.textView7);
        Button bBack = (Button) root.findViewById(R.id.bBack);

        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder bf = new StringBuilder("");
                switch (v.getId()){
                    case R.id.b1:
                        bf.append(et.getText());
                        bf.append("1");
                        et.setText(bf);
                        break;
                    case R.id.b2:
                        bf.append(et.getText());
                        bf.append("2");
                        et.setText(bf);
                        break;
                    case R.id.b3:
                        bf.append(et.getText());
                        bf.append("3");
                        et.setText(bf);
                        break;
                    case R.id.b4:
                        bf.append(et.getText());
                        bf.append("4");
                        et.setText(bf);
                        break;
                    case R.id.b5:
                        bf.append(et.getText());
                        bf.append("5");
                        et.setText(bf);
                        break;
                    case R.id.b6:
                        bf.append(et.getText());
                        bf.append("6");
                        et.setText(bf);
                        break;
                    case R.id.b7:
                        bf.append(et.getText());
                        bf.append("7");
                        et.setText(bf);
                        break;
                    case R.id.b8:
                        bf.append(et.getText());
                        bf.append("8");
                        et.setText(bf);
                        break;
                    case R.id.b9:
                        bf.append(et.getText());
                        bf.append("9");
                        et.setText(bf);
                        break;
                    case R.id.b0:
                        bf.append(et.getText());
                        bf.append("0");
                        et.setText(bf);
                        break;
                    case R.id.bc:
                        bf.append(et.getText());
                        bf.append(".");
                        et.setText(bf);
                        break;
                    case R.id.bBack:
                        try {
                            bf.append(et.getText());
                            int p = bf.length() - 1;
                            bf.deleteCharAt(p);
                            et.setText(bf);
                        }catch (Exception e){
                            diya.clear();
                            num.clear();
                            num.add(0, (double) 0);
                            i1=0;
                            i2=0;
                        }
                        break;
                    case R.id.bPlus:
                        bf.append(et.getText());
                        bf.append("+");
                        et.setText(bf);
                        break;
                    case R.id.bMinus:
                        bf.append(et.getText());
                        bf.append("-");
                        et.setText(bf);
                        break;
                    case R.id.bMnojenya:
                        bf.append(et.getText());
                        bf.append("*");
                        et.setText(bf);
                        break;
                    case R.id.bDilenya:
                        bf.append(et.getText());
                        bf.append("/");
                        et.setText(bf);
                        break;
                    case R.id.bRes:
                        String s = String.valueOf(et.getText());
                        StringTokenizer st = new StringTokenizer(s,"+-*/",true);
                        while(st.hasMoreTokens()) {
                            String s1 = st.nextToken();
                            try{
                                double p1 = Double.parseDouble(s1);
                                num.add(i2,p1);
                            }catch(NumberFormatException en) {
                                diya.add(i1,s1);
                                i1++;
                                i2++;
                            }
                        }
                        try{
                            for(int i1=0;i1<diya.size();i1++) {
                                if(diya.get(i1).equals("+")) {
                                    num.set(i1+1,num.get(i1)+num.get(i1+1));
                                }
                                if(diya.get(i1).equals("-")) {
                                    num.set(i1+1,num.get(i1)-num.get(i1+1));
                                }
                                if(diya.get(i1).equals("*")) {
                                    num.set(i1+1,num.get(i1)*num.get(i1+1));
                                }
                                if(diya.get(i1).equals("/")) {
                                    num.set(i1+1,num.get(i1)/num.get(i1+1));
                                }
                                res=num.get(i1+1);
                            }
                            et.setText(String.valueOf(res));
                            nr.setText(String.valueOf(res));
                            num.clear();
                            diya.clear();
                            num.add(0, (double) 0);
                            i1=0;
                            i2=0;
                        }catch (Exception e2){
                            nr.setText(R.string.error);
                            et.setText("");
                            diya.clear();
                            num.clear();
                            num.add(0, (double) 0);
                            i1=0;
                            i2=0;
                        }
                        break;
                    case R.id.bClear:
                        et.setText("");
                        nr.setText("");
                        diya.clear();
                        num.clear();
                        num.add(0, (double) 0);
                        i1=0;
                        i2=0;
                        break;
                }
            }
        };
        b1.setOnClickListener(l);
        b2.setOnClickListener(l);
        b3.setOnClickListener(l);
        b4.setOnClickListener(l);
        b5.setOnClickListener(l);
        b6.setOnClickListener(l);
        b7.setOnClickListener(l);
        b8.setOnClickListener(l);
        b9.setOnClickListener(l);
        b0.setOnClickListener(l);
        bPlus.setOnClickListener(l);
        bMinus.setOnClickListener(l);
        bMnojenya.setOnClickListener(l);
        bDilenya.setOnClickListener(l);
        bRes.setOnClickListener(l);
        bClear.setOnClickListener(l);
        bc.setOnClickListener(l);
        bBack.setOnClickListener(l);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}