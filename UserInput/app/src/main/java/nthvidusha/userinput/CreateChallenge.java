package nthvidusha.userinput;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateChallenge extends ActionBarActivity {

    EditText etTitle,etDescription,etTag,etRating;
    Button submit;
    String title,desc,tag,rating;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);


       etTitle=(EditText)findViewById(R.id.title);
       etDescription=(EditText)findViewById(R.id.description);
       etTag=(EditText)findViewById(R.id.tag);
       etRating=(EditText)findViewById(R.id.rating);
        submit=(Button)findViewById(R.id.submit);


        final DbMethods dbMethods=new DbMethods(CreateChallenge.this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title=etTitle.getText().toString();
                desc=etDescription.getText().toString();
                tag=etTag.getText().toString();
                rating=etRating.getText().toString();


                if(title.contentEquals("")||desc.contentEquals("")||tag.contentEquals("")||rating.contentEquals("")){
                    Toast.makeText(CreateChallenge.this,"Check the input",Toast.LENGTH_SHORT).show();
                }else{
                   dbMethods.insert(title,desc,tag,Float.parseFloat(rating),12l);
                   finish();
                }
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_challenge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
