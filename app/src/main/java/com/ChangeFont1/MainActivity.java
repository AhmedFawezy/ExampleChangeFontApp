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
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "معلومات")
            .setIcon(R.drawable.info)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        menu.add(Menu.NONE, 2, Menu.NONE, "الاعدادت")
            .setIcon(R.drawable.setting)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        // استخدام الانعكاس لإظهار الأيقونات
        try {
            Class<?> menuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
            if (menuBuilderClass.isInstance(menu)) {
                java.lang.reflect.Method m = menuBuilderClass.getDeclaredMethod(
                    "setOptionalIconsVisible", boolean.class);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    @Override 
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getTitle().toString()) {
            case "معلومات":
                Toast.makeText(getApplicationContext(), "معلومات", Toast.LENGTH_LONG).show();
                return true;
            case "الاعدادت":
                Toast.makeText(getApplicationContext(),"الاعدادت",Toast.LENGTH_SHORT).show();
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
