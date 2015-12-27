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
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class BackgroundTaskInsert extends AsyncTask<Coche, Void, String>{
	String registro_coche_url;
	String login_url;
	
	Context context;
	
	
	BackgroundTaskInsert (Context context){
		this.context=context;
	}
	
	@Override
	protected void onPreExecute(){
		registro_coche_url="/matriculacion/registrar_coche.php";
		login_url="/matriculacion/login.php";
	}
	
	@Override
	protected String doInBackground(Coche... params) {
		
	{
			String bastidor = params[0].getNum_bastidor();
			String matricula = params[0].getMatricula();
			String propietario = params[0].getPropietario();
			String marca = params[0].getMarca();
			String modelo = params[0].getModelo();
			String combustible = params[0].getCombustible();
			String motorizacion = params[0].getMotorizacion();
			String direccionIP = params[0].getIP();
			String puerto = params[0].getPuerto();
			try{
				URL url = new URL("http://"+direccionIP+":"+puerto+registro_coche_url);
				HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setDoOutput(true);
				OutputStream OS = httpURLConnection.getOutputStream();
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
				String data = URLEncoder.encode("num_bastidor", "UTF-8")+"="+URLEncoder.encode(bastidor, "UTF-8")+"&"+
						URLEncoder.encode("matricula", "UTF-8")+"="+URLEncoder.encode(matricula, "UTF-8")+"&"+
						URLEncoder.encode("propietario", "UTF-8")+"="+URLEncoder.encode(propietario, "UTF-8")+"&"+
						URLEncoder.encode("marca", "UTF-8")+"="+URLEncoder.encode(marca, "UTF-8")+"&"+
						URLEncoder.encode("modelo", "UTF-8")+"="+URLEncoder.encode(modelo, "UTF-8")+"&"+
						URLEncoder.encode("combustible", "UTF-8")+"="+URLEncoder.encode(combustible, "UTF-8")+"&"+
						URLEncoder.encode("motorizacion", "UTF-8")+"="+URLEncoder.encode(motorizacion, "UTF-8");
				bufferedWriter.write(data);
				bufferedWriter.flush();
				bufferedWriter.close();
				OS.close();
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
				return "Coche Registrado Satisfactoriamente";
				
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	protected void onProgressUpdate (Void... values){
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute (String result){
		if(result.equals("Coche Registrado Satisfactoriamente")){
			Toast.makeText(context, result, Toast.LENGTH_LONG).show();
		
		}
	}
	

}
