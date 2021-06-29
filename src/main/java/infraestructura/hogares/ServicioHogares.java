package infraestructura.hogares;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import dominio.excepcion.HogaresNoObtenidosException;

import java.io.IOException;

public class ServicioHogares {

    private final Retrofit retrofit;
    private final String endpoint = "https://api.refugiosdds.com.ar/api/";
    private final String bearerToken = "Bearer DlEO1YkConEH8roim0rnoHOe7dSgRyFBr95t7h0j5mXcAW32gE8OcdNclill";

    public ServicioHogares() {
        this.retrofit = new Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public HogaresResponse hogares(int paginas) {
        try {
            Hogares hogares = this.retrofit.create(Hogares.class);
            Call<HogaresResponse> solicitud = hogares.todos(paginas, bearerToken);
            Response<HogaresResponse> respuesta = solicitud.execute();
            return respuesta.body();
        } catch (IOException e) {
            throw new HogaresNoObtenidosException();
        }
    }

}