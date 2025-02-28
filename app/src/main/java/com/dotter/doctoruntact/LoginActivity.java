  package com.dotter.doctoruntact;

  import android.content.Intent;
  import android.os.Bundle;
  import android.text.TextUtils;
  import android.view.View;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.TextView;
  import android.widget.Toast;

  import com.google.android.gms.tasks.OnCompleteListener;
  import com.google.android.gms.tasks.Task;
  import com.google.firebase.auth.AuthResult;
  import com.google.firebase.auth.FirebaseAuth;

  import androidx.annotation.NonNull;
  import androidx.appcompat.app.AppCompatActivity;
  import androidx.appcompat.widget.Toolbar;

  public class LoginActivity extends AppCompatActivity {

      EditText email,password;
      Button btn_lgn;
      FirebaseAuth auth;
      TextView forgot_password;




      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_lgn = findViewById(R.id.btn_lgn);
        forgot_password = findViewById(R.id.forgot_password);

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.dotter.doctoruntact.LoginActivity.this, com.dotter.doctoruntact.ResetPasswordActivity.class));
            }
        });

        auth = FirebaseAuth.getInstance();




        btn_lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();



                if ( TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password))
                {
                    Toast.makeText(com.dotter.doctoruntact.LoginActivity.this, "All Fields Are Required !", Toast.LENGTH_SHORT);
                } else {
                    auth.signInWithEmailAndPassword(txt_email,txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(com.dotter.doctoruntact.LoginActivity.this, MainActivity.class); // 메인메뉴로 넘어가기
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); // 실행 액티비티 외 모두 제거 | 실행하는 액티비티를 새 태스크로 생성, 동족이 있으면 그 태스크로 들어감
                                startActivity(intent);
                                finish();
                            }  else {
                                Toast.makeText(com.dotter.doctoruntact.LoginActivity.this, "Authentication Is failed!", Toast.LENGTH_SHORT);
                            }
                        }
                    });
                }
            }
        });
    }
}
