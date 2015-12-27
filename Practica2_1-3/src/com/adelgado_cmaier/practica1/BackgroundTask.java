package com.adelgado_cmaier.practica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<Credencial, Void, String>{
	String registro_coche_url;
	String login_url;
	
	String username, password;
	String direcIP;
	String puerto;
	
	Context context;
	Builder alertDialog;
	
	
	BackgroundTask (Context context){
		this.context=context;
	}
	
	@Override
	protected void onPreExecute(){
		
		login_url="/matriculacion/login.php";
		alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle("Información de Login");
		
	}
	
	@Override
	protected String doInBackground(Credencial... params) {
			
			username=params[0].getNom_usuario();
			password=params[0].getPassword();
			direcIP=params[0].getDir_red();
			puerto=params[0].getPuerto();
			try{
				URL url = new URL("http://"+direcIP+":"+puerto+login_url);
				HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setDoInput(true);
				OutputStream outputStream = httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter (outputStream, "UTF-8"));
				String data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+"&"+
							URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				outputStream.close();
				
				InputStream inputStream = httpURLConnection.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
				String response="";
				String line="";
				while((line = bufferedReader.readLine())!=null){
					response+=line;
				}
				System.out.println("La respuesta es: "+response);
				bufferedReader.close();
				inputStream.close();
				httpURLConnection.disconnect();
				return response;
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		
		
		return null;
	}
	
	@Override
	protected void onProgressUpdate (Void... values){
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute (String result){
			if(result.equals("[[]]")==false){
				alertDialog.setMessage("Bienvenido, "+username);
				alertDialog.setPositiveButton("Ok", null);
				alertDialog.show();
				Bundle bundle1 = new Bundle();
				bundle1.putString("IP", direcIP);
				bundle1.putString("PORT", puerto);
				DinamicoFragmentRegistroCoche fragmentRegistroCoche = new DinamicoFragmentRegistroCoche();
				fragmentRegistroCoche.setArguments(bundle1);
				((Activity)context).getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentRegistroCoche).addToBackStack(null).commit();
				
			}else{
				alertDialog.setMessage("Login Incorrecto!");
				alertDialog.setPositiveButton("Loguearme de nuevo", null);
				alertDialog.show();
			}
			
	}

}
