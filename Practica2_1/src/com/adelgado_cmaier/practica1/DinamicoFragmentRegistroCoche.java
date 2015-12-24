package com.adelgado_cmaier.practica1;

import android.app.*;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.*;

public class DinamicoFragmentRegistroCoche extends Fragment{
	EditText EDIT_NUMBASTIDOR, EDIT_MATRICULA, EDIT_PROPIETARIO, EDIT_MARCA, EDIT_MODELO, EDIT_CV, EDIT_CC;
	Spinner SPINNER_COMBUSTIBLE;
	String num_bastidor, matricula, propietario, marca, modelo, combustible, cv, cc, motorizacion;
	Button btnRegistrar;
	TextView t1, t2;
	


	//Constructor
	public DinamicoFragmentRegistroCoche(){
	
	}
	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Conservamos información ante cambios de configuración del fragment .
        setRetainInstance(true);
    }


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		setRetainInstance(true);
		View rootView = inflater.inflate(R.layout.fragment_registro_coches, container, false);
		
		EDIT_NUMBASTIDOR = (EditText)rootView.findViewById(R.id.editBastidor);
		EDIT_MATRICULA = (EditText)rootView.findViewById(R.id.editMatricula);
		EDIT_PROPIETARIO = (EditText)rootView.findViewById(R.id.editPropietario);
		EDIT_MARCA = (EditText)rootView.findViewById(R.id.editMarca);
		EDIT_MODELO = (EditText)rootView.findViewById(R.id.editModelo);
		EDIT_CV = (EditText)rootView.findViewById(R.id.EditCV);
		EDIT_CC = (EditText)rootView.findViewById(R.id.EditCC);
		SPINNER_COMBUSTIBLE = (Spinner)rootView.findViewById(R.id.spinnerCombustible);
		btnRegistrar = (Button)rootView.findViewById(R.id.btnRegistrarVehiculo);
		
		 Bundle bundle = this.getArguments();
	     final String direccionIP = bundle.getString("IP");
	     final String puerto = bundle.getString("PORT");
	    
		
		btnRegistrar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				num_bastidor = EDIT_NUMBASTIDOR.getText().toString();
				if(num_bastidor.length()!=17){
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			        builder.setTitle("Error - Numero de Bastidor");
			        builder.setMessage("Numero de Bastidor Incorrecto. Debe contener 17 digitos!");
			        builder.setPositiveButton("Entendido!",null);
			        builder.create();
			        builder.show();        
					EDIT_NUMBASTIDOR.setText("");
				}else{
					matricula = EDIT_MATRICULA.getText().toString();
					propietario = EDIT_PROPIETARIO.getText().toString();
					marca = EDIT_MARCA.getText().toString();
					modelo = EDIT_MODELO.getText().toString();
					combustible = SPINNER_COMBUSTIBLE.getSelectedItem().toString();
					cv = EDIT_CV.getText().toString();
					cc = EDIT_CC.getText().toString(); 
					motorizacion = cv+" "+cc;
					
					
					
					BackgroundTaskInsert backgroundTask = new BackgroundTaskInsert(getActivity());
					Coche coche = new Coche(num_bastidor, matricula, propietario, marca, modelo, combustible, motorizacion, direccionIP, puerto);
					backgroundTask.execute(coche);
					//getActivity().finish();
					
					EDIT_NUMBASTIDOR.setText("");
					EDIT_MATRICULA.setText("");
					EDIT_PROPIETARIO.setText("");
					EDIT_MARCA.setText("");
					EDIT_MODELO.setText("");
					EDIT_CV.setText("");
					EDIT_CC.setText("");
				}
				
			}
			
		});
		
		return rootView;
	}
	
}
