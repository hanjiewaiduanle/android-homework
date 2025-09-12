package com.example.newbee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner avatarSpinner;
    private int selectedAvatarResId = R.drawable.avatar1; // 默认头像

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化头像下拉列表
        initAvatarSpinner();

        Button loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建跳转到欢迎界面的Intent，并传递选择的头像
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("avatar_res_id", selectedAvatarResId);
                startActivity(intent);
            }
        });
    }

    private void initAvatarSpinner() {
        avatarSpinner = findViewById(R.id.avatar_spinner);

        // 创建头像列表
        ArrayList<AvatarItem> avatarList = new ArrayList<>();
        avatarList.add(new AvatarItem(R.drawable.avatar1, "头像1"));
        avatarList.add(new AvatarItem(R.drawable.avatar2, "头像2"));
        avatarList.add(new AvatarItem(R.drawable.avatar3, "头像3"));
        avatarList.add(new AvatarItem(R.drawable.avatar4, "头像4"));
        avatarList.add(new AvatarItem(R.drawable.avatar5, "头像5"));

        AvatarSpinnerAdapter adapter = new AvatarSpinnerAdapter(this, avatarList);
        avatarSpinner.setAdapter(adapter);

        avatarSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvatarItem selectedItem = (AvatarItem) parent.getItemAtPosition(position);
                selectedAvatarResId = selectedItem.getImageResId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}