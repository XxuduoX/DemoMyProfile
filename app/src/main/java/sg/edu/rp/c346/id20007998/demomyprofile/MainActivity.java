package sg.edu.rp.c346.id20007998.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.inputName);
        etGPA=findViewById(R.id.inputGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName=etName.getText().toString();
        Float floatGPA=Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit=prefs.edit();
        prefEdit.putString("Name",strName);
        prefEdit.putFloat("GPA",floatGPA);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        String name=prefs.getString("Name","N.A");
        float GPA=prefs.getFloat("GPA",0.0f);
        etName.setText(name);
        etGPA.setText(GPA+"");
    }
}