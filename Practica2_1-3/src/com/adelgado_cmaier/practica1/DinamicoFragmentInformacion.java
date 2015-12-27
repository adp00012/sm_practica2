package com.adelgado_cmaier.practica1;

import android.app.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.os.*;
import android.text.Html;
import android.widget.*;
import android.widget.TextView.BufferType;

public class DinamicoFragmentInformacion extends Fragment{
	
	//Constructor
	public DinamicoFragmentInformacion(){
	
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
		View rootView = inflater.inflate(R.layout.fragment_dinamico_introduccion, container, false);
		
		//Con este metodo vamos a escribir texto en un TextView como si fuese HTML para poder
		//formatearlo en negrita, cursiva y demás cada parte del texto.
		TextView texto = (TextView)rootView.findViewById(R.id.textoIntroductorio);
		texto.setText(Html.fromHtml("<p align='justify'>Esta aplicacion"
				+ " ha sido diseñada para la realización de la <b><i>Práctica 2</i></b>"
				+ " de <b><i>Servicios Móviles</i></b>, y consiste en:</p>"),BufferType.SPANNABLE);
		
		TextView texto2 = (TextView)rootView.findViewById(R.id.caracteristica1);
		texto2.setText(Html.fromHtml("<i>#Una aplicacion capaz de <b>acceder remotamente</b> "
				+ "a un servidor a través de un nombre de <b>usuario</b> y una <b>password</b> "
				+ "existente en la <b>base de datos.</b></i>"),BufferType.SPANNABLE);
		
		TextView texto3 = (TextView)rootView.findViewById(R.id.caracteristica2);
		texto3.setText(Html.fromHtml("<i># Podemos <b>registrar "
				+ "vehiculos</b> en nuestra <b>BD</b>. Esta aplicacion ha sido "
				+ "diseñada para poder dar de alta en la DGT los vehiculos que "
				+ "se adquieren en los concesionarios de primera mano.</i>"),BufferType.SPANNABLE);
		
		TextView texto4 = (TextView)rootView.findViewById(R.id.caracteristica3);
		texto4.setText(Html.fromHtml("<i># Aplicación apta unicamente para personal "
				+ "de la DGT, todo usuario ajeno a este trabajo no tiene acceso a la "
				+ "aplicación. De ahi que no tenga servicio de registro</i>"),BufferType.SPANNABLE);
		
		
		Button boton = (Button)rootView.findViewById(R.id.button$fragment_dinamico_introduccion$PasarFragmentDatos);
		boton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Con addtobackStack conseguimos retornar el fragment al anterior fragment
				//con el boton de retroceso fisico de nuestro dispositivo android
				DinamicoFragmentDatos fragmentDatos = new DinamicoFragmentDatos();
				getFragmentManager().beginTransaction().replace(R.id.frameLayout$activity_main$contenedorFragmentsDinamicos, fragmentDatos).addToBackStack(null).commit();
				
			}
		});
		return rootView;
	}
}
