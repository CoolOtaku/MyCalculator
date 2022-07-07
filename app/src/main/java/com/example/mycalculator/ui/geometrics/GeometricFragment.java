package com.example.mycalculator.ui.geometrics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mycalculator.R;
import com.example.mycalculator.databinding.FragmentGeometricsBinding;

public class GeometricFragment extends Fragment implements View.OnClickListener{

    private FragmentGeometricsBinding binding;
    View root;

    RadioGroup rg = null;
    RadioButton rb = null;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGeometricsBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        rg = (RadioGroup) root.findViewById(R.id.rGrp);
        rb = (RadioButton) root.findViewById(R.id.rbSquare);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton) root.findViewById(checkedId);
            }
        });

        root.findViewById(R.id.calculate).setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        EditText lEdit1 = (EditText) root.findViewById(R.id.length1);
        EditText lEdit2 = (EditText) root.findViewById(R.id.length2);
        TextView areaField = (TextView) root.findViewById(R.id.areaVal);
        int id = rg.getCheckedRadioButtonId();
        if(id == R.id.rbSquare){
            try{
                double area = Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit1.getText().toString());
                areaField.setText(""+area);
                lEdit2.setText("");
            } catch (NumberFormatException e) {
                showToastMessage("Введіть дійсні дані");
            }
        } else if(id == R.id.rbCircle) {
            try{
                double area = 3.14 * Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit1.getText().toString());
                areaField.setText(""+area);
                lEdit2.setText("");
            } catch (NumberFormatException e) {
                showToastMessage("Введіть дійсні дані");
            }
        } else if(id == R.id.rbRectangle) {
            try{
                double area = Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit2.getText().toString());
                areaField.setText(""+area);
            } catch (NumberFormatException e) {
                showToastMessage("Введіть дійсні дані");
            }
        } else if(id == R.id.rbTriangle) {
            try{
                double area = 0.5 * Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit2.getText().toString());
                areaField.setText(""+area);
            } catch (NumberFormatException e) {
                showToastMessage("Введіть дійсні дані");
            }
        } else  {
            lEdit1.setText("");
            lEdit2.setText("");
            areaField.setText("");
        }
    }

    public void showToastMessage(String message){
        Toast.makeText(root.getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}