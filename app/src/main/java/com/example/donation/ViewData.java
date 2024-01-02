package com.example.donation;


        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class ViewData extends AppCompatActivity {
    //ListView lv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        //lv=findViewById(R.id.lv);
        tv=findViewById(R.id.tv);

        String user = getIntent().getStringExtra("key");
        tv.setText(user);





    }
}