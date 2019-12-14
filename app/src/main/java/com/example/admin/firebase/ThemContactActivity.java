package com.example.admin.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThemContactActivity extends AppCompatActivity {
    EditText edtID,edtTen,edtPhone,edtmon,edtKN, edtDiaChi,edtGioiTinh ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_contact);
        addControls();
    }
    private void addControls() {
        edtID=findViewById(R.id.edtID);
        edtTen=findViewById(R.id.edtTen);
        edtPhone=findViewById(R.id.edtPhone);
        edtmon=findViewById(R.id.edtmon);
        edtKN=findViewById(R.id.edtKN);
        edtDiaChi=findViewById(R.id.edtDiaChi);
        edtGioiTinh=findViewById(R.id.edtGioiTinh);
    }
    public void xuLyThemMoi(View view) {
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
//Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
            DatabaseReference myRef = database.getReference("GiaSu");
            String contactId=edtID.getText().toString();
            String ten = edtTen.getText().toString();
            String phone = edtPhone.getText().toString();
            String mon = edtmon.getText().toString();
            String KN = edtKN.getText().toString();
            String dc = edtDiaChi.getText().toString();
            String gt = edtGioiTinh.getText().toString();
            myRef.child(contactId).child("MonHoc").setValue(mon);
            myRef.child(contactId).child("SDT").setValue(phone);
            myRef.child(contactId).child("Name").setValue(ten);
            myRef.child(contactId).child("KinhNghiem").setValue(KN);
            myRef.child(contactId).child("GioiTinh").setValue(gt);
            myRef.child(contactId).child("DiaChi").setValue(dc);
            finish();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error:"+ex.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
