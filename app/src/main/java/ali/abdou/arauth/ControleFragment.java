package ali.abdou.arauth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ControleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ControleFragment extends Fragment {
    private static final String RASPBERRY_PI_URL_RIGHT = "http://192.168.137.165:5000/move_right";
    private static final String RASPBERRY_PI_URL_LEFT = "http://192.168.137.165:5000/move_left";
    private static final String RASPBERRY_PI_URL_FORWARD = "http://192.168.137.165:5000/move_forward";
    private static final String RASPBERRY_PI_URL_BACKWARD = "http://192.168.137.165:5000/move_backward";
    private static final String RASPBERRY_PI_URL_STOP = "http://192.168.137.165:5000/stop";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ControleFragment() {
        // Required empty public constructor
    }
    public static ControleFragment newInstance(String param1, String param2) {
        ControleFragment fragment = new ControleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * Envoie une requête HTTP GET à l'URL spécifiée de manière asynchrone dans un thread séparé.
     * Cette méthode est utilisée pour effectuer des requêtes HTTP vers un serveur distant.
     *
     * @param urlString l'URL vers laquelle envoyer la requête HTTP
     */
    private void sendHttpRequest(String urlString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    int responseCode = urlConnection.getResponseCode();
                    urlConnection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    // Gérer les erreurs de connexion ici
                }
            }
        }).start();
    }
    /**
     * Exécute une fonction spécifique sur le Raspberry Pi en envoyant une requête HTTP GET à l'URL spécifiée pour déclencher l'action "right".
     * Cette méthode est utilisée pour envoyer des commandes au Raspberry Pi afin de déplacer un dispositif vers la droite.
     */
    private void executeFunctionOnRaspberryPiRight() {
        sendHttpRequest(RASPBERRY_PI_URL_RIGHT);
    }

    /**
     * Exécute une fonction spécifique sur le Raspberry Pi en envoyant une requête HTTP GET à l'URL spécifiée pour déclencher l'action "left".
     * Cette méthode est utilisée pour envoyer des commandes au Raspberry Pi afin de déplacer un dispositif vers la gauche.
     */
    private void executeFunctionOnRaspberryPiLeft() {
        sendHttpRequest(RASPBERRY_PI_URL_LEFT);
    }

    /**
     * Exécute une fonction spécifique sur le Raspberry Pi en envoyant une requête HTTP GET à l'URL spécifiée pour déclencher l'action "forward".
     * Cette méthode est utilisée pour envoyer des commandes au Raspberry Pi afin de déplacer un dispositif vers l'avant.
     */
    private void executeFunctionOnRaspberryPiForward() {
        sendHttpRequest(RASPBERRY_PI_URL_FORWARD);
    }

    /**
     * Exécute une fonction spécifique sur le Raspberry Pi en envoyant une requête HTTP GET à l'URL spécifiée pour déclencher l'action "backward".
     * Cette méthode est utilisée pour envoyer des commandes au Raspberry Pi afin de déplacer un dispositif vers l'arrière.
     */
    private void executeFunctionOnRaspberryPiBackward() {
        sendHttpRequest(RASPBERRY_PI_URL_BACKWARD);
    }

    /**
     * Exécute une fonction spécifique sur le Raspberry Pi en envoyant une requête HTTP GET à l'URL spécifiée pour arrêter une action en cours.
     * Cette méthode est utilisée pour envoyer des commandes au Raspberry Pi afin d'arrêter le mouvement d'un dispositif.
     */
    private void executeFunctionOnRaspberryPiStop() {
        sendHttpRequest(RASPBERRY_PI_URL_STOP);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_controle, container, false);

        // Trouver les boutons par leur ID
        Button right = rootView.findViewById(R.id.btnRight);
        Button left = rootView.findViewById(R.id.btnLeft);
        Button forward = rootView.findViewById(R.id.btnForward);
        Button backward = rootView.findViewById(R.id.btnReverse);
        Button stop=rootView.findViewById(R.id.btnStop);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        executeFunctionOnRaspberryPiRight();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeFunctionOnRaspberryPiLeft();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeFunctionOnRaspberryPiForward();
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeFunctionOnRaspberryPiBackward();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeFunctionOnRaspberryPiStop();
            }
        });

        return rootView;
    }
}