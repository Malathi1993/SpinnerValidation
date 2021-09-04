package com.example.spinnervalidation;

 phonenumberr = phonenumber.getText().toString();
         passwordd = password.getText().toString();
         emaill = email.getText().toString();
         namee=name.getText().toString();
         if (namee.length()==0) {
         name.setError(getResources().getString(R.string.nameshouldnotbeempty));
         proceedToLogin = false;
         }
         else if ( phonenumberr.length() == 0) {
         phonenumber.setError(getResources().getString(R.string.mobile_no_not_valid));
         proceedToLogin = false;
         } else if (phonenumberr.length() <9) {
        phonenumber.setError(getResources().getString(R.string.mobile_no_not_valid9));
        proceedToLogin = false;
        } else if (phonenumberr.charAt(0) != '5'){
        phonenumber.setError(getResources().getString(R.string.mobilenosholdstartdigit5));
        proceedToLogin=false;
        }



        }
        else if (emaill.length()==0) {
        email.setError(getResources().getString(R.string.emailshouldnotbeleftempty));
        proceedToLogin = false;
        }
        else if (!emaill.matches(emailPattern)) {
        email.setError(getResources().getString(R.string.enteraccordingtopattern));
        proceedToLogin = false;
        }
        else if (passwordd.length() == 0) {
        password.setError(getResources().getString(R.string.passwordshouldnotbeempty));
        proceedToLogin = false;
        }   else if (!passwordd.matches(passwordPattern)) {
        password.setError(getResources().getString(R.string.passwordshouldconatins));
        proceedToLogin = false;
        } else if (passwordd.length()<8) {
        password.setError(getResources().getString(R.string.mineightdigit));
        proceedToLogin = false;
        }else if(!checkBox.isChecked()){
        Toast.makeText(this, getString(R.string.clickonterms), Toast.LENGTH_SHORT).show();
        proceedToLogin = false;
        }


        else {
        password.setError(null);
        password.setError(null);
        proceedToLogin = true;
        }
        if(proceedToLogin) {
        if (ConnectivityReceiver.isConnected(this)){
        new RegistrationRequest().execute();
        }
        else {
        //  NetWorkErrorPopup.callDailog(this);
        Intent i = new Intent(RegistrationViaPhone.this,NetworkPopup.class);
        startActivity(i);
        }
        }
        return proceedToLogin;
