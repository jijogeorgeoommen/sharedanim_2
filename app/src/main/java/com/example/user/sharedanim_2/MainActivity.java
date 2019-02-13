package com.example.user.sharedanim_2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CircleImageView imageView=findViewById(R.id.ironimage);
        final TextView textView=findViewById(R.id.irontext);
        imageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent shared=new Intent(MainActivity.this,Main2Activity.class);
                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(imageView,"imagetrans");
                pairs[1]=new Pair<View,String>(textView,"texttrans");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(shared,options.toBundle());
            }
        });
    }
}
