package com.ChangeFont1;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import android.provider.*;
import android.net.*;
import java.util.*;
import android.content.res.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		 
}
@Override
public boolean onCreateOptionsMenu(Menu menu){
	menu.add("معلومات").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
	menu.add("احمد").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
	return true;
}

@Override 
public boolean onOptionsItemSelected(final MenuItem item) {
	switch (item.getTitle().toString()) {
		case "معلومات":
			 
			/*Intent i = new Intent( android.provider.Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
			  startActivity( i );*/
			// Check if app is whitelisted
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
				PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
				if (!pm.isIgnoringBatteryOptimizations(getPackageName())) {
					// If app is not whitelisted, display settings screen to add it to whitelist
					Toast.makeText(this, "تحتاج إلى إضافة التطبيق إلى القائمة البيضاء لضمان عمله في الخلفية", Toast.LENGTH_LONG).show();
					Intent intent = new Intent();
					intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
					intent.setData(Uri.parse("package:" + getPackageName()));
					startActivity(intent);
				} else {
					// App is already whitelisted
					Toast.makeText(this, "تمت إضافة التطبيق إلى القائمة البيضاء", Toast.LENGTH_SHORT).show();
				}}
			
		return true;
		case "احمد":
			Toast.makeText(this,item.getTitle().toString(),-1).show();
			/*Intent intent = new Intent();

			int sdkVersion = android.os.Build.VERSION.SDK_INT;
			String settingsAction;

			if (sdkVersion >= 26) {
				settingsAction = android.provider.Settings.ACTION_APP_NOTIFICATION_SETTINGS;
				intent.setAction(settingsAction);
				intent.putExtra(android.provider.Settings.EXTRA_APP_PACKAGE, getPackageName());
			} else if (sdkVersion >= 21) {
				settingsAction = "android.settings.APP_NOTIFICATION_SETTINGS";
				intent.setAction(settingsAction);
				intent.putExtra("app_package", getPackageName());
				intent.putExtra("app_uid", getApplicationInfo().uid);
			} else {
				settingsAction = android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS;
				intent.setAction(settingsAction);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				Uri uri = Uri.fromParts("package", getPackageName(), null);
				intent.setData(uri);
			}

			startActivity(intent);*/
			Intent intent = new Intent();
			String settingsAction = "android.settings.APP_NOTIFICATION_SETTINGS";
			intent.setAction(settingsAction);
			intent.putExtra("app_package", getPackageName());
			intent.putExtra("app_uid", getApplicationInfo().uid);
			startActivity(intent);
		return true;
		default:
		return super.onOptionsItemSelected(item);
	}
}
public void Aaa(View v){
	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,0);

// set title
	alertDialogBuilder.setTitle("الخروج من التطبيق");

// set dialog message
	alertDialogBuilder
		.setMessage("انقر فوق نعم للخروج!")
		.setCancelable(false)
		.setPositiveButton("نعم",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {

// if this button is clicked, close
// current activity

				MainActivity.this.finish();
			}
		})
		.setNegativeButton("لا",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id){
// if this button is clicked, just close
// the dialog box and do nothing
				dialog.cancel();
			}
		});
// create alert dialog
	AlertDialog alertDialog = alertDialogBuilder.create();

// show it
	alertDialog.show();
}

}
