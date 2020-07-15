package com.example.qrattend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    public static final String GOOGLE_ACCOUNT = "google_account";
    private TextView profileName, profileEmail;
    private ImageView profileImage;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profile_text);
        profileEmail = findViewById(R.id.profile_email);
        profileImage = findViewById(R.id.profile_image);
        signOut = findViewById(R.id.sign_out);
    }

    private void setDataOnView() {
        GoogleSignInAccount googleSignInAccount = getIntent().getParcelableExtra(GOOGLE_ACCOUNT);
        Picasso.get().load(googleSignInAccount.getPhotoUrl()).centerInside().fit().into(profileImage);
        profileName.setText(googleSignInAccount.getDisplayName());
        profileEmail.setText(googleSignInAccount.getEmail());
    }
//    signOut.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//          /*
//          Sign-out is initiated by simply calling the googleSignInClient.signOut API. We add a
//          listener which will be invoked once the sign out is the successful
//           */
//            googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    //On Succesfull signout we navigate the user back to LoginActivity
//                    Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//                }
//            });
//        }
//    });
}
