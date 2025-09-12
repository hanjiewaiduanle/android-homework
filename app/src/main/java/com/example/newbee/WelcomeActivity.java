package com.example.newbee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // 获取传递的头像资源ID
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("avatar_res_id")) {
            int avatarResId = intent.getIntExtra("avatar_res_id", R.drawable.avatar1);
            ImageView avatarImageView = findViewById(R.id.ivWelcomeAvatar);
            avatarImageView.setImageResource(avatarResId);
        }
    }
}