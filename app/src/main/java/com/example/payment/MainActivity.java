package com.example.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button btnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    switch (compoundButton.getId()) {
                        case R.id.bankCardChkBx:
                            resetCheckBoxes();
                            mBankCardChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            break;
                        case R.id.mobilePhoneChkBx:
                            resetCheckBoxes();
                            mMobilePhoneChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                        case R.id.cashAddressChkBx:
                            resetCheckBoxes();
                            mCashAddressChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            break;
                        default:
                    }
                }
            }
        };
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mes = "";
                if (mBankCardChkBx.isChecked()) {
                    mes = getString(R.string.bankCardChkBx);
                }else if (mCashAddressChkBx.isChecked()){
                    mes = getString(R.string.cashAddressChkBx);
                }else if(mMobilePhoneChkBx.isChecked()){
                    mes = getString(R.string.mobilePhoneChkBx);
                }
                Toast.makeText(MainActivity.this, getString(R.string.message) + " " + mes, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void init() {
        mInputInfo = findViewById(R.id.inputInfo);
        mInputMoney = findViewById(R.id.inputMoney);
        btnOk = findViewById(R.id.btnOk);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);

    }

    private void resetCheckBoxes(){
        mInputInfo.getText().clear();
        mCashAddressChkBx.setChecked(false);
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
    }
}
