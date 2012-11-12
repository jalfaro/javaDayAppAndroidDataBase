package com.javaday.telefonos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListaActivity extends Activity {
	ListView lista;
	TelefonosDBUtility conn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		conn = new TelefonosDBUtility(this);
		setContentView(R.layout.lista_contactos_layout);
		lista = (ListView) findViewById(R.id.listView1);
		lista.setAdapter(new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,conn.getContactos(),new String[] {TelefonosDBUtility.FLD_NOM,TelefonosDBUtility.FLD_TEL},
				new int[] {android.R.id.text1,android.R.id.text2}));
	}

}
