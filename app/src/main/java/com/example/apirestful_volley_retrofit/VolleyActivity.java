package com.example.apirestful_volley_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    private static final String URL1 = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=2";

    private static final String URL = "https://gorest.co.in/public/v1/users";

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        requestQueue = Volley.newRequestQueue(this);


        txtResultado = findViewById(R.id.txtResultado_v);

        Obtener_Datos();

        //stringRequest();
    }

    private void Obtener_Datos(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            txtResultado.setText("");
                            JSONArray Data = response.getJSONArray("data");
                            int size = Data.length();

                            for(int i=0; i<size; i++){
                                try {
                                    JSONObject jsonObject = new JSONObject(Data.get(i).toString());

                                    String id = jsonObject.getString("id");
                                    String name = jsonObject.getString("name");
                                    String email = jsonObject.getString("email");
                                    String gender = jsonObject.getString("gender");
                                    String status = jsonObject.getString("status");

                                    txtResultado.append("ID :" + id + "\n");
                                    txtResultado.append("NAME :" + name + "\n");
                                    txtResultado.append("E-MAIL :" + email + "\n");
                                    txtResultado.append("GENDER :" + gender + "\n");
                                    txtResultado.append("STATUS :" + status + "\n" + "\n");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        }catch (JSONException a){}


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        requestQueue.add(jsonObjectRequest);
    }
    private void ObtenerDatos_Volley(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        int size = response.length();
                        for(int i=0; i<size; i++){
                            try {
                                JSONObject jsonObject = new JSONObject(response.get(i).toString());

                                String pais = jsonObject.getString("Pais");
                                String tInscritos = jsonObject.getString("TotalInscritos");

                                txtResultado.append(pais + " : " + tInscritos + "\n");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void stringRequest(){
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtResultado.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(request);
    }
}