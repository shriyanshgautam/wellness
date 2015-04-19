package nthvidusha.userinput;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_signup_name, new NameFragment())
                    .commit();
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

   public void onNameEntered(View view){
       // validate and store the name entered if reqd
       EditText name = (EditText) findViewById(R.id.editText_name);
       name.setFocusable(false);
       name.setEnabled(false);

       // remove the name button & keyboard
       Button nameButton = (Button) findViewById(R.id.button_next_name);
       nameButton.setVisibility(View.GONE);

       ((InputMethodManager) getSystemService(
               Context.INPUT_METHOD_SERVICE))
               .hideSoftInputFromWindow(name.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);


       // display the email fragment
       getSupportFragmentManager().beginTransaction()
               .replace(R.id.fragment_signup_email, new EmailFragment())
               .commit();
   }

    public void onEmailEntered(View view){
        //validate and store the email if reqd
        EditText email = (EditText) findViewById(R.id.editText_email);
        email.setFocusable(false);
        email.setEnabled(false);

        //remove the email button
        Button emailButton = (Button) findViewById(R.id.button_next_email);
        emailButton.setVisibility(View.GONE);

        ((InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(email.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);

        // display the phone fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_signup_phone, new PhoneFragment())
                .commit();
    }

    public void onPhoneEntered(View view){
        //validate the phone if reqd
        EditText phone = (EditText) findViewById(R.id.editText_phone);
        phone.setFocusable(false);
        phone.setEnabled(false);

        //remove the phone button
        Button phoneButton = (Button) findViewById(R.id.button_next_phone);
        phoneButton.setVisibility(View.GONE);

        ((InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(phone.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);

        // display the address fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_signup_address, new AddressFragment())
                .commit();
    }

    public void onAddressEntered(View view){
        //validate the address if reqd
        EditText address = (EditText) findViewById(R.id.editText_address);
        address.setFocusable(false);
        address.setEnabled(false);

        //remove the address button
        Button addressButton = (Button) findViewById(R.id.button_next_address);
        addressButton.setVisibility(View.GONE);

        ((InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(address.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);

        //intent to next page
        Toast.makeText(this,"END OF INPUT Intent comes here",Toast.LENGTH_LONG).show();
    }

  public static class NameFragment extends Fragment{

      public NameFragment(){

      }

      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          View rootView = inflater.inflate(R.layout.fragment_sign_up_name, container, false);

          EditText name = (EditText) rootView.findViewById(R.id.editText_name);

          name.setOnKeyListener(new View.OnKeyListener() {

              public boolean onKey(View v, int keyCode, KeyEvent event) {
                  // If the event is a key-down event on the "enter" button
                  if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                          (keyCode == KeyEvent.KEYCODE_ENTER)) {
                      // Perform action on Enter key press
                      getActivity().findViewById(R.id.button_next_name).performClick();
                  }
                  return false;
              }
          });
          return rootView;
      }
  }

  public static class EmailFragment extends Fragment{

      public EmailFragment(){

      }

      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          View rootView = inflater.inflate(R.layout.fragment_sign_up_email, container, false);

          EditText email = (EditText) rootView.findViewById(R.id.editText_email);

          email.setOnKeyListener(new View.OnKeyListener() {

              public boolean onKey(View v, int keyCode, KeyEvent event) {
                  // If the event is a key-down event on the "enter" button
                  if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                          (keyCode == KeyEvent.KEYCODE_ENTER)) {
                      // Perform action on Enter key press
                      getActivity().findViewById(R.id.button_next_email).performClick();
                  }
                  return false;
              }
          });
          return rootView;
      }

  }

  public static class PhoneFragment extends Fragment{

        public PhoneFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sign_up_phone, container, false);
            EditText phone = (EditText) rootView.findViewById(R.id.editText_phone);

            phone.setOnKeyListener(new View.OnKeyListener() {

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    // If the event is a key-down event on the "enter" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on Enter key press
                        getActivity().findViewById(R.id.button_next_phone).performClick();
                    }
                    return false;
                }
            });
            return rootView;
        }

    }

  public static class AddressFragment extends Fragment{

        public AddressFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sign_up_address, container, false);
            EditText address = (EditText) rootView.findViewById(R.id.editText_address);

            address.setOnKeyListener(new View.OnKeyListener() {

                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    // If the event is a key-down event on the "enter" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on Enter key press
                        getActivity().findViewById(R.id.button_next_address).performClick();
                    }
                    return false;
                }
            });
            return rootView;
        }

    }
}
