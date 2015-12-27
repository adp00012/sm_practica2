
package com.adelgado_cmaier.practica1;

import android.app.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DinamicoFragmentDatos extends Fragment{
	
	EditText EDIT_USERNAME, EDIT_PASSWORD, EDIT_DIRIP, EDIT_PORT;
	TextView estadoConexion;
	Button btnLogin;
	String username, pass, dir_ip, puerto;
	
	//Constructor
	public DinamicoFragmentDatos(){
		
	}
	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Conservamos información ante cambios de configuración del fragment .
        setRetainInstance(true);
        
    }

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_dinamico_datos, container, false);
		
		//Declaramos todos los objetos que tenemos en XML para poder trabajar con ellos aqui
		EDIT_USERNAME = (EditText)rootView.findViewById(R.id.editUser);
		EDIT_PASSWORD = (EditText)rootView.findViewById(R.id.editPass);
		EDIT_DIRIP = (EditText)rootView.findViewById(R.id.editRed);
		EDIT_PORT = (EditText)rootView.findViewById(R.id.editPuerto);
		
		btnLogin = (Button)rootView.findViewById(R.id.button$fragment_dinamico_datos$ActivityPasoParametros);
		
		estadoConexion = (TextView)rootView.findViewById(R.id.txt_estadioConexion);

		ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if(networkInfo!=null && networkInfo.isConnected()){
			estadoConexion.setVisibility(View.INVISIBLE);
		}else{
			btnLogin.setEnabled(false);
		}
		
		btnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				username = EDIT_USERNAME.getText().toString();
				pass = EDIT_PASSWORD.getText().toString();
				dir_ip = EDIT_DIRIP.getText().toString();
				puerto = EDIT_PORT.getText().toString();
				
				//Menos de 7 porque como minimo tiene que ser 0.0.0.0 que son 7 digitos
				if(dir_ip.length()<7){
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			        builder.setTitle("Error - Direccion Servidor");
			        builder.setMessage("No ha introducido una direccion IP valida!");
			        builder.setPositiveButton("Entendido!",null);
			        builder.create();
			        builder.show();
			        EDIT_DIRIP.setText("");
				}else if(puerto.length()<1){
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			        builder.setTitle("Error - Puerto");
			        builder.setMessage("No ha introducido un puerto valid!");
			        builder.setPositiveButton("Entendido!",null);
			        builder.create();
			        builder.show();
			        EDIT_PORT.setText("");
				}else{
					BackgroundTask backgroundTask = new BackgroundTask(getActivity());
					Credencial credenciales = new Credencial(username, pass, dir_ip, puerto);
					backgroundTask.execute(credenciales);

				}
				
			}
			
		});
		
		return rootView;
	}
	
	
	
}
