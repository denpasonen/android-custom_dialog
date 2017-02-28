package com.saki.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView text;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_member:

                LayoutInflater inflater = getLayoutInflater();

                final View dialogView = inflater.inflate(R.layout.dialog_addmember, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Member Information");
                builder.setIcon(android.R.mipmap.sym_def_app_icon);
                builder.setView(dialogView);
                builder.setPositiveButton("Complite", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText edit_name = (EditText) dialogView.findViewById(R.id.dialog_edit);
                        RadioGroup rg = (RadioGroup) dialogView.findViewById(R.id.dialog_rg);

                        String name = edit_name.getText().toString();
                        int checkedId = rg.getCheckedRadioButtonId();

                        RadioButton rb = (RadioButton) rg.findViewById(checkedId);
                        String nation = rb.getText().toString();

                        String s = name + "  " + nation + "\n";
                        str += s;
                        text.setText(str);

                        Toast.makeText(MainActivity.this, "새로운 멤버 추가", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "멤버 추가 취소", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();

                dialog.setCanceledOnTouchOutside(false);

                dialog.show();

                break;
        }
    }
}
