package com.adelgado_cmaier.practica1;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.*;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String direcIP="";
	String puerto="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		

		FragmentManager fm = getFragmentManager();

		Fragment f = fm.findFragmentById(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos);
		if (f == null) {
			DinamicoFragmentInformacion fragmentInfo = new DinamicoFragmentInformacion();
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentInfo);
			ft.addToBackStack("atras");
			ft.commit();
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.menu_preferencias:
			Toast.makeText(this, "Preferencias", Toast.LENGTH_LONG).show();
			break;
		case R.id.menu_buscar:
			break;
		case R.id.menu_acerca:
			// HACEMOS EL ALERT DIALOG DEL ACERCA DE, INCLUYENDO UN
			// IMAGERESOURCE QUE CONTIENE
			// EL LOGO DE NUESTRA APP
			ImageView imagen_acerca_de = new ImageView(this);
			imagen_acerca_de.setImageResource(R.drawable.logo_adcm_3);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(Html.fromHtml("<p><b><u>Práctica 2</u></b> Versión: <b><i><u>14.0</u></i></b></p>"
					+ "<p>Desarrollada por: </p>" + "<p><i><b># Antonio Delgado Pamos</b></i></p>"
					+ "<p><i><b># Cristian Maier </b></i></p>"));
			builder.setPositiveButton("OK", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			}).setView(imagen_acerca_de);
			builder.create().show();
			break;
		case R.id.menu_instrucciones:
			FragmentInstrucciones fragmentInstrucciones = new FragmentInstrucciones();
			this.getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentInstrucciones).addToBackStack(null).commit();
			break;
		case R.id.menu_instrucciones_ingles:
			FragmentInstrucctions fragmentHelp = new FragmentInstrucctions();
			this.getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentHelp).addToBackStack(null).commit();
			break;
			
		}
		
		
		return false;
	}

	

}
