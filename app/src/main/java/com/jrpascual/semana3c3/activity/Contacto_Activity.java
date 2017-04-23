package com.jrpascual.semana3c3.activity;

import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jrpascual.semana3c3.R;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto_Activity extends AppCompatActivity {
    private TextInputEditText etNombre, etEmail, etMensaje;
    private Button btEnviar;
    private String user, pwd, comentario, nombre, emailDestino;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = (TextInputEditText) findViewById(R.id.tiNombre);
        etEmail = (TextInputEditText) findViewById(R.id.tiEmail);
        etMensaje = (TextInputEditText) findViewById(R.id.tiMensaje);
        btEnviar = (Button) findViewById(R.id.bEnviarComentario);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMensaje();
            }
        });

    }

    public void enviarMensaje(){
        user = "courserac3@gmail.com";
        pwd = "123456coursera819";
        comentario = etMensaje.getText().toString();
        nombre = etNombre.getText().toString();
        emailDestino = etEmail.getText().toString();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try {
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pwd);
                }
            });

            if (session != null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(user));
                message.setSubject(nombre);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
                message.setContent(comentario, "text/html; charset=utf-8");
                Transport.send(message);
                Toast.makeText(this, getResources().getString(R.string.sEnviado), Toast.LENGTH_SHORT).show();
                finish();
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}
