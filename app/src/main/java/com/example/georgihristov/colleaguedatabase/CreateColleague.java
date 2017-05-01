package com.example.georgihristov.colleaguedatabase;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class CreateColleague extends AppCompatActivity implements View.OnClickListener{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_LOAD = 2;

    private EditText nameEditText;
    private EditText titleEditText;
    private EditText phoneEditText;
    private EditText skypeEditText;
    private EditText emailEditText;
    private Button saveButton;
    private ImageView avatarImageView;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference("colleague");
    private boolean[] check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcolleague_activity);

        bindView();
        textListeners();
        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if (check[0] && check[1] && check[2] && check[3] && check[4]) {
                reference.push().setValue(addColleague());
                finish();
            } else {
                Toast.makeText(this, "Please enter the values correctly", Toast.LENGTH_SHORT).show();
            }
    }

    private void bindView(){
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        skypeEditText = (EditText) findViewById(R.id.skypeEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        avatarImageView = (ImageView) findViewById(R.id.avatarImageView);
        saveButton = (Button) findViewById(R.id.saveButton);
    }

    private Colleague addColleague(){
        String name = nameEditText.getText().toString();
        String title = titleEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String skype = skypeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String picture = "http://blog.teamtreehouse.com/wp-content/themes/treehouse-treehouse-blog-reboot-d52be032409979219bf3dc804312e918a26a251c/img/treehouse-ads/android-dev.png";

        return new Colleague(name,picture,title,phone,skype,email);
    }

    private void textListeners(){
        check = new boolean[5];
        nameEditText.addTextChangedListener(new TextValidator(nameEditText) {
            @Override
            public void validate(EditText editText, String text) {
                text = editText.getText().toString();
                if (text.length() == 0){
                    editText.setError("Please enter a name");
                }
                else if (text.length() < 4 ){
                   editText.setError("Name needs to be at least 4 characters long");
                }else if (text.length() > 4){
                    check[0] = true;
                }
            }
        });
        titleEditText.addTextChangedListener(new TextValidator(titleEditText) {
            @Override
            public void validate(EditText editText, String text) {
                text = editText.getText().toString();
                if (text.length() == 0){
                    editText.setError("Please enter a title");
                }
                else if (text.length() < 4 ){
                    editText.setError("title needs to be at least 4 characters long");
                }else if (text.length() > 4){
                    check[1] = true;
                }
            }
        });
        phoneEditText.addTextChangedListener(new TextValidator(phoneEditText) {
            @Override
            public void validate(EditText editText, String text) {
                text = editText.getText().toString();
                if (text.length() == 0){
                    editText.setError("Please enter a phone number");
                }
                else if (text.length() < 8 ){
                    editText.setError("Phone number needs to be at least 8 characters long");
                }else if (text.length() > 8){
                    check[2] = true;
                }
            }
        });
        skypeEditText.addTextChangedListener(new TextValidator(skypeEditText) {
            @Override
            public void validate(EditText editText, String text) {
                text = editText.getText().toString();
                if (text.length() == 0){
                    editText.setError("Please enter a Skype Account");
                }
                else if (text.length() < 5 ){
                    editText.setError("Skype Account needs to be at least 5 characters long");
                }else if (text.length() > 5){
                    check[3] = true;
                }
            }
        });
        emailEditText.addTextChangedListener(new TextValidator(emailEditText) {
            @Override
            public void validate(EditText editText, String text) {
                text = editText.getText().toString();
                if (text.length() == 0){
                    editText.setError("Please enter a email address");
                }
                else if (text.length() < 10 && !text.contains("@")){
                    editText.setError("please enter a valid email address");
                }else if (text.length() > 10){
                    check[4] = true;
                }
            }
        });
    }



}
