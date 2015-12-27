package com.adelgado_cmaier.practica1;

import android.app.*;
import android.view.*;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.EditText;
import android.os.*;


public class FragmentInstrucctions extends Fragment{
	private WebView browser;
	//Constructor
	public FragmentInstrucctions(){
	
	}
	@Override
	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Conservamos información ante cambios de configuración del fragment .
        setRetainInstance(true);
    }

	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		setRetainInstance(true);
		View rootView = inflater.inflate(R.layout.help, container, false);
		
		browser = (WebView)rootView.findViewById(R.id.webkit_instrucciones_ingles);
		
		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setBuiltInZoomControls(true);
		
		browser.loadUrl("file:///android_asset/instrucctions/index.html");

		return rootView;
	}
}
