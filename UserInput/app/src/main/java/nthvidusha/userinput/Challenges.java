package nthvidusha.userinput;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Challenges extends ActionBarActivity implements DbConstants{

    ListView listView;
    DbMethods dbMethods;
    ImageView createBtn;
    SimpleCursorAdapter simpleCursorAdapter;
    View navigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        listView=(ListView)findViewById(R.id.challengeList);
        createBtn=(ImageView)findViewById(R.id.createBtn);
        navigate=(View)findViewById(R.id.navigate);
        dbMethods=new DbMethods(Challenges.this);

        simpleCursorAdapter=new SimpleCursorAdapter(Challenges.this,
                R.layout.track_list_item,
                dbMethods.getChallenges(NOT_COMPLETED),
                new String[]{COL_TITLE,COL_DESCRIPTION,COL_RATING,COL_CATEGORY},
                new int[]{R.id.tvTitle,R.id.tvDesc,R.id.tvRating,R.id.tvTag});

        listView.setAdapter(simpleCursorAdapter);


        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Challenges.this,CreateChallenge.class);
                startActivity(intent);
            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Challenges.this,MyTrack.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        simpleCursorAdapter.swapCursor(dbMethods.getChallenges(NOT_COMPLETED));
        simpleCursorAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenges, menu);
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
