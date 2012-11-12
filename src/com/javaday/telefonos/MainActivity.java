package com.javaday.telefonos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity implements OnClickListener{
	EditText txtNombre, txtCorreo, txtTelefono;
	Button btnGrabar, btnVer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		txtNombre =(EditText) findViewById(R.id.txtNombre);
		txtCorreo = (EditText) findViewById(R.id.txtCorreo);
		txtTelefono  = (EditText) findViewById(R.id.txtTelefono);
		btnGrabar = (Button) findViewById(R.id.btnGuardar);
		btnVer  = (Button) findViewById(R.id.btnVer);
		
		btnGrabar.setOnClickListener(this);
		btnVer.setOnClickListener(this);
		}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnGuardar :
			TelefonosDBUtility conn = new TelefonosDBUtility(this);
			conn.insertContacto(txtNombre.getText().toString(),txtCorreo.getText().toString(), txtTelefono.getText().toString());
			Toast.makeText(this, "click en Guardar", Toast.LENGTH_LONG).show();
			break;
		case R.id.btnVer :
			Intent i = new Intent(this,ListaActivity.class);
			startActivity(i);
			Toast.makeText(this, "click en Ver", Toast.LENGTH_LONG).show();
			break;
		}
	}

   

    
}
