package edu.cnm.bootcamp.caryl.helloworld;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import edu.cnm.bootcamp.caryl.helloworld.fragments.MainFragment;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
    implements MainFragment.OnFragmentInteractionListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnHelloWorld = (Button) findViewById(R.id.blnHelloWorld);
    btnHelloWorld.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        TextView textView =(TextView) findViewById(R.id.txtHelloWorld);
        String text = textView.getText().toString();
        String expected = getString(R.string.message_received);

        if (Objects.equals(text, expected)) {
          textView.setText(R.string.hello_world);
        }
        else {
          textView.setText(getString(R.string.message_received));
        }
      }
    });
  }


  @Override
  public void onFragmentInteraction(Uri uri) {

  }
}
