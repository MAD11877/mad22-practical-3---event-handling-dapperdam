package sg.edu.np.mad.s10206197practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        User user = initUser();
        setFollowing(user,button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toast;
                if(user.followed == false){
                    user.followed = true;
                    toast = "Followed";
                }
                else{
                    user.followed = false;
                    toast = "Unfollowed";
                }
                setFollowing(user,button);

                Toast toastnotif = Toast.makeText(MainActivity.this,toast,Toast.LENGTH_SHORT);
                toastnotif.show();
            }
        });

        Intent receivingEnd = getIntent();
        Integer genInt = receivingEnd.getIntExtra("genInt",0);
        TextView text = findViewById(R.id.textView);
        text.setText(String.format("MAD %s",genInt));

    }
    public User initUser(){
        User user = new User("Username","Description",1,false);
        return user;
    }

    public void setFollowing(User user, Button button){
        TextView txt = button;
        if(user.followed == false){
            txt.setText("Follow");
        }
        else{
            txt.setText("Unfollow");
        }
    }
}



