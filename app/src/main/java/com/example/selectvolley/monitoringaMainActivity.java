package com.example.selectvolley;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class monitoringaMainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String URLSELECT = "http://192.168.1.11/PROJEK/SELECTM.php";
    public static final String URLDELETE = "http://192.168.1.11/PROJEK/DELETEM.php";
    public static final String URLEDIT = "http://192.168.1.11/PROJEK/EDITM.php";
    public static final String URLINSERT = "http://192.168.1.11/PROJEK/INSERTM.php";
    ListView list;
    SwipeRefreshLayout swipe;
    List<Datamonitoring> itemList = new ArrayList<Datamonitoring>();
    monitoringAdapter adapter;
    LayoutInflater inflater;
    EditText tidm,tglm,tnis, tjam, tkegiatan, tlokasi, tuser, tfoto;
    String vidm,vtglm,vnis, vjam, vkegiatan, vlokasi, vuser, vfoto;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitoringactivity_main);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        list = (ListView) findViewById(R.id.list);

        adapter = new monitoringAdapter(monitoringaMainActivity.this, itemList);
        list.setAdapter(adapter);

        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           itemList.clear();
                           adapter.notifyDataSetChanged();
                           callVolley();
                       }
                   }
        );
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //statement jika fab diklik
                dialogForm("","","","","","","","","Tambah");
//                startActivity(new Intent(nilaiMainActivity.this, nilaisiswaMainActivity.class));
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String idx = itemList.get(position).getIdm();
                final CharSequence[] pilihanAksi = {"Hapus","Ubah"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(monitoringaMainActivity.this);
                dialog.setItems(pilihanAksi, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                //jika dipilih hapus
                                hapusData(idx);
                                break;

                            case 1:
                                //jika memilih edit/ubah
                                ubahData(idx);
                                break;

                        }

                    }
                }).show();
                return false;
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String idx = itemList.get(i).getIdm();
                detailpenempatan(idx);
            }
        });
    }

    private void detailpenempatan(String idpp) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLEDIT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jObj = new JSONObject(response);

                            String idmx = jObj.getString("idm");
                            String tglmx = jObj.getString("tglm");
                            String nisx = jObj.getString("nis");
                            String jamx = jObj.getString("jam");
                            String kegiatanx = jObj.getString("kegiatan");
                            String lokasix = jObj.getString("lokasi");
                            String userx = jObj.getString("user");
                            String fotox = jObj.getString("foto");


                            Intent intent = new Intent(monitoringaMainActivity.this, detailmonitoringMainActivity.class);
                            intent.putExtra("idm",idmx);
                            intent.putExtra("tglm",tglmx);
                            intent.putExtra("nis",nisx);
                            intent.putExtra("jam",jamx);
                            intent.putExtra("kegiatan",kegiatanx);
                            intent.putExtra("lokasi",lokasix);
                            intent.putExtra("user",userx);
                            intent.putExtra("foto",fotox);

                            startActivity(intent);
                        }catch (JSONException e) {
                            // JSON error
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(monitoringaMainActivity.this, "Gagal Koneksi Ke server, Cek setingan koneksi anda", Toast.LENGTH_LONG).show();
            }
        })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();


                params.put("idm", idpp);

                return params;
            }

        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);

    }

//    private void detailindikator(String idxx){
//        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, URLTAMPILINDI,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jObj = new JSONObject(response);
//
//                            String idnxA = jObj.getString("id");
//                            String indikatorx1A = jObj.getString("ketindi");
//
//
//
//                            Intent intent = new Intent(nilaiMainActivity.this, detailnilaiMainActivity.class);
//                            intent.putExtra("id",idnxA);
//                            intent.putExtra("ketindi",indikatorx1A);
//
//                            startActivity(intent);
//                        }catch (JSONException e) {
//                            // JSON error
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(nilaiMainActivity.this, "Gagal Koneksi Ke server, Cek setingan koneksi anda", Toast.LENGTH_LONG).show();
//            }
//        })
//        {
//
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                // Posting parameters ke post url
//                Map<String, String> params = new HashMap<String, String>();
//
//
//                params.put("id", idxx);
//
//                return params;
//            }
//
//        };
//        RequestQueue queue1 = Volley.newRequestQueue(getApplicationContext());
//        queue1.add(stringRequest1);
//    }


    public void ubahData(String idp){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLEDIT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jObj = new JSONObject(response);

                            String idmx = jObj.getString("idm");
                            String tglmx = jObj.getString("tglm");
                            String nisx = jObj.getString("nis");
                            String jamx = jObj.getString("jam");
                            String kegiatanx = jObj.getString("kegiatan");
                            String lokasix = jObj.getString("lokasi");
                            String userx = jObj.getString("user");
                            String fotox = jObj.getString("foto");


                            dialogForm(idmx,tglmx,nisx,jamx,kegiatanx,lokasix,userx,fotox, "Ubah ");

                            adapter.notifyDataSetChanged();

                        }catch (JSONException e) {
                            // JSON error
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(monitoringaMainActivity.this, "Gagal Koneksi Ke server, Cek setingan koneksi anda", Toast.LENGTH_LONG).show();
            }
        })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();


                params.put("idm", idp);

                return params;
            }

        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
    }

    public void dialogForm(String id,String tgl,String nis,String jam,String kegiatan,String lokasi,String user,String foto,String button){
        AlertDialog.Builder dialogForm = new AlertDialog.Builder(monitoringaMainActivity.this);
        inflater = getLayoutInflater();
        View viewDialog = inflater.inflate(R.layout.form_monitoring, null);
        dialogForm.setView(viewDialog);
        dialogForm.setCancelable(true);
        dialogForm.setTitle("Form Input Monitoring");

        tidm = (EditText) viewDialog.findViewById(R.id.inid);
        tglm = (EditText) viewDialog.findViewById(R.id.tglm);
        tnis = (EditText) viewDialog.findViewById(R.id.nism);
        tjam = (EditText) viewDialog.findViewById(R.id.jamm);
        tkegiatan = (EditText) viewDialog.findViewById(R.id.kegiatanm);
        tlokasi = (EditText) viewDialog.findViewById(R.id.lokasim);
        tuser = (EditText) viewDialog.findViewById(R.id.user);
        tfoto = (EditText) viewDialog.findViewById(R.id.foto);



        if (id.isEmpty()){
            tidm.setText(null);
            tglm.setText(null);
            tnis.setText(null);
            tjam.setText(null);
            tkegiatan.setText(null);
            tlokasi.setText(null);
            tuser.setText(null);
            tfoto.setText(null);
        }else{
            tidm.setText(id);
            tglm.setText(tgl);
            tnis.setText(nis);
            tjam.setText(jam);
            tkegiatan.setText(kegiatan);
            tlokasi.setText(lokasi);
            tuser.setText(user);
            tfoto.setText(foto);
        }

        dialogForm.setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                vidm = tidm.getText().toString();
                vtglm = tglm.getText().toString();
                vnis = tnis.getText().toString();
                vjam = tjam.getText().toString();
                vkegiatan = tkegiatan.getText().toString();
                vlokasi = tlokasi.getText().toString();
                vuser = tuser.getText().toString();
                vfoto = tfoto.getText().toString();


                simpan();
                dialog.dismiss();
            }
        });
        dialogForm.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                tidm.setText(null);
                tglm.setText(null);
                tnis.setText(null);
                tjam.setText(null);
                tkegiatan.setText(null);
                tlokasi.setText(null);
                tuser.setText(null);
                tfoto.setText(null);

            }
        });
        dialogForm.show();

    }
    public void simpan(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLINSERT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callVolley();
                        Toast.makeText(monitoringaMainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(monitoringaMainActivity.this, "gagal koneksi ke server, cek setingan koneksi anda", Toast.LENGTH_LONG).show();
            }
        })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                if (vidm.isEmpty()) {
                    params.put("tglm", vtglm);
                    params.put("nis", vnis);
                    params.put("jam", vjam);
                    params.put("kegiatan", vkegiatan);
                    params.put("lokasi", vlokasi);
                    params.put("user", vuser);
                    params.put("foto", vfoto);
                    return params;
                }else{
                    params.put("idm", vidm);
                    params.put("tglm", vtglm);
                    params.put("nis", vnis);
                    params.put("jam", vjam);
                    params.put("kegiatan", vkegiatan);
                    params.put("lokasi", vlokasi);
                    params.put("user", vuser);
                    params.put("foto", vfoto);
                    return params;
                }
            }

        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);

    }
    public void hapusData(String idp){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLDELETE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(monitoringaMainActivity.this, response, Toast.LENGTH_LONG).show();
                        callVolley();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(monitoringaMainActivity.this, "Gagal Koneksi Ke server, Cek setingan koneksi anda", Toast.LENGTH_LONG).show();
            }
        })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();


                params.put("idm", idp);

                return params;
            }

        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
    }
    @Override
    public void onRefresh() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        callVolley();

    }
    private void callVolley() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        // membuat request JSON
        JsonArrayRequest jArr = new JsonArrayRequest(URLSELECT, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Datamonitoring item = new Datamonitoring();

                        item.setIdm(obj.getString("idm"));
                        item.setTglm(obj.getString("tglm"));
                        item.setUser(obj.getString("user"));

                        // menambah item ke array
                        itemList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                // notifikasi adanya perubahan data pada adapter
                adapter.notifyDataSetChanged();

                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                swipe.setRefreshing(false);
            }
        });

        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);

    }

}