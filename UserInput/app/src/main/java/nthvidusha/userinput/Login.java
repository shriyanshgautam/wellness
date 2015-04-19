package nthvidusha.userinput;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ActionMenuView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by shriyansh on 10/4/15.
 */
public class Login extends ActionBarActivity {

    LinearLayout nameLayout,emailLayout,phoneLayout,cityLayout;
    View nameView,emailView,phoneView,cityView;
    EditText etFName, etLName, etEmail, etPhone , etCity;
    LinearLayout.LayoutParams layoutBig =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,3.0f);
    LinearLayout.LayoutParams layoutMid =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,2.0f);
    LinearLayout.LayoutParams layoutSmall =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1.0f);
    LinearLayout.LayoutParams viewSmall;
    LinearLayout.LayoutParams viewBig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        nameLayout=(LinearLayout)findViewById(R.id.layoutName);
        emailLayout=(LinearLayout)findViewById(R.id.layoutEmail);
        phoneLayout=(LinearLayout)findViewById(R.id.layoutPhone);
        cityLayout=(LinearLayout)findViewById(R.id.layoutCity);

        nameView=(View)findViewById(R.id.viewCircleName);
        emailView=(View)findViewById(R.id.viewCircleEmail);
        phoneView=(View)findViewById(R.id.viewCirclePhone);
        cityView=(View)findViewById(R.id.viewCircleCity);

        etFName = (EditText) findViewById(R.id.etFirstName);
        etLName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etCity = (EditText) findViewById(R.id.etCity);

        viewSmall = new LinearLayout.LayoutParams( (int)getResources().getDimension(R.dimen.circle_param_small),
                (int)getResources().getDimension(R.dimen.circle_param_small));
        viewBig = new LinearLayout.LayoutParams( (int)getResources().getDimension(R.dimen.circle_param_big),
                (int)getResources().getDimension(R.dimen.circle_param_big));

        etCity.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on Enter key press
//                    Toast.makeText(Login.this,"onKey city",Toast.LENGTH_SHORT).show();
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(etCity.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
                return false;
            }
        });


        etFName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    fNameClicked(v);
//                    Toast.makeText(Login.this,"onF fN",Toast.LENGTH_SHORT).show();
                }else
                {
                      etFName.clearFocus();
//                    Toast.makeText(Login.this,"!onF! fN",Toast.LENGTH_SHORT).show();
                }
            }
        });

        etLName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    fNameClicked(v);
                    etFName.clearFocus();
                    etLName.requestFocus();
//                    Toast.makeText(Login.this,"onF lN",Toast.LENGTH_SHORT).show();
                }else{
                    etLName.clearFocus();
                }

            }
        });

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    emailClicked(v);
//                    Toast.makeText(Login.this,"onF email",Toast.LENGTH_SHORT).show();
                } else {
//                    Toast.makeText(Login.this,"!onF! email",Toast.LENGTH_SHORT).show();
                    etEmail.clearFocus();
                }
            }
        });

        etPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    phoneClicked(v);
                } else {
                    etPhone.clearFocus();
                }
            }
        });

        etCity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    cityClicked(v);
                } else {

                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(etCity.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);
                    etCity.clearFocus();
                }
            }
        });
    }



    public void fNameClicked(View view){
        nameLayout.setLayoutParams(layoutBig);
        emailLayout.setLayoutParams(layoutSmall);
        phoneLayout.setLayoutParams(layoutSmall);
        cityLayout.setLayoutParams(layoutSmall);

        nameLayout.setBackground(getResources().getDrawable(R.color.grey));
        emailLayout.setBackground(getResources().getDrawable(R.color.white));
        phoneLayout.setBackground(getResources().getDrawable(R.color.white));
        cityLayout.setBackground(getResources().getDrawable(R.color.white));

        nameView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        emailView.setBackground(getResources().getDrawable(R.drawable.grey_ring));
        phoneView.setBackground(getResources().getDrawable(R.drawable.grey_ring));
        cityView.setBackground(getResources().getDrawable(R.drawable.grey_ring));

        etFName.setTextSize(35);
        etLName.setTextSize(35);
        etEmail.setTextSize(20);
        etPhone.setTextSize(20);
        etCity.setTextSize(20);


        etLName.clearFocus();
        etEmail.clearFocus();
        etPhone.clearFocus();
        etCity.clearFocus();
        etFName.requestFocus();

        nameView.setLayoutParams(viewBig);
        emailView.setLayoutParams(viewSmall);
        phoneView.setLayoutParams(viewSmall);
        cityView.setLayoutParams(viewSmall);

    }
    public void emailClicked(View view){
        nameLayout.setLayoutParams(layoutMid);
        emailLayout.setLayoutParams(layoutBig);
        phoneLayout.setLayoutParams(layoutSmall);
        cityLayout.setLayoutParams(layoutSmall);

        nameLayout.setBackground(getResources().getDrawable(R.color.white));
        emailLayout.setBackground(getResources().getDrawable(R.color.grey));
        phoneLayout.setBackground(getResources().getDrawable(R.color.white));
        cityLayout.setBackground(getResources().getDrawable(R.color.white));

        nameView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        emailView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        phoneView.setBackground(getResources().getDrawable(R.drawable.grey_ring));
        cityView.setBackground(getResources().getDrawable(R.drawable.grey_ring));

        etFName.setTextSize(20);
        etLName.setTextSize(20);
        etEmail.setTextSize(35);
        etPhone.setTextSize(20);
        etCity.setTextSize(20);

        etLName.clearFocus();
        etFName.clearFocus();
        etPhone.clearFocus();
        etCity.clearFocus();
        etEmail.requestFocus();

        nameView.setLayoutParams(viewSmall);
        emailView.setLayoutParams(viewBig);
        phoneView.setLayoutParams(viewSmall);
        cityView.setLayoutParams(viewSmall);

    }
    public void phoneClicked(View view){
        nameLayout.setLayoutParams(layoutMid);
        emailLayout.setLayoutParams(layoutSmall);
        phoneLayout.setLayoutParams(layoutBig);
        cityLayout.setLayoutParams(layoutSmall);

        nameLayout.setBackground(getResources().getDrawable(R.color.white));
        emailLayout.setBackground(getResources().getDrawable(R.color.white));
        phoneLayout.setBackground(getResources().getDrawable(R.color.grey));
        cityLayout.setBackground(getResources().getDrawable(R.color.white));

        nameView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        emailView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        phoneView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        cityView.setBackground(getResources().getDrawable(R.drawable.grey_ring));

        etFName.setTextSize(20);
        etLName.setTextSize(20);
        etEmail.setTextSize(20);
        etPhone.setTextSize(35);
        etCity.setTextSize(20);

        etLName.clearFocus();
        etFName.clearFocus();
        etEmail.clearFocus();
        etCity.clearFocus();
        etPhone.requestFocus();

        nameView.setLayoutParams(viewSmall);
        emailView.setLayoutParams(viewSmall);
        phoneView.setLayoutParams(viewBig);
        cityView.setLayoutParams(viewSmall);

    }
    public void cityClicked(View view){
        nameLayout.setLayoutParams(layoutMid);
        emailLayout.setLayoutParams(layoutSmall);
        phoneLayout.setLayoutParams(layoutSmall);
        cityLayout.setLayoutParams(layoutBig);

        nameLayout.setBackground(getResources().getDrawable(R.color.white));
        emailLayout.setBackground(getResources().getDrawable(R.color.white));
        phoneLayout.setBackground(getResources().getDrawable(R.color.white));
        cityLayout.setBackground(getResources().getDrawable(R.color.grey));

        nameView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        emailView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        phoneView.setBackground(getResources().getDrawable(R.drawable.grey_circle));
        cityView.setBackground(getResources().getDrawable(R.drawable.grey_circle));

        etFName.setTextSize(20);
        etLName.setTextSize(20);
        etEmail.setTextSize(20);
        etPhone.setTextSize(20);
        etCity.setTextSize(35);

        etLName.clearFocus();
        etFName.clearFocus();
        etEmail.clearFocus();
        etPhone.clearFocus();
        etCity.requestFocus();


        nameView.setLayoutParams(viewSmall);
        emailView.setLayoutParams(viewSmall);
        phoneView.setLayoutParams(viewSmall);
        cityView.setLayoutParams(viewBig);

    }
}
